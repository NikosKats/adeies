package sample;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;

public class DhlBaptTable  implements Initializable{

    public TableView tableView;
    public TableColumn col1,col2,col3,col4,col5,col6,col7,col8,col9,col10,col11;



    int id;
    String Field1, Field2, Field3, Field4, Field5, Field6, Field7, Field8, Field9, Field10, Field11, Field12, Field13, Field14, Field15, Field16, Field17, Field18, Field19, Field20, Field21, Field22, Field23, Field24, Field25, Field26, Field27, Field28, Field29, Field30, Field31;


    ObservableList<BaptisiTableData> obList = FXCollections.observableArrayList();

    public JFXButton create_new_btn;
    public JFXButton menu_btn;
    public JFXButton view_btn;
    public JFXButton edit_btn;
    public JFXButton delete_btn;
    public JFXButton refresh_btn;


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
    //Διαγραφή από Βάση
    /******************************/

    public void delete(int id) {
        String sql = "DELETE FROM dataBaptisis WHERE id = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setInt(1, id);
            // execute the delete statement
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /*******************************
    //Επιλογή από τη Βάση
    /*******************************/

    public void selectAll(){
        String sql = "SELECT * FROM dataBaptisis";




        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){

            // loop through the result set
            while (rs.next()) {

                id = rs.getInt("id");
                String s_id = Integer.toString(id);

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

                obList.add(new BaptisiTableData(s_id,Field2,Field3,Field4,Field6,Field7,Field8,Field11,Field12,Field23,Field31));


                col1.setCellValueFactory(new PropertyValueFactory<>("id"));
                col2.setCellValueFactory(new PropertyValueFactory<>("Field2"));
                col3.setCellValueFactory(new PropertyValueFactory<>("Field3"));
                col4.setCellValueFactory(new PropertyValueFactory<>("Field4"));
                col5.setCellValueFactory(new PropertyValueFactory<>("Field6"));
                col6.setCellValueFactory(new PropertyValueFactory<>("Field7"));
                col7.setCellValueFactory(new PropertyValueFactory<>("Field8"));
                col8.setCellValueFactory(new PropertyValueFactory<>("Field11"));
                col9.setCellValueFactory(new PropertyValueFactory<>("Field12"));
                col10.setCellValueFactory(new PropertyValueFactory<>("Field23"));
                col11.setCellValueFactory(new PropertyValueFactory<>("Field31"));

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
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("dhlBapt.fxml"));

            AnchorPane pane = loader.load();


            Scene scene = new Scene(pane);





            scene.getStylesheets().addAll(Main.class.getResource("style.css").toExternalForm());

            stage.setResizable(false);
            stage.setTitle("Δήλωση Βαπτίσεως");
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

    public void view(ActionEvent actionEvent) {
        BaptisiTableData data = (BaptisiTableData) tableView.getSelectionModel().getSelectedItem();


        String pass_id = data.getId();

        Preferences preferences = Preferences.userNodeForPackage(DhlBaptTable.class);
        preferences.put("id",pass_id);




       Stage primaryStage = (Stage) view_btn.getScene().getWindow();
       primaryStage.close();

        Stage stage = new Stage();

        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("dhlBaptView.fxml"));
            AnchorPane pane = loader.load();
            Scene scene = new Scene(pane);


            scene.getStylesheets().addAll(Main.class.getResource("style.css").toExternalForm());

            stage.setResizable(false);
            stage.setTitle("Προβολή Δήλωσης");

            stage.setScene(scene);
            stage.show();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void edit(ActionEvent actionEvent) {
        BaptisiTableData data = (BaptisiTableData) tableView.getSelectionModel().getSelectedItem();


        String pass_id = data.getId();

        Preferences preferences = Preferences.userNodeForPackage(DhlBaptTable.class);
        preferences.put("id",pass_id);




        Stage primaryStage = (Stage) edit_btn.getScene().getWindow();
        primaryStage.close();

        Stage stage = new Stage();

        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("dhlBaptEdit.fxml"));
            AnchorPane pane = loader.load();
            Scene scene = new Scene(pane);


            scene.getStylesheets().addAll(Main.class.getResource("style.css").toExternalForm());

            stage.setResizable(false);
            stage.setTitle("Επεξεργασία Δήλωσης");

            stage.setScene(scene);
            stage.show();


        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void delete(ActionEvent actionEvent) {
        BaptisiTableData data = (BaptisiTableData) tableView.getSelectionModel().getSelectedItem();


        String pass_id = data.getId();
        int id = Integer.parseInt(pass_id);

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Θέλετε να διαγράψετε οριστικά την δήλωση;");
        alert.setHeaderText("Επιβεβαίωση Διαγραφής Στοιχείων.");
        alert.setContentText("Επιλέξτε.");

        ButtonType buttonTypeOne = new ButtonType("Ναι, διαγραφή δήλωσης");
        ButtonType buttonTypeTwo = new ButtonType("Όχι, ακύρωση διαγραφής");


        alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == buttonTypeOne){
            delete(id);


            Stage primaryStage = (Stage) delete_btn.getScene().getWindow();
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



        } else if (result.get() == buttonTypeTwo) {
            // ... user chose "Two"
        }
    }

    public void refresh(ActionEvent actionEvent) {

        Stage primaryStage = (Stage) refresh_btn.getScene().getWindow();
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


    @Override
    public void initialize(URL location, ResourceBundle resources) {
       selectAll();

    }
}
