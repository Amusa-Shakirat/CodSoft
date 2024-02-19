package com.codsoft.managementsystem.service;

import com.codsoft.managementsystem.model.Student;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentService {

    private static final Connection connection = ConnectionService.connector();


    // Method to create the student table if it doesn't exist
    public static void createStudentTable() {
        String query = "CREATE TABLE IF NOT EXISTS students (" +
                "id INT PRIMARY KEY AUTO_INCREMENT," +
                "full_name VARCHAR(100) NOT NULL," +
                "gender VARCHAR(100) NOT NULL," +
                "department VARCHAR(100) NOT NULL," +
                "grade VARCHAR(100) NOT NULL" +
                ")";

        try {
            assert connection != null;
            try (Statement statement = connection.createStatement()) {

                    statement.executeUpdate(query);
                }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static void save(Student student) {
        String insertQuery = "INSERT INTO students (id, full_name, gender, department, grade) VALUES (?, ?, ?, ?, ?)";

        try {
            assert connection != null;
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

                // Set values for parameters
                preparedStatement.setInt(1, student.getId());
                preparedStatement.setString(2, student.getFullName());
                preparedStatement.setString(3, student.getGender());
                preparedStatement.setString(4, student.getDepartment());
                preparedStatement.setString(5, student.getGrade());

                // Execute the query
                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    display("Student inserted successfully.");
                } else {
                    display("Failed to insert student.");
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

        public static void deleteStudent(int studentId) {
        String deleteQuery = "DELETE FROM students WHERE id = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {

            // Set the value for the parameter
            preparedStatement.setInt(1, studentId);

            // Execute the query
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                display("Student deleted successfully.");
            } else {
                display("No student found with the given ID.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static List<Student> getAllStudents() {
        List<Student> studentList = new ArrayList<>();
        // SQL query to retrieve all students
        String query = "SELECT * FROM students";

        try {
            assert connection != null;
            try (Statement statement = connection.createStatement();
                     ResultSet resultSet = statement.executeQuery(query)) {

                // Iterate through the result set and create Student objects
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String fullName = resultSet.getString("full_name");
                    String gender = resultSet.getString("gender");
                    String department = resultSet.getString("department");
                    String grade = resultSet.getString("grade");

                    // Create a new Student object and add it to the list
                    Student student = new Student(id, fullName, gender, department, grade);
                    studentList.add(student);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return studentList;
    }

    private static void display(String info) {
        // Create a new Alert
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        // Set the title
        alert.setTitle("message");

        // Set the header text (optional)
        alert.setHeaderText(null);

        // Set the content text
        alert.setContentText(info);


        ButtonType customButton = new ButtonType("OK");
        alert.getButtonTypes().setAll(customButton);

        // Show the alert and wait for user response
        alert.showAndWait().ifPresent(response -> {
        });
    }


}
