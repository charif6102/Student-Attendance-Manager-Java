package com.prjrmi.dao;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.prjrmi.model.Grade;
import com.prjrmi.model.Student;

;

public class StudentManagerImpl extends UnicastRemoteObject implements StudentManager {
    private Connection connection;

    public StudentManagerImpl(String dbUrl) throws RemoteException {
        super();
        try {
            this.connection = DriverManager.getConnection(dbUrl);
        } catch (SQLException e) {
            throw new RemoteException("Erreur de connexion à la base de données", e);
        }
    }

    @Override
    public Student getStudent(Integer studentId) throws RemoteException {
         Student student = new Student();
    String sql = "SELECT s.id, s.first_name, s.last_name, s.std_class_name, g.subject_name, g.exam_date, g.coef, g.grade "
               + "FROM students s LEFT JOIN grades g ON s.id = g.student_id WHERE s.id=?";

try {
       
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setInt(1, studentId);

        try (ResultSet rs = pstmt.executeQuery()) {
            Integer currentId = null;
            Student currentStudent = null;

            while (rs.next()) {
                Integer id = rs.getInt("id");
                if (currentStudent == null || !id.equals(currentId)) {
                   
                    currentStudent = new Student(
                        id,
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("std_class_name"),
                        new ArrayList<Grade>()
                    );
                    currentId = id;
                }
                // Vérifier si la ligne contient une note (elle peut être nulle si la jointure ne trouve pas de correspondance)
                if (rs.getString("subject_name") != null) {
                    Grade grade = new Grade();
                    grade.setSubjectName(rs.getString("subject_name"));
                    grade.setExamDate(rs.getString("exam_date"));
                    grade.setCoef(rs.getDouble("coef"));
                    grade.setGrade(rs.getDouble("grade"));
                    currentStudent.getGrades().add(grade);
                }
            }
            // Ajouter le dernier étudiant traité à la liste
            if (currentStudent != null) {
                student = currentStudent;
            }
        }
    } catch (SQLException e) {
        throw new RemoteException("Erreur lors de la récupération des étudiants par nom de classe", e);
    }




        return student;
    }

 @Override
public List<Student> getAllStudents() throws RemoteException {
    List<Student> students = new ArrayList<>();
    String sql = "SELECT s.id, s.first_name, s.last_name, s.std_class_name, g.subject_name, g.exam_date, g.coef, g.grade "
               + "FROM students s LEFT JOIN grades g ON s.id = g.student_id ORDER BY s.id";

    try {

        
        Statement stmt = connection.createStatement();
       
        ResultSet rs = stmt.executeQuery(sql);

        Integer currentId = null;
        Student currentStudent = null;

        while (rs.next()) {
            Integer id = rs.getInt("id");
            if (currentStudent == null || !id.equals(currentId)) {
                if (currentStudent != null) {
                    students.add(currentStudent); // Ajouter l'étudiant précédent à la liste
                }
                // Créer un nouvel étudiant
                currentStudent = new Student(
                    id,
                    rs.getString("first_name"),
                    rs.getString("last_name"),
                    rs.getString("std_class_name"),
                    new ArrayList<Grade>()
                );
                currentId = id;
            }
            // Vérifier si la ligne contient une note (elle peut être nulle si la jointure ne trouve pas de correspondance)
            if (rs.getString("subject_name") != null) {
                Grade grade = new Grade(
                    rs.getInt("id"),
                    rs.getInt("student_id"),
                    rs.getString("subject_name"),
                    rs.getString("exam_date"),
                    rs.getDouble("coef"),
                    rs.getDouble("grade")
                );
                currentStudent.getGrades().add(grade);
            }
        }
        // Ajouter le dernier étudiant traité à la liste
        if (currentStudent != null) {
            students.add(currentStudent);
        }
    } catch (SQLException e) {
        throw new RemoteException("Erreur lors de la récupération des étudiants", e);
    }

    return students;
}

@Override
public List<Student> getStudentsByStdClassName(String stdClassName) throws RemoteException {
    List<Student> students = new ArrayList<>();
    String sql = "SELECT s.id, s.first_name, s.last_name, s.std_class_name, g.subject_name, g.exam_date, g.coef, g.grade "
               + "FROM students s LEFT JOIN grades g ON s.id = g.student_id "
               + "WHERE s.std_class_name = ? ORDER BY s.id, g.subject_name";

    try {
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, stdClassName);

        try (ResultSet rs = pstmt.executeQuery()) {
            Integer currentId = null;
            Student currentStudent = null;

            while (rs.next()) {
                Integer id = rs.getInt("id");
                if (currentStudent == null || !id.equals(currentId)) {
                    if (currentStudent != null) {
                        students.add(currentStudent); // Add the previous student to the list
                    }
                    // Create a new student
                    currentStudent = new Student(
                        id,
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("std_class_name"),
                        new ArrayList<Grade>()
                    );
                    currentId = id;
                }
                // Check if the row contains a grade (it might be null if the join finds no match)
                if (rs.getString("subject_name") != null) {
                    Grade grade = new Grade();
                    grade.setSubjectName(rs.getString("subject_name"));
                    grade.setExamDate(rs.getString("exam_date"));
                    grade.setCoef(rs.getDouble("coef")); // Ensure your Grade object handles Number properly
                    grade.setGrade(rs.getDouble("grade"));
                    currentStudent.getGrades().add(grade);
                }   
            }  
            // Add the last processed student to the list
            if (currentStudent != null) {
                students.add(currentStudent);
            }
        }
    } catch (SQLException e) {
        throw new RemoteException("Error retrieving students by class name", e);
    }

    return students;
}


@Override
public void addStudent(Student student) throws RemoteException {
    String sqlStudent = "INSERT INTO students (first_name, last_name, std_class_name) VALUES (?, ?, ?)";
    String sqlGrade = "INSERT INTO grades (student_id, subject_name, exam_date, coef, grade) VALUES (?, ?, ?, ?, ?)";

    try  {
    
       
        PreparedStatement pstmtStudent = connection.prepareStatement(sqlStudent);
       // pstmtStudent.setLong(1, student.getId());
        pstmtStudent.setString(1, student.getFirstName());
        pstmtStudent.setString(2, student.getLastName());
        pstmtStudent.setString(3, student.getStdClassName());
        pstmtStudent.executeUpdate();

        // Si l'étudiant a des notes à ajouter
   /*     if (student.getGrades() != null && !student.getGrades().isEmpty()) {
            try (PreparedStatement pstmtGrade = connection.prepareStatement(sqlGrade)) {
                for (Grade grade : student.getGrades()) {
                  //  pstmtGrade.setLong(1, student.getId());
                    pstmtGrade.setString(1, grade.getSubjectName());
                    pstmtGrade.setString(2, grade.getExamDate());
                    pstmtGrade.setDouble(4, grade.getCoef().doubleValue());
                    pstmtGrade.setDouble(5, grade.getGrade().doubleValue());
                    pstmtGrade.addBatch();
                }
                pstmtGrade.executeBatch();
            }
        }   */
    } catch (SQLException e) {
        throw new RemoteException("Erreur lors de l'ajout de l'étudiant", e);
    }
}

    @Override
public void addGrade(Grade grade) throws RemoteException {
    String sqlGrade = "INSERT INTO grades (student_id, subject_name, exam_date, coef, grade) VALUES (?, ?, ?, ?, ?)";


    
       
            try (PreparedStatement pstmtGrade = connection.prepareStatement(sqlGrade)) {
              
                  //  pstmtGrade.setLong(1, student.getId());
                   pstmtGrade.setInt(1, grade.getStudentId());
                    pstmtGrade.setString(2, grade.getSubjectName());
                    pstmtGrade.setString(3, grade.getExamDate());
                    pstmtGrade.setDouble(4, grade.getCoef().doubleValue());
                    pstmtGrade.setDouble(5, grade.getGrade().doubleValue());
                    pstmtGrade.addBatch();
                
                pstmtGrade.executeUpdate();
    } catch (SQLException e) {
        throw new RemoteException("Erreur lors de l'ajout de l'étudiant", e);
    }
}
}
