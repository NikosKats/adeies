package sample;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class PistAgamiasBTable implements Initializable {
    public JFXButton create_new_btn;
    public JFXButton menu_btn;

    public TableView tableView;
    public TableColumn col1,col2,col3,col4,col5,col6,col7,col8,col9;

    int id;
    String Field2, Field3, Field4, Field7, Field10, Field11, Field12, Field13;


    ObservableList<PistAgamiasBTableData> obList = FXCollections.observableArrayList();

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
     //Επιλογή από τη Βάση
     /*******************************/

    public void selectAll(){
        String sql = "SELECT * FROM dataAgamiasB";




        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){

            // loop through the result set
            while (rs.next()) {

                id = rs.getInt("id");
                String s_id = Integer.toString(id);

                Field2 = rs.getString("Field2");
                Field3 = rs.getString("Field3");
                Field4 = rs.getString("Field4");
                Field7 = rs.getString("Field7");
                Field10 = rs.getString("Field10");
                Field11 = rs.getString("Field11");
                Field12 = rs.getString("Field12");
                Field13 = rs.getString("Field13");


                obList.add(new PistAgamiasBTableData(s_id,Field2,Field3,Field4,Field7,Field10,Field11,Field12,Field13));


                col1.setCellValueFactory(new PropertyValueFactory<>("id"));
                col2.setCellValueFactory(new PropertyValueFactory<>("Field2"));
                col3.setCellValueFactory(new PropertyValueFactory<>("Field3"));
                col4.setCellValueFactory(new PropertyValueFactory<>("Field4"));
                col5.setCellValueFactory(new PropertyValueFactory<>("Field7"));
                col6.setCellValueFactory(new PropertyValueFactory<>("Field10"));
                col7.setCellValueFactory(new PropertyValueFactory<>("Field11"));
                col8.setCellValueFactory(new PropertyValueFactory<>("Field12"));
                col9.setCellValueFactory(new PropertyValueFactory<>("Field13"));

                tableView.setItems(obList);

            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }



    public void create_new(ActionEvent actionEvent) {

        Stage primaryStage = (Stage) create_new_btn.getScene().getWindow();

        primaryStage.close();

        Stage stage = new Stage();



        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("pistAgamiasB.fxml"));

            AnchorPane pane = loader.load();


            Scene scene = new Scene(pane);



            scene.getStylesheets().addAll(Main.class.getResource("style.css").toExternalForm());

            stage.setResizable(false);
            stage.setTitle("Πιστοποιητικό Αγαμίας Β");
            stage.setScene(scene);
            stage.show();




        } catch (IOException e) {
            e.printStackTrace();
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        selectAll();
    }
}
