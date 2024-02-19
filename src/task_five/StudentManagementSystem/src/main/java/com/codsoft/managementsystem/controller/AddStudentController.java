package com.codsoft.managementsystem.controller;

import com.codsoft.managementsystem.model.Student;
import com.codsoft.managementsystem.service.StudentService;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class AddStudentController {

    @FXML
    private TextField departmentField;

    @FXML
    private TextField fullNameField;

    @FXML
    private TextField genderField;

    @FXML
    private TextField gradeField;

    @FXML
    void addStudentBtn() {
        StudentService.save(new Student(fullNameField.getText(),
                genderField.getText(), departmentField.getText(), gradeField.getText()));

        // Close the form window (optional)
        fullNameField.getScene().getWindow().hide();
    }

    @FXML
    void cancelBtn() {
        fullNameField.getScene().getWindow().hide();
    }

}
