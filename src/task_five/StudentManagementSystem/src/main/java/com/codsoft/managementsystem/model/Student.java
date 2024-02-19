package com.codsoft.managementsystem.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

public class Student {
    private final IntegerProperty id = new SimpleIntegerProperty();
    private final StringProperty fullName = new SimpleStringProperty();
    private final StringProperty gender = new SimpleStringProperty();
    private final StringProperty department = new SimpleStringProperty();
    private final StringProperty grade = new SimpleStringProperty();

    //private static int count = 1;

    public Student(String fullName, String gender, String department, String grade) {
//        this.id.set(count++);
        this.fullName.set(fullName);
        this.gender.set(gender);
        this.department.set(department);
        this.grade.set(grade);
    }

    public Student(int id, String fullName, String gender, String department, String grade) {
        this.id.set(id);
        this.fullName.set(fullName);
        this.gender.set(gender);
        this.department.set(department);
        this.grade.set(grade);
    }

    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public String getFullName() {
        return fullName.get();
    }

    public void setFullName(String fullName) {
        this.fullName.set(fullName);
    }

    public StringProperty fullNameProperty() {
        return fullName;
    }

    public String getGender() {
        return gender.get();
    }

    public void setGender(String gender) {
        this.gender.set(gender);
    }

    public StringProperty genderProperty() {
        return gender;
    }

    public String getDepartment() {
        return department.get();
    }

    public void setDepartment(String department) {
        this.department.set(department);
    }

    public StringProperty departmentProperty() {
        return department;
    }

    public String getGrade() {
        return grade.get();
    }

    public void setGrade(String grade) {
        this.grade.set(grade);
    }

    public StringProperty gradeProperty() {
        return grade;
    }

    @Override
    public String toString() {
        return String.format("%d\t %s\t %s\t %s\t %s\t%n", id.get(), fullName.get(), gender.get(), department.get(), grade.get());
    }
}