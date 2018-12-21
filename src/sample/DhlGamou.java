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
import java.sql.PreparedStatement;
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


    /*******************************
     //Εισαγωγή στη Βάση
     //*******************************/

    public void insert(String Field1,String Field2,String Field3,String Field4,String Field5,String Field6,String Field7,String Field8,String Field9,String Field10,
                       String Field11,String Field12, String Field13,String Field14,String Field15,String Field16,String Field17,String Field18,String Field19,String Field20,
                       String Field21,String Field22,String Field23,String Field24,String Field25, String Field26,String Field27,String Field28,String Field29,String Field30,
                       String Field31,String Field32,String Field33,String Field34,String Field35,String Field36,String Field37,String Field38, String Field39,String Field40,
                       String Field41, String Field42,String Field43,String Field44,String Field45,String Field46,String Field47,String Field48,String Field49,String Field50,
                       String Field51,String Field52, String Field53,String Field54,String Field55,String Field56, String Field57,String Field58,String Field59,String Field60,
                       String Field61,String Field62,String Field63,String Field64,String Field65,String Field66,String Field67,String Field68,String Field69,String Field70,
                       String Field71, String Field72, String Field73,String Field74, String Field75,String Field76,String Field77,String Field78,String Field79,String Field80,
                       String Field81,String Field82, String Field83,String Field84,String Field85,String Field86,String Field87, String Field88,String Field89,String Field90,
                       String Field91,String Field92, String Field93,String Field94) {

            String sql = "INSERT INTO dataGamou(Field1,Field2,Field3,Field4,Field5,Field6,Field7,Field8,Field9,Field10," +
                    "Field11,Field12,Field13,Field14,Field15,Field16,Field17,Field18,Field19,Field20," +
                    "Field21,Field22,Field23,Field24,Field25,Field26,Field27,Field28,Field29,Field30," +
                    "Field31,Field32,Field33,Field34,Field35,Field36,Field37,Field38,Field39,Field40,)" +
                    "Field41,Field42,Field43,Field44,Field45,Field46,Field47,Field48,Field49,Field50," +
                    "Field51,Field52,Field53,Field54,Field55,Field56,Field57,Field58,Field59,Field60," +
                    "Field61,Field62,Field63,Field64,Field65,Field66,Field67,Field68,Field69,Field70,)" +
                    "Field71,Field72,Field73,Field74,Field75,Field76,Field77,Field78,Field79,Field80," +
                    "Field81,Field82,Field83,Field84,Field85,Field86,Field87,Field88,Field89,Field90," +
                    "Field91,Field92,Field93,Field94)" +
                    " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?," +
                    "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?" +
                    ",?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, Field1);
            pstmt.setString(2, Field2);
            pstmt.setString(3, Field3);
            pstmt.setString(4, Field4);
            pstmt.setString(5, Field5);
            pstmt.setString(6, Field6);
            pstmt.setString(7, Field7);
            pstmt.setString(8, Field8);
            pstmt.setString(9, Field9);
            pstmt.setString(10, Field10);
            pstmt.setString(11, Field11);
            pstmt.setString(12, Field12);
            pstmt.setString(13, Field13);
            pstmt.setString(14, Field14);
            pstmt.setString(15, Field15);
            pstmt.setString(16, Field16);
            pstmt.setString(17, Field17);
            pstmt.setString(18, Field18);
            pstmt.setString(19, Field19);
            pstmt.setString(20, Field20);
            pstmt.setString(21, Field21);
            pstmt.setString(22, Field22);
            pstmt.setString(23, Field23);
            pstmt.setString(24, Field24);
            pstmt.setString(25, Field25);
            pstmt.setString(26, Field26);
            pstmt.setString(27, Field27);
            pstmt.setString(28, Field28);
            pstmt.setString(29, Field29);
            pstmt.setString(30, Field30);
            pstmt.setString(31, Field31);
            pstmt.setString(32, Field32);
            pstmt.setString(33, Field33);
            pstmt.setString(34, Field34);
            pstmt.setString(35, Field35);
            pstmt.setString(36, Field36);
            pstmt.setString(37, Field37);
            pstmt.setString(38, Field38);
            pstmt.setString(39, Field39);
            pstmt.setString(40, Field40);
            pstmt.setString(41, Field41);
            pstmt.setString(42, Field42);
            pstmt.setString(43, Field43);
            pstmt.setString(44, Field44);
            pstmt.setString(45, Field45);
            pstmt.setString(46, Field46);
            pstmt.setString(47, Field47);
            pstmt.setString(48, Field48);
            pstmt.setString(49, Field49);
            pstmt.setString(50, Field50);
            pstmt.setString(51, Field51);
            pstmt.setString(52, Field52);
            pstmt.setString(53, Field53);
            pstmt.setString(54, Field54);
            pstmt.setString(55, Field55);
            pstmt.setString(56, Field56);
            pstmt.setString(57, Field57);
            pstmt.setString(58, Field58);
            pstmt.setString(59, Field59);
            pstmt.setString(60, Field60);
            pstmt.setString(61, Field61);
            pstmt.setString(62, Field62);
            pstmt.setString(63, Field63);
            pstmt.setString(64, Field64);
            pstmt.setString(65, Field65);
            pstmt.setString(66, Field66);
            pstmt.setString(67, Field67);
            pstmt.setString(68, Field68);
            pstmt.setString(69, Field69);
            pstmt.setString(70, Field70);
            pstmt.setString(71, Field71);
            pstmt.setString(72, Field72);
            pstmt.setString(73, Field73);
            pstmt.setString(74, Field74);
            pstmt.setString(75, Field75);
            pstmt.setString(76, Field76);
            pstmt.setString(77, Field77);
            pstmt.setString(78, Field78);
            pstmt.setString(79, Field79);
            pstmt.setString(80, Field80);
            pstmt.setString(81, Field81);
            pstmt.setString(82, Field82);
            pstmt.setString(83, Field83);
            pstmt.setString(84, Field84);
            pstmt.setString(85, Field85);
            pstmt.setString(86, Field86);
            pstmt.setString(87, Field87);
            pstmt.setString(88, Field88);
            pstmt.setString(89, Field89);
            pstmt.setString(90, Field90);
            pstmt.setString(91, Field91);
            pstmt.setString(92, Field92);
            pstmt.setString(93, Field93);
            pstmt.setString(94, Field94);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
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
