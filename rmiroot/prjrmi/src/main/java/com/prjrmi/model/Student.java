package com.prjrmi.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Student implements Serializable {
    private Integer id;
    private String firstName;
    private String lastName;
    private String stdClassName;
    private List<Grade> grades;



    public Student() {
    }

    public Student(Integer id, String firstName, String lastName, String stdClassName, List<Grade> grades) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.stdClassName = stdClassName;
        this.grades = grades;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStdClassName() {
        return this.stdClassName;
    }

    public void setStdClassName(String stdClassName) {
        this.stdClassName = stdClassName;
    }

    public List<Grade> getGrades() {
        return this.grades;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }

    public Student id(Integer id) {
        setId(id);
        return this;
    }

    public Student firstName(String firstName) {
        setFirstName(firstName);
        return this;
    }

    public Student lastName(String lastName) {
        setLastName(lastName);
        return this;
    }

    public Student stdClassName(String stdClassName) {
        setStdClassName(stdClassName);
        return this;
    }

    public Student grades(List<Grade> grades) {
        setGrades(grades);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Student)) {
            return false;
        }
        Student student = (Student) o;
        return Objects.equals(id, student.id) && Objects.equals(firstName, student.firstName) && Objects.equals(lastName, student.lastName) && Objects.equals(stdClassName, student.stdClassName) && Objects.equals(grades, student.grades);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, stdClassName, grades);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", firstName='" + getFirstName() + "'" +
            ", lastName='" + getLastName() + "'" +
            ", stdClassName='" + getStdClassName() + "'" +
            ", grades='" + getGrades() + "'" +
            "}";
    }
  

    
}
