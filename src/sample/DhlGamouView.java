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



        String INITIAL_TEXT = "<html>\n" +
                "<head><meta http-equiv=Content-Type content=\"text/html; charset=UTF-8\">\n" +
                "<style type=\"text/css\">\n" +
                "<!--\n" +
                "span.cls_002{font-family:\"DejaVu Serif Bold\",serif;font-size:24.1px;color:rgb(0,0,0);font-weight:bold;font-style:normal;text-decoration: none}\n" +
                "div.cls_002{font-family:\"DejaVu Serif Bold\",serif;font-size:24.1px;color:rgb(0,0,0);font-weight:bold;font-style:normal;text-decoration: none}\n" +
                "span.cls_003{font-family:\"DejaVu Serif Bold\",serif;font-size:16.1px;color:rgb(0,0,0);font-weight:bold;font-style:normal;text-decoration: none}\n" +
                "div.cls_003{font-family:\"DejaVu Serif Bold\",serif;font-size:16.1px;color:rgb(0,0,0);font-weight:bold;font-style:normal;text-decoration: none}\n" +
                "span.cls_004{font-family:\"DejaVu Sans Condensed Bold\",serif;font-size:12.1px;color:rgb(0,0,0);font-weight:bold;font-style:normal;text-decoration: none}\n" +
                "div.cls_004{font-family:\"DejaVu Sans Condensed Bold\",serif;font-size:12.1px;color:rgb(0,0,0);font-weight:bold;font-style:normal;text-decoration: none}\n" +
                "span.cls_005{font-family:\"DejaVu Sans Condensed\",serif;font-size:12.1px;color:rgb(0,0,0);font-weight:normal;font-style:normal;text-decoration: none}\n" +
                "div.cls_005{font-family:\"DejaVu Sans Condensed\",serif;font-size:12.1px;color:rgb(0,0,0);font-weight:normal;font-style:normal;text-decoration: none}\n" +
                "span.cls_007{font-family:\"DejaVu Sans Condensed Bold\",serif;font-size:16.1px;color:rgb(0,0,0);font-weight:bold;font-style:normal;text-decoration: none}\n" +
                "div.cls_007{font-family:\"DejaVu Sans Condensed Bold\",serif;font-size:16.1px;color:rgb(0,0,0);font-weight:bold;font-style:normal;text-decoration: none}\n" +
                "span.cls_008{font-family:\"DejaVu Serif Bold\",serif;font-size:13.1px;color:rgb(0,0,0);font-weight:bold;font-style:normal;text-decoration: none}\n" +
                "div.cls_008{font-family:\"DejaVu Serif Bold\",serif;font-size:13.1px;color:rgb(0,0,0);font-weight:bold;font-style:normal;text-decoration: none}\n" +
                "span.cls_009{font-family:\"DejaVu Serif Bold\",serif;font-size:13.1px;color:rgb(73,168,255);font-weight:bold;font-style:normal;text-decoration: none}\n" +
                "div.cls_009{font-family:\"DejaVu Serif Bold\",serif;font-size:13.1px;color:rgb(73,168,255);font-weight:bold;font-style:normal;text-decoration: none}\n" +
                "span.cls_010{font-family:\"DejaVu Serif Bold\",serif;font-size:13.1px;color:rgb(73,168,255);font-weight:bold;font-style:normal;text-decoration: underline}\n" +
                "div.cls_010{font-family:\"DejaVu Serif Bold\",serif;font-size:13.1px;color:rgb(73,168,255);font-weight:bold;font-style:normal;text-decoration: none}\n" +
                "-->\n" +
                "</style>\n" +
                "<script type=\"text/javascript\" src=\"bd32dd0a-06be-11e9-8f58-0cc47a792c0a_id_bd32dd0a-06be-11e9-8f58-0cc47a792c0a_files/wz_jsgraphics.js\"></script>\n" +
                "</head>\n" +
                "<body>\n" +
                "<div style=\"position:absolute;left:50%;margin-left:-306px;top:0px;width:612px;height:792px;border-style:outset;overflow:hidden\">\n" +
                "<div style=\"position:absolute;left:0px;top:0px\">\n" +
                "<img src=\"../bd32dd0a-06be-11e9-8f58-0cc47a792c0a_id_bd32dd0a-06be-11e9-8f58-0cc47a792c0a_files/background1.jpg\" width=612 height=792></div>\n" +
                "<div style=\"position:absolute;left:98.00px;top:92.00px\" class=\"cls_002\"><span class=\"cls_002\">Sean Sarantos's Workout Log -</span></div>\n" +
                "<div style=\"position:absolute;left:182.50px;top:121.00px\" class=\"cls_002\"><span class=\"cls_002\">Bodybuilding.com</span></div>\n" +
                "<div style=\"position:absolute;left:258.00px;top:161.00px\" class=\"cls_003\"><span class=\"cls_003\">Shoulders</span></div>\n" +
                "<div style=\"position:absolute;left:8.00px;top:257.00px\" class=\"cls_004\"><span class=\"cls_004\">DAY:</span></div>\n" +
                "<div style=\"position:absolute;left:196.00px;top:257.00px\" class=\"cls_004\"><span class=\"cls_004\">DAT E:</span></div>\n" +
                "<div style=\"position:absolute;left:373.00px;top:257.00px\" class=\"cls_004\"><span class=\"cls_004\">T IME:</span></div>\n" +
                "<div style=\"position:absolute;left:8.00px;top:272.00px\" class=\"cls_005\"><span class=\"cls_005\">__________________________</span></div>\n" +
                "<div style=\"position:absolute;left:196.00px;top:272.00px\" class=\"cls_005\"><span class=\"cls_005\">__________________________</span></div>\n" +
                "<div style=\"position:absolute;left:373.00px;top:272.00px\" class=\"cls_005\"><span class=\"cls_005\">__________________________</span></div>\n" +
                "<div style=\"position:absolute;left:551.00px;top:272.00px\" class=\"cls_004\"><span class=\"cls_004\">am/pm</span></div>\n" +
                "<div style=\"position:absolute;left:206.50px;top:302.00px\" class=\"cls_005\"><span class=\"cls_005\">__________________________</span></div>\n" +
                "<div style=\"position:absolute;left:384.00px;top:302.00px\" class=\"cls_005\"><span class=\"cls_005\">__________________________</span></div>\n" +
                "<div style=\"position:absolute;left:8.00px;top:309.00px\" class=\"cls_004\"><span class=\"cls_004\">CARDIO T ODAY?</span><span class=\"cls_005\">  YES NO</span></div>\n" +
                "<div style=\"position:absolute;left:257.50px;top:317.00px\" class=\"cls_005\"><span class=\"cls_005\">EXERCISE</span></div>\n" +
                "<div style=\"position:absolute;left:432.00px;top:317.00px\" class=\"cls_005\"><span class=\"cls_005\">DURATION</span></div>\n" +
                "<div style=\"position:absolute;left:8.00px;top:347.00px\" class=\"cls_004\"><span class=\"cls_004\">LENGT H OF WORKOUT:      WEIGHT:</span></div>\n" +
                "<div style=\"position:absolute;left:373.00px;top:347.00px\" class=\"cls_004\"><span class=\"cls_004\">LOCATION:</span></div>\n" +
                "<div style=\"position:absolute;left:8.00px;top:362.00px\" class=\"cls_004\"><span class=\"cls_004\">__________________________</span></div>\n" +
                "<div style=\"position:absolute;left:196.00px;top:362.00px\" class=\"cls_004\"><span class=\"cls_004\">__________________________</span></div>\n" +
                "<div style=\"position:absolute;left:373.00px;top:362.00px\" class=\"cls_004\"><span class=\"cls_004\">__________________________</span></div>\n" +
                "<div style=\"position:absolute;left:8.00px;top:407.00px\" class=\"cls_004\"><span class=\"cls_004\">MOOD WHEN STARTING:</span></div>\n" +
                "<div style=\"position:absolute;left:8.00px;top:422.00px\" class=\"cls_004\"><span class=\"cls_004\">__________________________</span></div>\n" +
                "<div style=\"position:absolute;left:8.00px;top:464.00px\" class=\"cls_005\"><span class=\"cls_005\">Instructions: In the white spaces below, fill in the weight you used and the number of reps you</span></div>\n" +
                "<div style=\"position:absolute;left:8.00px;top:479.00px\" class=\"cls_005\"><span class=\"cls_005\">performed. If you did 100 pounds for 10 reps, you would write \"100 X</span></div>\n" +
                "<div style=\"position:absolute;left:436.00px;top:479.00px\" class=\"cls_005\"><span class=\"cls_005\">10\". The gray bo*es below</span></div>\n" +
                "<div style=\"position:absolute;left:8.00px;top:494.00px\" class=\"cls_005\"><span class=\"cls_005\">are not used.</span></div>\n" +
                "<div style=\"position:absolute;left:390.00px;top:522.00px\" class=\"cls_007\"><span class=\"cls_007\">Set</span></div>\n" +
                "<div style=\"position:absolute;left:446.50px;top:522.00px\" class=\"cls_007\"><span class=\"cls_007\">Set</span></div>\n" +
                "<div style=\"position:absolute;left:503.50px;top:522.00px\" class=\"cls_007\"><span class=\"cls_007\">Set</span></div>\n" +
                "<div style=\"position:absolute;left:561.50px;top:522.00px\" class=\"cls_007\"><span class=\"cls_007\">Set</span></div>\n" +
                "<div style=\"position:absolute;left:150.50px;top:531.00px\" class=\"cls_007\"><span class=\"cls_007\">EXERCISE</span></div>\n" +
                "<div style=\"position:absolute;left:387.50px;top:541.00px\" class=\"cls_007\"><span class=\"cls_007\">#1</span></div>\n" +
                "<div style=\"position:absolute;left:444.50px;top:541.00px\" class=\"cls_007\"><span class=\"cls_007\">#2</span></div>\n" +
                "<div style=\"position:absolute;left:501.00px;top:541.00px\" class=\"cls_007\"><span class=\"cls_007\">#3</span></div>\n" +
                "<div style=\"position:absolute;left:559.00px;top:541.00px\" class=\"cls_007\"><span class=\"cls_007\">#4</span></div>\n" +
                "<div style=\"position:absolute;left:16.00px;top:562.00px\" class=\"cls_007\"><span class=\"cls_007\">Superset:</span></div>\n" +
                "<div style=\"position:absolute;left:16.00px;top:583.00px\" class=\"cls_007\"><span class=\"cls_007\">Seated Arnold press: 4 sets of 15</span></div>\n" +
                "<div style=\"position:absolute;left:10.00px;top:602.00px\" class=\"cls_007\"><span class=\"cls_007\">reps</span></div>\n" +
                "<div style=\"position:absolute;left:16.00px;top:623.00px\" class=\"cls_007\"><span class=\"cls_007\">Side Lateral raises: 4 sets of 20 reps</span></div>\n" +
                "<div style=\"position:absolute;left:16.00px;top:644.00px\" class=\"cls_007\"><span class=\"cls_007\">Superset:</span></div>\n" +
                "<div style=\"position:absolute;left:16.00px;top:665.00px\" class=\"cls_007\"><span class=\"cls_007\">Front dumbbell raises: 4 sets of 12</span></div>\n" +
                "<div style=\"position:absolute;left:10.00px;top:684.00px\" class=\"cls_007\"><span class=\"cls_007\">reps, each arm</span></div>\n" +
                "<div style=\"position:absolute;left:16.00px;top:705.00px\" class=\"cls_007\"><span class=\"cls_007\">Reverse flyes: 4 sets of 20 reps</span></div>\n" +
                "<div style=\"position:absolute;left:16.00px;top:726.00px\" class=\"cls_007\"><span class=\"cls_007\">Triple Set:</span></div>\n" +
                "<div style=\"position:absolute;left:16.00px;top:755.00px\" class=\"cls_007\"><span class=\"cls_007\">One-arm side lateral raises: 4 sets of</span></div>\n" +
                "</div>\n" +
                "<div style=\"position:absolute;left:50%;margin-left:-306px;top:802px;width:612px;height:792px;border-style:outset;overflow:hidden\">\n" +
                "<div style=\"position:absolute;left:0px;top:0px\">\n" +
                "<img src=\"bd32dd0a-06be-11e9-8f58-0cc47a792c0a_id_bd32dd0a-06be-11e9-8f58-0cc47a792c0a_files/background2.jpg\" width=612 height=792></div>\n" +
                "<div style=\"position:absolute;left:10.00px;top:0.00px\" class=\"cls_007\"><span class=\"cls_007\">15 reps</span></div>\n" +
                "<div style=\"position:absolute;left:16.00px;top:20.00px\" class=\"cls_007\"><span class=\"cls_007\">Upright barbell rows: 4 sets of 10</span></div>\n" +
                "<div style=\"position:absolute;left:10.00px;top:39.00px\" class=\"cls_007\"><span class=\"cls_007\">reps</span></div>\n" +
                "<div style=\"position:absolute;left:16.00px;top:60.00px\" class=\"cls_007\"><span class=\"cls_007\">Front plate raises: 4 sets to failure</span></div>\n" +
                "<div style=\"position:absolute;left:19.00px;top:104.00px\" class=\"cls_004\"><span class=\"cls_004\">T RAINING, NUT RIT ION & SU99LEMENT NOT ES:</span></div>\n" +
                "<div style=\"position:absolute;left:8.00px;top:267.00px\" class=\"cls_008\"><span class=\"cls_008\">Back to the</span><span class=\"cls_009\"> </span><A HREF=\"http://www.bodybuilding.com/fun/printlogs.htm\">Printable Logs   ain Page</A> </span><span class=\"cls_008\">.</span></div>\n" +
                "</div>\n" +
                "\n" +
                "</body>\n" +
                "</html>\n" ;


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
