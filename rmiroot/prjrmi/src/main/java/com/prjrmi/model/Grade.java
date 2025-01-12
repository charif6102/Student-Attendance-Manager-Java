package com.prjrmi.model;

import java.io.Serializable;
import java.util.Objects;

public class Grade implements Serializable{
    private Integer id;
    private Integer studentId;
    private String subjectName;
    private String  examDate;
    private Double coef ;
    private Double grade ;


    public Grade() {
    }

    public Grade(Integer id, Integer studentId, String subjectName, String examDate, Double coef, Double grade) {
        this.id = id;
        this.studentId = studentId;
        this.subjectName = subjectName;
        this.examDate = examDate;
        this.coef = coef;
        this.grade = grade;
    }
    

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStudentId() {
        return this.studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getSubjectName() {
        return this.subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getExamDate() {
        return this.examDate;
    }

    public void setExamDate(String examDate) {
        this.examDate = examDate;
    }

    public Double getCoef() {
        return this.coef;
    }

    public void setCoef(Double coef) {
        this.coef = coef;
    }

    public Double getGrade() {
        return this.grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    public Grade id(Integer id) {
        setId(id);
        return this;
    }

    public Grade studentId(Integer studentId) {
        setStudentId(studentId);
        return this;
    }

    public Grade subjectName(String subjectName) {
        setSubjectName(subjectName);
        return this;
    }

    public Grade examDate(String examDate) {
        setExamDate(examDate);
        return this;
    }

    public Grade coef(Double coef) {
        setCoef(coef);
        return this;
    }

    public Grade grade(Double grade) {
        setGrade(grade);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Grade)) {
            return false;
        }
        Grade grade = (Grade) o;
        return Objects.equals(id, grade.id) && Objects.equals(studentId, grade.studentId) && Objects.equals(subjectName, grade.subjectName) && Objects.equals(examDate, grade.examDate) && Objects.equals(coef, grade.coef) && Objects.equals(grade, grade.grade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, studentId, subjectName, examDate, coef, grade);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", studentId='" + getStudentId() + "'" +
            ", subjectName='" + getSubjectName() + "'" +
            ", examDate='" + getExamDate() + "'" +
            ", coef='" + getCoef() + "'" +
            ", grade='" + getGrade() + "'" +
            "}";
    }


    
}
