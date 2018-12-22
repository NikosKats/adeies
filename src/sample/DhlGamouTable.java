package sample;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;

public class DhlGamouTable implements Initializable {

    public JFXButton create_new_btn;
    public JFXButton menu_btn;
    public TableView tableView;
    public TableColumn col1,col2,col3,col4,col5,col6,col7,col8,col9,col10,col11,col12;

    public JFXButton view_btn;
    public JFXButton edit_btn;
    public JFXButton delete_btn;
    public JFXButton refresh_btn;

    int id;
    String Field2, Field5, Field10, Field4, Field12, Field13, Field14, Field18, Field19, Field28, Field29, Field88;

    ObservableList<GamosTableData> obList = FXCollections.observableArrayList();

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
        String sql = "DELETE FROM dataGamou WHERE id = ?";

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
        String sql = "SELECT * FROM dataGamou";




        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){

            // loop through the result set
            while (rs.next()) {

                id = rs.getInt("id");
                String s_id = Integer.toString(id);

                Field2 = rs.getString("Field2");
                Field5 = rs.getString("Field5");
                Field10 = rs.getString("Field10");
                Field12 = rs.getString("Field12");
                Field13 = rs.getString("Field13");
                Field14 = rs.getString("Field14");
                Field18 = rs.getString("Field18");
                Field19 = rs.getString("Field19");
                Field28 = rs.getString("Field28");
                Field29 = rs.getString("Field29");
                Field88 = rs.getString("Field88");

                obList.add(new GamosTableData(s_id,Field2,Field5,Field10,Field12,Field13,Field14,Field18,Field19,Field28,Field29,Field88));


                col1.setCellValueFactory(new PropertyValueFactory<>("id"));
                col2.setCellValueFactory(new PropertyValueFactory<>("Field2"));
                col3.setCellValueFactory(new PropertyValueFactory<>("Field5"));
                col4.setCellValueFactory(new PropertyValueFactory<>("Field10"));
                col5.setCellValueFactory(new PropertyValueFactory<>("Field12"));
                col6.setCellValueFactory(new PropertyValueFactory<>("Field13"));
                col7.setCellValueFactory(new PropertyValueFactory<>("Field14"));
                col8.setCellValueFactory(new PropertyValueFactory<>("Field18"));
                col9.setCellValueFactory(new PropertyValueFactory<>("Field19"));
                col10.setCellValueFactory(new PropertyValueFactory<>("Field28"));
                col11.setCellValueFactory(new PropertyValueFactory<>("Field29"));
                col12.setCellValueFactory(new PropertyValueFactory<>("Field88"));
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
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("dhlGamou.fxml"));

            AnchorPane pane = loader.load();


            Scene scene = new Scene(pane);

            scene.getStylesheets().addAll(Main.class.getResource("style.css").toExternalForm());

            stage.setResizable(false);
            stage.setTitle("Δήλωση Γάμου");
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
        GamosTableData data = (GamosTableData) tableView.getSelectionModel().getSelectedItem();

        if(data == null)
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Ειδοποίηση");
            alert.setHeaderText("Προσοχή!");
            alert.setContentText("Δεν έχεις επιλέξει άδεια για προβολή!");
            alert.showAndWait();
        }

        else
        {
            System.out.println("ok");

            String pass_id = data.getId();

            Preferences preferences = Preferences.userNodeForPackage(DhlBaptTable.class);
            preferences.put("id",pass_id);




            Stage primaryStage = (Stage) view_btn.getScene().getWindow();
            primaryStage.close();

            Stage stage = new Stage();

            try {
                FXMLLoader loader = new FXMLLoader(Main.class.getResource("dhlGamouView.fxml"));
                AnchorPane pane = loader.load();
                Scene scene = new Scene(pane);


                scene.getStylesheets().addAll(Main.class.getResource("style.css").toExternalForm());

                stage.setResizable(false);
                stage.setTitle("Προβολή Δήλωσης Γάμου");

                stage.setScene(scene);
                stage.show();


            } catch (IOException e) {
                e.printStackTrace();
            }


        }

    }

    public void edit(ActionEvent actionEvent) {
        GamosTableData data = (GamosTableData) tableView.getSelectionModel().getSelectedItem();

        if(data == null)
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Ειδοποίηση");
            alert.setHeaderText("Προσοχή!");
            alert.setContentText("Δεν έχεις επιλέξει άδεια προς επεξεργασία!");
            alert.showAndWait();
        }
        else {
            String pass_id = data.getId();

            Preferences preferences = Preferences.userNodeForPackage(DhlBaptTable.class);
            preferences.put("id",pass_id);




            Stage primaryStage = (Stage) edit_btn.getScene().getWindow();
            primaryStage.close();

            Stage stage = new Stage();

            try {
                FXMLLoader loader = new FXMLLoader(Main.class.getResource("dhlGamouEdit.fxml"));
                AnchorPane pane = loader.load();
                Scene scene = new Scene(pane);


                scene.getStylesheets().addAll(Main.class.getResource("style.css").toExternalForm());

                stage.setResizable(false);
                stage.setTitle("Επεξεργασία Δήλωσης Γάμου");

                stage.setScene(scene);
                stage.show();


            } catch (IOException e) {
                e.printStackTrace();
            }

        }



    }

    public void delete(ActionEvent actionEvent) {
        GamosTableData data = (GamosTableData) tableView.getSelectionModel().getSelectedItem();

        if(data == null)
        {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Ειδοποίηση");
            alert.setHeaderText("Προσοχή!");
            alert.setContentText("Δεν έχεις επιλέξει άδεια προς διαγραφή!");
            alert.showAndWait();
        }
        else {

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
            if (result.get() == buttonTypeOne) {
                delete(id);


                Stage primaryStage = (Stage) delete_btn.getScene().getWindow();
                primaryStage.close();

                Stage stage = new Stage();

                try {
                    FXMLLoader loader = new FXMLLoader(Main.class.getResource("dhlGamouTable.fxml"));
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
    }

    public void refresh(ActionEvent actionEvent) {

        Stage primaryStage = (Stage) refresh_btn.getScene().getWindow();
        primaryStage.close();

        Stage stage = new Stage();

        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("dhlGamouTable.fxml"));
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
