package sample;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.print.Printer;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ToolBar;
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

public class DhlGamouView implements Initializable {

    public HTMLEditor htmlEditor;
    public JFXButton print_btn;
    public JFXButton create_new_btn;
    public JFXButton view_btn;
    public JFXButton menu_btn;

    public WebView webView;
    public HTMLEditor htmlEditor2;
    private WebEngine webEngine;

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
        String pass_id = preferences.get("id", null);

        int id = Integer.parseInt(pass_id);
        selectRow(id);


        String INITIAL_TEXT = "<html>\n" +
                "\n" +
                "<head>\n" +
                "<meta http-equiv=Content-Type content=\"text/html; charset=utf-8\">\n" +
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
                " /* Style Definitions */\n" +
                " p.MsoNormal, li.MsoNormal, div.MsoNormal\n" +
                "\t{margin:0cm;\n" +
                "\tmargin-bottom:.0001pt;\n" +
                "\tfont-size:12.0pt;\n" +
                "\tfont-family:\"Calibri\",sans-serif;}\n" +
                ".MsoChpDefault\n" +
                "\t{font-family:\"Calibri\",sans-serif;}\n" +
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
                "<p class=MsoNormal style='margin-left:108.0pt;text-indent:36.0pt'><span\n" +
                "style='font-family:\"Times New Roman\",serif'>Αριθμ.ληξ.πράξη\n" +
                "γάμου "+Field2+" Τόμος "+Field3+" έτος "+Field4+" </span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span style='font-family:\"Times New Roman\",serif'>                                    \n" +
                "                                   </span><span lang=EL style='font-family:\n" +
                "\"Times New Roman\",serif'>(Αναγράφεται από το Ληξίαρχο)</span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>&nbsp;</span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>ΙΕΡΑ\n" +
                "ΜΗΤΡΟΠΟΛΗ "+Field1+"</span></p>\n" +
                "\n" +
                "<p class=MsoNormal style='margin-left:144.0pt;text-indent:-144.0pt'><span\n" +
                "lang=EL style='font-family:\"Times New Roman\",serif'>ΙΕΡΟΣ ΝΑΟΣ "+Field5+"                                                   Ο\n" +
                "γάμος δηλώνεται στο Ληξιαρχείο, </span></p>\n" +
                "\n" +
                "<p class=MsoNormal style='margin-left:144.0pt;text-indent:-144.0pt'><span\n" +
                "lang=EL style='font-family:\"Times New Roman\",serif'>ΔΗΜΟΤΙΚΟ/ΤΟΠΙΚΟ\n" +
                "ΔΙΑΜΕΡΙΣΜΑ "+Field6+"      μέσα σε (40) σαράντα ημέρες από την </span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>ΔΗΜΟΣ/ΔΗΜΟΤΙΚΗ\n" +
                "ΕΝΟΤΗΤΑ "+Field7+"             τέλεσή του, σύμφωνα με το άρθρο 29,</span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>ΝΟΜΟΣ "+Field8+"                                                           παραγρ.\n" +
                "1 του Ν.344/1976</span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>Αριθμ.\n" +
                "Βιβλ. "+Field9+"</span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>                             \n" +
                "                   </span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>&nbsp;</span></p>\n" +
                "\n" +
                "<p class=MsoNormal style='margin-left:36.0pt'><span lang=EL style='font-family:\n" +
                "\"Times New Roman\",serif'>                         ΔΗΛΩΣΗ ΤΕΛΕΣΗΣ ΘΡΗΣΚΕΥΤΙΚΟΥ\n" +
                "ΓΑΜΟΥ</span></p>\n" +
                "\n" +
                "<p class=MsoNormal style='margin-left:72.0pt'><span lang=EL style='font-family:\n" +
                "\"Times New Roman\",serif'>Ο υπογεγραμμένος ιερέας "+Field10+" της ενορίας\n" +
                "του Ιερου Ναού "+Field11+" δηλώνω ότι σήμερα στις "+Field12+" του\n" +
                "μήνα "+Field13+" του έτους "+Field14+" και ώρα "+Field15+" τέλεσα στ\n" +
                ""+Field16+"</span></p>\n" +
                "\n" +
                "<p class=MsoNormal style='margin-left:72.0pt'><span lang=EL style='font-family:\n" +
                "\"Times New Roman\",serif'>και στον ως άνω Ιερό ναό κατά το\n" +
                "δόγμα "+Field17+" το</span></p>\n" +
                "\n" +
                "<p class=MsoNormal style='margin-left:36.0pt'><span lang=EL style='font-family:\n" +
                "\"Times New Roman\",serif'>            μυστήριο του γάμου των κατωτέρω συζύγων:</span></p>\n" +
                "\n" +
                "<p class=MsoNormal style='margin-left:36.0pt'><span lang=EL style='font-family:\n" +
                "\"Times New Roman\",serif'>&nbsp;</span></p>\n" +
                "\n" +
                "<table class=MsoTableGrid border=1 cellspacing=0 cellpadding=0 width=586\n" +
                " style='width:439.45pt;margin-left:-.25pt;border-collapse:collapse;border:none'>\n" +
                " <tr style='height:13.65pt'>\n" +
                "  <td width=236 valign=top style='width:177.2pt;border:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>ΣΤΟΙΧΕΙΑ</span></p>\n" +
                "  </td>\n" +
                "  <td width=180 valign=top style='width:134.65pt;border:solid windowtext 1.0pt;\n" +
                "  border-left:none;padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>ΤΟΥ\n" +
                "  ΣΥΖΥΓΟΥ</span></p>\n" +
                "  </td>\n" +
                "  <td width=170 valign=top style='width:127.6pt;border:solid windowtext 1.0pt;\n" +
                "  border-left:none;padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>ΤΗΣ\n" +
                "  ΣΥΖΥΓΟΥ</span></p>\n" +
                "  </td>\n" +
                " </tr>\n" +
                " <tr style='height:14.1pt'>\n" +
                "  <td width=236 valign=top style='width:177.2pt;border:solid windowtext 1.0pt;\n" +
                "  border-top:none;padding:0cm 5.4pt 0cm 5.4pt;height:14.1pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>1.Επώνυμο*</span></p>\n" +
                "  </td>\n" +
                "  <td width=180 valign=top style='width:134.65pt;border-top:none;border-left:\n" +
                "  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:14.1pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>"+Field18+"</span></p>\n" +
                "  </td>\n" +
                "  <td width=170 valign=top style='width:127.6pt;border-top:none;border-left:\n" +
                "  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:14.1pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>"+Field19+"</span></p>\n" +
                "  </td>\n" +
                " </tr>\n" +
                " <tr style='height:13.65pt'>\n" +
                "  <td width=236 valign=top style='width:177.2pt;border:solid windowtext 1.0pt;\n" +
                "  border-top:none;padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>2.Όνομα</span></p>\n" +
                "  </td>\n" +
                "  <td width=180 valign=top style='width:134.65pt;border-top:none;border-left:\n" +
                "  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>"+Field20+"</span></p>\n" +
                "  </td>\n" +
                "  <td width=170 valign=top style='width:127.6pt;border-top:none;border-left:\n" +
                "  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>"+Field21+"</span></p>\n" +
                "  </td>\n" +
                " </tr>\n" +
                " <tr style='height:14.1pt'>\n" +
                "  <td width=236 valign=top style='width:177.2pt;border:solid windowtext 1.0pt;\n" +
                "  border-top:none;padding:0cm 5.4pt 0cm 5.4pt;height:14.1pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>3.Επάγγελμα\n" +
                "  (προ του γάμου)</span></p>\n" +
                "  </td>\n" +
                "  <td width=180 valign=top style='width:134.65pt;border-top:none;border-left:\n" +
                "  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:14.1pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>"+Field22+"</span></p>\n" +
                "  </td>\n" +
                "  <td width=170 valign=top style='width:127.6pt;border-top:none;border-left:\n" +
                "  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:14.1pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>"+Field23+"</span></p>\n" +
                "  </td>\n" +
                " </tr>\n" +
                " <tr style='height:13.65pt'>\n" +
                "  <td width=236 valign=top style='width:177.2pt;border:solid windowtext 1.0pt;\n" +
                "  border-top:none;padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>4.Θρήσκευμα\n" +
                "  και δόγμα.</span></p>\n" +
                "  </td>\n" +
                "  <td width=180 valign=top style='width:134.65pt;border-top:none;border-left:\n" +
                "  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>"+Field24+"</span></p>\n" +
                "  </td>\n" +
                "  <td width=170 valign=top style='width:127.6pt;border-top:none;border-left:\n" +
                "  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>"+Field25+"</span></p>\n" +
                "  </td>\n" +
                " </tr>\n" +
                " <tr style='height:13.65pt'>\n" +
                "  <td width=236 valign=top style='width:177.2pt;border:solid windowtext 1.0pt;\n" +
                "  border-top:none;padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>5.Ιθαγένεια\n" +
                "  (προ του γάμου)</span></p>\n" +
                "  </td>\n" +
                "  <td width=180 valign=top style='width:134.65pt;border-top:none;border-left:\n" +
                "  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>"+Field26+"</span></p>\n" +
                "  </td>\n" +
                "  <td width=170 valign=top style='width:127.6pt;border-top:none;border-left:\n" +
                "  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>"+Field27+"</span></p>\n" +
                "  </td>\n" +
                " </tr>\n" +
                " <tr style='height:14.1pt'>\n" +
                "  <td width=236 valign=top style='width:177.2pt;border:solid windowtext 1.0pt;\n" +
                "  border-top:none;padding:0cm 5.4pt 0cm 5.4pt;height:14.1pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>6.ΑΦΜ.</span></p>\n" +
                "  </td>\n" +
                "  <td width=180 valign=top style='width:134.65pt;border-top:none;border-left:\n" +
                "  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:14.1pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>"+Field28+"</span></p>\n" +
                "  </td>\n" +
                "  <td width=170 valign=top style='width:127.6pt;border-top:none;border-left:\n" +
                "  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:14.1pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>"+Field29+"</span></p>\n" +
                "  </td>\n" +
                " </tr>\n" +
                " <tr style='height:13.65pt'>\n" +
                "  <td width=236 valign=top style='width:177.2pt;border:solid windowtext 1.0pt;\n" +
                "  border-top:none;padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>7.ΑΜΚΑ</span></p>\n" +
                "  </td>\n" +
                "  <td width=180 valign=top style='width:134.65pt;border-top:none;border-left:\n" +
                "  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>"+Field30+"</span></p>\n" +
                "  </td>\n" +
                "  <td width=170 valign=top style='width:127.6pt;border-top:none;border-left:\n" +
                "  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>"+Field31+"</span></p>\n" +
                "  </td>\n" +
                " </tr>\n" +
                " <tr style='height:13.65pt'>\n" +
                "  <td width=236 valign=top style='width:177.2pt;border:solid windowtext 1.0pt;\n" +
                "  border-top:none;padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>8.Φορείς\n" +
                "  Ασφάλισης  </span></p>\n" +
                "  </td>\n" +
                "  <td width=180 valign=top style='width:134.65pt;border-top:none;border-left:\n" +
                "  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>"+Field32+"</span></p>\n" +
                "  </td>\n" +
                "  <td width=170 valign=top style='width:127.6pt;border-top:none;border-left:\n" +
                "  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>"+Field33+"</span></p>\n" +
                "  </td>\n" +
                " </tr>\n" +
                " <tr style='height:14.1pt'>\n" +
                "  <td width=236 valign=top style='width:177.2pt;border:solid windowtext 1.0pt;\n" +
                "  border-top:none;padding:0cm 5.4pt 0cm 5.4pt;height:14.1pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>9.Τόπος\n" +
                "  Γέννησης</span></p>\n" +
                "  </td>\n" +
                "  <td width=180 valign=top style='width:134.65pt;border-top:none;border-left:\n" +
                "  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:14.1pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>"+Field34+"</span></p>\n" +
                "  </td>\n" +
                "  <td width=170 valign=top style='width:127.6pt;border-top:none;border-left:\n" +
                "  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:14.1pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>"+Field35+"</span></p>\n" +
                "  </td>\n" +
                " </tr>\n" +
                " <tr style='height:13.65pt'>\n" +
                "  <td width=236 valign=top style='width:177.2pt;border:solid windowtext 1.0pt;\n" +
                "  border-top:none;padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span style='font-family:\"Times New Roman\",serif'>  <span\n" +
                "  lang=EL>Νομός</span></span></p>\n" +
                "  </td>\n" +
                "  <td width=180 valign=top style='width:134.65pt;border-top:none;border-left:\n" +
                "  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>"+Field36+"</span></p>\n" +
                "  </td>\n" +
                "  <td width=170 valign=top style='width:127.6pt;border-top:none;border-left:\n" +
                "  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>"+Field37+"</span></p>\n" +
                "  </td>\n" +
                " </tr>\n" +
                " <tr style='height:14.1pt'>\n" +
                "  <td width=236 valign=top style='width:177.2pt;border:solid windowtext 1.0pt;\n" +
                "  border-top:none;padding:0cm 5.4pt 0cm 5.4pt;height:14.1pt'>\n" +
                "  <p class=MsoNormal><span style='font-family:\"Times New Roman\",serif'>  <span\n" +
                "  lang=EL>Δήμος/Δημοτική Ενότητα</span></span></p>\n" +
                "  </td>\n" +
                "  <td width=180 valign=top style='width:134.65pt;border-top:none;border-left:\n" +
                "  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:14.1pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>"+Field38+"</span></p>\n" +
                "  </td>\n" +
                "  <td width=170 valign=top style='width:127.6pt;border-top:none;border-left:\n" +
                "  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:14.1pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>"+Field39+"</span></p>\n" +
                "  </td>\n" +
                " </tr>\n" +
                " <tr style='height:13.65pt'>\n" +
                "  <td width=236 valign=top style='width:177.2pt;border:solid windowtext 1.0pt;\n" +
                "  border-top:none;padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'> \n" +
                "  Δημοτική/Τοπική Κοινότητα</span></p>\n" +
                "  </td>\n" +
                "  <td width=180 valign=top style='width:134.65pt;border-top:none;border-left:\n" +
                "  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>"+Field40+"</span></p>\n" +
                "  </td>\n" +
                "  <td width=170 valign=top style='width:127.6pt;border-top:none;border-left:\n" +
                "  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>"+Field41+"</span></p>\n" +
                "  </td>\n" +
                " </tr>\n" +
                " <tr style='height:13.65pt'>\n" +
                "  <td width=236 valign=top style='width:177.2pt;border:solid windowtext 1.0pt;\n" +
                "  border-top:none;padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'> \n" +
                "  Χώρα/Πόλη εξωτερικού</span></p>\n" +
                "  </td>\n" +
                "  <td width=180 valign=top style='width:134.65pt;border-top:none;border-left:\n" +
                "  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>"+Field42+"</span></p>\n" +
                "  </td>\n" +
                "  <td width=170 valign=top style='width:127.6pt;border-top:none;border-left:\n" +
                "  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>"+Field43+"</span></p>\n" +
                "  </td>\n" +
                " </tr>\n" +
                " <tr style='height:14.1pt'>\n" +
                "  <td width=236 valign=top style='width:177.2pt;border:solid windowtext 1.0pt;\n" +
                "  border-top:none;padding:0cm 5.4pt 0cm 5.4pt;height:14.1pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>10.Χρονολογία\n" +
                "  Γέννησης</span></p>\n" +
                "  </td>\n" +
                "  <td width=180 valign=top style='width:134.65pt;border-top:none;border-left:\n" +
                "  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:14.1pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>"+Field44+"</span></p>\n" +
                "  </td>\n" +
                "  <td width=170 valign=top style='width:127.6pt;border-top:none;border-left:\n" +
                "  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:14.1pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>"+Field45+"</span></p>\n" +
                "  </td>\n" +
                " </tr>\n" +
                " <tr style='height:13.65pt'>\n" +
                "  <td width=236 valign=top style='width:177.2pt;border:solid windowtext 1.0pt;\n" +
                "  border-top:none;padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>11.Μόνιμη\n" +
                "  Κατοικία (προ γάμου)</span></p>\n" +
                "  </td>\n" +
                "  <td width=180 valign=top style='width:134.65pt;border-top:none;border-left:\n" +
                "  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>"+Field46+"</span></p>\n" +
                "  </td>\n" +
                "  <td width=170 valign=top style='width:127.6pt;border-top:none;border-left:\n" +
                "  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>"+Field47+"</span></p>\n" +
                "  </td>\n" +
                " </tr>\n" +
                " <tr style='height:14.1pt'>\n" +
                "  <td width=236 valign=top style='width:177.2pt;border:solid windowtext 1.0pt;\n" +
                "  border-top:none;padding:0cm 5.4pt 0cm 5.4pt;height:14.1pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'> \n" +
                "  Νομός</span></p>\n" +
                "  </td>\n" +
                "  <td width=180 valign=top style='width:134.65pt;border-top:none;border-left:\n" +
                "  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:14.1pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>"+Field48+"</span></p>\n" +
                "  </td>\n" +
                "  <td width=170 valign=top style='width:127.6pt;border-top:none;border-left:\n" +
                "  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:14.1pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>"+Field49+"</span></p>\n" +
                "  </td>\n" +
                " </tr>\n" +
                " <tr style='height:13.65pt'>\n" +
                "  <td width=236 valign=top style='width:177.2pt;border:solid windowtext 1.0pt;\n" +
                "  border-top:none;padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'> \n" +
                "  Δήμος/Δημοτική Ενότητα</span></p>\n" +
                "  </td>\n" +
                "  <td width=180 valign=top style='width:134.65pt;border-top:none;border-left:\n" +
                "  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>"+Field50+"</span></p>\n" +
                "  </td>\n" +
                "  <td width=170 valign=top style='width:127.6pt;border-top:none;border-left:\n" +
                "  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>"+Field51+"</span></p>\n" +
                "  </td>\n" +
                " </tr>\n" +
                " <tr style='height:13.65pt'>\n" +
                "  <td width=236 valign=top style='width:177.2pt;border:solid windowtext 1.0pt;\n" +
                "  border-top:none;padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'> \n" +
                "  Δημοτική/Τοπική Κοινότητα</span></p>\n" +
                "  </td>\n" +
                "  <td width=180 valign=top style='width:134.65pt;border-top:none;border-left:\n" +
                "  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>"+Field52+"</span></p>\n" +
                "  </td>\n" +
                "  <td width=170 valign=top style='width:127.6pt;border-top:none;border-left:\n" +
                "  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>"+Field53+"</span></p>\n" +
                "  </td>\n" +
                " </tr>\n" +
                " <tr style='height:14.1pt'>\n" +
                "  <td width=236 valign=top style='width:177.2pt;border:solid windowtext 1.0pt;\n" +
                "  border-top:none;padding:0cm 5.4pt 0cm 5.4pt;height:14.1pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'> \n" +
                "  Χώρα/Πόλη εξωτερικού</span></p>\n" +
                "  </td>\n" +
                "  <td width=180 valign=top style='width:134.65pt;border-top:none;border-left:\n" +
                "  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:14.1pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>"+Field54+"</span></p>\n" +
                "  </td>\n" +
                "  <td width=170 valign=top style='width:127.6pt;border-top:none;border-left:\n" +
                "  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:14.1pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>"+Field55+"</span></p>\n" +
                "  </td>\n" +
                " </tr>\n" +
                " <tr style='height:13.65pt'>\n" +
                "  <td width=236 valign=top style='width:177.2pt;border:solid windowtext 1.0pt;\n" +
                "  border-top:none;padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>12.Δημότης:Δήμος/Δημοτική\n" +
                "  Ενότητα</span></p>\n" +
                "  </td>\n" +
                "  <td width=180 valign=top style='width:134.65pt;border-top:none;border-left:\n" +
                "  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>"+Field56+"</span></p>\n" +
                "  </td>\n" +
                "  <td width=170 valign=top style='width:127.6pt;border-top:none;border-left:\n" +
                "  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>"+Field57+"</span></p>\n" +
                "  </td>\n" +
                " </tr>\n" +
                " <tr style='height:13.65pt'>\n" +
                "  <td width=236 valign=top style='width:177.2pt;border:solid windowtext 1.0pt;\n" +
                "  border-top:none;padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'> \n" +
                "  Νομός</span></p>\n" +
                "  </td>\n" +
                "  <td width=180 valign=top style='width:134.65pt;border-top:none;border-left:\n" +
                "  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>"+Field58+"</span></p>\n" +
                "  </td>\n" +
                "  <td width=170 valign=top style='width:127.6pt;border-top:none;border-left:\n" +
                "  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>"+Field59+"</span></p>\n" +
                "  </td>\n" +
                " </tr>\n" +
                " <tr style='height:14.1pt'>\n" +
                "  <td width=236 valign=top style='width:177.2pt;border:solid windowtext 1.0pt;\n" +
                "  border-top:none;padding:0cm 5.4pt 0cm 5.4pt;height:14.1pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'> \n" +
                "  Αριθμ. Δημοτολογίου</span></p>\n" +
                "  </td>\n" +
                "  <td width=180 valign=top style='width:134.65pt;border-top:none;border-left:\n" +
                "  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:14.1pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>"+Field60+"</span></p>\n" +
                "  </td>\n" +
                "  <td width=170 valign=top style='width:127.6pt;border-top:none;border-left:\n" +
                "  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:14.1pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>"+Field61+"</span></p>\n" +
                "  </td>\n" +
                " </tr>\n" +
                " <tr style='height:13.65pt'>\n" +
                "  <td width=236 valign=top style='width:177.2pt;border:solid windowtext 1.0pt;\n" +
                "  border-top:none;padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>13.Όνομα\n" +
                "  και Επώνυμο του πατέρα</span></p>\n" +
                "  </td>\n" +
                "  <td width=180 valign=top style='width:134.65pt;border-top:none;border-left:\n" +
                "  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>"+Field62+"</span></p>\n" +
                "  </td>\n" +
                "  <td width=170 valign=top style='width:127.6pt;border-top:none;border-left:\n" +
                "  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>"+Field63+"</span></p>\n" +
                "  </td>\n" +
                " </tr>\n" +
                " <tr style='height:14.1pt'>\n" +
                "  <td width=236 valign=top style='width:177.2pt;border:solid windowtext 1.0pt;\n" +
                "  border-top:none;padding:0cm 5.4pt 0cm 5.4pt;height:14.1pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>14.Όνομα\n" +
                "  και Επώνυμο της μητέρας</span></p>\n" +
                "  </td>\n" +
                "  <td width=180 valign=top style='width:134.65pt;border-top:none;border-left:\n" +
                "  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:14.1pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>"+Field64+"</span></p>\n" +
                "  </td>\n" +
                "  <td width=170 valign=top style='width:127.6pt;border-top:none;border-left:\n" +
                "  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:14.1pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>"+Field65+"</span></p>\n" +
                "  </td>\n" +
                " </tr>\n" +
                " <tr style='height:13.65pt'>\n" +
                "  <td width=236 valign=top style='width:177.2pt;border:solid windowtext 1.0pt;\n" +
                "  border-top:none;padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>15.Στοιχεία\n" +
                "  ζεύγους</span></p>\n" +
                "  </td>\n" +
                "  <td width=180 valign=top style='width:134.65pt;border-top:none;border-left:\n" +
                "  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>"+Field66+"</span></p>\n" +
                "  </td>\n" +
                "  <td width=170 valign=top style='width:127.6pt;border-top:none;border-left:\n" +
                "  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>"+Field67+"</span></p>\n" +
                "  </td>\n" +
                " </tr>\n" +
                " <tr style='height:13.65pt'>\n" +
                "  <td width=236 valign=top style='width:177.2pt;border:solid windowtext 1.0pt;\n" +
                "  border-top:none;padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'> \n" +
                "  Μόνιμη Κατοικία</span></p>\n" +
                "  </td>\n" +
                "  <td width=180 valign=top style='width:134.65pt;border-top:none;border-left:\n" +
                "  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>"+Field68+"</span></p>\n" +
                "  </td>\n" +
                "  <td width=170 valign=top style='width:127.6pt;border-top:none;border-left:\n" +
                "  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>"+Field69+"</span></p>\n" +
                "  </td>\n" +
                " </tr>\n" +
                " <tr style='height:14.1pt'>\n" +
                "  <td width=236 valign=top style='width:177.2pt;border:solid windowtext 1.0pt;\n" +
                "  border-top:none;padding:0cm 5.4pt 0cm 5.4pt;height:14.1pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'> \n" +
                "  Νομός</span></p>\n" +
                "  </td>\n" +
                "  <td width=180 valign=top style='width:134.65pt;border-top:none;border-left:\n" +
                "  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:14.1pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>"+Field70+"</span></p>\n" +
                "  </td>\n" +
                "  <td width=170 valign=top style='width:127.6pt;border-top:none;border-left:\n" +
                "  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:14.1pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>"+Field71+"</span></p>\n" +
                "  </td>\n" +
                " </tr>\n" +
                " <tr style='height:13.65pt'>\n" +
                "  <td width=236 valign=top style='width:177.2pt;border:solid windowtext 1.0pt;\n" +
                "  border-top:none;padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'> \n" +
                "  Δήμος/Δημοτική Ενότητα</span></p>\n" +
                "  </td>\n" +
                "  <td width=180 valign=top style='width:134.65pt;border-top:none;border-left:\n" +
                "  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>"+Field72+"</span></p>\n" +
                "  </td>\n" +
                "  <td width=170 valign=top style='width:127.6pt;border-top:none;border-left:\n" +
                "  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>"+Field73+"</span></p>\n" +
                "  </td>\n" +
                " </tr>\n" +
                " <tr style='height:14.1pt'>\n" +
                "  <td width=236 valign=top style='width:177.2pt;border:solid windowtext 1.0pt;\n" +
                "  border-top:none;padding:0cm 5.4pt 0cm 5.4pt;height:14.1pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'> \n" +
                "  Δημοτική/Τοπική Κοινότητα</span></p>\n" +
                "  </td>\n" +
                "  <td width=180 valign=top style='width:134.65pt;border-top:none;border-left:\n" +
                "  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:14.1pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>"+Field74+"</span></p>\n" +
                "  </td>\n" +
                "  <td width=170 valign=top style='width:127.6pt;border-top:none;border-left:\n" +
                "  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:14.1pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>"+Field75+"</span></p>\n" +
                "  </td>\n" +
                " </tr>\n" +
                " <tr style='height:13.65pt'>\n" +
                "  <td width=236 valign=top style='width:177.2pt;border:solid windowtext 1.0pt;\n" +
                "  border-top:none;padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'> \n" +
                "  Χώρα/Πόλη εξωτερικού</span></p>\n" +
                "  </td>\n" +
                "  <td width=180 valign=top style='width:134.65pt;border-top:none;border-left:\n" +
                "  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>"+Field76+"</span></p>\n" +
                "  </td>\n" +
                "  <td width=170 valign=top style='width:127.6pt;border-top:none;border-left:\n" +
                "  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>"+Field77+"</span></p>\n" +
                "  </td>\n" +
                " </tr>\n" +
                " <tr style='height:13.65pt'>\n" +
                "  <td width=236 valign=top style='width:177.2pt;border:solid windowtext 1.0pt;\n" +
                "  border-top:none;padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>16.Επώνυμο\n" +
                "  τέκνων</span></p>\n" +
                "  </td>\n" +
                "  <td width=180 valign=top style='width:134.65pt;border-top:none;border-left:\n" +
                "  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>"+Field78+"</span></p>\n" +
                "  </td>\n" +
                "  <td width=170 valign=top style='width:127.6pt;border-top:none;border-left:\n" +
                "  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>"+Field79+"</span></p>\n" +
                "  </td>\n" +
                " </tr>\n" +
                " <tr style='height:14.1pt'>\n" +
                "  <td width=236 valign=top style='width:177.2pt;border:solid windowtext 1.0pt;\n" +
                "  border-top:none;padding:0cm 5.4pt 0cm 5.4pt;height:14.1pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>17.Οικογενειακή\n" +
                "  κατάσταση (προ του γάμου)</span></p>\n" +
                "  </td>\n" +
                "  <td width=180 valign=top style='width:134.65pt;border-top:none;border-left:\n" +
                "  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:14.1pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>"+CheckBox1+"</span></p>\n" +
                "  </td>\n" +
                "  <td width=170 valign=top style='width:127.6pt;border-top:none;border-left:\n" +
                "  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:14.1pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>"+CheckBox2+"</span></p>\n" +
                "  </td>\n" +
                " </tr>\n" +
                " <tr style='height:13.65pt'>\n" +
                "  <td width=236 valign=top style='width:177.2pt;border:solid windowtext 1.0pt;\n" +
                "  border-top:none;padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>18.Βαθμός\n" +
                "  γάμου (πρώτος,δεύτερος,τρίτος)</span></p>\n" +
                "  </td>\n" +
                "  <td width=180 valign=top style='width:134.65pt;border-top:none;border-left:\n" +
                "  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>"+Field80+"</span></p>\n" +
                "  </td>\n" +
                "  <td width=170 valign=top style='width:127.6pt;border-top:none;border-left:\n" +
                "  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>"+Field81+"</span></p>\n" +
                "  </td>\n" +
                " </tr>\n" +
                " <tr style='height:14.1pt'>\n" +
                "  <td width=236 valign=top style='width:177.2pt;border:solid windowtext 1.0pt;\n" +
                "  border-top:none;padding:0cm 5.4pt 0cm 5.4pt;height:14.1pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>19.Εκπαίδευση</span></p>\n" +
                "  </td>\n" +
                "  <td width=180 valign=top style='width:134.65pt;border-top:none;border-left:\n" +
                "  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:14.1pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>"+CheckBox3+"</span></p>\n" +
                "  </td>\n" +
                "  <td width=170 valign=top style='width:127.6pt;border-top:none;border-left:\n" +
                "  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:14.1pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>"+CheckBox4+"</span></p>\n" +
                "  </td>\n" +
                " </tr>\n" +
                "</table>\n" +
                "\n" +
                "<p class=MsoNormal style='margin-left:36.0pt'><span lang=EL style='font-family:\n" +
                "\"Times New Roman\",serif'>&nbsp;</span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>&nbsp;</span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>20.Αριθμός\n" +
                "άδειας γάμου άνδρα "+Field82+" Ιεράς Μητροπόλεως "+Field83+"</span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>  \n" +
                "Αριθμός άδειας γάμου γυναίκας "+Field84+" Ιεράς Μητροπόλεως "+Field85+"</span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>&nbsp;</span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>21.Αριθμός\n" +
                "παραβόλου γάμου άνδρα "+Field86+"</span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>  \n" +
                "Αριθμός παραβόλου γάμου γυναίκας "+Field87+ "</span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>&nbsp;</span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>Οι\n" +
                "Σύζυγοι                               Οι Παράνυμφοι                                   Ο\n" +
                "Ιερέας </span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>(υπογραφή)\n" +
                "                             (υπογραφή)                                  (Υπογραφή\n" +
                "και σφραγίδα) </span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>&nbsp;</span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>&nbsp;</span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>____________              \n" +
                "</span><span style='font-family:\"Times New Roman\",serif'>         </span><span\n" +
                "lang=EL style='font-family:\"Times New Roman\",serif'>____________</span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span style='font-family:\"Times New Roman\",serif'>                                                                                                </span></p>\n" +
                "\n" +
                "<p class=MsoNormal style='margin-left:252.0pt;text-indent:36.0pt'><span\n" +
                "style='font-family:\"Times New Roman\",serif'>&nbsp;</span></p>\n" +
                "\n" +
                "<p class=MsoNormal style='margin-left:252.0pt;text-indent:36.0pt'><span\n" +
                "style='font-family:\"Times New Roman\",serif'>&nbsp;</span></p>\n" +
                "\n" +
                "<p class=MsoNormal style='margin-left:252.0pt;text-indent:36.0pt'><span\n" +
                "style='font-family:\"Times New Roman\",serif'> Αριθμ. τηλεφ. "+Field88+"</span></p>\n" +
                "\n" +
                "</div>\n" +
                "\n" +
                "</body>\n" +
                "\n" +
                "</html>\n";


        htmlEditor.setHtmlText(INITIAL_TEXT);

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
                " /* Style Definitions */\n" +
                " p.MsoNormal, li.MsoNormal, div.MsoNormal\n" +
                "\t{margin:0cm;\n" +
                "\tmargin-bottom:.0001pt;\n" +
                "\tfont-size:12.0pt;\n" +
                "\tfont-family:\"Calibri\",sans-serif;}\n" +
                "p.msonormal0, li.msonormal0, div.msonormal0\n" +
                "\t{mso-style-name:msonormal;\n" +
                "\tmargin-right:0cm;\n" +
                "\tmargin-left:0cm;\n" +
                "\tfont-size:12.0pt;\n" +
                "\tfont-family:\"Times New Roman\",serif;}\n" +
                "p.msochpdefault, li.msochpdefault, div.msochpdefault\n" +
                "\t{mso-style-name:msochpdefault;\n" +
                "\tmargin-right:0cm;\n" +
                "\tmargin-left:0cm;\n" +
                "\tfont-size:12.0pt;\n" +
                "\tfont-family:\"Calibri\",sans-serif;}\n" +
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
                "<p class=MsoNormal style='margin-left:36.0pt;text-indent:36.0pt'><span lang=EL\n" +
                "style='font-family:\"Times New Roman\",serif'>Αριθμ.ληξ.πράξη\n" +
                "γάμου........Τόμος...... ...έτος............</span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span style='font-family:\"Times New Roman\",serif'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><span\n" +
                "style='font-family:\"Times New Roman\",serif'> </span><span style='font-family:\n" +
                "\"Times New Roman\",serif'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><span\n" +
                "style='font-family:\"Times New Roman\",serif'> </span><span style='font-family:\n" +
                "\"Times New Roman\",serif'>&nbsp;&nbsp;</span><span lang=EL style='font-family:\n" +
                "\"Times New Roman\",serif'>(Αναγράφεται από το Ληξίαρχο)</span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>&nbsp;</span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>ΙΕΡΑ\n" +
                "ΜΗΤΡΟΠΟΛΗ..............................</span></p>\n" +
                "\n" +
                "<p class=MsoNormal style='margin-left:144.0pt;text-indent:-144.0pt'><span\n" +
                "lang=EL style='font-family:\"Times New Roman\",serif'>ΙΕΡΟΣ\n" +
                "ΝΑΟΣ......................\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Ο\n" +
                "γάμος δηλώνεται στο Ληξιαρχείο, </span></p>\n" +
                "\n" +
                "<p class=MsoNormal style='margin-left:144.0pt;text-align:justify;text-indent:\n" +
                "-144.0pt'><span lang=EL style='font-family:\"Times New Roman\",serif'>ΔΗΜΟΤΙΚΟ/ΤΟΠΙΚΟ\n" +
                "ΔΙΑΜΕΡΙΣΜΑ.............. μέσα σε (40) σαράντα ημέρες από την </span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>ΔΗΜΟΣ/ΔΗΜΟΤΙΚΗ\n" +
                "ΕΝΟΤΗΤΑ<span style='color:black'>.....................</span> τέλεσή του,\n" +
                "σύμφωνα με το άρθρο 29,</span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>ΝΟΜΟΣ.................................&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;παραγρ.\n" +
                "1 του Ν.344/1976</span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>Αριθμ.\n" +
                "Βιβλ.......................</span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
                "&nbsp;</span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>&nbsp;</span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
                "&nbsp;ΔΗΛΩΣΗ ΤΕΛΕΣΗΣ ΘΡΗΣΚΕΥΤΙΚΟΥ ΓΑΜΟΥ</span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>     \n" +
                "Ο υπογεγραμμένος ιερέας ................... της ενορίας του Ιερου Ναού…..…………</span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>     \n" +
                "δηλώνω ότι σήμερα στις ...................του μήνα..................του\n" +
                "έτους..................και </span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>     \n" +
                "ώρα....…...τέλεσα στ ...............και στον ως άνω Ιερό ναό κατά το δόγμα……..…</span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>     \n" +
                "το μυστήριο του γάμου των κατωτέρω συζύγων:</span></p>\n" +
                "\n" +
                "<p class=MsoNormal style='margin-left:36.0pt'><span lang=EL style='font-family:\n" +
                "\"Times New Roman\",serif'>&nbsp;</span></p>\n" +
                "\n" +
                "<table class=MsoNormalTable border=0 cellspacing=0 cellpadding=0 width=614\n" +
                " style='width:460.45pt;margin-left:-.25pt;border-collapse:collapse'>\n" +
                " <tr style='height:13.65pt'>\n" +
                "  <td width=236 valign=top style='width:177.2pt;border:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>ΣΤΟΙΧΕΙΑ</span></p>\n" +
                "  </td>\n" +
                "  <td width=189 valign=top style='width:141.5pt;border:solid windowtext 1.0pt;\n" +
                "  border-left:none;padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>ΤΟΥ\n" +
                "  ΣΥΖΥΓΟΥ</span></p>\n" +
                "  </td>\n" +
                "  <td width=189 valign=top style='width:5.0cm;border:solid windowtext 1.0pt;\n" +
                "  border-left:none;padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>ΤΗΣ\n" +
                "  ΣΥΖΥΓΟΥ</span></p>\n" +
                "  </td>\n" +
                " </tr>\n" +
                " <tr style='height:14.1pt'>\n" +
                "  <td width=236 valign=top style='width:177.2pt;border:solid windowtext 1.0pt;\n" +
                "  border-top:none;padding:0cm 5.4pt 0cm 5.4pt;height:14.1pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>1.Επώνυμο*</span></p>\n" +
                "  </td>\n" +
                "  <td width=189 valign=top style='width:141.5pt;border-top:none;border-left:\n" +
                "  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:14.1pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>&nbsp;</span></p>\n" +
                "  </td>\n" +
                "  <td width=189 valign=top style='width:5.0cm;border-top:none;border-left:none;\n" +
                "  border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:14.1pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>&nbsp;</span></p>\n" +
                "  </td>\n" +
                " </tr>\n" +
                " <tr style='height:13.65pt'>\n" +
                "  <td width=236 valign=top style='width:177.2pt;border:solid windowtext 1.0pt;\n" +
                "  border-top:none;padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>2.Όνομα</span></p>\n" +
                "  </td>\n" +
                "  <td width=189 valign=top style='width:141.5pt;border-top:none;border-left:\n" +
                "  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>&nbsp;</span></p>\n" +
                "  </td>\n" +
                "  <td width=189 valign=top style='width:5.0cm;border-top:none;border-left:none;\n" +
                "  border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>&nbsp;</span></p>\n" +
                "  </td>\n" +
                " </tr>\n" +
                " <tr style='height:14.1pt'>\n" +
                "  <td width=236 valign=top style='width:177.2pt;border:solid windowtext 1.0pt;\n" +
                "  border-top:none;padding:0cm 5.4pt 0cm 5.4pt;height:14.1pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>3.Επάγγελμα\n" +
                "  (προ του γάμου)</span></p>\n" +
                "  </td>\n" +
                "  <td width=189 valign=top style='width:141.5pt;border-top:none;border-left:\n" +
                "  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:14.1pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>&nbsp;</span></p>\n" +
                "  </td>\n" +
                "  <td width=189 valign=top style='width:5.0cm;border-top:none;border-left:none;\n" +
                "  border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:14.1pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>&nbsp;</span></p>\n" +
                "  </td>\n" +
                " </tr>\n" +
                " <tr style='height:13.65pt'>\n" +
                "  <td width=236 valign=top style='width:177.2pt;border:solid windowtext 1.0pt;\n" +
                "  border-top:none;padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>4.Θρήσκευμα\n" +
                "  και δόγμα.</span></p>\n" +
                "  </td>\n" +
                "  <td width=189 valign=top style='width:141.5pt;border-top:none;border-left:\n" +
                "  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>&nbsp;</span></p>\n" +
                "  </td>\n" +
                "  <td width=189 valign=top style='width:5.0cm;border-top:none;border-left:none;\n" +
                "  border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>&nbsp;</span></p>\n" +
                "  </td>\n" +
                " </tr>\n" +
                " <tr style='height:13.65pt'>\n" +
                "  <td width=236 valign=top style='width:177.2pt;border:solid windowtext 1.0pt;\n" +
                "  border-top:none;padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>5.Ιθαγένεια\n" +
                "  (προ του γάμου)</span></p>\n" +
                "  </td>\n" +
                "  <td width=189 valign=top style='width:141.5pt;border-top:none;border-left:\n" +
                "  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>&nbsp;</span></p>\n" +
                "  </td>\n" +
                "  <td width=189 valign=top style='width:5.0cm;border-top:none;border-left:none;\n" +
                "  border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>&nbsp;</span></p>\n" +
                "  </td>\n" +
                " </tr>\n" +
                " <tr style='height:14.1pt'>\n" +
                "  <td width=236 valign=top style='width:177.2pt;border:solid windowtext 1.0pt;\n" +
                "  border-top:none;padding:0cm 5.4pt 0cm 5.4pt;height:14.1pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>6.ΑΦΜ.</span></p>\n" +
                "  </td>\n" +
                "  <td width=189 valign=top style='width:141.5pt;border-top:none;border-left:\n" +
                "  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:14.1pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>&nbsp;</span></p>\n" +
                "  </td>\n" +
                "  <td width=189 valign=top style='width:5.0cm;border-top:none;border-left:none;\n" +
                "  border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:14.1pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>&nbsp;</span></p>\n" +
                "  </td>\n" +
                " </tr>\n" +
                " <tr style='height:13.65pt'>\n" +
                "  <td width=236 valign=top style='width:177.2pt;border:solid windowtext 1.0pt;\n" +
                "  border-top:none;padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>7.ΑΜΚΑ</span></p>\n" +
                "  </td>\n" +
                "  <td width=189 valign=top style='width:141.5pt;border-top:none;border-left:\n" +
                "  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>&nbsp;</span></p>\n" +
                "  </td>\n" +
                "  <td width=189 valign=top style='width:5.0cm;border-top:none;border-left:none;\n" +
                "  border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>&nbsp;</span></p>\n" +
                "  </td>\n" +
                " </tr>\n" +
                " <tr style='height:13.65pt'>\n" +
                "  <td width=236 valign=top style='width:177.2pt;border:solid windowtext 1.0pt;\n" +
                "  border-top:none;padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>8.Φορείς\n" +
                "  Ασφάλισης </span></p>\n" +
                "  </td>\n" +
                "  <td width=189 valign=top style='width:141.5pt;border-top:none;border-left:\n" +
                "  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>&nbsp;</span></p>\n" +
                "  </td>\n" +
                "  <td width=189 valign=top style='width:5.0cm;border-top:none;border-left:none;\n" +
                "  border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>&nbsp;</span></p>\n" +
                "  </td>\n" +
                " </tr>\n" +
                " <tr style='height:14.1pt'>\n" +
                "  <td width=236 valign=top style='width:177.2pt;border:solid windowtext 1.0pt;\n" +
                "  border-top:none;padding:0cm 5.4pt 0cm 5.4pt;height:14.1pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>9.Τόπος\n" +
                "  Γέννησης</span></p>\n" +
                "  </td>\n" +
                "  <td width=189 valign=top style='width:141.5pt;border-top:none;border-left:\n" +
                "  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:14.1pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>&nbsp;</span></p>\n" +
                "  </td>\n" +
                "  <td width=189 valign=top style='width:5.0cm;border-top:none;border-left:none;\n" +
                "  border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:14.1pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>&nbsp;</span></p>\n" +
                "  </td>\n" +
                " </tr>\n" +
                " <tr style='height:13.65pt'>\n" +
                "  <td width=236 valign=top style='width:177.2pt;border:solid windowtext 1.0pt;\n" +
                "  border-top:none;padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span style='font-family:\"Times New Roman\",serif'>&nbsp;&nbsp;</span><span\n" +
                "  lang=EL style='font-family:\"Times New Roman\",serif'>Νομός</span></p>\n" +
                "  </td>\n" +
                "  <td width=189 valign=top style='width:141.5pt;border-top:none;border-left:\n" +
                "  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>&nbsp;</span></p>\n" +
                "  </td>\n" +
                "  <td width=189 valign=top style='width:5.0cm;border-top:none;border-left:none;\n" +
                "  border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>&nbsp;</span></p>\n" +
                "  </td>\n" +
                " </tr>\n" +
                " <tr style='height:14.1pt'>\n" +
                "  <td width=236 valign=top style='width:177.2pt;border:solid windowtext 1.0pt;\n" +
                "  border-top:none;padding:0cm 5.4pt 0cm 5.4pt;height:14.1pt'>\n" +
                "  <p class=MsoNormal><span style='font-family:\"Times New Roman\",serif'>&nbsp;&nbsp;</span><span\n" +
                "  lang=EL style='font-family:\"Times New Roman\",serif'>Δήμος/Δημοτική Ενότητα</span></p>\n" +
                "  </td>\n" +
                "  <td width=189 valign=top style='width:141.5pt;border-top:none;border-left:\n" +
                "  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:14.1pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>&nbsp;</span></p>\n" +
                "  </td>\n" +
                "  <td width=189 valign=top style='width:5.0cm;border-top:none;border-left:none;\n" +
                "  border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:14.1pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>&nbsp;</span></p>\n" +
                "  </td>\n" +
                " </tr>\n" +
                " <tr style='height:13.65pt'>\n" +
                "  <td width=236 valign=top style='width:177.2pt;border:solid windowtext 1.0pt;\n" +
                "  border-top:none;padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>&nbsp;\n" +
                "  Δημοτική/Τοπική Κοινότητα</span></p>\n" +
                "  </td>\n" +
                "  <td width=189 valign=top style='width:141.5pt;border-top:none;border-left:\n" +
                "  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>&nbsp;</span></p>\n" +
                "  </td>\n" +
                "  <td width=189 valign=top style='width:5.0cm;border-top:none;border-left:none;\n" +
                "  border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>&nbsp;</span></p>\n" +
                "  </td>\n" +
                " </tr>\n" +
                " <tr style='height:13.65pt'>\n" +
                "  <td width=236 valign=top style='width:177.2pt;border:solid windowtext 1.0pt;\n" +
                "  border-top:none;padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>&nbsp;\n" +
                "  Χώρα/Πόλη εξωτερικού</span></p>\n" +
                "  </td>\n" +
                "  <td width=189 valign=top style='width:141.5pt;border-top:none;border-left:\n" +
                "  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>&nbsp;</span></p>\n" +
                "  </td>\n" +
                "  <td width=189 valign=top style='width:5.0cm;border-top:none;border-left:none;\n" +
                "  border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>&nbsp;</span></p>\n" +
                "  </td>\n" +
                " </tr>\n" +
                " <tr style='height:14.1pt'>\n" +
                "  <td width=236 valign=top style='width:177.2pt;border:solid windowtext 1.0pt;\n" +
                "  border-top:none;padding:0cm 5.4pt 0cm 5.4pt;height:14.1pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>10.Χρονολογία\n" +
                "  Γέννησης</span></p>\n" +
                "  </td>\n" +
                "  <td width=189 valign=top style='width:141.5pt;border-top:none;border-left:\n" +
                "  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:14.1pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>&nbsp;</span></p>\n" +
                "  </td>\n" +
                "  <td width=189 valign=top style='width:5.0cm;border-top:none;border-left:none;\n" +
                "  border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:14.1pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>&nbsp;</span></p>\n" +
                "  </td>\n" +
                " </tr>\n" +
                " <tr style='height:13.65pt'>\n" +
                "  <td width=236 valign=top style='width:177.2pt;border:solid windowtext 1.0pt;\n" +
                "  border-top:none;padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>11.Μόνιμη\n" +
                "  Κατοικία (προ γάμου)</span></p>\n" +
                "  </td>\n" +
                "  <td width=189 valign=top style='width:141.5pt;border-top:none;border-left:\n" +
                "  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>&nbsp;</span></p>\n" +
                "  </td>\n" +
                "  <td width=189 valign=top style='width:5.0cm;border-top:none;border-left:none;\n" +
                "  border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>&nbsp;</span></p>\n" +
                "  </td>\n" +
                " </tr>\n" +
                " <tr style='height:14.1pt'>\n" +
                "  <td width=236 valign=top style='width:177.2pt;border:solid windowtext 1.0pt;\n" +
                "  border-top:none;padding:0cm 5.4pt 0cm 5.4pt;height:14.1pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>&nbsp;\n" +
                "  Νομός</span></p>\n" +
                "  </td>\n" +
                "  <td width=189 valign=top style='width:141.5pt;border-top:none;border-left:\n" +
                "  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:14.1pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>&nbsp;</span></p>\n" +
                "  </td>\n" +
                "  <td width=189 valign=top style='width:5.0cm;border-top:none;border-left:none;\n" +
                "  border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:14.1pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>&nbsp;</span></p>\n" +
                "  </td>\n" +
                " </tr>\n" +
                " <tr style='height:13.65pt'>\n" +
                "  <td width=236 valign=top style='width:177.2pt;border:solid windowtext 1.0pt;\n" +
                "  border-top:none;padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>&nbsp;\n" +
                "  Δήμος/Δημοτική Ενότητα</span></p>\n" +
                "  </td>\n" +
                "  <td width=189 valign=top style='width:141.5pt;border-top:none;border-left:\n" +
                "  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>&nbsp;</span></p>\n" +
                "  </td>\n" +
                "  <td width=189 valign=top style='width:5.0cm;border-top:none;border-left:none;\n" +
                "  border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>&nbsp;</span></p>\n" +
                "  </td>\n" +
                " </tr>\n" +
                " <tr style='height:13.65pt'>\n" +
                "  <td width=236 valign=top style='width:177.2pt;border:solid windowtext 1.0pt;\n" +
                "  border-top:none;padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>&nbsp;\n" +
                "  Δημοτική/Τοπική Κοινότητα</span></p>\n" +
                "  </td>\n" +
                "  <td width=189 valign=top style='width:141.5pt;border-top:none;border-left:\n" +
                "  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>&nbsp;</span></p>\n" +
                "  </td>\n" +
                "  <td width=189 valign=top style='width:5.0cm;border-top:none;border-left:none;\n" +
                "  border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>&nbsp;</span></p>\n" +
                "  </td>\n" +
                " </tr>\n" +
                " <tr style='height:14.1pt'>\n" +
                "  <td width=236 valign=top style='width:177.2pt;border:solid windowtext 1.0pt;\n" +
                "  border-top:none;padding:0cm 5.4pt 0cm 5.4pt;height:14.1pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>&nbsp;\n" +
                "  Χώρα/Πόλη εξωτερικού</span></p>\n" +
                "  </td>\n" +
                "  <td width=189 valign=top style='width:141.5pt;border-top:none;border-left:\n" +
                "  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:14.1pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>&nbsp;</span></p>\n" +
                "  </td>\n" +
                "  <td width=189 valign=top style='width:5.0cm;border-top:none;border-left:none;\n" +
                "  border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:14.1pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>&nbsp;</span></p>\n" +
                "  </td>\n" +
                " </tr>\n" +
                " <tr style='height:13.65pt'>\n" +
                "  <td width=236 valign=top style='width:177.2pt;border:solid windowtext 1.0pt;\n" +
                "  border-top:none;padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>12.Δημότης:Δήμος/Δημοτική\n" +
                "  Ενότητα</span></p>\n" +
                "  </td>\n" +
                "  <td width=189 valign=top style='width:141.5pt;border-top:none;border-left:\n" +
                "  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>&nbsp;</span></p>\n" +
                "  </td>\n" +
                "  <td width=189 valign=top style='width:5.0cm;border-top:none;border-left:none;\n" +
                "  border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>&nbsp;</span></p>\n" +
                "  </td>\n" +
                " </tr>\n" +
                " <tr style='height:13.65pt'>\n" +
                "  <td width=236 valign=top style='width:177.2pt;border:solid windowtext 1.0pt;\n" +
                "  border-top:none;padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>&nbsp;\n" +
                "  Νομός</span></p>\n" +
                "  </td>\n" +
                "  <td width=189 valign=top style='width:141.5pt;border-top:none;border-left:\n" +
                "  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>&nbsp;</span></p>\n" +
                "  </td>\n" +
                "  <td width=189 valign=top style='width:5.0cm;border-top:none;border-left:none;\n" +
                "  border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>&nbsp;</span></p>\n" +
                "  </td>\n" +
                " </tr>\n" +
                " <tr style='height:14.1pt'>\n" +
                "  <td width=236 valign=top style='width:177.2pt;border:solid windowtext 1.0pt;\n" +
                "  border-top:none;padding:0cm 5.4pt 0cm 5.4pt;height:14.1pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>&nbsp;\n" +
                "  Αριθμ. Δημοτολογίου</span></p>\n" +
                "  </td>\n" +
                "  <td width=189 valign=top style='width:141.5pt;border-top:none;border-left:\n" +
                "  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:14.1pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>&nbsp;</span></p>\n" +
                "  </td>\n" +
                "  <td width=189 valign=top style='width:5.0cm;border-top:none;border-left:none;\n" +
                "  border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:14.1pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>&nbsp;</span></p>\n" +
                "  </td>\n" +
                " </tr>\n" +
                " <tr style='height:13.65pt'>\n" +
                "  <td width=236 valign=top style='width:177.2pt;border:solid windowtext 1.0pt;\n" +
                "  border-top:none;padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>13.Όνομα\n" +
                "  και Επώνυμο του πατέρα</span></p>\n" +
                "  </td>\n" +
                "  <td width=189 valign=top style='width:141.5pt;border-top:none;border-left:\n" +
                "  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>&nbsp;</span></p>\n" +
                "  </td>\n" +
                "  <td width=189 valign=top style='width:5.0cm;border-top:none;border-left:none;\n" +
                "  border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>&nbsp;</span></p>\n" +
                "  </td>\n" +
                " </tr>\n" +
                " <tr style='height:14.1pt'>\n" +
                "  <td width=236 valign=top style='width:177.2pt;border:solid windowtext 1.0pt;\n" +
                "  border-top:none;padding:0cm 5.4pt 0cm 5.4pt;height:14.1pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>14.Όνομα\n" +
                "  και Επώνυμο της μητέρας</span></p>\n" +
                "  </td>\n" +
                "  <td width=189 valign=top style='width:141.5pt;border-top:none;border-left:\n" +
                "  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:14.1pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>&nbsp;</span></p>\n" +
                "  </td>\n" +
                "  <td width=189 valign=top style='width:5.0cm;border-top:none;border-left:none;\n" +
                "  border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:14.1pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>&nbsp;</span></p>\n" +
                "  </td>\n" +
                " </tr>\n" +
                " <tr style='height:13.65pt'>\n" +
                "  <td width=236 valign=top style='width:177.2pt;border:solid windowtext 1.0pt;\n" +
                "  border-top:none;padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>15.Στοιχεία\n" +
                "  ζεύγους</span></p>\n" +
                "  </td>\n" +
                "  <td width=189 valign=top style='width:141.5pt;border-top:none;border-left:\n" +
                "  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>&nbsp;</span></p>\n" +
                "  </td>\n" +
                "  <td width=189 valign=top style='width:5.0cm;border-top:none;border-left:none;\n" +
                "  border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>&nbsp;</span></p>\n" +
                "  </td>\n" +
                " </tr>\n" +
                " <tr style='height:13.65pt'>\n" +
                "  <td width=236 valign=top style='width:177.2pt;border:solid windowtext 1.0pt;\n" +
                "  border-top:none;padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>&nbsp;\n" +
                "  Μόνιμη Κατοικία</span></p>\n" +
                "  </td>\n" +
                "  <td width=189 valign=top style='width:141.5pt;border-top:none;border-left:\n" +
                "  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>&nbsp;</span></p>\n" +
                "  </td>\n" +
                "  <td width=189 valign=top style='width:5.0cm;border-top:none;border-left:none;\n" +
                "  border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>&nbsp;</span></p>\n" +
                "  </td>\n" +
                " </tr>\n" +
                " <tr style='height:14.1pt'>\n" +
                "  <td width=236 valign=top style='width:177.2pt;border:solid windowtext 1.0pt;\n" +
                "  border-top:none;padding:0cm 5.4pt 0cm 5.4pt;height:14.1pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>&nbsp;\n" +
                "  Νομός</span></p>\n" +
                "  </td>\n" +
                "  <td width=189 valign=top style='width:141.5pt;border-top:none;border-left:\n" +
                "  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:14.1pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>&nbsp;</span></p>\n" +
                "  </td>\n" +
                "  <td width=189 valign=top style='width:5.0cm;border-top:none;border-left:none;\n" +
                "  border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:14.1pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>&nbsp;</span></p>\n" +
                "  </td>\n" +
                " </tr>\n" +
                " <tr style='height:13.65pt'>\n" +
                "  <td width=236 valign=top style='width:177.2pt;border:solid windowtext 1.0pt;\n" +
                "  border-top:none;padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>&nbsp;\n" +
                "  Δήμος/Δημοτική Ενότητα</span></p>\n" +
                "  </td>\n" +
                "  <td width=189 valign=top style='width:141.5pt;border-top:none;border-left:\n" +
                "  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>&nbsp;</span></p>\n" +
                "  </td>\n" +
                "  <td width=189 valign=top style='width:5.0cm;border-top:none;border-left:none;\n" +
                "  border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>&nbsp;</span></p>\n" +
                "  </td>\n" +
                " </tr>\n" +
                " <tr style='height:14.1pt'>\n" +
                "  <td width=236 valign=top style='width:177.2pt;border:solid windowtext 1.0pt;\n" +
                "  border-top:none;padding:0cm 5.4pt 0cm 5.4pt;height:14.1pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>&nbsp;\n" +
                "  Δημοτική/Τοπική Κοινότητα</span></p>\n" +
                "  </td>\n" +
                "  <td width=189 valign=top style='width:141.5pt;border-top:none;border-left:\n" +
                "  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:14.1pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>&nbsp;</span></p>\n" +
                "  </td>\n" +
                "  <td width=189 valign=top style='width:5.0cm;border-top:none;border-left:none;\n" +
                "  border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:14.1pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>&nbsp;</span></p>\n" +
                "  </td>\n" +
                " </tr>\n" +
                " <tr style='height:13.65pt'>\n" +
                "  <td width=236 valign=top style='width:177.2pt;border:solid windowtext 1.0pt;\n" +
                "  border-top:none;padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>&nbsp;\n" +
                "  Χώρα/Πόλη εξωτερικού</span></p>\n" +
                "  </td>\n" +
                "  <td width=189 valign=top style='width:141.5pt;border-top:none;border-left:\n" +
                "  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>&nbsp;</span></p>\n" +
                "  </td>\n" +
                "  <td width=189 valign=top style='width:5.0cm;border-top:none;border-left:none;\n" +
                "  border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>&nbsp;</span></p>\n" +
                "  </td>\n" +
                " </tr>\n" +
                " <tr style='height:13.65pt'>\n" +
                "  <td width=236 valign=top style='width:177.2pt;border:solid windowtext 1.0pt;\n" +
                "  border-top:none;padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>16.Επώνυμο\n" +
                "  τέκνων</span></p>\n" +
                "  </td>\n" +
                "  <td width=189 valign=top style='width:141.5pt;border-top:none;border-left:\n" +
                "  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>&nbsp;</span></p>\n" +
                "  </td>\n" +
                "  <td width=189 valign=top style='width:5.0cm;border-top:none;border-left:none;\n" +
                "  border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>&nbsp;</span></p>\n" +
                "  </td>\n" +
                " </tr>\n" +
                " <tr style='height:14.1pt'>\n" +
                "  <td width=236 valign=top style='width:177.2pt;border:solid windowtext 1.0pt;\n" +
                "  border-top:none;padding:0cm 5.4pt 0cm 5.4pt;height:14.1pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>17.Οικογενειακή\n" +
                "  κατάσταση (προ του γάμου)</span></p>\n" +
                "  </td>\n" +
                "  <td width=189 valign=top style='width:141.5pt;border-top:none;border-left:\n" +
                "  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:14.1pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>&nbsp;</span></p>\n" +
                "  </td>\n" +
                "  <td width=189 valign=top style='width:5.0cm;border-top:none;border-left:none;\n" +
                "  border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:14.1pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>&nbsp;</span></p>\n" +
                "  </td>\n" +
                " </tr>\n" +
                " <tr style='height:13.65pt'>\n" +
                "  <td width=236 valign=top style='width:177.2pt;border:solid windowtext 1.0pt;\n" +
                "  border-top:none;padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>18.Βαθμός\n" +
                "  γάμου (πρώτος,δεύτερος,τρίτος)</span></p>\n" +
                "  </td>\n" +
                "  <td width=189 valign=top style='width:141.5pt;border-top:none;border-left:\n" +
                "  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>&nbsp;</span></p>\n" +
                "  </td>\n" +
                "  <td width=189 valign=top style='width:5.0cm;border-top:none;border-left:none;\n" +
                "  border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:13.65pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>&nbsp;</span></p>\n" +
                "  </td>\n" +
                " </tr>\n" +
                " <tr style='height:14.1pt'>\n" +
                "  <td width=236 valign=top style='width:177.2pt;border:solid windowtext 1.0pt;\n" +
                "  border-top:none;padding:0cm 5.4pt 0cm 5.4pt;height:14.1pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>19.Εκπαίδευση</span></p>\n" +
                "  </td>\n" +
                "  <td width=189 valign=top style='width:141.5pt;border-top:none;border-left:\n" +
                "  none;border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:14.1pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>&nbsp;</span></p>\n" +
                "  </td>\n" +
                "  <td width=189 valign=top style='width:5.0cm;border-top:none;border-left:none;\n" +
                "  border-bottom:solid windowtext 1.0pt;border-right:solid windowtext 1.0pt;\n" +
                "  padding:0cm 5.4pt 0cm 5.4pt;height:14.1pt'>\n" +
                "  <p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>&nbsp;</span></p>\n" +
                "  </td>\n" +
                " </tr>\n" +
                "</table>\n" +
                "\n" +
                "<p class=MsoNormal style='margin-left:36.0pt'><span lang=EL style='font-family:\n" +
                "\"Times New Roman\",serif'>&nbsp;</span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>&nbsp;</span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>20.Αριθμός\n" +
                "άδειας γάμου άνδρα.............................Ιεράς Μητροπόλεως……………..</span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>&nbsp;&nbsp;\n" +
                "Αριθμός άδειας γάμου γυναίκας......……………Ιεράς Μητροπόλεως………………</span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>&nbsp;</span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>21.Αριθμός\n" +
                "παραβόλου γάμου άνδρα... ……………………………………………….</span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>Αριθμός\n" +
                "παραβόλου γάμου γυναίκας<span style='color:black'>...............................……………………………...</span></span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL>&nbsp;</span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>&nbsp;</span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>Οι\n" +
                "Σύζυγοι\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
                "&nbsp;Οι Παράνυμφοι\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
                "&nbsp;Ο Ιερέας </span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>(υπογραφή)\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
                "&nbsp;(υπογραφή) &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(Υπογραφή και σφραγίδα) </span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>&nbsp;</span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>&nbsp;</span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Times New Roman\",serif'>____________&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
                "</span><span style='font-family:\"Times New Roman\",serif'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
                "</span><span lang=EL style='font-family:\"Times New Roman\",serif'>____________</span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span style='font-family:\"Times New Roman\",serif'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
                "</span></p>\n" +
                "\n" +
                "<p class=MsoNormal style='margin-left:252.0pt;text-indent:36.0pt'><span\n" +
                "style='font-family:\"Times New Roman\",serif'>&nbsp;</span></p>\n" +
                "\n" +
                "<p class=MsoNormal style='margin-left:252.0pt;text-indent:36.0pt'><span\n" +
                "style='font-family:\"Times New Roman\",serif'>&nbsp;</span></p>\n" +
                "\n" +
                "<p class=MsoNormal style='margin-left:252.0pt;text-indent:36.0pt'><span\n" +
                "style='font-family:\"Times New Roman\",serif'>&nbsp;Αριθμ.\n" +
                "τηλεφ......................</span></p>\n" +
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


    public void print(ActionEvent actionEvent) throws Exception {
        PrinterJob job = PrinterJob.createPrinterJob();
        if (job != null) {


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
                job.printPage(htmlEditor2);
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



