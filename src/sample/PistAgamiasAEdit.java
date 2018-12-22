package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;

public class PistAgamiasAEdit implements Initializable {


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
    public JFXButton menu_btn;
    public JFXButton view_btn;
    public JFXButton btn_add;
    String Field1, Field2, Field3, Field4, Field5, Field6, Field7, Field8, Field9, Field10, Field11, Field12, Field13, Field14, Field15, Field16, Field17, Field18, Field19, Field20, Field21, Field22, Field23, Field24, Field25;



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
     //Ενημέρωση  Βάσης
     //*******************************/

    public void update(int id,  String Field1,String Field2,String Field3,String Field4,String Field5,String Field6,String Field7,String Field8,String Field9,String Field10,String Field11,String Field12,String Field13,String Field14,String Field15,String Field16,String Field17,String Field18,String Field19,String Field20,String Field21,String Field22,String Field23,String Field24,String Field25) {
        String sql = "UPDATE dataAgamiasA SET field1 = ? , "
                + "field2 = ? ,"
                + "field3 = ? ,"
                + "field4 = ? ,"
                + "field5 = ? ,"
                + "field6 = ? ,"
                + "field7 = ? ,"
                + "field8 = ? ,"
                + "field9 = ? ,"
                + "field10 = ?, "
                + "field11 = ? ,"
                + "field12 = ? ,"
                + "field13 = ? ,"
                + "field14 = ? ,"
                + "field15 = ? ,"
                + "field16 = ? ,"
                + "field17 = ? ,"
                + "field18 = ? ,"
                + "field19 = ?, "
                + "field20 = ?, "
                + "field21 = ?, "
                + "field22 = ?, "
                + "field23 = ?, "
                + "field24 = ?, "
                + "field25 = ?"
                + "WHERE id = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param

            pstmt.setString(1,  Field1);
            pstmt.setString(2,  Field2);
            pstmt.setString(3,  Field3);
            pstmt.setString(4,  Field4);
            pstmt.setString(5,  Field5);
            pstmt.setString(6,  Field6);
            pstmt.setString(7,  Field7);
            pstmt.setString(8,  Field8);
            pstmt.setString(9,  Field9);
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
            pstmt.setInt(26, id);

            // update
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /*******************************
     //Επιλογή άδειας
     /*******************************/

    public void selectRow(int id) {
        String sql = "SELECT * FROM dataAgamiasA WHERE id = ?";

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



            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    int id;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Preferences preferences = Preferences.userNodeForPackage(PistAgamiasAEdit.class);
        String pass_id = preferences.get("id",null);

        id = Integer.parseInt(pass_id);
        selectRow(id);

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
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("pistAgamiasATable.fxml"));

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

    public void getDataInsertData() {
        String Field1, Field2, Field3, Field4, Field5, Field6, Field7, Field8, Field9, Field10, Field11, Field12, Field13, Field14, Field15, Field16, Field17, Field18, Field19, Field20, Field21, Field22, Field23, Field24, Field25;




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



        if (       (Field1.trim().isEmpty())  || (Field2.trim().isEmpty()) || (Field3.trim().isEmpty()) || (Field4.trim().isEmpty()) || (Field5.trim().isEmpty())
                || (Field6.trim().isEmpty())  || (Field7.trim().isEmpty()) || (Field8.trim().isEmpty()) || (Field9.trim().isEmpty()) || (Field10.trim().isEmpty())
                || (Field11.trim().isEmpty()) || (Field12.trim().isEmpty()) || (Field13.trim().isEmpty()) || (Field14.trim().isEmpty()) || (Field15.trim().isEmpty())
                || (Field16.trim().isEmpty()) || (Field17.trim().isEmpty()) || (Field18.trim().isEmpty()) || (Field19.trim().isEmpty()) || (Field20.trim().isEmpty())
                || (Field21.trim().isEmpty()) || (Field22.trim().isEmpty()) || (Field23.trim().isEmpty()) || (Field24.trim().isEmpty()) || (Field25.trim().isEmpty())


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

                update(id,Field1, Field2, Field3, Field4, Field5, Field6, Field7, Field8, Field9, Field10, Field11, Field12, Field13, Field14, Field15, Field16, Field17, Field18, Field19, Field20, Field21, Field22, Field23, Field24, Field25);

                /**
                 * *
                 *  Also I have to pass the values to the next screen
                 * **/


                Stage primaryStage = (Stage) view_btn.getScene().getWindow();

                primaryStage.close();

                Stage stage = new Stage();



                try {
                    FXMLLoader loader = new FXMLLoader(Main.class.getResource("pistAgamiasATable.fxml"));

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

            }


        }


    }
}
