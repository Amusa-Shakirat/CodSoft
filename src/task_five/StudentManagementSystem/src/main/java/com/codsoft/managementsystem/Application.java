package com.codsoft.managementsystem;

import com.codsoft.managementsystem.service.StudentService;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("mainWindow.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Student Management System");
        stage.setScene(scene);

        StudentService.createStudentTable();
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}