package com.example.cw_fx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    private static Stage stg;
    @Override
    public void start(Stage primaryStage) throws IOException {
        stg = primaryStage;
        Parent rt=FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        primaryStage.setTitle("Car Dealership");
        primaryStage.setScene(new Scene(rt,1000,750));
        primaryStage.show();
    }

    public void navigate(String fxml) throws IOException {
        Parent pane = FXMLLoader.load(getClass().getResource(fxml));
        stg.getScene().setRoot(pane);
    }

    public static void main(String[] args) {
        launch();
    }
}