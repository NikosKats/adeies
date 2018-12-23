package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.print.Printer;
import javafx.print.PrinterJob;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.HTMLEditor;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;

public class PistAgamiasAView implements Initializable {
    public JFXButton print_btn;
    public JFXButton create_new_btn;
    public JFXButton view_btn;
    public JFXButton menu_btn;
    public HTMLEditor htmlEditor;
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
    public AnchorPane anchorPanePrint;

    String Field1, Field2, Field3, Field4, Field5, Field6, Field7, Field8, Field9, Field10, Field11, Field12, Field13, Field14, Field15, Field16, Field17, Field18, Field19, Field20, Field21, Field22, Field23, Field24, Field25;

    @FXML
    private JFXTextField textField;

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


    public void create_new(ActionEvent actionEvent)  {

        Stage primaryStage = (Stage) create_new_btn.getScene().getWindow();

        primaryStage.close();

        Stage stage = new Stage();



        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("pistAgamiasA.fxml"));

            AnchorPane pane = loader.load();


            Scene scene = new Scene(pane);



            scene.getStylesheets().addAll(Main.class.getResource("style.css").toExternalForm());

            stage.setResizable(false);
            stage.setTitle("Πιστοποιητικό Αγαμίας Α");
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
            stage.setTitle("Προβολή Λίστας Δηλώσεων");
            stage.setScene(scene);
            stage.show();






        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void print(ActionEvent actionEvent) throws Exception{
        PrinterJob job = PrinterJob.createPrinterJob();
        if(job != null){

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Επιλογή Άδειας Για Εκτύπωση.");
            alert.setHeaderText("Θέλετε να εκτυπώσετε την άδεια από το αριστερό ή από το δεξί παράθυρο;");
            alert.setContentText("Επιλέξτε.");

            ButtonType buttonTypeOne = new ButtonType("Εκτύπωση άδειας αριστερού παραθύρου");
            ButtonType buttonTypeTwo = new ButtonType("Εκτύπωση άδειας δεξιού παραθύρου");

            alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo);

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == buttonTypeOne) {
                htmlEditor.print(PrinterJob.createPrinterJob(Printer.getDefaultPrinter()));

            } else if (result.get() == buttonTypeTwo) {
                job.printPage(anchorPanePrint);
                job.endJob();
            }
        }


//        try{
//            htmlEditor.print(PrinterJob.createPrinterJob(Printer.getDefaultPrinter()));
//        }
//        catch (RuntimeException ex)
//        {
//            ex.printStackTrace();
//        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Preferences preferences = Preferences.userNodeForPackage(PistAgamiasAView.class);
        String pass_id = preferences.get("id",null);

        int id = Integer.parseInt(pass_id);
        selectRow(id);



        String INITIAL_TEXT = "<div style=\"text-align: center;\">&Iota;&Epsilon;&Rho;&Alpha; &Mu;&Eta;&Tau;&Rho;&Omicron;&Pi;&Omicron;&Lambda;&Iota;&Sigma;&nbsp;" +
                ""+Field1+" </div>\n" +
                "<div style=\"text-align: center;\">&Epsilon;&Nu;&Omicron;&Rho;&Iota;&Alpha;&Kappa;&Omicron;&Sigma; &Iota;.&Nu;&Alpha;&Omicron;&Sigma; "+Field2+"&nbsp;</div>\n" +
                "<div style=\"text-align: center;\">&Alpha;&rho;&iota;&theta;&mu;.&Pi;&rho;&omega;&tau;. "+Field3+"&nbsp;</div>\n" +
                "<div style=\"text-align: center;\">&nbsp;</div>\n" +
                "<div style=\"text-align: center;\">&nbsp;</div>\n" +
                "<div style=\"text-align: center;\">&nbsp;</div>\n" +
                "<div style=\"text-align: center;\">&nbsp;</div>\n" +
                "<div style=\"text-align: center;\">&Pi;&Iota;&Sigma;&Tau;&Omicron;&Pi;&Omicron;&Iota;&Eta;&Tau;&Iota;&Kappa;&Omicron;&Nu; &Alpha;&Gamma;&Alpha;&Mu;&Iota;&Alpha;&Sigma; (&Tau;&Upsilon;&Pi;&Omicron;&Sigma; &Alpha;΄)&nbsp;</div>\n" +
                "<div style=\"text-align: center;\">&nbsp;</div>\n" +
                "<div style=\"text-align: center;\">&nbsp;</div>\n" +
                "<div style=\"text-align: center;\">&nbsp;</div>\n" +
                "<div style=\"text-align: center;\">Ὁ ὑ&pi;&omicron;&gamma;&epsilon;&gamma;&rho;&alpha;&mu;&mu;έ&nu;&omicron;&sigmaf; "+Field4+"</div>\n" +
                "<div style=\"text-align: center;\">Ἐ&phi;&eta;&mu;έ&rho;&iota;&omicron;&sigmaf; &tau;&omicron;ῦ Ἱ&epsilon;&rho;&omicron;ῦ &Nu;&alpha;&omicron;ῦ &nbsp; "+Field5+" &nbsp;</div>\n" +
                "<div style=\"text-align: center;\">&pi;&iota;&sigma;&tau;&omicron;&pi;&omicron;&iota;ῶ ὑ&pi;&epsilon;&upsilon;&theta;ύ&nu;&omega;&sigmaf; ὃ&tau;&iota;: ὁ ἢ ἡ "+Field6+" &nbsp;</div>\n" +
                "<div style=\"text-align: center;\">&tau;&omicron;ῦ "+Field7+" &kappa;&alpha;ί &tau;ῆ&sigmaf; "+Field8+" &tau;ό &gamma;έ&nu;&omicron;&sigmaf;</div>\n" +
                "<div style=\"text-align: center;\">&nbsp; "+Field9+" &gamma;&epsilon;&nu;&nu;&eta;&theta;&epsilon;&iota; "+Field10+" ἐ&nu; </div>\n" +
                "<div style=\"text-align: center;\">&nbsp; "+Field11+" &tau;ό ἒ&tau;&omicron;&sigmaf; "+Field12+" </div>\n" +
                "<div style=\"text-align: center;\">&kappa;&alpha;ί ἐ&nu; &tau;ῆ ἡ&mu;&epsilon;&tau;έ&rho;&alpha; ἐ&nu;&omicron;&rho;ί&alpha; &delta;&iota;&alpha;&mu;έ&nu; "+Field13+" ἀ&pi;ό &tau;&omicron;ῦ ἒ&tau;&omicron;&upsilon;&sigmaf; "+Field14+" (ὁ&delta;ό&sigmaf;</div>\n" +
                "<div style=\"text-align: center;\">"+Field15+" ἀ&rho; "+Field16+" )</div>\n" +
                "<div style=\"text-align: center;\">ἐ&tau;ῶ&nu; "+Field17+" ἐ&pi;&alpha;&gamma;&gamma;έ&lambda;&mu;&alpha;&tau;&omicron;&sigmaf; "+Field18+"</div>\n" +
                "<div style=\"text-align: center;\">&kappa;&alpha;ί &chi;&rho;&iota;&sigma;&tau;&iota;&alpha;&nu; "+Field19+" ὀ&rho;&theta;ό&delta;&omicron;&xi;&omicron;&sigmaf;,&tau;&upsilon;&gamma;&chi;ά&nu;&epsilon;&iota; ἂ&gamma;&alpha;&mu;&omicron;&sigmaf; </div>\n" +
                "<div style=\"text-align: center;\"> "+Field20+" </div>\n" +
                "<div style=\"text-align: center;\">&kappa;&alpha;ί &delta;ύ&nu;&alpha;&tau;&alpha;&iota; &nu;ά &sigma;&upsilon;&nu;ά&psi;&eta; &gamma;ά&mu;&omicron;&nu;"+Field21+"</div>\n" +
                "<div style=\"text-align: center;\">&Chi;&omicron;&rho;&eta;&gamma;&epsilon;ῖ&tau;&alpha;&iota; &tau;ό &pi;&alpha;&rho;ό&nu; &delta;&iota;ά &tau;ή&nu; ἒ&kappa;&delta;&omicron;&sigma;&iota;&nu; ἀ&delta;&epsilon;ί&alpha;&sigmaf; &gamma;ά&mu;&omicron;&upsilon; &tau;</div>\n" +
                "<div style=\"text-align: center;\"> "+Field22+" </div>\n" +
                "<div style=\"text-align: center;\">Ἐ&nu; "+Field23+" &nbsp; &nbsp; &tau;ῆ "+Field24+" &nbsp; &nbsp; &nbsp;20"+Field25+"</div>\n" +
                "<div style=\"text-align: center;\">&nbsp;</div>\n" +
                "<div style=\"text-align: center;\">&nbsp;</div>\n" +
                "<div style=\"text-align: center;\">&Omicron; &Epsilon;&Phi;&Eta;&Mu;&Epsilon;&Rho;&Iota;&Omicron;&Sigma;</div>\n" +
                "<p style=\"text-align: center;\">&nbsp;</p>" ;


        htmlEditor.setHtmlText(INITIAL_TEXT);
    }
}
