package com.prjrmi.dao;



import com.prjrmi.model.Grade;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import com.prjrmi.model.Student;









public interface StudentManager extends Remote {
    Student getStudent(Integer id) throws RemoteException;
    List<Student> getAllStudents() throws RemoteException;
    List<Student> getStudentsByStdClassName(String stdClassName) throws RemoteException;  
    void addStudent(Student student) throws RemoteException;
    public void addGrade(Grade grade) throws RemoteException;
}
