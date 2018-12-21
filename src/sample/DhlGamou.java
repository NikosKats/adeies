package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DhlGamou {


    public JFXTextField field1;
    public JFXTextField field2;
    public JFXTextField field3;
    public JFXTextField field4;
    public JFXTextField field5;
    public JFXTextField field6;
    public JFXTextField field7;
    public JFXTextField field8;
    public JFXTextField field9;
    public JFXTextField field10;
    public JFXTextField field11;
    public JFXTextField field12;
    public JFXTextField field13;
    public JFXTextField field14;
    public JFXTextField field15;
    public JFXTextField field16;
    public JFXTextField field17;
    public JFXTextField field18;
    public JFXTextField field19;
    public JFXTextField field20;
    public JFXTextField field21;
    public JFXTextField field22;
    public JFXTextField field23;
    public JFXTextField field24;
    public JFXTextField field25;
    public JFXTextField field26;
    public JFXTextField field27;
    public JFXTextField field28;
    public JFXTextField field29;
    public JFXTextField field30;
    public JFXTextField field31;
    public JFXTextField field32;
    public JFXTextField field33;
    public JFXTextField field34;
    public JFXTextField field35;
    public JFXTextField field36;
    public JFXTextField field37;
    public JFXTextField field38;
    public JFXTextField field39;
    public JFXTextField field40;
    public JFXTextField field41;
    public JFXTextField field42;
    public JFXTextField field43;
    public JFXTextField field44;
    public JFXTextField field45;
    public JFXTextField field46;
    public JFXTextField field47;
    public JFXTextField field48;
    public JFXTextField field49;
    public JFXTextField field50;
    public JFXTextField field51;
    public JFXTextField field52;
    public JFXTextField field53;
    public JFXTextField field54;
    public JFXTextField field55;
    public JFXTextField field56;
    public JFXTextField field57;
    public JFXTextField field58;
    public JFXTextField field59;
    public JFXTextField field60;
    public JFXTextField field61;
    public JFXTextField field62;
    public JFXTextField field63;
    public JFXTextField field64;
    public JFXTextField field65;
    public JFXTextField field66;
    public JFXTextField field67;
    public JFXTextField field68;
    public JFXTextField field69;
    public JFXTextField field70;
    public JFXTextField field71;
    public JFXTextField field72;
    public JFXTextField field73;
    public JFXTextField field74;
    public JFXTextField field75;
    public JFXTextField field76;
    public JFXTextField field77;
    public JFXTextField field78;
    public JFXTextField field79;
    public JFXTextField field80;
    public JFXTextField field81;
    public JFXTextField field82;
    public JFXTextField field83;
    public JFXTextField field84;
    public JFXTextField field85;
    public JFXTextField field86;
    public JFXTextField field87;
    public JFXTextField field88;


    /*******************************
     //Σύνδεση με Βάση
     ******************************/

    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:adeies.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }



    public JFXButton menu_btn;
    public JFXButton view_btn;

    public void main_menu(ActionEvent actionEvent) {
        Stage primaryStage = (Stage) menu_btn.getScene().getWindow();

        primaryStage.close();

        Stage stage = new Stage();



        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("sample.fxml"));

            AnchorPane pane = loader.load();


            Scene scene = new Scene(pane);





            scene.getStylesheets().addAll(Main.class.getResource("style.css").toExternalForm());

            stage.setResizable(false);
            stage.setTitle("Αρχική");
            stage.setScene(scene);
            stage.show();






        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void view_screen(ActionEvent actionEvent) {

        Stage primaryStage = (Stage) view_btn.getScene().getWindow();

        primaryStage.close();

        Stage stage = new Stage();



        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("dhlBaptView.fxml"));

            AnchorPane pane = loader.load();


            Scene scene = new Scene(pane);





            scene.getStylesheets().addAll(Main.class.getResource("style.css").toExternalForm());

            stage.setResizable(false);
            stage.setTitle("Προβολή Δηλώσεων");
            stage.setScene(scene);
            stage.show();






        } catch (IOException e) {
            e.printStackTrace();
        }
    }







}
