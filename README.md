# Student Attendance Manager — Java RMI

A distributed client/server application for managing students and grades, built with **Java RMI**, a **Swing** desktop client and a **SQLite** database.

![Java](https://img.shields.io/badge/Java-17-ED8B00?logo=openjdk&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-multi--module-C71A36?logo=apachemaven)
![SQLite](https://img.shields.io/badge/SQLite-JDBC-003B57?logo=sqlite)

## Architecture

```
┌──────────────────────┐    Java RMI (port 1099)    ┌───────────────────────┐
│  rmiprjclient        │ ─────────────────────────▶ │  prjrmi (server)      │
│  Swing GUI client    │                            │  StudentManager impl  │
└──────────────────────┘                            └──────────┬────────────┘
                                                               │ JDBC
                                                        ┌──────▼──────┐
                                                        │   SQLite    │
                                                        └─────────────┘
```

- **`prjrmi`**: RMI server. It exposes the remote `StudentManager` interface and reads and writes the SQLite database through JDBC.
- **`rmiprjclient`**: Swing desktop client. It looks up the remote service in the RMI registry.

## Features

- List all students, or the students of a given class
- View a student's details and grades
- Add students and grades from the GUI

## Remote interface

```java
public interface StudentManager extends Remote {
    Student getStudent(Integer id) throws RemoteException;
    List<Student> getAllStudents() throws RemoteException;
    List<Student> getStudentsByStdClassName(String stdClassName) throws RemoteException;
    void addStudent(Student student) throws RemoteException;
    void addGrade(Grade grade) throws RemoteException;
}
```

## Getting started

**Requirements:** JDK 17+ and Maven 3.8+.

```bash
git clone https://github.com/charif6102/Student-Attendance-Manager-Java.git
cd Student-Attendance-Manager-Java/rmiroot
mvn clean package
```

1. Set the SQLite path in `prjrmi/src/main/java/com/prjrmi/App.java` (`dbUrl`).
2. Start the server: `java -jar prjrmi/target/prjrmi-1.jar`
3. Start the client: `java -jar rmiprjclient/target/rmiprjclient-1.jar`

## Related projects

- [Web version (Next.js + MongoDB)](https://github.com/charif6102/Student-Attendance-Manager-React)
- [C# WinForms version](https://github.com/charif6102/Student-Attendance-Manager--C--)
