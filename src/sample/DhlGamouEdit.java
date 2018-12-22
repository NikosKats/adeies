package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;

public class DhlGamouEdit implements Initializable {
    public JFXButton menu_btn;
    public JFXButton view_btn;
    public JFXButton btn_add;


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
    public JFXRadioButton check1;
    public JFXRadioButton check2;
    public JFXRadioButton check3;
    public JFXRadioButton check4;
    public JFXRadioButton check5;
    public JFXRadioButton check6;
    public JFXRadioButton check7;
    public JFXRadioButton check8;
    public JFXRadioButton check9;
    public JFXRadioButton check10;
    public JFXRadioButton check11;
    public JFXRadioButton check12;
    public JFXRadioButton check13;
    public JFXRadioButton check14;
    public JFXRadioButton check15;
    public JFXRadioButton check16;
    public ToggleGroup group1;
    public ToggleGroup group2;
    public ToggleGroup group3;
    public ToggleGroup group4;

    String CheckBox1, CheckBox2, CheckBox3, CheckBox4;


    String Field1, Field2, Field3, Field4, Field5, Field6, Field7, Field8, Field9, Field10, Field11, Field12, Field13, Field14, Field15, Field16, Field17, Field18, Field19, Field20, Field21, Field22, Field23, Field24, Field25, Field26, Field27, Field28, Field29, Field30, Field31;
    String Field32, Field33, Field34, Field35, Field36, Field37, Field38, Field39, Field40, Field41, Field42, Field43, Field44, Field45, Field46, Field47, Field48, Field49, Field50;
    String Field51, Field52, Field53, Field54, Field55, Field56, Field57, Field58, Field59, Field60, Field61, Field62, Field63, Field64, Field65, Field66, Field67, Field68;
    String Field69, Field70, Field71, Field72, Field73, Field74, Field75, Field76, Field77, Field78, Field79, Field80, Field81, Field82, Field83, Field84, Field85;
    String Field86, Field87, Field88;


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
     //Επιλογή άδειας
     /*******************************/

    public void selectRow(int id) {
        String sql = "SELECT * FROM dataGamou WHERE id = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the value
            pstmt.setDouble(1, id);
            //
            ResultSet rs = pstmt.executeQuery();

            // loop through the result set
            while (rs.next()) {

                Field1 = rs.getString("Field1");
                Field2 = rs.getString("Field2");
                Field3 = rs.getString("Field3");
                Field4 = rs.getString("Field4");
                Field5 = rs.getString("Field5");
                Field6 = rs.getString("Field6");
                Field7 = rs.getString("Field7");
                Field8 = rs.getString("Field8");
                Field9 = rs.getString("Field9");
                Field10 = rs.getString("Field10");
                Field11 = rs.getString("Field11");
                Field12 = rs.getString("Field12");
                Field13 = rs.getString("Field13");
                Field14 = rs.getString("Field14");
                Field15 = rs.getString("Field15");
                Field16 = rs.getString("Field16");
                Field17 = rs.getString("Field17");
                Field18 = rs.getString("Field18");
                Field19 = rs.getString("Field19");
                Field20 = rs.getString("Field20");
                Field21 = rs.getString("Field21");
                Field22 = rs.getString("Field22");
                Field23 = rs.getString("Field23");
                Field24 = rs.getString("Field24");
                Field25 = rs.getString("Field25");
                Field26 = rs.getString("Field26");
                Field27 = rs.getString("Field27");
                Field28 = rs.getString("Field28");
                Field29 = rs.getString("Field29");
                Field30 = rs.getString("Field30");
                Field31 = rs.getString("Field31");
                Field32 = rs.getString("Field32");
                Field33 = rs.getString("Field33");
                Field34 = rs.getString("Field34");
                Field35 = rs.getString("Field35");
                Field36 = rs.getString("Field36");
                Field37 = rs.getString("Field37");
                Field38 = rs.getString("Field38");
                Field39 = rs.getString("Field39");
                Field40 = rs.getString("Field40");
                Field41 = rs.getString("Field41");
                Field42 = rs.getString("Field42");
                Field43 = rs.getString("Field43");
                Field44 = rs.getString("Field44");
                Field45 = rs.getString("Field45");
                Field46 = rs.getString("Field46");
                Field47 = rs.getString("Field47");
                Field48 = rs.getString("Field48");
                Field49 = rs.getString("Field49");
                Field50 = rs.getString("Field50");
                Field51 = rs.getString("Field51");
                Field52 = rs.getString("Field52");
                Field53 = rs.getString("Field53");
                Field54 = rs.getString("Field54");
                Field55 = rs.getString("Field55");
                Field56 = rs.getString("Field56");
                Field57 = rs.getString("Field57");
                Field58 = rs.getString("Field58");
                Field59 = rs.getString("Field59");
                Field60 = rs.getString("Field60");
                Field61 = rs.getString("Field61");
                Field62 = rs.getString("Field62");
                Field63 = rs.getString("Field63");
                Field64 = rs.getString("Field64");
                Field65 = rs.getString("Field65");
                Field66 = rs.getString("Field66");
                Field67 = rs.getString("Field67");
                Field68 = rs.getString("Field68");
                Field69 = rs.getString("Field69");
                Field70 = rs.getString("Field70");
                Field71 = rs.getString("Field71");
                Field72 = rs.getString("Field72");
                Field73 = rs.getString("Field73");
                Field74 = rs.getString("Field74");
                Field75 = rs.getString("Field75");
                Field76 = rs.getString("Field76");
                Field77 = rs.getString("Field77");
                Field78 = rs.getString("Field78");
                Field79 = rs.getString("Field79");
                Field80 = rs.getString("Field80");
                Field81 = rs.getString("Field81");
                Field82 = rs.getString("Field82");
                Field83 = rs.getString("Field83");
                Field84 = rs.getString("Field84");
                Field85 = rs.getString("Field85");
                Field86 = rs.getString("Field86");
                Field87 = rs.getString("Field87");
                Field88 = rs.getString("Field88");


                field1.setText(Field1);
                field2.setText(Field2);
                field3.setText(Field3);
                field4.setText(Field4);
                field5.setText(Field5);
                field6.setText(Field6);
                field7.setText(Field7);
                field8.setText(Field8);
                field9.setText(Field9);
                field10.setText(Field10);
                field11.setText(Field11);
                field12.setText(Field12);
                field13.setText(Field13);
                field14.setText(Field14);
                field15.setText(Field15);
                field16.setText(Field16);
                field17.setText(Field17);
                field18.setText(Field18);
                field19.setText(Field19);
                field20.setText(Field20);
                field21.setText(Field21);
                field22.setText(Field22);
                field23.setText(Field23);
                field24.setText(Field24);
                field25.setText(Field25);
                field26.setText(Field26);
                field27.setText(Field27);
                field28.setText(Field28);
                field29.setText(Field29);
                field30.setText(Field30);
                field31.setText(Field31);
                field32.setText(Field32);
                field33.setText(Field33);
                field34.setText(Field34);
                field35.setText(Field35);
                field36.setText(Field36);
                field37.setText(Field37);
                field38.setText(Field38);
                field39.setText(Field39);
                field40.setText(Field40);
                field41.setText(Field41);
                field42.setText(Field42);
                field43.setText(Field43);
                field44.setText(Field44);
                field45.setText(Field45);
                field46.setText(Field46);
                field47.setText(Field47);
                field48.setText(Field48);
                field49.setText(Field49);
                field50.setText(Field50);
                field51.setText(Field51);
                field52.setText(Field52);
                field53.setText(Field53);
                field54.setText(Field54);
                field55.setText(Field55);
                field56.setText(Field56);
                field57.setText(Field57);
                field58.setText(Field58);
                field59.setText(Field59);
                field60.setText(Field60);
                field61.setText(Field61);
                field62.setText(Field62);
                field63.setText(Field63);
                field64.setText(Field64);
                field65.setText(Field65);
                field66.setText(Field66);
                field67.setText(Field67);
                field68.setText(Field68);
                field69.setText(Field69);
                field70.setText(Field70);
                field71.setText(Field71);
                field72.setText(Field72);
                field73.setText(Field73);
                field74.setText(Field74);
                field75.setText(Field75);
                field76.setText(Field76);
                field77.setText(Field77);
                field78.setText(Field78);
                field79.setText(Field79);
                field80.setText(Field80);
                field81.setText(Field81);
                field82.setText(Field82);
                field83.setText(Field83);
                field84.setText(Field84);
                field85.setText(Field85);
                field86.setText(Field86);
                field87.setText(Field87);
                field88.setText(Field88);



            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


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
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("dhlBaptTable.fxml"));

            AnchorPane pane = loader.load();


            Scene scene = new Scene(pane);





            scene.getStylesheets().addAll(Main.class.getResource("style.css").toExternalForm());

            stage.setResizable(false);
            stage.setTitle("Προβολή Λίστας Δηλώσεων");
            stage.setScene(scene);
            stage.show();






        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getDataInsertData() {
        String Field1, Field2, Field3, Field4, Field5, Field6, Field7, Field8, Field9, Field10, Field11, Field12, Field13, Field14, Field15, Field16, Field17, Field18, Field19, Field20, Field21, Field22, Field23, Field24, Field25, Field26, Field27, Field28, Field29, Field30, Field31;
        String Field32, Field33, Field34, Field35, Field36, Field37, Field38, Field39, Field40, Field41, Field42, Field43, Field44, Field45, Field46, Field47, Field48, Field49, Field50;
        String Field51, Field52, Field53, Field54, Field55, Field56, Field57, Field58, Field59, Field60, Field61, Field62, Field63, Field64, Field65, Field66, Field67, Field68;
        String Field69, Field70, Field71, Field72, Field73, Field74, Field75, Field76, Field77, Field78, Field79, Field80, Field81, Field82, Field83, Field84, Field85;
        String Field86, Field87, Field88;



        Field1 = field1.getText();
        Field2 = field2.getText();
        Field3 = field3.getText();
        Field4 = field4.getText();
        Field5 = field5.getText();
        Field6 = field6.getText();
        Field7 = field7.getText();
        Field8 = field8.getText();
        Field9 = field9.getText();
        Field10 = field10.getText();
        Field11 = field11.getText();
        Field12 = field12.getText();
        Field13 = field13.getText();
        Field14 = field14.getText();
        Field15 = field15.getText();
        Field16 = field16.getText();
        Field17 = field17.getText();
        Field18 = field18.getText();
        Field19 = field19.getText();
        Field20 = field20.getText();
        Field21 = field21.getText();
        Field22 = field22.getText();
        Field23 = field23.getText();
        Field24 = field24.getText();
        Field25 = field25.getText();
        Field26 = field26.getText();
        Field27 = field27.getText();
        Field28 = field28.getText();
        Field29 = field29.getText();
        Field30 = field30.getText();
        Field31 = field31.getText();
        Field32 = field32.getText();
        Field33 = field33.getText();
        Field34 = field34.getText();
        Field35 = field35.getText();
        Field36 = field36.getText();
        Field37 = field37.getText();
        Field38 = field38.getText();
        Field39 = field39.getText();
        Field40 = field40.getText();
        Field41 = field41.getText();
        Field42 = field42.getText();
        Field43 = field43.getText();
        Field44 = field44.getText();
        Field45 = field45.getText();
        Field46 = field46.getText();
        Field47 = field47.getText();
        Field48 = field48.getText();
        Field49 = field49.getText();
        Field50 = field50.getText();
        Field51 = field51.getText();
        Field52 = field52.getText();
        Field53 = field53.getText();
        Field54 = field54.getText();
        Field55 = field55.getText();
        Field56 = field56.getText();
        Field57 = field57.getText();
        Field58 = field58.getText();
        Field59 = field59.getText();
        Field60 = field60.getText();
        Field61 = field61.getText();
        Field62 = field62.getText();
        Field63 = field63.getText();
        Field64 = field64.getText();
        Field65 = field65.getText();
        Field66 = field66.getText();
        Field67 = field67.getText();
        Field68 = field68.getText();
        Field69 = field69.getText();
        Field70 = field70.getText();
        Field71 = field71.getText();
        Field72 = field72.getText();
        Field73 = field73.getText();
        Field74 = field74.getText();
        Field75 = field75.getText();
        Field76 = field76.getText();
        Field77 = field77.getText();
        Field78 = field78.getText();
        Field79 = field79.getText();
        Field80 = field80.getText();
        Field81 = field81.getText();
        Field82 = field82.getText();
        Field83 = field83.getText();
        Field84 = field84.getText();
        Field85 = field85.getText();
        Field86 = field86.getText();
        Field87 = field87.getText();
        Field88 = field88.getText();

        /******
         *
         * Group 1
         * ****/
        if(check1.isSelected())
        {
            CheckBox1 = check1.getText();
        }
        if(check2.isSelected())
        {
            CheckBox1 = check2.getText();
        }
        if(check3.isSelected())
        {
            CheckBox1 = check3.getText();
        }





        /******
         *
         * Group 2
         * ****/
        if(check4.isSelected())
        {
            CheckBox2 = check4.getText();
        }
        if(check5.isSelected())
        {
            CheckBox2 = check5.getText();
        }
        if(check6.isSelected())
        {
            CheckBox2 = check6.getText();
        }



        /******
         *
         * Group 3
         * ****/
        if(check7.isSelected())
        {
            CheckBox3 = check7.getText();
        }
        if(check8.isSelected())
        {
            CheckBox3 = check8.getText();
        }
        if(check9.isSelected())
        {
            CheckBox3 = check9.getText();
        }
        if(check10.isSelected())
        {
            CheckBox3 = check10.getText();
        }
        if(check11.isSelected())
        {
            CheckBox3 = check11.getText();
        }





        /******
         *
         * Group 4
         * ****/
        if(check12.isSelected())
        {
            CheckBox4 = check12.getText();
        }
        if(check13.isSelected())
        {
            CheckBox4 = check13.getText();
        }
        if(check14.isSelected())
        {
            CheckBox4 = check14.getText();
        }
        if(check15.isSelected())
        {
            CheckBox4 = check15.getText();
        }
        if(check16.isSelected())
        {
            CheckBox4 = check16.getText();
        }





        if (       (Field1.trim().isEmpty())  || (Field2.trim().isEmpty()) || (Field3.trim().isEmpty()) || (Field4.trim().isEmpty()) || (Field5.trim().isEmpty())
                || (Field6.trim().isEmpty())  || (Field7.trim().isEmpty()) || (Field8.trim().isEmpty()) || (Field9.trim().isEmpty()) || (Field10.trim().isEmpty())
                || (Field11.trim().isEmpty()) || (Field12.trim().isEmpty()) || (Field13.trim().isEmpty()) || (Field14.trim().isEmpty()) || (Field15.trim().isEmpty())
                || (Field16.trim().isEmpty()) || (Field17.trim().isEmpty()) || (Field18.trim().isEmpty()) || (Field19.trim().isEmpty()) || (Field20.trim().isEmpty())
                || (Field21.trim().isEmpty()) || (Field22.trim().isEmpty()) || (Field23.trim().isEmpty()) || (Field24.trim().isEmpty()) || (Field25.trim().isEmpty())
                || (Field26.trim().isEmpty()) || (Field27.trim().isEmpty()) || (Field28.trim().isEmpty()) || (Field29.trim().isEmpty()) || (Field30.trim().isEmpty())
                || (Field31.trim().isEmpty()) || (Field32.trim().isEmpty()) || (Field33.trim().isEmpty()) || (Field34.trim().isEmpty()) || (Field35.trim().isEmpty())
                || (Field36.trim().isEmpty()) || (Field37.trim().isEmpty()) || (Field38.trim().isEmpty()) || (Field39.trim().isEmpty()) || (Field40.trim().isEmpty())
                || (Field41.trim().isEmpty()) || (Field42.trim().isEmpty()) || (Field43.trim().isEmpty()) || (Field44.trim().isEmpty()) || (Field45.trim().isEmpty())
                || (Field46.trim().isEmpty()) || (Field47.trim().isEmpty()) || (Field48.trim().isEmpty()) || (Field49.trim().isEmpty()) || (Field50.trim().isEmpty())
                || (Field51.trim().isEmpty()) || (Field52.trim().isEmpty()) || (Field53.trim().isEmpty()) || (Field54.trim().isEmpty()) || (Field55.trim().isEmpty())
                || (Field56.trim().isEmpty()) || (Field57.trim().isEmpty()) || (Field58.trim().isEmpty()) || (Field59.trim().isEmpty()) || (Field60.trim().isEmpty())
                || (Field61.trim().isEmpty()) || (Field62.trim().isEmpty()) || (Field63.trim().isEmpty()) || (Field64.trim().isEmpty()) || (Field65.trim().isEmpty())
                || (Field66.trim().isEmpty()) || (Field67.trim().isEmpty()) || (Field68.trim().isEmpty()) || (Field69.trim().isEmpty()) || (Field70.trim().isEmpty())
                || (Field71.trim().isEmpty()) || (Field72.trim().isEmpty()) || (Field73.trim().isEmpty()) || (Field74.trim().isEmpty()) || (Field75.trim().isEmpty())
                || (Field76.trim().isEmpty()) || (Field77.trim().isEmpty()) || (Field78.trim().isEmpty()) || (Field79.trim().isEmpty()) || (Field80.trim().isEmpty())
                || (Field81.trim().isEmpty()) || (Field82.trim().isEmpty()) || (Field83.trim().isEmpty()) || (Field84.trim().isEmpty()) || (Field85.trim().isEmpty())
                || (Field86.trim().isEmpty()) || (Field87.trim().isEmpty()) || (Field88.trim().isEmpty())
                || (CheckBox1.isEmpty()) || (CheckBox2.isEmpty()) || (CheckBox3.isEmpty()) || (CheckBox4.isEmpty())
                ) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Ειδοποίηση");
            alert.setHeaderText("Προσοχή!");
            alert.setContentText("Δεν έχεις συμπληρώσει όλα τα πεδία!");
            alert.showAndWait();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Θέλετε να οριστικοποιήσετε την δήλωση;");
            alert.setHeaderText("Επιβεβαίωση Υποβολής Στοιχείων.");
            alert.setContentText("Επιλέξτε.");

            ButtonType buttonTypeOne = new ButtonType("Ναι, τελική υποβολή");
            ButtonType buttonTypeTwo = new ButtonType("Όχι, διόρθωση στοιχείων");

            ButtonType buttonTypeCancel = new ButtonType("Ακύρωση, διαγραφή στοιχείων!", ButtonBar.ButtonData.CANCEL_CLOSE);

            alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo, buttonTypeCancel);

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == buttonTypeOne) {

                //insert(Field1, Field2, Field3, Field4, Field5, Field6, Field7, Field8, Field9, Field10, Field11, Field12, Field13, Field14, Field15, Field16, Field17, Field18, Field19, Field20, Field21, Field22, Field23, Field24, Field25, Field26, Field27, Field28, Field29, Field30, Field31, Field32, Field33, Field34, Field35, Field36, Field37, Field38, Field39, Field40, Field41, Field42, Field43, Field44, Field45, Field46, Field47, Field48, Field49, Field50,Field51,Field52,Field53,Field54,Field55,Field56,Field57,Field58,Field59, Field60,Field61, Field62, Field63, Field64, Field65, Field66, Field67, Field68, Field69, Field70, Field71, Field72, Field73, Field74, Field75, Field76, Field77, Field78, Field79, Field80, Field81, Field82, Field83, Field84, Field85, Field86, Field87, Field88, CheckBox1, CheckBox2, CheckBox3, CheckBox4);

                /**
                 * *
                 *  Also I have to pass the values to the next screen
                 * **/

                Stage primaryStage = (Stage) view_btn.getScene().getWindow();

                primaryStage.close();

                Stage stage = new Stage();



                try {
                    FXMLLoader loader = new FXMLLoader(Main.class.getResource("dhlGamouTable.fxml"));

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




            } else if (result.get() == buttonTypeTwo) {
                // ... user chose "Two"
            } else {
                field1.setText("");
                field2.setText("");
                field3.setText("");
                field4.setText("");
                field5.setText("");
                field6.setText("");
                field7.setText("");
                field8.setText("");
                field9.setText("");
                field10.setText("");
                field11.setText("");
                field12.setText("");
                field13.setText("");
                field14.setText("");
                field15.setText("");
                field16.setText("");
                field17.setText("");
                field18.setText("");
                field19.setText("");
                field20.setText("");
                field21.setText("");
                field22.setText("");
                field23.setText("");
                field24.setText("");
                field25.setText("");
                field26.setText("");
                field27.setText("");
                field28.setText("");
                field29.setText("");
                field30.setText("");
                field31.setText("");
                field32.setText("");
                field33.setText("");
                field34.setText("");
                field35.setText("");
                field36.setText("");
                field37.setText("");
                field38.setText("");
                field39.setText("");
                field40.setText("");
                field41.setText("");
                field42.setText("");
                field43.setText("");
                field44.setText("");
                field45.setText("");
                field46.setText("");
                field47.setText("");
                field48.setText("");
                field49.setText("");
                field50.setText("");
                field51.setText("");
                field52.setText("");
                field53.setText("");
                field54.setText("");
                field55.setText("");
                field56.setText("");
                field57.setText("");
                field58.setText("");
                field59.setText("");
                field60.setText("");
                field61.setText("");
                field62.setText("");
                field63.setText("");
                field64.setText("");
                field65.setText("");
                field66.setText("");
                field67.setText("");
                field68.setText("");
                field69.setText("");
                field70.setText("");
                field71.setText("");
                field72.setText("");
                field73.setText("");
                field74.setText("");
                field75.setText("");
                field76.setText("");
                field77.setText("");
                field78.setText("");
                field79.setText("");
                field80.setText("");
                field81.setText("");
                field82.setText("");
                field83.setText("");
                field84.setText("");
                field85.setText("");
                field86.setText("");
                field87.setText("");
                field88.setText("");
            }


        }


    }

    int id;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Preferences preferences = Preferences.userNodeForPackage(DhlBaptTable.class);
        String pass_id = preferences.get("id",null);

        id = Integer.parseInt(pass_id);
        selectRow(id);
    }
}
