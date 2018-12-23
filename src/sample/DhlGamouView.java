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
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.HTMLEditor;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;

public class DhlGamouView implements Initializable {

    public HTMLEditor htmlEditor;
    public JFXButton print_btn;
    public JFXButton create_new_btn;
    public JFXButton view_btn;
    public JFXButton menu_btn;
    String CheckBox1, CheckBox2, CheckBox3, CheckBox4;


    String Field1, Field2, Field3, Field4, Field5, Field6, Field7, Field8, Field9, Field10, Field11, Field12, Field13, Field14, Field15, Field16, Field17, Field18, Field19, Field20, Field21, Field22, Field23, Field24, Field25, Field26, Field27, Field28, Field29, Field30, Field31;
    String Field32, Field33, Field34, Field35, Field36, Field37, Field38, Field39, Field40, Field41, Field42, Field43, Field44, Field45, Field46, Field47, Field48, Field49, Field50;
    String Field51, Field52, Field53, Field54, Field55, Field56, Field57, Field58, Field59, Field60, Field61, Field62, Field63, Field64, Field65, Field66, Field67, Field68;
    String Field69, Field70, Field71, Field72, Field73, Field74, Field75, Field76, Field77, Field78, Field79, Field80, Field81, Field82, Field83, Field84, Field85;
    String Field86, Field87, Field88;

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

                CheckBox1 = rs.getString("CheckBox1");
                CheckBox2 = rs.getString("CheckBox2");
                CheckBox3 = rs.getString("CheckBox3");
                CheckBox4 = rs.getString("CheckBox4");




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

    public void view_screen(ActionEvent actionEvent) {
        Stage primaryStage = (Stage) view_btn.getScene().getWindow();

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
        Preferences preferences = Preferences.userNodeForPackage(DhlGamouView.class);
        String pass_id = preferences.get("id",null);

        int id = Integer.parseInt(pass_id);
        selectRow(id);



        String INITIAL_TEXT = "<h3><span style=\"font-size: medium;\">&Iota;&Epsilon;&Rho;&Alpha; </span>&Mu;&Eta;&Tau;&Rho;&Omicron;&Pi;&Omicron;&Lambda;&Eta;....&xi;&kappa;&beta;.... &nbsp; &nbsp;<span style=\"font-size: medium;\">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&Alpha;&rho;&iota;&theta;&mu;.&lambda;&eta;&xi;.&pi;&rho;ά&xi;&eta; &gamma;ά&mu;&omicron;&upsilon;...&xi;&kappa;&xi;&kappa;&iota;&theta;...&Tau;ό&mu;&omicron;&sigmaf;...&xi;&kappa;...έ&tau;&omicron;&sigmaf;...&xi;&kappa;...</span>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &Iota;&Epsilon;&Rho;&Omicron;&Sigma; &Nu;&Alpha;&Omicron;&Sigma;....&nu;&xi;.... &nbsp; &nbsp; (&Alpha;&nu;&alpha;&gamma;&rho;ά&phi;&epsilon;&tau;&alpha;&iota; &alpha;&pi;ό &tau;&omicron; &Lambda;&eta;&xi;ί&alpha;&rho;&chi;&omicron;)&nbsp;</h3>\n" +
                "<h3>&nbsp; &nbsp; &Delta;&Eta;&Mu;&Omicron;&Tau;&Iota;&Kappa;&Omicron;/&Tau;&Omicron;&Pi;&Iota;&Kappa;&Omicron; &Delta;&Iota;&Alpha;&Mu;&Epsilon;&Rho;&Iota;&Sigma;&Mu;&Alpha;....&nu;&xi;&kappa;&xi;&kappa;&nu;....&nbsp; <span style=\"font-size: medium;\">&Omicron; &gamma;ά&mu;&omicron;&sigmaf; &delta;&eta;&lambda;ώ&nu;&epsilon;&tau;&alpha;&iota; &sigma;&tau;&omicron; &Lambda;&eta;&xi;&iota;&alpha;&rho;&chi;&epsilon;ί&omicron;, &mu;έ&sigma;&alpha; &sigma;&epsilon; (40) &sigma;&alpha;&rho;ά&nu;&tau;&alpha; &eta;&mu;έ&rho;&epsilon;&sigmaf;</span>&nbsp;</h3>\n" +
                "<h3>&nbsp; &Delta;&Eta;&Mu;&Omicron;&Sigma;/&Delta;&Eta;&Mu;&Omicron;&Tau;&Iota;&Kappa;&Eta; &Epsilon;&Nu;&Omicron;&Tau;&Eta;&Tau;&Alpha;....&nu;&xi;&kappa;.... &alpha;&pi;ό &tau;&eta;&nu; &tau;έ&lambda;&epsilon;&sigma;ή &tau;&omicron;&upsilon;, &sigma;ύ&mu;&phi;&omega;&nu;&alpha; &mu;&epsilon; &tau;&omicron; ά&rho;&theta;&rho;&omicron; 29,&pi;&alpha;&rho;&alpha;&gamma;&rho;. 1 &tau;&omicron;&upsilon; &Nu;.</h3>\n" +
                "<h3>&Delta;&Eta;&Mu;&Omicron;&Sigma;/&Delta;&Eta;&Mu;&Omicron;&Tau;&Iota;&Kappa;&Eta; &Epsilon;&Nu;&Omicron;&Tau;&Eta;&Tau;&Alpha;....&nu;&xi;&kappa;....</h3>\n" +
                "<h3><span style=\"font-size: medium;\">&Nu;&Omicron;&Mu;&Omicron;&Sigma;....&nu;&kappa;&xi;.... 344/1976 </span></h3>\n" +
                "<h3><span style=\"font-size: medium;\">&Alpha;&rho;&iota;&theta;&mu;. &Beta;&iota;&beta;&lambda;....&nu;&xi;&kappa;.... </span></h3>\n" +
                "<h3><span style=\"font-size: medium;\">&nbsp;</span></h3>\n" +
                "<h3><span style=\"font-size: medium;\">&nbsp;</span></h3>\n" +
                "<h3><span style=\"font-size: medium;\">&Delta;&Eta;&Lambda;&Omega;&Sigma;&Eta; &Tau;&Epsilon;&Lambda;&Epsilon;&Sigma;&Eta;&Sigma; &Theta;&Rho;&Eta;&Sigma;&Kappa;&Epsilon;&Upsilon;&Tau;&Iota;&Kappa;&Omicron;&Upsilon; &Gamma;&Alpha;&Mu;&Omicron;&Upsilon;</span></h3>\n" +
                "<h3><span style=\"font-size: medium;\">&Omicron; &upsilon;&pi;&omicron;&gamma;&epsilon;&gamma;&rho;&alpha;&mu;&mu;έ&nu;&omicron;&sigmaf; &iota;&epsilon;&rho;έ&alpha;&sigmaf; ........&nu;&xi;&kappa;&nu;........ &tau;&eta;&sigmaf; &epsilon;&nu;&omicron;&rho;ί&alpha;&sigmaf; &tau;&omicron;&upsilon; &Iota;&epsilon;&rho;&omicron;&upsilon; &Nu;&alpha;&omicron;ύ........&xi;&kappa;&nu;&xi;&kappa;........&delta;&eta;&lambda;ώ&nu;&omega;</span></h3>\n" +
                "<h3><span style=\"font-size: medium;\">ό&tau;&iota; &sigma;ή&mu;&epsilon;&rho;&alpha; &sigma;&tau;&iota;&sigmaf; ........&nu;&kappa;&xi;........&tau;&omicron;&upsilon; &mu;ή&nu;&alpha;........&nu;&xi;&kappa;........&tau;&omicron;&upsilon; έ&tau;&omicron;&upsilon;&sigmaf;...&nu;&kappa;&xi;...&kappa;&alpha;&iota; ώ&rho;&alpha;...&nu;&kappa;&xi;&nu;...&tau;έ&lambda;&epsilon;&sigma;&alpha;</span></h3>\n" +
                "<h3><span style=\"font-size: medium;\">&sigma;&tau; ........&xi;&kappa;&nu;&kappa;&xi;........&kappa;&alpha;&iota; &sigma;&tau;&omicron;&nu; &omega;&sigmaf; ά&nu;&omega; &Iota;&epsilon;&rho;ό &nu;&alpha;ό &kappa;&alpha;&tau;ά &tau;&omicron; &delta;ό&gamma;&mu;&alpha;........&nu;&xi;&kappa;........&tau;&omicron;</span></h3>\n" +
                "<h3><span style=\"font-size: medium;\">&mu;&upsilon;&sigma;&tau;ή&rho;&iota;&omicron; &tau;&omicron;&upsilon; &gamma;ά&mu;&omicron;&upsilon; &tau;&omega;&nu; &kappa;&alpha;&tau;&omega;&tau;έ&rho;&omega; &sigma;&upsilon;&zeta;ύ&gamma;&omega;&nu;:</span></h3>\n" +
                "<h3><span style=\"font-size: medium;\">&nbsp;</span></h3>\n" +
                "<h3><span style=\"font-size: medium;\">&Sigma;&Tau;&Omicron;&Iota;&Chi;&Epsilon;&Iota;&Alpha; &nbsp; &nbsp; &nbsp; &Tau;&Omicron;&Upsilon; &Sigma;&Upsilon;&Zeta;&Upsilon;&Gamma;&Omicron;&Upsilon; &Tau;&Eta;&Sigma; &Sigma;&Upsilon;&Zeta;&Upsilon;&Gamma;&Omicron;&Upsilon;</span></h3>\n" +
                "<h3><span style=\"font-size: medium;\">&nbsp;</span></h3>\n" +
                "<h3><span style=\"font-size: medium;\">1.&Epsilon;&pi;ώ&nu;&upsilon;&mu;&omicron;* &nu;&kappa;&xi; &nbsp; &nbsp; &nbsp;&nbsp;&nbsp;&kappa;&xi;&nu;</span></h3>\n" +
                "<h3><span style=\"font-size: medium;\">2.Ό&nu;&omicron;&mu;&alpha; &kappa;&nu;&xi; &nbsp; &nbsp; &nbsp; &nbsp;&kappa;&xi;&nu;&kappa;&nu;&xi;</span></h3>\n" +
                "<h3><span style=\"font-size: medium;\">3.&Epsilon;&pi;ά&gamma;&gamma;&epsilon;&lambda;&mu;&alpha; (&pi;&rho;&omicron; &tau;&omicron;&upsilon; &gamma;ά&mu;&omicron;&upsilon;) &kappa;&xi;&nu; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&kappa;&xi;&nu;</span></h3>\n" +
                "<h3><span style=\"font-size: medium;\">4.&Theta;&rho;ή&sigma;&kappa;&epsilon;&upsilon;&mu;&alpha; &kappa;&alpha;&iota; &delta;ό&gamma;&mu;&alpha;. &nu;&kappa;&xi; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nu;&kappa;&xi;</span></h3>\n" +
                "<h3><span style=\"font-size: medium;\">5.&Iota;&theta;&alpha;&gamma;έ&nu;&epsilon;&iota;&alpha; (&pi;&rho;&omicron; &tau;&omicron;&upsilon; &gamma;ά&mu;&omicron;&upsilon;) &nbsp;&kappa;&nu;&xi; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;&nu;&kappa;&xi;</span></h3>\n" +
                "<h3><span style=\"font-size: medium;\">6.&Alpha;&Phi;&Mu;. &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;&nu;&kappa;&xi;&nu;&xi;&kappa; &nbsp; &nbsp; &nbsp; &nbsp; &nu;&kappa;&xi;</span></h3>\n" +
                "<h3><span style=\"font-size: medium;\">7.&Alpha;&Mu;&Kappa;&Alpha; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&kappa;&nu;&xi; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nu;&kappa;&xi;</span></h3>\n" +
                "<h3><span style=\"font-size: medium;\">8.&Phi;&omicron;&rho;&epsilon;ί&sigmaf; &Alpha;&sigma;&phi;ά&lambda;&iota;&sigma;&eta;&sigmaf; &nu;&xi;&kappa; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nu;&xi;&kappa;</span></h3>\n" +
                "<h3><span style=\"font-size: medium;\">9.&Tau;ό&pi;&omicron;&sigmaf; &Gamma;έ&nu;&nu;&eta;&sigma;&eta;&sigmaf; &nu;&kappa;&xi;&nu;&xi;&kappa; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &xi;&nu;&kappa;</span></h3>\n" +
                "<h3><span style=\"font-size: medium;\">&nbsp; &Nu;&omicron;&mu;ό&sigmaf; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;&nu;&xi;&kappa; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nu;&xi;&kappa;</span></h3>\n" +
                "<h3><span style=\"font-size: medium;\">&nbsp; &Delta;ή&mu;&omicron;&sigmaf;/&Delta;&eta;&mu;&omicron;&tau;&iota;&kappa;ή &Epsilon;&nu;ό&tau;&eta;&tau;&alpha; &xi;&nu;&kappa;&nu;&xi;&kappa; &nbsp; &nbsp; &nbsp; &nbsp;&nu;&xi;&kappa;</span></h3>\n" +
                "<h3><span style=\"font-size: medium;\">&nbsp; &Delta;&eta;&mu;&omicron;&tau;&iota;&kappa;ή/&Tau;&omicron;&pi;&iota;&kappa;ή &Kappa;&omicron;&iota;&nu;ό&tau;&eta;&tau;&alpha; &nu;&xi;&kappa; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&xi;&nu;&kappa;</span></h3>\n" +
                "<h3><span style=\"font-size: medium;\">&nbsp; &Chi;ώ&rho;&alpha;/&Pi;ό&lambda;&eta; &epsilon;&xi;&omega;&tau;&epsilon;&rho;&iota;&kappa;&omicron;ύ &nu;&xi; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&iota;&theta;&beta;</span></h3>\n" +
                "<h3><span style=\"font-size: medium;\">10.&Chi;&rho;&omicron;&nu;&omicron;&lambda;&omicron;&gamma;ί&alpha; &Gamma;έ&nu;&nu;&eta;&sigma;&eta;&sigmaf; &iota;&theta;&beta; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&iota;&theta;&beta;</span></h3>\n" +
                "<h3><span style=\"font-size: medium;\">11.&Mu;ό&nu;&iota;&mu;&eta; &Kappa;&alpha;&tau;&omicron;&iota;&kappa;ί&alpha; (&pi;&rho;&omicron; &gamma;ά&mu;&omicron;&upsilon;) &nbsp;&iota;&theta; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &beta;&iota;</span></h3>\n" +
                "<h3><span style=\"font-size: medium;\">&nbsp; &Nu;&omicron;&mu;ό&sigmaf; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&theta;&beta; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;&iota;&theta;&beta;</span></h3>\n" +
                "<h3><span style=\"font-size: medium;\">&nbsp; &Delta;ή&mu;&omicron;&sigmaf;/&Delta;&eta;&mu;&omicron;&tau;&iota;&kappa;ή &Epsilon;&nu;ό&tau;&eta;&tau;&alpha; &iota;&theta;&beta; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&iota;&theta;</span></h3>\n" +
                "<h3><span style=\"font-size: medium;\">&nbsp; &Delta;&eta;&mu;&omicron;&tau;&iota;&kappa;ή/&Tau;&omicron;&pi;&iota;&kappa;ή &Kappa;&omicron;&iota;&nu;ό&tau;&eta;&tau;&alpha; &beta;&iota;&theta; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;&beta;</span></h3>\n" +
                "<h3><span style=\"font-size: medium;\">&nbsp; &Chi;ώ&rho;&alpha;/&Pi;ό&lambda;&eta; &epsilon;&xi;&omega;&tau;&epsilon;&rho;&iota;&kappa;&omicron;ύ &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;&iota;&theta;&beta; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;&omicron;&theta;&iota;</span></h3>\n" +
                "<h3><span style=\"font-size: medium;\">12.&Delta;&eta;&mu;ό&tau;&eta;&sigmaf;:&Delta;ή&mu;&omicron;&sigmaf;/&Delta;&eta;&mu;&omicron;&tau;&iota;&kappa;ή &Epsilon;&nu;ό&tau;&eta;&tau;&alpha; &beta;&theta;&iota; &omicron;&beta;</span></h3>\n" +
                "<h3><span style=\"font-size: medium;\">&nbsp; &Nu;&omicron;&mu;ό&sigmaf; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&iota;&theta;&omicron;&beta; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;&iota;&omicron;&theta;&beta;</span></h3>\n" +
                "<h3><span style=\"font-size: medium;\">&nbsp; &Alpha;&rho;&iota;&theta;&mu;. &Delta;&eta;&mu;&omicron;&tau;&omicron;&lambda;&omicron;&gamma;ί&omicron;&upsilon; &iota;&omicron;&theta; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;&beta;&iota;&omicron;</span></h3>\n" +
                "<h3><span style=\"font-size: medium;\">13.Ό&nu;&omicron;&mu;&alpha; &kappa;&alpha;&iota; &Epsilon;&pi;ώ&nu;&upsilon;&mu;&omicron; &tau;&omicron;&upsilon; &pi;&alpha;&tau;έ&rho;&alpha; &theta;&beta;&iota; &nbsp; &nbsp; &nbsp; &nbsp;&omicron;&theta;&beta;</span></h3>\n" +
                "<h3><span style=\"font-size: medium;\">14.Ό&nu;&omicron;&mu;&alpha; &kappa;&alpha;&iota; &Epsilon;&pi;ώ&nu;&upsilon;&mu;&omicron; &tau;&eta;&sigmaf; &mu;&eta;&tau;έ&rho;&alpha;&sigmaf; &iota;&omicron;&theta;&beta; &nbsp; &nbsp; &nbsp; &nbsp;&iota;&omicron;&theta;</span></h3>\n" +
                "<h3><span style=\"font-size: medium;\">15.&Sigma;&tau;&omicron;&iota;&chi;&epsilon;ί&alpha; &zeta;&epsilon;ύ&gamma;&omicron;&upsilon;&sigmaf; &nbsp;&beta;&iota;&omicron;&theta; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&beta;</span></h3>\n" +
                "<h3><span style=\"font-size: medium;\">&nbsp; &Mu;ό&nu;&iota;&mu;&eta; &Kappa;&alpha;&tau;&omicron;&iota;&kappa;ί&alpha; &iota;&theta;&beta; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&iota;&omicron;&theta;</span></h3>\n" +
                "<h3><span style=\"font-size: medium;\">&nbsp; &Nu;&omicron;&mu;ό&sigmaf; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&beta;&iota;&omicron;&theta; &nbsp; &nbsp; &nbsp; &nbsp;&beta;</span></h3>\n" +
                "<h3><span style=\"font-size: medium;\">&nbsp; &Delta;ή&mu;&omicron;&sigmaf;/&Delta;&eta;&mu;&omicron;&tau;&iota;&kappa;ή &Epsilon;&nu;ό&tau;&eta;&tau;&alpha; &iota;&omicron;&theta;&beta; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&iota;&omicron;&theta;&beta;</span></h3>\n" +
                "<h3><span style=\"font-size: medium;\">&nbsp; &Delta;&eta;&mu;&omicron;&tau;&iota;&kappa;ή/&Tau;&omicron;&pi;&iota;&kappa;ή &Kappa;&omicron;&iota;&nu;ό&tau;&eta;&tau;&alpha; &iota;&omicron;&theta; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;&beta;&iota;&omicron;&theta;</span></h3>\n" +
                "<h3><span style=\"font-size: medium;\">&nbsp; &Chi;ώ&rho;&alpha;/&Pi;ό&lambda;&eta; &epsilon;&xi;&omega;&tau;&epsilon;&rho;&iota;&kappa;&omicron;ύ &beta; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &iota;&omicron;&theta;&beta;</span></h3>\n" +
                "<h3><span style=\"font-size: medium;\">16.&Epsilon;&pi;ώ&nu;&upsilon;&mu;&omicron; &tau;έ&kappa;&nu;&omega;&nu; &iota;&omicron;&theta; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&beta;&iota;&omicron;&theta;</span></h3>\n" +
                "<h3><span style=\"font-size: medium;\">17.&Omicron;&iota;&kappa;&omicron;&gamma;&epsilon;&nu;&epsilon;&iota;&alpha;&kappa;ή &kappa;&alpha;&tau;ά&sigma;&tau;&alpha;&sigma;&eta; (&pi;&rho;&omicron; &tau;&omicron;&upsilon; &gamma;ά&mu;&omicron;&upsilon;) &Chi;ή&rho;&omicron;&sigmaf; &Chi;ή&rho;&alpha;</span></h3>\n" +
                "<h3><span style=\"font-size: medium;\">18.&Beta;&alpha;&theta;&mu;ό&sigmaf; &gamma;ά&mu;&omicron;&upsilon; (&pi;&rho;ώ&tau;&omicron;&sigmaf;,&delta;&epsilon;ύ&tau;&epsilon;&rho;&omicron;&sigmaf;,&tau;&rho;ί&tau;&omicron;&sigmaf;) &beta;&iota; &theta;&beta;</span></h3>\n" +
                "<h3><span style=\"font-size: medium;\">19.&Epsilon;&kappa;&pi;&alpha;ί&delta;&epsilon;&upsilon;&sigma;&eta; έ&chi;&epsilon;&iota; &pi;&tau;&upsilon;&chi;ί&omicron; &Alpha;&Epsilon;&Iota; ή &Tau;&Epsilon;&Iota; έ&chi;&epsilon;&iota; &alpha;&pi;&omicron;&lambda;&upsilon;&tau;ή&rho;&iota;&omicron; &lambda;&upsilon;&kappa;&epsilon;ί&omicron;&upsilon; ή &iota;&sigma;ό&tau;&iota;&mu;&omicron;</span></h3>\n" +
                "<h3><span style=\"font-size: medium;\">&nbsp;</span></h3>\n" +
                "<h3><span style=\"font-size: medium;\">20.&Alpha;&rho;&iota;&theta;&mu;ό&sigmaf; ά&delta;&epsilon;&iota;&alpha;&sigmaf; &gamma;ά&mu;&omicron;&upsilon; ά&nu;&delta;&rho;&alpha;...&beta;&iota;...&Iota;&epsilon;&rho;ά&sigmaf; &Mu;&eta;&tau;&rho;&omicron;&pi;ό&lambda;&epsilon;&omega;&sigmaf;...&theta;&beta;...</span></h3>\n" +
                "<h3><span style=\"font-size: medium;\">&nbsp; &nbsp;&Alpha;&rho;&iota;&theta;&mu;ό&sigmaf; ά&delta;&epsilon;&iota;&alpha;&sigmaf; &gamma;ά&mu;&omicron;&upsilon; &gamma;&upsilon;&nu;&alpha;ί&kappa;&alpha;&sigmaf;...&iota;&theta;&beta;...&Iota;&epsilon;&rho;ά&sigmaf; &Mu;&eta;&tau;&rho;&omicron;&pi;ό&lambda;&epsilon;&omega;&sigmaf;...&iota;&theta;...</span></h3>\n" +
                "<h3><span style=\"font-size: medium;\">&nbsp;</span></h3>\n" +
                "<h3><span style=\"font-size: medium;\">21.&Alpha;&rho;&iota;&theta;&mu;ό&sigmaf; &pi;&alpha;&rho;&alpha;&beta;ό&lambda;&omicron;&upsilon; &gamma;ά&mu;&omicron;&upsilon; ά&nu;&delta;&rho;&alpha;...&beta;&iota;&theta;...</span></h3>\n" +
                "<h3><span style=\"font-size: medium;\">&nbsp; &nbsp;&Alpha;&rho;&iota;&theta;&mu;ό&sigmaf; &pi;&alpha;&rho;&alpha;&beta;ό&lambda;&omicron;&upsilon; &gamma;ά&mu;&omicron;&upsilon; &gamma;&upsilon;&nu;&alpha;ί&kappa;&alpha;&sigmaf;...&beta;...</span></h3>\n" +
                "<h3><span style=\"font-size: medium;\">&nbsp;</span>&Omicron;&iota; &Sigma;ύ&zeta;&upsilon;&gamma;&omicron;&iota; &Omicron;&iota; &Pi;&alpha;&rho;ά&nu;&upsilon;&mu;&phi;&omicron;&iota; &Omicron; &Iota;&epsilon;&rho;έ&alpha;&sigmaf;&nbsp;</h3>\n" +
                "<h3><span style=\"font-size: medium;\">(&upsilon;&pi;&omicron;&gamma;&rho;&alpha;&phi;ή) (&upsilon;&pi;&omicron;&gamma;&rho;&alpha;&phi;ή) &nbsp; &nbsp; &nbsp;(&Upsilon;&pi;&omicron;&gamma;&rho;&alpha;&phi;ή &kappa;&alpha;&iota; &sigma;&phi;&rho;&alpha;&gamma;ί&delta;&alpha;)&nbsp;</span></h3>\n" +
                "<h3><span style=\"font-size: medium;\">&nbsp;</span></h3>\n" +
                "<h3><span style=\"font-size: medium;\">&nbsp;</span></h3>\n" +
                "<h3><span style=\"font-size: medium;\">&nbsp; &Alpha;&rho;&iota;&theta;&mu;. &tau;&eta;&lambda;&epsilon;&phi;.......&iota;&theta;&beta;......</span></h3>\n" +
                "<p>&nbsp;</p>" ;


        htmlEditor.setHtmlText(INITIAL_TEXT);
    }


    public void print(ActionEvent actionEvent) throws Exception{
        PrinterJob job = PrinterJob.createPrinterJob();
        if(job != null){
            htmlEditor.print(PrinterJob.createPrinterJob(Printer.getDefaultPrinter()));
            job.endJob();
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
