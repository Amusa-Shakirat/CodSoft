package com.codsoft.managementsystem.controller;

import com.codsoft.managementsystem.Application;
import com.codsoft.managementsystem.model.Student;
import com.codsoft.managementsystem.service.StudentService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class MainWindow {
    @FXML
    private TableColumn<Student, String> departmentColumn;

    @FXML
    private TableColumn<Student, String> fullNameColumn;

    @FXML
    private TableColumn<Student, String> genderColumn;

    @FXML
    private TableColumn<Student, String> gradeColumn;

    @FXML
    private TableColumn<Student, Integer> idColumn;

    @FXML
    private TableView<Student> tableview;

    @FXML
    private MenuItem addMenu;

    @FXML
    private MenuItem deleteMenu;

    @FXML
    private Menu menu;

    @FXML
    private TextField searchTextField;

    private FilteredList<Student> filteredData;

    private final ObservableList<Student> students =
            FXCollections.observableList(StudentService.getAllStudents());

    public void initialize() {
        idColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
        fullNameColumn.setCellValueFactory(cellData -> cellData.getValue().fullNameProperty());
        genderColumn.setCellValueFactory(cellData -> cellData.getValue().genderProperty());
        departmentColumn.setCellValueFactory(cellData -> cellData.getValue().departmentProperty());
        gradeColumn.setCellValueFactory(cellData -> cellData.getValue().gradeProperty());


        tableview.setItems(students);

        deleteMenu.setOnAction(event -> {
            Student selectedStudent = tableview.getSelectionModel().getSelectedItem();
            if (selectedStudent != null) {
                students.remove(selectedStudent);
            }
        });


        filteredData = new FilteredList<>(students, p -> true);

        // Set the filter predicate whenever the filter changes
        searchTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(student -> {
                // If filter text is empty, display all students
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                // Compare name of every student with filter text
                String lowerCaseFilter = newValue.toLowerCase();
                if (student.getFullName().toLowerCase().contains(lowerCaseFilter)) {
                    return true; // Filter matches student name
                }

                return false; // Does not match
            });
        });

        // Wrap the filtered list in a SortedList
        SortedList<Student> sortedData = new SortedList<>(filteredData);

        // Bind the SortedList comparator to the TableView comparator
        sortedData.comparatorProperty().bind(tableview.comparatorProperty());

        // Add sorted (and filtered) data to the TableView
       tableview.setItems(sortedData);

    }

    @FXML
    void handleAddStudent() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("addWindow.fxml"));

        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Add Student");
        stage.setScene(scene);

        StudentService.createStudentTable();
        stage.show();
    }
    @FXML
    void handleDelete() {

    }
}
