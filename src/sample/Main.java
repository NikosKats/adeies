package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{



        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        Scene scene = new Scene(root, 1200, 800);

        scene.getStylesheets().addAll(getClass().getResource("style.css").toExternalForm());
        primaryStage.setTitle("Αρχική");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();


    }




    public static void main(String[] args) {
        launch(args);
    }
}
