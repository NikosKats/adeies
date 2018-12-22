package sample;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;

public class DhlBaptEdit implements Initializable {


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
    String Field1, Field2, Field3, Field4, Field5, Field6, Field7, Field8, Field9, Field10, Field11, Field12, Field13, Field14, Field15, Field16, Field17, Field18, Field19, Field20, Field21, Field22, Field23, Field24, Field25, Field26, Field27, Field28, Field29, Field30, Field31;



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
        String sql = "SELECT * FROM dataBaptisis WHERE id = ?";

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


            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Preferences preferences = Preferences.userNodeForPackage(DhlBaptTable.class);
        String pass_id = preferences.get("id",null);

        int id = Integer.parseInt(pass_id);
        selectRow(id);

    }

    public void main_menu(ActionEvent actionEvent) {
    }

    public void view_screen(ActionEvent actionEvent) {
    }

    public void getDataInsertData(ActionEvent actionEvent) {
    }
}
