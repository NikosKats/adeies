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

public class PistAgamiasBView implements Initializable {
    public JFXButton print_btn;
    public JFXButton create_new_btn;
    public JFXButton view_btn;
    public JFXButton menu_btn;
    public HTMLEditor htmlEditor;


    public HTMLEditor htmlEditor2;

    String Field1, Field2, Field3, Field4, Field5, Field6, Field7, Field8, Field9, Field10, Field11, Field12, Field13, Field14, Field15, Field16, Field17, Field18, Field19, Field20, Field21, Field22, Field23, Field24, Field25, Field26, Field27, Field28, Field29, Field30, Field31;
    String Field32, Field33, Field34, Field35, Field36, Field37, Field38;


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
        String sql = "SELECT * FROM dataAgamiasB WHERE id = ?";

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

    public void view_screen(ActionEvent actionEvent) {
        Stage primaryStage = (Stage) view_btn.getScene().getWindow();

        primaryStage.close();

        Stage stage = new Stage();



        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("pistAgamiasBTable.fxml"));

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
        Preferences preferences = Preferences.userNodeForPackage(PistAgamiasBView.class);
        String pass_id = preferences.get("id",null);

        int id = Integer.parseInt(pass_id);
        selectRow(id);



        String INITIAL_TEXT = "<div style=\"text-align: center;\">&Iota;&Epsilon;&Rho;&Alpha; &Mu;&Eta;&Tau;&Rho;&Omicron;&Pi;&Omicron;&Lambda;&Iota;&Sigma; "+Field1+"</div>\n" +
                "<div style=\"text-align: center;\">&Epsilon;&Nu;&Omicron;&Rho;&Iota;&Alpha;&Kappa;&Omicron;&Sigma; &Iota;.&Nu;&Alpha;&Omicron;&Sigma; "+Field2+"&nbsp;</div>\n" +
                "<div style=\"text-align: center;\">&Alpha;&rho;&iota;&theta;&mu;.&Pi;&rho;&omega;&tau; "+Field3+" &nbsp;</div>\n" +
                "<div style=\"text-align: center;\">&nbsp;</div>\n" +
                "<div style=\"text-align: center;\">&nbsp;</div>\n" +
                "<div style=\"text-align: center;\">&nbsp;</div>\n" +
                "<div style=\"text-align: center;\">&Pi;&Iota;&Sigma;&Tau;&Omicron;&Pi;&Omicron;&Iota;&Eta;&Tau;&Iota;&Kappa;&Omicron;&Nu; &Alpha;&Gamma;&Alpha;&Mu;&Iota;&Alpha;&Sigma; (&Tau;&Upsilon;&Pi;&Omicron;&Sigma; &Beta;΄)&nbsp;</div>\n" +
                "<div style=\"text-align: center;\">&nbsp;</div>\n" +
                "<div style=\"text-align: center;\">&nbsp;</div>\n" +
                "<div style=\"text-align: center;\">Ὁ ὑ&pi;&omicron;&gamma;&epsilon;&gamma;&rho;&alpha;&mu;&mu;έ&nu;&omicron;&sigmaf; "+Field4+"</div>\n" +
                "<div style=\"text-align: center;\">Ἐ&phi;&eta;&mu;έ&rho;&iota;&omicron;&sigmaf; &tau;&omicron;ῦ Ἱ&epsilon;&rho;&omicron;ῦ &Nu;&alpha;&omicron;ῦ &nbsp; "+Field5+ " &nbsp;</div>\n" +
                "<div style=\"text-align: center;\">&beta;&epsilon;&beta;&alpha;&iota;ῶ ὃ&tau;&iota; &pi;&rho;&omicron;&sigma;&epsilon;&lambda;&theta; "+Field6+" ἐ&nu;ώ&pi;&iota;ό&nu; &mu;&omicron;&upsilon; ὁ ἢ ἡ "+Field7+" </div>\n" +
                "<div style=\"text-align: center;\">&tau;&omicron;ῦ "+Field8+" &kappa;&alpha;ί &tau;ῆ&sigmaf; "+Field9+" &tau;ό &gamma;έ&nu;&omicron;&sigmaf;</div>\n" +
                "<div style=\"text-align: center;\">&nbsp; "+Field10+" &gamma;&epsilon;&nu;&nu;&eta;&theta;&epsilon;&iota; "+Field11+" ἐ&nu; "+Field12+" </div>\n" +
                "<div style=\"text-align: center;\">&nbsp;. "+Field13+" &tau;ό ἒ&tau;&omicron;&sigmaf; "+Field14+" </div>\n" +
                "<div style=\"text-align: center;\">&kappa;&alpha;ί ἐ&nu; &tau;ῆ ἡ&mu;&epsilon;&tau;έ&rho;&alpha; ἐ&nu;&omicron;&rho;ί&alpha; &delta;&iota;&alpha;&mu;έ&nu;  "+Field15+" ἀ&pi;ό &tau;&omicron;ῦ ἒ&tau;&omicron;&upsilon;&sigmaf; "+Field16+" (ὁ&delta;ό&sigmaf;</div>\n" +
                "<div style=\"text-align: center;\">"+Field16+" ἀ&rho; "+Field17+" )</div>\n" +
                "<div style=\"text-align: center;\">ἐ&tau;ῶ&nu; "+Field18+" ἐ&pi;&alpha;&gamma;&gamma;έ&lambda;&mu;&alpha;&tau;&omicron;&sigmaf; "+Field19+"</div>\n" +
                "<div style=\"text-align: center;\">&kappa;&alpha;ί &chi;&rho;&iota;&sigma;&tau;&iota;&alpha;&nu; "+Field20+" ὀ&rho;&theta;ό&delta;&omicron;&xi;&omicron;&sigmaf;,ὑ&pi;έ&gamma;&rho;&alpha;&psi;&epsilon; &tau;ή&nu; &sigma;&upsilon;&nu;&eta;&mu;&mu;έ&nu;&eta;&nu; &delta;ή&lambda;&omega;&sigma;&iota;&nu;&nbsp;</div>\n" +
                "<div style=\"text-align: center;\">&tau;&omicron;ῦ &pi;&epsilon;&rho;ί &tau;ῆ&sigmaf; &kappa;&alpha;&tau;&omicron;&iota;&kappa;ί&alpha;&sigmaf; &kappa;&alpha;ί ἀ&gamma;&alpha;&mu;ί&alpha;&sigmaf; "+Field21+" </div>\n" +
                "<div style=\"text-align: center;\">&nbsp;</div>\n" +
                "<div style=\"text-align: center;\">Ὡ&sigma;&alpha;ύ&tau;&omega;&sigmaf; &pi;&rho;&omicron;&sigma;ῆ&lambda;&theta;&alpha;&nu; &omicron;ἱ ὑ&pi;&omicron;&gamma;&rho;ά&phi;&omicron;&nu;&tau;&epsilon;&sigmaf; &kappa;&alpha;&tau;&omega;&tau;έ&rho;&omega; &mu;ά&rho;&tau;&upsilon;&rho;&epsilon;&sigmaf;:(&pi;&lambda;ή&rho;&eta; &sigma;&tau;&omicron;&iota;&chi;&epsilon;ί&alpha; &tau;&alpha;&upsilon;&tau;ό&tau;&eta;&tau;&omicron;&sigmaf;)</div>\n" +
                "<div style=\"text-align: center;\">1. "+Field22+" </div>\n" +
                "<div style=\"text-align: center;\">2. Ἁ&rho;&iota;&theta;&mu;ό&sigmaf; &Tau;&alpha;&upsilon;&tau;ό&tau;&eta;&tau;&omicron;&sigmaf; "+Field23+" Ἀ&sigma;&tau;&upsilon;&nu;.&Tau;&mu;ῆ&mu;&alpha; "+Field24+" </div>\n" +
                "<div style=\"text-align: center;\">3. "+Field25+"</div>\n" +
                "<div style=\"text-align: center;\">4. Ἁ&rho;&iota;&theta;&mu;ό&sigmaf; &Tau;&alpha;&upsilon;&tau;ό&tau;&eta;&tau;&omicron;&sigmaf; "+Field26+" Ἀ&sigma;&tau;&upsilon;&nu;.&Tau;&mu;ῆ&mu;&alpha; "+Field27+" </div>\n" +
                "<div style=\"text-align: center;\">&omicron;ἲ&tau;&iota;&nu;&epsilon;&sigmaf; &pi;&rho;&omicron;έ&beta;&eta;&sigma;&alpha;&nu; &epsilon;ἰ&sigmaf; &tau;ή&nu; &delta;ή&lambda;&omega;&sigma;&iota;&nu;:</div>\n" +
                "<div style=\"text-align: center;\">&nbsp;&Delta;&eta;&lambda;&omicron;ῦ&mu;&epsilon;&nu; ὑ&pi;&epsilon;&upsilon;&theta;ύ&nu;&omega;&sigmaf; &kappa;&alpha;ί ἐ&nu; &gamma;&nu;ώ&sigma;&epsilon;&iota; &tau;ῶ&nu; &sigma;&upsilon;&nu;&epsilon;&pi;&epsilon;&iota;ῶ&nu; &tau;&omicron;ῦ &Nu;ό&mu;&omicron;&upsilon; &pi;&epsilon;&rho;ί &psi;&epsilon;&upsilon;&delta;&omicron;ῦ&sigmaf; &delta;&eta;&lambda;ώ&sigma;&epsilon;&omega;&sigmaf; ὃ&tau;&iota; ὁ ἢ</div>\n" +
                "<div style=\"text-align: center;\">ἡ ἀ&nu;&omega;&tau;έ&rho;&omega; &mu;&nu;&eta;&mu;&omicron;&nu;&epsilon;&upsilon;&theta; "+Field28+" &delta;&iota;&alpha;&mu;έ&nu;&epsilon;&iota; "+Field29+" &kappa;&alpha;ί ἐ&pi;ί &tau;ῆ&sigmaf; ὁ&delta;&omicron;ῦ "+Field30+" &nbsp;&nbsp;</div>\n" +
                "<div style=\"text-align: center;\">&tau;&upsilon;&gamma;&chi;ά&nu;&epsilon;&iota; &delta;έ ἂ&gamma;&alpha;&mu;&omicron;&sigmaf; "+Field31+" &kappa;&alpha;ί &delta;ύ&nu;&alpha;&tau;&alpha;&iota; &nu;ά &sigma;&upsilon;&nu;ά&psi;&eta; &gamma;ά&mu;&omicron;&nu;</div>\n" +
                "<div style=\"text-align: center;\">"+Field32+"</div>\n" +
                "<div style=\"text-align: center;\">&nbsp;</div>\n" +
                "<div style=\"text-align: center;\">&Omicron;&Iota; &Mu;&Alpha;&Rho;&Tau;&Upsilon;&Rho;&Epsilon;&Sigma;:(Ὑ&pi;&omicron;&gamma;&rho;&alpha;&phi;&alpha;ί)1. "+Field33+" 2. "+Field34+"</div>\n" +
                "<div style=\"text-align: center;\">&nbsp;&Pi;ά&nu;&tau;&alpha; &tau;ά ἀ&nu;&omega;&tau;έ&rho;&omega; &kappa;&alpha;&tau;&epsilon;&tau;έ&theta;&eta;&sigma;&alpha;&nu; &kappa;&alpha;ί ἐ&delta;&eta;&lambda;ώ&theta;&eta;&sigma;&alpha;&nu; ἐ&nu;ώ&pi;&iota;ό&nu; &mu;&omicron;&upsilon;,&nbsp;</div>\n" +
                "<div style=\"text-align: center;\">&chi;&omicron;&rho;&eta;&gamma;&epsilon;ῖ&tau;&alpha;&iota; &delta;έ &tau;ό &pi;&alpha;&rho;ό&nu; &delta;&iota;ά &tau;ή&nu;ἒ&kappa;&delta;&omicron;&sigma;&iota;&nu; ἀ&delta;&epsilon;ί&alpha;&sigmaf; &gamma;ά&mu;&omicron;&upsilon; &tau; "+Field35+" &nbsp;&nbsp;</div>\n" +
                "<div style=\"text-align: center;\">Ἐ&nu; "+Field36+" &nbsp; &nbsp; &tau;ῆ "+Field37+" &nbsp; &nbsp; &nbsp;20"+Field38+"</div>\n" +
                "<div style=\"text-align: center;\">&nbsp;</div>\n" +
                "<div style=\"text-align: center;\">&nbsp;</div>\n" +
                "<div style=\"text-align: center;\">&Omicron; &Epsilon;&Phi;&Eta;&Mu;&Epsilon;&Rho;&Iota;&Omicron;&Sigma;</div>\n" +
                "<p style=\"text-align: center;\">&nbsp;</p>" ;


        htmlEditor.setHtmlText(INITIAL_TEXT);


        String INITIAL_TEXT_2 = "";
        htmlEditor2.setHtmlText(INITIAL_TEXT_2);
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
               // job.printPage(anchorPanePrint);
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

}
