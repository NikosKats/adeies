package sample;

import com.jfoenix.controls.JFXButton;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;

import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.util.Optional;


public class DhlBapt {



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
    private Stage stage;

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

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Ειδοποίηση");
            alert.setHeaderText("Προσοχή!");
            alert.setContentText("Υπάρχει σφάλμα με τη βάση!");
            alert.showAndWait();
        }
        return conn;
    }

    /*******************************
    //Εισαγωγή στη Βάση
    //*******************************/

    public void insert(String Field1,String Field2,String Field3,String Field4,String Field5,String Field6,String Field7,String Field8,String Field9,String Field10,String Field11,String Field12,String Field13,String Field14,String Field15,String Field16,String Field17,String Field18,String Field19,String Field20,String Field21,String Field22,String Field23,String Field24,String Field25,String Field26,String Field27,String Field28,String Field29,String Field30,String Field31) {
        String sql = "INSERT INTO dataBaptisis(Field1,Field2,Field3,Field4,Field5,Field6,Field7,Field8,Field9,Field10,Field11,Field12,Field13,Field14,Field15,Field16,Field17,Field18,Field19,Field20,Field21,Field22,Field23,Field24,Field25,Field26,Field27,Field28,Field29,Field30,Field31) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

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
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }



    public JFXButton menu_btn;
    public JFXButton view_btn;
    public JFXButton add_btn;

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
            stage.setTitle("Προβολή Δηλώσεων");
            stage.setScene(scene);
            stage.show();






        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void getDataInsertData()
    {
        String Field1, Field2, Field3, Field4, Field5, Field6, Field7, Field8, Field9, Field10, Field11, Field12, Field13, Field14, Field15, Field16, Field17, Field18, Field19, Field20, Field21, Field22, Field23, Field24, Field25, Field26, Field27, Field28, Field29, Field30, Field31;




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


        if ( (Field1.trim().isEmpty()) || (Field2.trim().isEmpty()) || (Field3.trim().isEmpty())  || (Field4.trim().isEmpty()) || (Field5.trim().isEmpty())
                || (Field6.trim().isEmpty())  || (Field7.trim().isEmpty())  || (Field8.trim().isEmpty()) || (Field9.trim().isEmpty())  || (Field10.trim().isEmpty())
                || (Field11.trim().isEmpty()) || (Field12.trim().isEmpty())  || (Field13.trim().isEmpty())  || (Field14.trim().isEmpty()) || (Field15.trim().isEmpty())
                || (Field16.trim().isEmpty())  || (Field17.trim().isEmpty())  || (Field18.trim().isEmpty()) || (Field19.trim().isEmpty()) || (Field20.trim().isEmpty())
                || (Field21.trim().isEmpty())  || (Field22.trim().isEmpty()) || (Field23.trim().isEmpty()) || (Field24.trim().isEmpty())  || (Field25.trim().isEmpty())
                || (Field26.trim().isEmpty()) || (Field27.trim().isEmpty()) || (Field28.trim().isEmpty())  || (Field29.trim().isEmpty())  || (Field30.trim().isEmpty()) || (Field31.trim().isEmpty()) )    {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Ειδοποίηση");
            alert.setHeaderText("Προσοχή!");
            alert.setContentText("Δεν έχεις συμπληρώσει όλα τα πεδία!");
            alert.showAndWait();
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Θέλετε να οριστικοποιήσετε την δήλωση;");
            alert.setHeaderText("Επιβεβαίωση Υποβολής Στοιχείων.");
            alert.setContentText("Επιλέξτε.");

            ButtonType buttonTypeOne = new ButtonType("Ναι, τελική υποβολή");
            ButtonType buttonTypeTwo = new ButtonType("Όχι, διόρθωση στοιχείων");

            ButtonType buttonTypeCancel = new ButtonType("Ακύρωση, διαγραφή στοιχείων!", ButtonBar.ButtonData.CANCEL_CLOSE);

            alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo, buttonTypeCancel);

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == buttonTypeOne){

                insert(Field1, Field2, Field3, Field4, Field5, Field6, Field7, Field8, Field9, Field10, Field11, Field12, Field13, Field14, Field15, Field16, Field17, Field18, Field19, Field20, Field21, Field22, Field23, Field24, Field25, Field26, Field27, Field28, Field29, Field30, Field31);

                /**
                 * *
                 *  Also I have to pass the values to the next screen
                 * **/

                Stage primaryStage = (Stage) view_btn.getScene().getWindow();

                primaryStage.close();

                Stage stage = new Stage();



                try {
                    FXMLLoader loader = new FXMLLoader(Main.class.getResource("dhlBaptTable.fxml"));

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
                field26.setText("");
                field27.setText("");
                field28.setText("");
                field29.setText("");
                field30.setText("");
                field31.setText("");
            }


        }





    }



}
