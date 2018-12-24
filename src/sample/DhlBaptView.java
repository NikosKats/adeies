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
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;

public class DhlBaptView implements Initializable {

    public HTMLEditor htmlEditor;
    public JFXButton view_btn;
    public JFXButton menu_btn;
    public JFXButton create_new_btn;
    public JFXButton print_btn;

    public HTMLEditor htmlEditor2;
    public WebView webView;

    private WebEngine webEngine;
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


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Preferences preferences = Preferences.userNodeForPackage(DhlBaptView.class);
        String pass_id = preferences.get("id",null);

        int id = Integer.parseInt(pass_id);
        selectRow(id);



        String INITIAL_TEXT = "<div style=\"text-align: center;\">&nbsp;<strong>&Iota;&Epsilon;&Rho;&Alpha; &Mu;&Eta;&Tau;&Rho;&Omicron;&Pi;&Omicron;&Lambda;&Iota;&Sigma;</strong></div>\n" +
                "<div style=\"text-align: center;\">"+Field1+"</div>\n" +
                "<div style=\"text-align: center;\">&nbsp;</div>\n" +
                "<div style=\"text-align: center;\">&nbsp;</div>\n" +
                "<div style=\"text-align: center;\"><strong>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&Iota;&Epsilon;&Rho;&Omicron;&Sigma; &Nu;&Alpha;&Omicron;&Sigma;</strong> "+Field2+" &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;<strong>&Alpha;&rho;&iota;&theta;&mu;.&Pi;&rho;&omega;&tau;.</strong> "+Field3+"</div>\n" +
                "<div style=\"text-align: center;\">&nbsp;</div>\n" +
                "<div style=\"text-align: center;\">&nbsp;</div>\n" +
                "<div style=\"text-align: center;\">Ὁ ὐ&pi;&omicron;&gamma;&epsilon;&gamma;&rho;&alpha;&mu;&mu;έ&nu;&omicron;&sigmaf; Ἷ&epsilon;&rho;&epsilon;ύ&sigmaf; "+Field4+"&nbsp;</div>\n" +
                "<div style=\"text-align: center;\">&Epsilon;&phi;&eta;&mu;έ&rho;&iota;&omicron;&sigmaf; &tau;&omicron;ῦ Ἷ&epsilon;&rho;&omicron;ῦ &Nu;&alpha;&omicron;ῦ "+Field5+"&nbsp;</div>\n" +
                "<div style=\"text-align: center;\">&delta;&eta;&lambda;ῶ ὃ&tau;&iota; &sigma;ή&mu;&epsilon;&rho;&omicron;&nu; &tau;ἡ&nu; "+Field6+" &tau;&omicron;ῦ &mu;&eta;&nu;ό&sigmaf; "+Field7+"</div>\n" +
                "<div style=\"text-align: center;\">&tau;&omicron;ῦ ἐ&tau;&omicron;&upsilon;&sigmaf; "+Field8+" ἠ&mu;έ&rho;&alpha;&nu; "+Field9+", &epsilon;&nu; &tau;ῶ Ἱ&epsilon;&rho;ῶ &Nu;&alpha;ῶ  &nbsp;</div>\n" +
                "<div style=\"text-align: center;\">"+Field10+"</div>\n" +
                "<div style=\"text-align: center;\">&nbsp;</div>\n" +
                "<div style=\"text-align: center;\">&nbsp;</div>\n" +
                "<div style=\"text-align: center;\"><strong>&Epsilon;&Beta;&Alpha;&Pi;&Tau;&Iota;&Sigma;&Alpha;&nbsp;</strong></div>\n" +
                "<div style=\"text-align: center;\">&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &kappa;&alpha;&tau;ά &tau;&omicron;ὺ&sigmaf; Ἱ&epsilon;&rho;&omicron;ύ&sigmaf; &Kappa;&alpha;&nu;ό&nu;&alpha;&sigmaf; &tau;ῆ&sigmaf; Ὁ&rho;&theta;&omicron;&delta;ό&xi;&omicron;&upsilon; Ἁ&nu;&alpha;&tau;&omicron;&lambda;&iota;&kappa;ῆ&sigmaf; Ἑ&kappa;&kappa;&lambda;&eta;&sigma;ί&alpha;&sigmaf;&nbsp;</div>\n" +
                "<div style=\"text-align: center;\">&nbsp;</div>\n" +
                "<div style=\"text-align: center;\">&tau;ό &tau;έ&kappa;&nu;&omicron;&nu; &tau;&omicron;ῦ "+Field11+"</div>\n" +
                "<div style=\"text-align: center;\">&kappa;&alpha;ί &tau;ῆ&sigmaf; "+Field12+" &tau;ό &gamma;έ&nu;&omicron;&sigmaf; "+Field13+"</div>\n" +
                "<div style=\"text-align: center;\">&kappa;&alpha;&tau;&omicron;ί&kappa;&omega;&nu; "+Field14+" ό&delta;ὁ&sigmaf; "+Field15+"</div>\n" +
                "<div style=\"text-align: center;\">ἀ&rho;&iota;&theta;&mu;. "+Field16+", &gamma;&epsilon;&nu;&nu;&eta;&theta;έ&nu; &tau;ή&nu;"+Field17+" ἔ&nu;"+Field18+"</div>\n" +
                "<div style=\"text-align: center;\">&kappa;&alpha;&tau;ά &tau;ή&nu; ύ&pi;'ἀ&rho;&iota;&theta;&mu;. "+Field19+" &tau;ὁ&mu;&omicron;&sigmaf; "+Field20+" &tau;&omicron;ῦ "+Field21+" ἕ&tau;&omicron;&upsilon;&sigmaf; &pi;&rho;ᾶ&xi;&iota;&nu;</div>\n" +
                "<div style=\"text-align: center;\">&Gamma;&epsilon;&nu;&nu;ή&sigma;&epsilon;&omega;&sigmaf; &tau;&omicron;ῦ &kappa;. &Lambda;&eta;&xi;&iota;ά&rho;&chi;&omicron;&upsilon; "+Field22+"</div>\n" +
                "<div style=\"text-align: center;\">&nbsp;</div>\n" +
                "<div style=\"text-align: center;\"><strong>Ὀ&nu;&omicron;&mu;&alpha;&sigma;&theta;έ&nu;&nbsp;</strong></div>\n" +
                "<div style=\"text-align: center;\"> "+Field23+"&nbsp;</div>\n" +
                "<div style=\"text-align: center;\">&nbsp;</div>\n" +
                "<div style=\"text-align: center;\">ὐ&pi;ό &tau;&omicron;&upsilon;/&eta;&sigmaf; ἀ&nu;&alpha;&delta;&epsilon;&xi;&alpha;&mu;έ&nu;&omicron;&upsilon;/&eta;&sigmaf; &alpha;ὐ&tau;ό ἕ&kappa; &tau;ῆ&sigmaf; Ἱ&epsilon;&rho;ᾶ&sigmaf; &Kappa;&omicron;&lambda;&upsilon;&mu;&beta;ή&theta;&rho;&alpha;&sigmaf; </div>\n" +
                "<div style=\"text-align: center;\">&nbsp;"+Field24+"</div>\n" +
                "<div style=\"text-align: center;\">&kappa;&alpha;&tau;&omicron;ί&kappa;&omicron;&upsilon; "+Field25+" ό&delta;ὁ&sigmaf; "+Field26+" ἀ&rho;&iota;&theta;&mu;. "+Field27+"</div>\n" +
                "<div style=\"text-align: center;\">Ἐ&phi;᾽ὥ &sigma;&upsilon;&nu;&epsilon;&tau;ά&gamma;&eta; &tau;&omicron; &pi;&alpha;&rho;ό&nu; &kappa;&alpha;ί ὑ&pi;&omicron;&gamma;&rho;ά&phi;&epsilon;&tau;&alpha;&iota; ώ&sigmaf; ἕ&pi;&epsilon;&tau;&alpha;&iota;:&nbsp;</div>\n" +
                "<div style=\"text-align: center;\">&nbsp;</div>\n" +
                "<div style=\"text-align: center;\"><strong>&Omicron; &Epsilon;&Phi;&Eta;&Mu;&Epsilon;&Rho;&Iota;&Omicron;&Sigma;&nbsp;</strong></div>\n" +
                "<div style=\"text-align: center;\">&nbsp;"+Field28+"&nbsp;</div>\n" +
                "<div style=\"text-align: center;\">&nbsp;</div>\n" +
                "<div style=\"text-align: center;\"><strong>&Omicron; &Pi;&Alpha;&Tau;&Eta;&Rho; &Kappa;&Alpha;&Iota; &Eta; &Mu;&Eta;&Tau;&Eta;&Rho; &Tau;&Omicron;&Upsilon; &Beta;&Alpha;&Pi;&Tau;&Iota;&Sigma;&Theta;&Epsilon;&Nu;&Tau;&Omicron;&Sigma; &Nu;&Eta;&Pi;&Iota;&Omicron;&Upsilon;</strong>&nbsp;</div>\n" +
                "<div style=\"text-align: center;\">"+Field29+"&nbsp;</div>\n" +
                "<div style=\"text-align: center;\">"+Field30+"&nbsp;</div>\n" +
                "<div style=\"text-align: center;\">&nbsp;</div>\n" +
                "<div style=\"text-align: center;\"><strong>&Omicron; &Alpha;&Nu;&Alpha;&Delta;&Omicron;&Chi;&Omicron;&Sigma;</strong>&nbsp;</div>\n" +
                "<div style=\"text-align: center;\">"+Field31+"&nbsp;</div>\n" +
                "<div style=\"text-align: center;\">&nbsp;</div>" ;


        htmlEditor.setHtmlText(INITIAL_TEXT);

        /***********************************--HTMLEDITOR 2--***********************************/

        String INITIAL_TEXT_2 = "<html>\n" +
                "\n" +
                "<head>\n" +
                "<meta http-equiv=Content-Type content=\"text/html; charset=unicode\">\n" +
                "<meta name=Generator content=\"Microsoft Word 15 (filtered)\">\n" +
                "<style>\n" +
                "<!--\n" +
                " /* Font Definitions */\n" +
                " @font-face\n" +
                "\t{font-family:\"Cambria Math\";\n" +
                "\tpanose-1:2 4 5 3 5 4 6 3 2 4;}\n" +
                "@font-face\n" +
                "\t{font-family:Calibri;\n" +
                "\tpanose-1:2 15 5 2 2 2 4 3 2 4;}\n" +
                "@font-face\n" +
                "\t{font-family:-webkit-standard;\n" +
                "\tpanose-1:2 11 6 4 2 2 2 2 2 4;}\n" +
                " /* Style Definitions */\n" +
                " p.MsoNormal, li.MsoNormal, div.MsoNormal\n" +
                "\t{margin:0cm;\n" +
                "\tmargin-bottom:.0001pt;\n" +
                "\tfont-size:12.0pt;\n" +
                "\tfont-family:\"Calibri\",sans-serif;}\n" +
                "p.MsoAcetate, li.MsoAcetate, div.MsoAcetate\n" +
                "\t{mso-style-link:\"Balloon Text Char\";\n" +
                "\tmargin:0cm;\n" +
                "\tmargin-bottom:.0001pt;\n" +
                "\tfont-size:9.0pt;\n" +
                "\tfont-family:\"Times New Roman\",serif;}\n" +
                "p.msonormal0, li.msonormal0, div.msonormal0\n" +
                "\t{mso-style-name:msonormal;\n" +
                "\tmargin-right:0cm;\n" +
                "\tmargin-left:0cm;\n" +
                "\tfont-size:12.0pt;\n" +
                "\tfont-family:\"Times New Roman\",serif;}\n" +
                "span.BalloonTextChar\n" +
                "\t{mso-style-name:\"Balloon Text Char\";\n" +
                "\tmso-style-link:\"Balloon Text\";\n" +
                "\tfont-family:\"Times New Roman\",serif;}\n" +
                "p.msochpdefault, li.msochpdefault, div.msochpdefault\n" +
                "\t{mso-style-name:msochpdefault;\n" +
                "\tmargin-right:0cm;\n" +
                "\tmargin-left:0cm;\n" +
                "\tfont-size:12.0pt;\n" +
                "\tfont-family:\"Calibri\",sans-serif;}\n" +
                "span.apple-converted-space\n" +
                "\t{mso-style-name:apple-converted-space;}\n" +
                ".MsoChpDefault\n" +
                "\t{font-size:10.0pt;\n" +
                "\tfont-family:\"Calibri\",sans-serif;}\n" +
                "@page WordSection1\n" +
                "\t{size:595.0pt 842.0pt;\n" +
                "\tmargin:72.0pt 72.0pt 72.0pt 72.0pt;}\n" +
                "div.WordSection1\n" +
                "\t{page:WordSection1;}\n" +
                "-->\n" +
                "</style>\n" +
                "\n" +
                "</head>\n" +
                "\n" +
                "<body lang=EN-US>\n" +
                "\n" +
                "<div class=WordSection1>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>&nbsp;&nbsp;&nbsp;\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><span\n" +
                "lang=EL style='font-size:14.0pt;font-family:\"Times New Roman\",serif'>ΙΕΡΑ\n" +
                "ΜΗΤΡΟΠΟΛΙΣ</span></p>\n" +
                "\n" +
                "<p class=MsoNormal style='text-indent:36.0pt'><span lang=EL style='font-size:\n" +
                "14.0pt;font-family:\"Times New Roman\",serif'>ΣΑΜΟΥ ΙΚΑΡΙΑΣ ΚΑΙ ΚΟΡΣΕΩΝ</span></p>\n" +
                "\n" +
                "<p class=MsoNormal style='text-indent:36.0pt'><span lang=EL style='font-size:\n" +
                "14.0pt'>&nbsp;</span></p>\n" +
                "\n" +
                "<p class=MsoNormal><b><span lang=EL style='font-size:14.0pt;font-family:\"Times New Roman\",serif'>ΙΕΡΟΣ\n" +
                "ΝΑΟΣ\n" +
                "&nbsp;______________&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></b><span\n" +
                "lang=EL style='font-size:14.0pt;font-family:\"Times New Roman\",serif'>Άριθμ.Πρωτ.&nbsp;_____________&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
                "</span></p>\n" +
                "\n" +
                "<p class=MsoNormal style='text-indent:36.0pt'><span lang=EL style='font-family:\n" +
                "\"Times New Roman\",serif'>&nbsp;</span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>&nbsp;</span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-size:14.0pt;font-family:-webkit-standard;\n" +
                "color:black'>Ὁ ὐπογεγραμμένος Ἷερεύς </span><b><span lang=EL style='font-size:\n" +
                "14.0pt;font-family:\"Times New Roman\",serif'>&nbsp;___________________________________</span></b></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-size:14.0pt;font-family:-webkit-standard;\n" +
                "color:black'>Εφημέριος τοῦ Ἷεροῦ Ναοῦ </span><b><span lang=EL style='font-size:\n" +
                "14.0pt;font-family:\"Times New Roman\",serif'>___________________________________</span></b></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-size:14.0pt;font-family:-webkit-standard;\n" +
                "color:black'>δηλῶ ὃτι σήμερον τἡν&nbsp; τοῦ μηνός </span><b><span lang=EL\n" +
                "style='font-size:14.0pt;font-family:\"Times New Roman\",serif'>______________________________</span></b></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-size:14.0pt;font-family:-webkit-standard;\n" +
                "color:black'>τοῦ ἐτους ἠμέραν, εν τῶ Ἱερῶ Ναῶ </span><b><span lang=EL\n" +
                "style='font-size:14.0pt;font-family:\"Times New Roman\",serif'>_____________________________</span></b></p>\n" +
                "\n" +
                "<p class=MsoNormal style='margin-left:36.0pt'><span lang=EL style='font-family:\n" +
                "-webkit-standard;color:black'>&nbsp;</span></p>\n" +
                "\n" +
                "<p class=MsoNormal style='text-indent:36.0pt'><span lang=EL style='font-family:\n" +
                "-webkit-standard;color:black'>&nbsp;</span></p>\n" +
                "\n" +
                "<p class=MsoNormal style='text-indent:36.0pt'><b><span lang=EL\n" +
                "style='font-size:14.0pt;font-family:\"Times New Roman\",serif;color:black'>&nbsp;</span></b></p>\n" +
                "\n" +
                "<p class=MsoNormal style='margin-left:72.0pt;text-indent:36.0pt'><b><span\n" +
                "lang=EL style='font-size:14.0pt;font-family:\"Times New Roman\",serif;color:black'>&nbsp;\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ΕΒΑΠΤΙΣΑ</span></b><b><span\n" +
                "style='font-size:14.0pt;font-family:\"Times New Roman\",serif;color:black'>&nbsp;</span></b></p>\n" +
                "\n" +
                "<p class=MsoNormal><b><span lang=EL style='font-size:14.0pt;font-family:\"Times New Roman\",serif;\n" +
                "color:black'>κατά τοὺς Ἱερούς Κανόνας τῆς Ὁρθοδόξου Ἁνατολικῆς Ἑκκλησίας</span></b></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>&nbsp;</span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-size:14.0pt;font-family:\"Times New Roman\",serif;\n" +
                "color:black'>τό τέκνον τοῦ </span><b><span lang=EL style='font-size:14.0pt;\n" +
                "font-family:\"Times New Roman\",serif'>_____________________________________________</span></b></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-size:14.0pt;font-family:\"Times New Roman\",serif;\n" +
                "color:black'>καί τῆς &nbsp;τό γένος </span><b><span lang=EL style='font-size:\n" +
                "14.0pt;font-family:\"Times New Roman\",serif'>__________________________________________</span></b></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-size:14.0pt;font-family:\"Times New Roman\",serif;\n" +
                "color:black'>κατοίκων&nbsp; όδὁς </span><b><span lang=EL style='font-size:14.0pt;\n" +
                "font-family:\"Times New Roman\",serif'>___________________________________________</span></b></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-size:14.0pt;font-family:\"Times New Roman\",serif;\n" +
                "color:black'>ἀριθμ. , γεννηθέν την&nbsp; ἔν </span><b><span lang=EL\n" +
                "style='font-size:14.0pt;font-family:\"Times New Roman\",serif'>____________________________________</span></b></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-size:14.0pt;font-family:\"Times New Roman\",serif;\n" +
                "color:black'>κατά τήν ύπ'ἀριθμ. &nbsp;τὁμος &nbsp;τοῦ &nbsp;ἕτους πρᾶξιν </span><b><span\n" +
                "lang=EL style='font-size:14.0pt;font-family:\"Times New Roman\",serif'>____________________</span></b></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-size:14.0pt;font-family:\"Times New Roman\",serif;\n" +
                "color:black'>Γεννήσεως τοῦ κ. Ληξιάρχου </span><b><span lang=EL\n" +
                "style='font-size:14.0pt;font-family:\"Times New Roman\",serif'>_________________________________</span></b></p>\n" +
                "\n" +
                "<p class=MsoNormal style='text-indent:36.0pt'><span lang=EL style='font-size:\n" +
                "14.0pt;font-family:\"Times New Roman\",serif;color:black'>&nbsp;</span></p>\n" +
                "\n" +
                "<p class=MsoNormal style='margin-left:144.0pt;text-indent:36.0pt'><span\n" +
                "lang=EL style='font-size:14.0pt;font-family:\"Times New Roman\",serif;color:black'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
                "Ὀνομασθέν</span><span style='font-size:14.0pt;font-family:\"Times New Roman\",serif;\n" +
                "color:black'>&nbsp;</span></p>\n" +
                "\n" +
                "<p class=MsoNormal style='margin-left:72.0pt;text-indent:36.0pt'><b><span\n" +
                "style='font-size:14.0pt;font-family:\"Times New Roman\",serif'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
                "</span></b><b><span lang=EL style='font-size:14.0pt;font-family:\"Times New Roman\",serif'>______________________________</span></b></p>\n" +
                "\n" +
                "<p class=MsoNormal><span style='font-size:14.0pt;font-family:\"Times New Roman\",serif;\n" +
                "color:black'>&nbsp;</span></p>\n" +
                "\n" +
                "<p class=MsoNormal style='text-indent:36.0pt'><span lang=EL style='font-size:\n" +
                "14.0pt;font-family:\"Times New Roman\",serif;color:black'>&nbsp;\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ὐπό του/ης ἀναδεξαμένου/ης αὐτό ἕκ τῆς\n" +
                "Ἱερᾶς Κολυμβήθρας</span><span style='font-size:14.0pt;font-family:\"Times New Roman\",serif;\n" +
                "color:black'>&nbsp;</span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span style='font-size:14.0pt;font-family:\"Times New Roman\",serif;\n" +
                "color:black'>&nbsp;</span><span lang=EL style='font-size:14.0pt;font-family:\n" +
                "\"Times New Roman\",serif;color:black'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
                "</span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-size:14.0pt;font-family:\"Times New Roman\",serif;\n" +
                "color:black'>&nbsp;κατοίκου&nbsp; όδὁς &nbsp;ἀριθμ. </span><b><span lang=EL\n" +
                "style='font-size:14.0pt;font-family:\"Times New Roman\",serif'>_____________________________________</span></b></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-size:14.0pt;font-family:\"Times New Roman\",serif;\n" +
                "color:black'>&nbsp;Ἐφ᾽ὥ συνετάγη το παρόν καί ὑπογράφεται ώς ἕπεται:</span><span\n" +
                "style='font-size:14.0pt;font-family:\"Times New Roman\",serif;color:black'>&nbsp;</span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span style='font-size:14.0pt;font-family:\"Times New Roman\",serif;\n" +
                "color:black'>&nbsp;</span></p>\n" +
                "\n" +
                "<p class=MsoNormal style='margin-left:108.0pt;text-indent:36.0pt'><b><span\n" +
                "lang=EL style='font-size:14.0pt;font-family:\"Times New Roman\",serif;color:black'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
                "</span></b></p>\n" +
                "\n" +
                "<p class=MsoNormal style='margin-left:108.0pt;text-indent:36.0pt'><b><span\n" +
                "lang=EL style='font-size:14.0pt;font-family:\"Times New Roman\",serif;color:black'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
                "Ο ΕΦΗΜΕΡΙΟΣ</span></b><b><span style='font-size:14.0pt;font-family:\"Times New Roman\",serif;\n" +
                "color:black'>&nbsp;</span></b></p>\n" +
                "\n" +
                "<p class=MsoNormal style='margin-left:108.0pt;text-indent:36.0pt'><b><span\n" +
                "lang=EL style='font-size:14.0pt;font-family:\"Times New Roman\",serif'>&nbsp;</span></b></p>\n" +
                "\n" +
                "<p class=MsoNormal style='margin-left:108.0pt;text-indent:36.0pt'><b><span\n" +
                "lang=EL style='font-size:14.0pt;font-family:\"Times New Roman\",serif'>____________________________</span></b></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL>&nbsp;</span></p>\n" +
                "\n" +
                "<p class=MsoNormal><b><span style='font-size:14.0pt;font-family:\"Times New Roman\",serif;\n" +
                "color:black'>         </span></b><b><span lang=EL style='font-size:14.0pt;\n" +
                "font-family:\"Times New Roman\",serif;color:black'>Ο ΠΑΤΗΡ ΚΑΙ Η ΜΗΤΗΡ ΤΟΥ\n" +
                "ΒΑΠΤΙΣΘΕΝΤΟΣ ΝΗΠΙΟΥ</span></b><span style='font-size:14.0pt;font-family:\"Times New Roman\",serif;\n" +
                "color:black'>&nbsp;</span></p>\n" +
                "\n" +
                "<p class=MsoNormal style='margin-left:36.0pt'><span lang=EL style='font-size:\n" +
                "14.0pt;font-family:\"Times New Roman\",serif;color:black'>&nbsp;</span></p>\n" +
                "\n" +
                "<p class=MsoNormal><b><span lang=EL style='font-size:14.0pt;font-family:\"Times New Roman\",serif'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
                "</span></b></p>\n" +
                "\n" +
                "<p class=MsoNormal style='margin-left:72.0pt;text-indent:36.0pt'><b><span\n" +
                "lang=EL style='font-size:14.0pt;font-family:\"Times New Roman\",serif'>&nbsp;&nbsp;&nbsp;\n" +
                "&nbsp;___________________</span></b><b><span style='font-size:14.0pt;\n" +
                "font-family:\"Times New Roman\",serif'>__________</span></b></p>\n" +
                "\n" +
                "<p class=MsoNormal style='margin-left:72.0pt'><b><span style='font-size:14.0pt;\n" +
                "font-family:\"Times New Roman\",serif'>&nbsp;</span></b></p>\n" +
                "\n" +
                "<p class=MsoNormal style='margin-left:72.0pt'><b><span style='font-size:14.0pt;\n" +
                "font-family:\"Times New Roman\",serif'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span></b></p>\n" +
                "\n" +
                "<p class=MsoNormal style='margin-left:108.0pt'><b><span style='font-size:14.0pt;\n" +
                "font-family:\"Times New Roman\",serif'>&nbsp;&nbsp;&nbsp;&nbsp; </span></b><b><span\n" +
                "lang=EL style='font-size:14.0pt;font-family:\"Times New Roman\",serif'>___________________</span></b><b><span\n" +
                "style='font-size:14.0pt;font-family:\"Times New Roman\",serif'>__________</span></b></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL>&nbsp;</span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-size:14.0pt;font-family:\"Times New Roman\",serif;\n" +
                "color:black'>&nbsp;</span></p>\n" +
                "\n" +
                "<p class=MsoNormal style='margin-left:180.0pt'><b><span lang=EL\n" +
                "style='font-size:14.0pt;font-family:\"Times New Roman\",serif;color:black'>&nbsp;&nbsp;\n" +
                "</span></b><b><span style='font-size:14.0pt;font-family:\"Times New Roman\",serif;\n" +
                "color:black'>Ο ΑΝΑΔΟΧΟΣ</span></b><span style='font-size:14.0pt;font-family:\n" +
                "\"Times New Roman\",serif;color:black'>&nbsp;</span></p>\n" +
                "\n" +
                "<p class=MsoNormal style='margin-left:180.0pt'>&nbsp;</p>\n" +
                "\n" +
                "<p class=MsoNormal><b><span style='font-size:14.0pt;font-family:\"Times New Roman\",serif'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
                "&nbsp;&nbsp;&nbsp;</span></b><b><span lang=EL style='font-size:14.0pt;\n" +
                "font-family:\"Times New Roman\",serif'>___________________</span></b><b><span\n" +
                "style='font-size:14.0pt;font-family:\"Times New Roman\",serif'>________________</span></b></p>\n" +
                "\n" +
                "<p class=MsoNormal style='margin-left:180.0pt'><span lang=EL style='font-size:\n" +
                "14.0pt;font-family:\"Times New Roman\",serif;color:black'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
                "</span></p>\n" +
                "\n" +
                "</div>\n" +
                "\n" +
                "</body>\n" +
                "\n" +
                "</html>\n";

        htmlEditor2.setHtmlText(INITIAL_TEXT_2);


//        webEngine = webView.getEngine();
//
//        webEngine.load("http://www.google.com");
       // webEngine.loadContent("");

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
                job.printPage(webView);
                job.endJob();
            }

        }


//        try{
//            htmlEditor.print(PrinterJob.createPrinterJob(Printer.getDefaultPrinter()));
//        }
//        catch (RuntimeException ex)
//        {
//           ex.printStackTrace();
//        }

    }
}
