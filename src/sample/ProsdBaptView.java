package sample;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
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

public class ProsdBaptView implements Initializable {
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
        String sql = "SELECT * FROM dataProsdBaptisis WHERE id = ?";

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

    public void create_new(ActionEvent actionEvent) {

        Stage primaryStage = (Stage) create_new_btn.getScene().getWindow();

        primaryStage.close();

        Stage stage = new Stage();


        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("prosdBapt.fxml"));

            AnchorPane pane = loader.load();


            Scene scene = new Scene(pane);


            scene.getStylesheets().addAll(Main.class.getResource("style.css").toExternalForm());

            stage.setResizable(false);
            stage.setTitle("Προσδιορισμός Βαπτίσεως");
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
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("prosdBaptTable.fxml"));

            AnchorPane pane = loader.load();


            Scene scene = new Scene(pane);


            scene.getStylesheets().addAll(Main.class.getResource("style.css").toExternalForm());

            stage.setResizable(false);
            stage.setTitle("Προβολή Λίστας Δηλώσεων Προσδιορισμού Βαπτίσεως");
            stage.setScene(scene);
            stage.show();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Preferences preferences = Preferences.userNodeForPackage(DhlBaptView.class);
        String pass_id = preferences.get("id", null);

        int id = Integer.parseInt(pass_id);
        selectRow(id);



        String INITIAL_TEXT = "<html>\n" +
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
                "\t{font-family:\"Palatino Linotype\";\n" +
                "\tpanose-1:2 4 5 2 5 5 5 3 3 4;}\n" +
                "@font-face\n" +
                "\t{font-family:Genesis;\n" +
                "\tpanose-1:2 11 6 4 2 2 2 2 2 4;}\n" +
                " /* Style Definitions */\n" +
                " p.MsoNormal, li.MsoNormal, div.MsoNormal\n" +
                "\t{margin-top:0cm;\n" +
                "\tmargin-right:0cm;\n" +
                "\tmargin-bottom:10.0pt;\n" +
                "\tmargin-left:0cm;\n" +
                "\tline-height:115%;\n" +
                "\tfont-size:11.0pt;\n" +
                "\tfont-family:\"Calibri\",sans-serif;}\n" +
                "p.MsoHeader, li.MsoHeader, div.MsoHeader\n" +
                "\t{mso-style-link:\"Header Char\";\n" +
                "\tmargin:0cm;\n" +
                "\tmargin-bottom:.0001pt;\n" +
                "\tfont-size:11.0pt;\n" +
                "\tfont-family:\"Calibri\",sans-serif;}\n" +
                "p.MsoFooter, li.MsoFooter, div.MsoFooter\n" +
                "\t{mso-style-link:\"Footer Char\";\n" +
                "\tmargin:0cm;\n" +
                "\tmargin-bottom:.0001pt;\n" +
                "\tfont-size:11.0pt;\n" +
                "\tfont-family:\"Calibri\",sans-serif;}\n" +
                "p.msonormal0, li.msonormal0, div.msonormal0\n" +
                "\t{mso-style-name:msonormal;\n" +
                "\tmargin-right:0cm;\n" +
                "\tmargin-left:0cm;\n" +
                "\tfont-size:12.0pt;\n" +
                "\tfont-family:\"Times New Roman\",serif;}\n" +
                "span.HeaderChar\n" +
                "\t{mso-style-name:\"Header Char\";\n" +
                "\tmso-style-link:Header;}\n" +
                "span.FooterChar\n" +
                "\t{mso-style-name:\"Footer Char\";\n" +
                "\tmso-style-link:Footer;}\n" +
                "p.msochpdefault, li.msochpdefault, div.msochpdefault\n" +
                "\t{mso-style-name:msochpdefault;\n" +
                "\tmargin-right:0cm;\n" +
                "\tmargin-left:0cm;\n" +
                "\tfont-size:11.0pt;\n" +
                "\tfont-family:\"Calibri\",sans-serif;}\n" +
                "p.msopapdefault, li.msopapdefault, div.msopapdefault\n" +
                "\t{mso-style-name:msopapdefault;\n" +
                "\tmargin-right:0cm;\n" +
                "\tmargin-bottom:10.0pt;\n" +
                "\tmargin-left:0cm;\n" +
                "\tline-height:115%;\n" +
                "\tfont-size:12.0pt;\n" +
                "\tfont-family:\"Times New Roman\",serif;}\n" +
                ".MsoChpDefault\n" +
                "\t{font-size:11.0pt;\n" +
                "\tfont-family:\"Calibri\",sans-serif;}\n" +
                ".MsoPapDefault\n" +
                "\t{margin-bottom:10.0pt;\n" +
                "\tline-height:115%;}\n" +
                "@page WordSection1\n" +
                "\t{size:595.3pt 841.9pt;\n" +
                "\tmargin:72.0pt 90.0pt 72.0pt 90.0pt;}\n" +
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
                "<p class=MsoNormal style='text-indent:26.25pt'><b><span lang=EL\n" +
                "style='font-family:\"Palatino Linotype\",serif'>ΙΕΡΑ ΜΗΤΡΟΠΟΛΙΣ ΣΑΜΟΥ ΚΑΙ\n" +
                "ΙΚΑΡΙΑΣ&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></b></p>\n" +
                "\n" +
                "<p class=MsoNormal style='text-indent:26.25pt'><b><span lang=EL\n" +
                "style='font-family:\"Palatino Linotype\",serif'>ΟΔΗΓΙΕΣ ΤΕΛΕΣΕΩΣ ΤΟΥ ΜΥΣΤΗΡΙΟ ΤΟΥ\n" +
                "ΒΑΠΤΙΣΜΑΤΟΣ&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
                "</span></b></p>\n" +
                "\n" +
                "<p class=MsoNormal style='text-indent:26.25pt'><span lang=EL style='font-family:\n" +
                "\"Palatino Linotype\",serif'>Αγαπητοί\n" +
                "γονείς,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
                "</span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Palatino Linotype\",serif'>&nbsp;\n" +
                "Σε λίγες μέρες θα ζήσετε στο σπιτικό σας μια ξεχωριστή στιγμή που\n" +
                "θα&nbsp;&nbsp; συνοδεύει το παιδί σας για όλη του την ζωή !</span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Palatino Linotype\",serif'>&nbsp;\n" +
                "Ένας&nbsp; νέος χριστιανός ορθόδοξος θα πλαισιώσει την Εκκλησία μας. Από την πλευρά\n" +
                "μας νοιώθουμε την ανάγκη να σας υπενθυμίσουμε και να σας παρακαλέσουμε για την\n" +
                "τήρηση των πιο κάτω&nbsp; σημείων τα οποία βοηθούν στην καλλίτερη συμμέτοχη του\n" +
                "Μυστήριου.&nbsp;&nbsp; </span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Palatino Linotype\",serif'>1.Το\n" +
                "Βάπτισμα δεν είναι μια απλή κοινωνική εκδήλωση και&nbsp; υποχρέωση ,ούτε ένα\n" +
                "κοινωνικό γεγονός .Είναι το πρώτο βασικό Μυστήριο της Εκκλησιάς μας και η\n" +
                "σφραγίδα της πίστεως μας .Με&nbsp; το βάπτισμα απαλλάσσεται ο βαπτιζόμενος από\n" +
                "το προπατορικό αμάρτημα και εντάσσεται στο Σώμα της Εκκλησιάς του Χριστού μας\n" +
                ".Αξίζει λοιπόν οι γονείς να έχουν βαθειά συνείδηση&nbsp; και επίγνωση της\n" +
                "ιερότητας του Μυστήριου. </span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Palatino Linotype\",serif'>&nbsp;2.\n" +
                "Απαραίτητη προϋπόθεση για την τέλεση του Μυστήριου είναι η συμφωνία &nbsp;και η\n" +
                "παρουσία των γονέων του βαπτιζόμενου, που θα αποδεικνύεται με την υπογραφή τους\n" +
                "στην δήλωση Βαπτίσεως την ημέρα του Μυστήριου.\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Palatino Linotype\",serif'>&nbsp;3.Ο\n" +
                "Ανάδοχος πρέπει μα είναι Ορθόδοξος Χριστιανός .Απαγγέλει κατά την διάρκεια του\n" +
                "Μυστήριου το Σύμβολο της Πίστεως και είναι εγγυητής &nbsp;στην Εκκλησία για την\n" +
                "Ορθόδοξη πιστή του Βαπτιζόμενου. Έχει δε την υποχρέωση να βοηθήσει το παΐδι\n" +
                ",όταν ενηλικιωθεί να γνωρίσει την ορθόδοξη πιστή του. Δεν επιτρέπεται να είναι\n" +
                "αλλόθρησκος ή αλλού δόγματος (Ρωμαιοκαθολικός, Προτεστάντης κα)ή άνθρωπος ο\n" +
                "οποίος αρνείται την ορθόδοξη πιστή και ομολόγει Αθεΐα. Απαγορεύεται&nbsp;\n" +
                "επίσης ο ανάδοχος να έχει τελέσει μόνο&nbsp; πολίτικο γάμο.\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Palatino Linotype\",serif'>4.Οφειλουν\n" +
                "ιδιαιτέρως&nbsp; η Ανάδοχος και η μητέρα του βρέφους να είναι ευπρεπώς\n" +
                "ενδεδυμένες .Ο απαραίτητος σεβασμός στην ιερότητα του χώρου εκδηλώνεται και με\n" +
                "την ευπρεπή και σεμνή παρουσία μας.&nbsp;&nbsp; </span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Palatino Linotype\",serif'>5.\n" +
                "Ο&nbsp; στολισμός μπορεί να περιλαμβάνει μια ή δυο ανθοστήλες (όχι Μίκυ-Μαους\n" +
                "κ.τ.λ)και δεν επιτρέπεται το στόλισμα της κολυμβήθρας</span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Palatino Linotype\",serif'>6.&nbsp;\n" +
                "Το λαδί&nbsp; που θα χρησιμοποιηθεί θα πρέπει να είναι αγνό ελαιόλαδο.</span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Palatino Linotype\",serif'>7.\n" +
                "Τα ρούχα του βαπτιζόμενου πρέπει να είναι απαραιτήτως λεύκα.\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Palatino Linotype\",serif'>8.\n" +
                "Για οποιαδήποτε άλλο που δεν αναφέρεται στο παρόν σημείωμα&nbsp; οι γονείς θα\n" +
                "πρέπει να έρθουν σε συνείδηση προηγουμένως με τον Εφημέριο του Ιερού Ναού&nbsp;\n" +
                "οπού θα τελεσθεί το\n" +
                "Μυστήριο.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
                "</span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Palatino Linotype\",serif'>9.\n" +
                "Τέλος οφείλουν οι γονείς οι ανάδοχοι και οι συγγενείς να επιδείξουν κατά την\n" +
                "διάρκεια της ακολουθίας του Μυστήριου τον πρέποντα&nbsp; σεβασμό με την σιωπή\n" +
                "τους και την συμμέτοχη τους στην ακολουθία του Μυστηρίου&nbsp; </span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Palatino Linotype\",serif'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
                "</span><b><i><span lang=EL style='font-size:10.0pt;line-height:115%;font-family:\n" +
                "\"Palatino Linotype\",serif'>Ευχόμαστε&nbsp; ο Κύριος να σας χαρίζει οικογενειακή\n" +
                "υγεία και πρόοδο!!!!!</span></i></b></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Palatino Linotype\",serif'>&nbsp;</span></p>\n" +
                "\n" +
                "<p class=MsoNormal style='text-indent:26.25pt'><b><i><span lang=EL\n" +
                "style='font-size:10.0pt;line-height:115%;font-family:\"Palatino Linotype\",serif'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
                "</span></i></b><b><span lang=EL style='font-family:\"Palatino Linotype\",serif'>ΕΛΛΗΝΙΚΗ\n" +
                "ΔΗΜΟΚΡΑΤΙΑ</span></b></p>\n" +
                "\n" +
                "<p class=MsoNormal><b><span lang=EL style='font-family:\"Palatino Linotype\",serif'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
                "ΙΕΡΑ ΜΗΤΡΟΠΟΛΙΣ "+Field1+
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span></b></p>\n" +
                "\n" +
                "<p class=MsoNormal><b><span lang=EL style='font-family:\"Palatino Linotype\",serif'>&nbsp;&nbsp;&nbsp;\n" +
                "ΙΕΡΟΣ ΝΑΟΣ "+Field1+" </span></b></p>\n" +
                "\n" +
                "<p class=MsoNormal><b><span lang=EL style='font-family:\"Palatino Linotype\",serif'>Αριθμ.Πρωτ……"+Field1+" ……</span></b></p>\n" +
                "\n" +
                "<p class=MsoNormal><b><i><span lang=EL style='font-family:\"Palatino Linotype\",serif'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
                "ΠΡΑΞΙΣ ΠΡΟΣΔΙΟΡΙΣΜΟΥ</span></i></b></p>\n" +
                "\n" +
                "<p class=MsoNormal><b><i><span lang=EL style='font-family:\"Palatino Linotype\",serif'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
                "ΤΕΛΕΣΕΩΣ&nbsp; ΤΟΥ ΜΥΣΤΗΡΙΟΥ ΤΟΥ ΒΑΠΤΙΣΜΑΤΟΣ</span></i></b></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Palatino Linotype\",serif'>Σήμερον\n" +
                "την <b>"+Field1+" </b>…του μηνός<b> "+Field1+" </b> .του έτους "+Field1+" .εμφανίσθησαν\n" +
                "ενώπιον εμού του Εφημερίου του ως άνω Ιερού Ναού,οι υπογεγραμμένοι γονείς: </span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Palatino Linotype\",serif'>1)<b> "+Field1+" </b>&nbsp;\n" +
                "Αρ.δελτ .αστ. ταυτοτητος "+Field1+" .χρο.εκδ "+Field1+" .εκδ. Αρχ. "+Field1+"\n" +
                "</span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Palatino Linotype\",serif'>2)\n" +
                ""+Field1+" . Αρ.δελτ αστ. Ταυτοτητος"+Field1+"χρον.εκδ\n" +
                ""+Field1+" εκδ.Αρχη</span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Palatino Linotype\",serif'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
                "και εδήλωσαν&nbsp; ότι: </span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Palatino Linotype\",serif'>Α)τοΤέκνο\n" +
                "τους(αγόρι- κορίτσι) γεννηθέν "+Field1+"  του μηνός "+Field1+"  του\n" +
                "έτους "+Field1+" στ"+Field1+" νοσοκομειο.και εγεγραμμένο στο Ληξιαρχείο "+Field1+"  με αριθμό\n" +
                "πράξης "+Field1+" Τομο "+Field1+" έτος "+Field1+" </span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Palatino Linotype\",serif'>&nbsp;&nbsp;ΕΠΙΘΥΜΟΥΝ\n" +
                "να το ΒΑΠΤΙΣΟΥΝ με το όνομα <b>"+Field1+" </b> την "+Field1+" του\n" +
                "μήνος&nbsp;&nbsp; "+Field1+" του έτους "+Field1+"  &nbsp;&nbsp;και ώρα\n" +
                ""+Field1+" </span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Palatino Linotype\",serif'>&nbsp;\n" +
                "σύμφωνα με το τυπικό της Ορθοδόξου Χριστιανικής Εκκλησίας.</span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Palatino Linotype\",serif'>Β)ως\n" +
                "ΑΝΑΔΟΧΟΣ θα παρίσταται ο-η "+Field1+"  Ορθόδοξος Χριστιανός ο οποίος ετέλεσε\n" +
                "ορθόδοξο γάμο κατά την&nbsp; χρονολογία "+Field1+"  στον Ιερό&nbsp;\n" +
                "Ναό "+Field1+" &nbsp;&nbsp; </span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Palatino Linotype\",serif'>Γ)Οι\n" +
                "γονείς εδήλωσαν ότι αποδέχονται τις σχετικές με το Βαπτισμα οδηγίες,οι οποίες\n" +
                "αναφέρονται δε ειδικό έντυπο το οποίο έλαβαν μαζί\n" +
                "τους.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
                "</span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Palatino Linotype\",serif'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
                "</span></p>\n" +
                "\n" +
                "<p class=MsoNormal style='margin-left:36.0pt'><span lang=EL style='font-family:\n" +
                "\"Palatino Linotype\",serif'>&nbsp;</span><b><span lang=EL style='font-family:\n" +
                "Genesis'>&nbsp;ΕΝ </span></b><b><span lang=EL></span></b><b><span\n" +
                "lang=EL style='font-family:Genesis'>"+Field1+" τη</span></b><b><span lang=EL></span></b><b><span\n" +
                "lang=EL style='font-family:Genesis'> "+Field1+" 2"+Field1+" </span></b></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Palatino Linotype\",serif'>&nbsp;</span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Palatino Linotype\",serif'>Ο&nbsp;\n" +
                "ΕΦΗΜΕΡΙΟΣ&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
                "ΟΙ ΔΗΛΟΥΝΤΕΣ ΓΟΝΕΙΣ</span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Palatino Linotype\",serif'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
                "1."+Field1+"</span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Palatino Linotype\",serif'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
                "2. "+Field1+"</span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Palatino Linotype\",serif'>&nbsp;</span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Palatino Linotype\",serif'>&nbsp;</span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Palatino Linotype\",serif'>&nbsp;</span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Palatino Linotype\",serif'>&nbsp;</span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Palatino Linotype\",serif'>&nbsp;</span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Palatino Linotype\",serif'>&nbsp;</span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Palatino Linotype\",serif'>&nbsp;</span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Palatino Linotype\",serif'>&nbsp;</span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Palatino Linotype\",serif'>&nbsp;</span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Palatino Linotype\",serif'>&nbsp;</span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Palatino Linotype\",serif'>&nbsp;</span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Palatino Linotype\",serif'>&nbsp;</span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Palatino Linotype\",serif'>&nbsp;</span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Palatino Linotype\",serif'>&nbsp;</span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Palatino Linotype\",serif'>&nbsp;</span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Palatino Linotype\",serif'>&nbsp;</span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Palatino Linotype\",serif'>-&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
                "</span></p>\n" +
                "\n" +
                "</div>\n" +
                "\n" +
                "</body>\n" +
                "\n" +
                "</html>\n";


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
                "\t{font-family:\"Palatino Linotype\";\n" +
                "\tpanose-1:2 4 5 2 5 5 5 3 3 4;}\n" +
                "@font-face\n" +
                "\t{font-family:Genesis;\n" +
                "\tpanose-1:2 11 6 4 2 2 2 2 2 4;}\n" +
                " /* Style Definitions */\n" +
                " p.MsoNormal, li.MsoNormal, div.MsoNormal\n" +
                "\t{margin-top:0cm;\n" +
                "\tmargin-right:0cm;\n" +
                "\tmargin-bottom:10.0pt;\n" +
                "\tmargin-left:0cm;\n" +
                "\tline-height:115%;\n" +
                "\tfont-size:11.0pt;\n" +
                "\tfont-family:\"Calibri\",sans-serif;}\n" +
                "p.MsoHeader, li.MsoHeader, div.MsoHeader\n" +
                "\t{mso-style-link:\"Header Char\";\n" +
                "\tmargin:0cm;\n" +
                "\tmargin-bottom:.0001pt;\n" +
                "\tfont-size:11.0pt;\n" +
                "\tfont-family:\"Calibri\",sans-serif;}\n" +
                "p.MsoFooter, li.MsoFooter, div.MsoFooter\n" +
                "\t{mso-style-link:\"Footer Char\";\n" +
                "\tmargin:0cm;\n" +
                "\tmargin-bottom:.0001pt;\n" +
                "\tfont-size:11.0pt;\n" +
                "\tfont-family:\"Calibri\",sans-serif;}\n" +
                "p.msonormal0, li.msonormal0, div.msonormal0\n" +
                "\t{mso-style-name:msonormal;\n" +
                "\tmargin-right:0cm;\n" +
                "\tmargin-left:0cm;\n" +
                "\tfont-size:12.0pt;\n" +
                "\tfont-family:\"Times New Roman\",serif;}\n" +
                "span.HeaderChar\n" +
                "\t{mso-style-name:\"Header Char\";\n" +
                "\tmso-style-link:Header;}\n" +
                "span.FooterChar\n" +
                "\t{mso-style-name:\"Footer Char\";\n" +
                "\tmso-style-link:Footer;}\n" +
                "p.msochpdefault, li.msochpdefault, div.msochpdefault\n" +
                "\t{mso-style-name:msochpdefault;\n" +
                "\tmargin-right:0cm;\n" +
                "\tmargin-left:0cm;\n" +
                "\tfont-size:11.0pt;\n" +
                "\tfont-family:\"Calibri\",sans-serif;}\n" +
                "p.msopapdefault, li.msopapdefault, div.msopapdefault\n" +
                "\t{mso-style-name:msopapdefault;\n" +
                "\tmargin-right:0cm;\n" +
                "\tmargin-bottom:10.0pt;\n" +
                "\tmargin-left:0cm;\n" +
                "\tline-height:115%;\n" +
                "\tfont-size:12.0pt;\n" +
                "\tfont-family:\"Times New Roman\",serif;}\n" +
                ".MsoChpDefault\n" +
                "\t{font-size:11.0pt;\n" +
                "\tfont-family:\"Calibri\",sans-serif;}\n" +
                ".MsoPapDefault\n" +
                "\t{margin-bottom:10.0pt;\n" +
                "\tline-height:115%;}\n" +
                "@page WordSection1\n" +
                "\t{size:595.3pt 841.9pt;\n" +
                "\tmargin:72.0pt 90.0pt 72.0pt 90.0pt;}\n" +
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
                "<p class=MsoNormal style='text-indent:26.25pt'><b><span lang=EL\n" +
                "style='font-family:\"Palatino Linotype\",serif'>ΙΕΡΑ ΜΗΤΡΟΠΟΛΙΣ ΣΑΜΟΥ ΚΑΙ\n" +
                "ΙΚΑΡΙΑΣ&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></b></p>\n" +
                "\n" +
                "<p class=MsoNormal style='text-indent:26.25pt'><b><span lang=EL\n" +
                "style='font-family:\"Palatino Linotype\",serif'>ΟΔΗΓΙΕΣ ΤΕΛΕΣΕΩΣ ΤΟΥ ΜΥΣΤΗΡΙΟ ΤΟΥ\n" +
                "ΒΑΠΤΙΣΜΑΤΟΣ&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
                "</span></b></p>\n" +
                "\n" +
                "<p class=MsoNormal style='text-indent:26.25pt'><span lang=EL style='font-family:\n" +
                "\"Palatino Linotype\",serif'>Αγαπητοί\n" +
                "γονείς,&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
                "</span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Palatino Linotype\",serif'>&nbsp;\n" +
                "Σε λίγες μέρες θα ζήσετε στο σπιτικό σας μια ξεχωριστή στιγμή που\n" +
                "θα&nbsp;&nbsp; συνοδεύει το παιδί σας για όλη του την ζωή !</span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Palatino Linotype\",serif'>&nbsp;\n" +
                "Ένας&nbsp; νέος χριστιανός ορθόδοξος θα πλαισιώσει την Εκκλησία μας. Από την πλευρά\n" +
                "μας νοιώθουμε την ανάγκη να σας υπενθυμίσουμε και να σας παρακαλέσουμε για την\n" +
                "τήρηση των πιο κάτω&nbsp; σημείων τα οποία βοηθούν στην καλλίτερη συμμέτοχη του\n" +
                "Μυστήριου.&nbsp;&nbsp; </span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Palatino Linotype\",serif'>1.Το\n" +
                "Βάπτισμα δεν είναι μια απλή κοινωνική εκδήλωση και&nbsp; υποχρέωση ,ούτε ένα\n" +
                "κοινωνικό γεγονός .Είναι το πρώτο βασικό Μυστήριο της Εκκλησιάς μας και η\n" +
                "σφραγίδα της πίστεως μας .Με&nbsp; το βάπτισμα απαλλάσσεται ο βαπτιζόμενος από\n" +
                "το προπατορικό αμάρτημα και εντάσσεται στο Σώμα της Εκκλησιάς του Χριστού μας\n" +
                ".Αξίζει λοιπόν οι γονείς να έχουν βαθειά συνείδηση&nbsp; και επίγνωση της\n" +
                "ιερότητας του Μυστήριου. </span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Palatino Linotype\",serif'>&nbsp;2.\n" +
                "Απαραίτητη προϋπόθεση για την τέλεση του Μυστήριου είναι η συμφωνία &nbsp;και η\n" +
                "παρουσία των γονέων του βαπτιζόμενου, που θα αποδεικνύεται με την υπογραφή τους\n" +
                "στην δήλωση Βαπτίσεως την ημέρα του Μυστήριου.\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Palatino Linotype\",serif'>&nbsp;3.Ο\n" +
                "Ανάδοχος πρέπει μα είναι Ορθόδοξος Χριστιανός .Απαγγέλει κατά την διάρκεια του\n" +
                "Μυστήριου το Σύμβολο της Πίστεως και είναι εγγυητής &nbsp;στην Εκκλησία για την\n" +
                "Ορθόδοξη πιστή του Βαπτιζόμενου. Έχει δε την υποχρέωση να βοηθήσει το παΐδι\n" +
                ",όταν ενηλικιωθεί να γνωρίσει την ορθόδοξη πιστή του. Δεν επιτρέπεται να είναι\n" +
                "αλλόθρησκος ή αλλού δόγματος (Ρωμαιοκαθολικός, Προτεστάντης κα)ή άνθρωπος ο\n" +
                "οποίος αρνείται την ορθόδοξη πιστή και ομολόγει Αθεΐα. Απαγορεύεται&nbsp;\n" +
                "επίσης ο ανάδοχος να έχει τελέσει μόνο&nbsp; πολίτικο γάμο.\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Palatino Linotype\",serif'>4.Οφειλουν\n" +
                "ιδιαιτέρως&nbsp; η Ανάδοχος και η μητέρα του βρέφους να είναι ευπρεπώς\n" +
                "ενδεδυμένες .Ο απαραίτητος σεβασμός στην ιερότητα του χώρου εκδηλώνεται και με\n" +
                "την ευπρεπή και σεμνή παρουσία μας.&nbsp;&nbsp; </span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Palatino Linotype\",serif'>5.\n" +
                "Ο&nbsp; στολισμός μπορεί να περιλαμβάνει μια ή δυο ανθοστήλες (όχι Μίκυ-Μαους\n" +
                "κ.τ.λ)και δεν επιτρέπεται το στόλισμα της κολυμβήθρας</span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Palatino Linotype\",serif'>6.&nbsp;\n" +
                "Το λαδί&nbsp; που θα χρησιμοποιηθεί θα πρέπει να είναι αγνό ελαιόλαδο.</span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Palatino Linotype\",serif'>7.\n" +
                "Τα ρούχα του βαπτιζόμενου πρέπει να είναι απαραιτήτως λεύκα.\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Palatino Linotype\",serif'>8.\n" +
                "Για οποιαδήποτε άλλο που δεν αναφέρεται στο παρόν σημείωμα&nbsp; οι γονείς θα\n" +
                "πρέπει να έρθουν σε συνείδηση προηγουμένως με τον Εφημέριο του Ιερού Ναού&nbsp;\n" +
                "οπού θα τελεσθεί το\n" +
                "Μυστήριο.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
                "</span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Palatino Linotype\",serif'>9.\n" +
                "Τέλος οφείλουν οι γονείς οι ανάδοχοι και οι συγγενείς να επιδείξουν κατά την\n" +
                "διάρκεια της ακολουθίας του Μυστήριου τον πρέποντα&nbsp; σεβασμό με την σιωπή\n" +
                "τους και την συμμέτοχη τους στην ακολουθία του Μυστηρίου&nbsp; </span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Palatino Linotype\",serif'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
                "</span><b><i><span lang=EL style='font-size:10.0pt;line-height:115%;font-family:\n" +
                "\"Palatino Linotype\",serif'>Ευχόμαστε&nbsp; ο Κύριος να σας χαρίζει οικογενειακή\n" +
                "υγεία και πρόοδο!!!!!</span></i></b></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Palatino Linotype\",serif'>&nbsp;</span></p>\n" +
                "\n" +
                "<p class=MsoNormal style='text-indent:26.25pt'><b><i><span lang=EL\n" +
                "style='font-size:10.0pt;line-height:115%;font-family:\"Palatino Linotype\",serif'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
                "</span></i></b><b><span lang=EL style='font-family:\"Palatino Linotype\",serif'>ΕΛΛΗΝΙΚΗ\n" +
                "ΔΗΜΟΚΡΑΤΙΑ</span></b></p>\n" +
                "\n" +
                "<p class=MsoNormal><b><span lang=EL style='font-family:\"Palatino Linotype\",serif'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
                "ΙΕΡΑ ΜΗΤΡΟΠΟΛΙΣ ΣΑΜΟΥ ΚΑΙ\n" +
                "ΙΚΑΡΙΑΣ&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </span></b></p>\n" +
                "\n" +
                "<p class=MsoNormal><b><span lang=EL style='font-family:\"Palatino Linotype\",serif'>&nbsp;&nbsp;&nbsp;\n" +
                "ΙΕΡΟΣ ΝΑΟΣ ΚΟΙΜΗΣΕΩΣ ΤΗΣ ΘΕΟΤΟΚΟΥ ΚΟΝΤΑΚΑΙΙΚΩΝ</span></b></p>\n" +
                "\n" +
                "<p class=MsoNormal><b><span lang=EL style='font-family:\"Palatino Linotype\",serif'>Αριθμ.Πρωτ……13/2018……………</span></b></p>\n" +
                "\n" +
                "<p class=MsoNormal><b><i><span lang=EL style='font-family:\"Palatino Linotype\",serif'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
                "ΠΡΑΞΙΣ ΠΡΟΣΔΙΟΡΙΣΜΟΥ</span></i></b></p>\n" +
                "\n" +
                "<p class=MsoNormal><b><i><span lang=EL style='font-family:\"Palatino Linotype\",serif'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
                "ΤΕΛΕΣΕΩΣ&nbsp; ΤΟΥ ΜΥΣΤΗΡΙΟΥ ΤΟΥ ΒΑΠΤΙΣΜΑΤΟΣ</span></i></b></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Palatino Linotype\",serif'>Σήμερον\n" +
                "την <b>…………………</b>…του μηνός<b>………………..</b> .του έτους…………..εμφανίσθησαν\n" +
                "ενώπιον εμού του Εφημερίου του ως άνω Ιερού Ναού,οι υπογεγραμμένοι γονείς: </span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Palatino Linotype\",serif'>1)…<b>………………………………………….</b>&nbsp;\n" +
                "Αρ.δελτ .αστ. ταυτοτητος<b>………..</b>.χρο.εκδ<b>…………..</b>.εκδ. Αρχ…<b>…………….</b>……\n" +
                "</span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Palatino Linotype\",serif'>2)…\n" +
                "<b>………………………………………………………………….. </b>Αρ.δελτ αστ. Ταυτοτητος…<b>…..</b>χρον.<b>εκδ\n" +
                "…………εκδ</b>.Αρχη</span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Palatino Linotype\",serif'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
                "και εδήλωσαν&nbsp; ότι: </span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Palatino Linotype\",serif'>Α)τοΤέκνο\n" +
                "τους(αγόρι- κορίτσι) γεννηθέν <b>………... του</b> μηνός<b>…….</b>… του\n" +
                "έτους………στ…. νοσοκομειο.και εγεγραμμένο στο Ληξιαρχείο …<b>…..</b>……. με αριθμό\n" +
                "πράξης…….Τομο..έτος…<b>….</b>……...</span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Palatino Linotype\",serif'>&nbsp;&nbsp;ΕΠΙΘΥΜΟΥΝ\n" +
                "να το ΒΑΠΤΙΣΟΥΝ με το όνομα…<b>……………………………….</b>………………… την……………του\n" +
                "μήνος&nbsp;&nbsp; <b>……………</b>…..του έτους <b>…….</b> &nbsp;&nbsp;και ώρα\n" +
                "……………..</span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Palatino Linotype\",serif'>&nbsp;\n" +
                "σύμφωνα με το τυπικό της Ορθοδόξου Χριστιανικής Εκκλησίας.</span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Palatino Linotype\",serif'>Β)ως\n" +
                "ΑΝΑΔΟΧΟΣ θα παρίσταται ο-η…<b>…………</b> Ορθόδοξος Χριστιανός ο οποίος ετέλεσε\n" +
                "ορθόδοξο γάμο κατά την&nbsp; χρονολογία<b>…………. </b>στον Ιερό&nbsp;\n" +
                "Ναό…………&nbsp;&nbsp; </span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Palatino Linotype\",serif'>Γ)Οι\n" +
                "γονείς εδήλωσαν ότι αποδέχονται τις σχετικές με το Βαπτισμα οδηγίες,οι οποίες\n" +
                "αναφέρονται δε ειδικό έντυπο το οποίο έλαβαν μαζί\n" +
                "τους.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
                "</span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Palatino Linotype\",serif'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
                "</span></p>\n" +
                "\n" +
                "<p class=MsoNormal style='margin-left:36.0pt'><span lang=EL style='font-family:\n" +
                "\"Palatino Linotype\",serif'>&nbsp;</span><b><span lang=EL style='font-family:\n" +
                "Genesis'>&nbsp;ΕΝ </span></b><b><span lang=EL>……………………………………….</span></b><b><span\n" +
                "lang=EL style='font-family:Genesis'>………τη</span></b><b><span lang=EL>….</span></b><b><span\n" +
                "lang=EL style='font-family:Genesis'>…………………2…………</span></b></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Palatino Linotype\",serif'>&nbsp;</span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Palatino Linotype\",serif'>Ο&nbsp;\n" +
                "ΕΦΗΜΕΡΙΟΣ&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
                "ΟΙ ΔΗΛΟΥΝΤΕΣ ΓΟΝΕΙΣ</span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Palatino Linotype\",serif'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
                "1……………………………………</span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Palatino Linotype\",serif'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
                "2……………………………………</span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Palatino Linotype\",serif'>&nbsp;</span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Palatino Linotype\",serif'>&nbsp;</span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Palatino Linotype\",serif'>&nbsp;</span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Palatino Linotype\",serif'>&nbsp;</span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Palatino Linotype\",serif'>&nbsp;</span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Palatino Linotype\",serif'>&nbsp;</span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Palatino Linotype\",serif'>&nbsp;</span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Palatino Linotype\",serif'>&nbsp;</span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Palatino Linotype\",serif'>&nbsp;</span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Palatino Linotype\",serif'>&nbsp;</span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Palatino Linotype\",serif'>&nbsp;</span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Palatino Linotype\",serif'>&nbsp;</span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Palatino Linotype\",serif'>&nbsp;</span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Palatino Linotype\",serif'>&nbsp;</span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Palatino Linotype\",serif'>&nbsp;</span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Palatino Linotype\",serif'>&nbsp;</span></p>\n" +
                "\n" +
                "<p class=MsoNormal><span lang=EL style='font-family:\"Palatino Linotype\",serif'>-&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n" +
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