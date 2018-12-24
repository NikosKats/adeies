package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main extends Application {


    /*****************************************
    //Δημιουργία Βάσης
    //*****************************************/


    public static void createNewDatabase(String fileName) {

        String url = "jdbc:sqlite:" + fileName;

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /***************************************************
     //Δημιουργία συνάρτησης για να φτίαξω πίνακα στη Βάση
     //***************************************************/

    public static void createDataProsdBaptisis() {
        // SQLite connection string
        String url = "jdbc:sqlite:adeies.db";

        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS `dataProsdBaptisis` (\n" +
                "\t`id`\tINTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "\t`Field1`\tTEXT,\n" +
                "\t`Field2`\tTEXT,\n" +
                "\t`Field3`\tTEXT,\n" +
                "\t`Field4`\tTEXT,\n" +
                "\t`Field5`\tTEXT,\n" +
                "\t`Field6`\tTEXT,\n" +
                "\t`Field7`\tTEXT,\n" +
                "\t`Field8`\tTEXT,\n" +
                "\t`Field9`\tTEXT,\n" +
                "\t`Field10`\tTEXT,\n" +
                "\t`Field11`\tTEXT,\n" +
                "\t`Field12`\tTEXT,\n" +
                "\t`Field13`\tTEXT,\n" +
                "\t`Field14`\tTEXT,\n" +
                "\t`Field15`\tTEXT,\n" +
                "\t`Field16`\tTEXT,\n" +
                "\t`Field17`\tTEXT,\n" +
                "\t`Field18`\tTEXT,\n" +
                "\t`Field19`\tTEXT,\n" +
                "\t`Field20`\tTEXT,\n" +
                "\t`Field21`\tTEXT,\n" +
                "\t`Field22`\tTEXT,\n" +
                "\t`Field23`\tTEXT,\n" +
                "\t`Field24`\tTEXT,\n" +
                "\t`Field25`\tTEXT,\n" +
                "\t`Field26`\tTEXT,\n" +
                "\t`Field27`\tTEXT,\n" +
                "\t`Field28`\tTEXT,\n" +
                "\t`Field29`\tTEXT,\n" +
                "\t`Field30`\tTEXT,\n" +
                "\t`Field31`\tTEXT\n" +
                ");";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /***************************************************
    //Δημιουργία συνάρτησης για να φτίαξω πίνακα στη Βάση
    //***************************************************/

    public static void createDataBaptisis() {
        // SQLite connection string
        String url = "jdbc:sqlite:adeies.db";

        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS `dataBaptisis` (\n" +
                "\t`id`\tINTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "\t`Field1`\tTEXT,\n" +
                "\t`Field2`\tTEXT,\n" +
                "\t`Field3`\tTEXT,\n" +
                "\t`Field4`\tTEXT,\n" +
                "\t`Field5`\tTEXT,\n" +
                "\t`Field6`\tTEXT,\n" +
                "\t`Field7`\tTEXT,\n" +
                "\t`Field8`\tTEXT,\n" +
                "\t`Field9`\tTEXT,\n" +
                "\t`Field10`\tTEXT,\n" +
                "\t`Field11`\tTEXT,\n" +
                "\t`Field12`\tTEXT,\n" +
                "\t`Field13`\tTEXT,\n" +
                "\t`Field14`\tTEXT,\n" +
                "\t`Field15`\tTEXT,\n" +
                "\t`Field16`\tTEXT,\n" +
                "\t`Field17`\tTEXT,\n" +
                "\t`Field18`\tTEXT,\n" +
                "\t`Field19`\tTEXT,\n" +
                "\t`Field20`\tTEXT,\n" +
                "\t`Field21`\tTEXT,\n" +
                "\t`Field22`\tTEXT,\n" +
                "\t`Field23`\tTEXT,\n" +
                "\t`Field24`\tTEXT,\n" +
                "\t`Field25`\tTEXT,\n" +
                "\t`Field26`\tTEXT,\n" +
                "\t`Field27`\tTEXT,\n" +
                "\t`Field28`\tTEXT,\n" +
                "\t`Field29`\tTEXT,\n" +
                "\t`Field30`\tTEXT,\n" +
                "\t`Field31`\tTEXT\n" +
                ");";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /***************************************************
     //Δημιουργία συνάρτησης για να φτίαξω πίνακα στη Βάση
     //***************************************************/

    public static void createDataGamou() {
        // SQLite connection string
        String url = "jdbc:sqlite:adeies.db";

        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS \n" +
                "`dataGamou` (\n" +
                "\t`id`\tINTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "\t`Field1`\tTEXT,\n" +
                "\t`Field2`\tTEXT,\n" +
                "\t`Field3`\tTEXT,\n" +
                "\t`Field4`\tTEXT,\n" +
                "\t`Field5`\tTEXT,\n" +
                "\t`Field6`\tTEXT,\n" +
                "\t`Field7`\tTEXT,\n" +
                "\t`Field8`\tTEXT,\n" +
                "\t`Field9`\tTEXT,\n" +
                "\t`Field10`\tTEXT,\n" +
                "\t`Field11`\tTEXT,\n" +
                "\t`Field12`\tTEXT,\n" +
                "\t`Field13`\tTEXT,\n" +
                "\t`Field14`\tTEXT,\n" +
                "\t`Field15`\tTEXT,\n" +
                "\t`Field16`\tTEXT,\n" +
                "\t`Field17`\tTEXT,\n" +
                "\t`Field18`\tTEXT,\n" +
                "\t`Field19`\tTEXT,\n" +
                "\t`Field20`\tTEXT,\n" +
                "\t`Field21`\tTEXT,\n" +
                "\t`Field22`\tTEXT,\n" +
                "\t`Field23`\tTEXT,\n" +
                "\t`Field24`\tTEXT,\n" +
                "\t`Field25`\tTEXT,\n" +
                "\t`Field26`\tTEXT,\n" +
                "\t`Field27`\tTEXT,\n" +
                "\t`Field28`\tTEXT,\n" +
                "\t`Field29`\tTEXT,\n" +
                "\t`Field30`\tTEXT,\n" +
                "\t`Field31`\tTEXT,\n" +
                "\t`Field32`\tTEXT,\n" +
                "\t`Field33`\tTEXT,\n" +
                "\t`Field34`\tTEXT,\n" +
                "\t`Field35`\tTEXT,\n" +
                "\t`Field36`\tTEXT,\n" +
                "\t`Field37`\tTEXT,\n" +
                "\t`Field38`\tTEXT,\n" +
                "\t`Field39`\tTEXT,\n" +
                "\t`Field40`\tTEXT,\n" +
                "\t`Field41`\tTEXT,\n" +
                "\t`Field42`\tTEXT,\n" +
                "\t`Field43`\tTEXT,\n" +
                "\t`Field44`\tTEXT,\n" +
                "\t`Field45`\tTEXT,\n" +
                "\t`Field46`\tTEXT,\n" +
                "\t`Field47`\tTEXT,\n" +
                "\t`Field48`\tTEXT,\n" +
                "\t`Field49`\tTEXT,\n" +
                "\t`Field50`\tTEXT,\n" +
                "\t`Field51`\tTEXT,\n" +
                "\t`Field52`\tTEXT,\n" +
                "\t`Field53`\tTEXT,\n" +
                "\t`Field54`\tTEXT,\n" +
                "\t`Field55`\tTEXT,\n" +
                "\t`Field56`\tTEXT,\n" +
                "\t`Field57`\tTEXT,\n" +
                "\t`Field58`\tTEXT,\n" +
                "\t`Field59`\tTEXT,\n" +
                "\t`Field60`\tTEXT,\n" +
                "\t`Field61`\tTEXT,\n" +
                "\t`Field62`\tTEXT,\n" +
                "\t`Field63`\tTEXT,\n" +
                "\t`Field64`\tTEXT,\n" +
                "\t`Field65`\tTEXT,\n" +
                "\t`Field66`\tTEXT,\n" +
                "\t`Field67`\tTEXT,\n" +
                "\t`Field68`\tTEXT,\n" +
                "\t`Field69`\tTEXT,\n" +
                "\t`Field70`\tTEXT,\n" +
                "\t`Field71`\tTEXT,\n" +
                "\t`Field72`\tTEXT,\n" +
                "\t`Field73`\tTEXT,\n" +
                "\t`Field74`\tTEXT,\n" +
                "\t`Field75`\tTEXT,\n" +
                "\t`Field76`\tTEXT,\n" +
                "\t`Field77`\tTEXT,\n" +
                "\t`Field78`\tTEXT,\n" +
                "\t`Field79`\tTEXT,\n" +
                "\t`Field80`\tTEXT,\n" +
                "\t`Field81`\tTEXT,\n" +
                "\t`Field82`\tTEXT,\n" +
                "\t`Field83`\tTEXT,\n" +
                "\t`Field84`\tTEXT,\n" +
                "\t`Field85`\tTEXT,\n" +
                "\t`Field86`\tTEXT,\n" +
                "\t`Field87`\tTEXT,\n" +
                "\t`Field88`\tTEXT,\n" +
                "\t`CheckBox1`\tTEXT,\n" +
                "\t`CheckBox2`\tTEXT,\n" +
                "\t`CheckBox3`\tTEXT,\n" +
                "\t`CheckBox4`\tTEXT\n" +
                ");";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /***************************************************
     //Δημιουργία συνάρτησης για να φτίαξω πίνακα στη Βάση
     //***************************************************/

    public static void createDataAgamiasA() {
        // SQLite connection string
        String url = "jdbc:sqlite:adeies.db";

        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS \n" +
                "`dataAgamiasA` (\n" +
                "\t`id`\tINTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "\t`Field1`\tTEXT,\n" +
                "\t`Field2`\tTEXT,\n" +
                "\t`Field3`\tTEXT,\n" +
                "\t`Field4`\tTEXT,\n" +
                "\t`Field5`\tTEXT,\n" +
                "\t`Field6`\tTEXT,\n" +
                "\t`Field7`\tTEXT,\n" +
                "\t`Field8`\tTEXT,\n" +
                "\t`Field9`\tTEXT,\n" +
                "\t`Field10`\tTEXT,\n" +
                "\t`Field11`\tTEXT,\n" +
                "\t`Field12`\tTEXT,\n" +
                "\t`Field13`\tTEXT,\n" +
                "\t`Field14`\tTEXT,\n" +
                "\t`Field15`\tTEXT,\n" +
                "\t`Field16`\tTEXT,\n" +
                "\t`Field17`\tTEXT,\n" +
                "\t`Field18`\tTEXT,\n" +
                "\t`Field19`\tTEXT,\n" +
                "\t`Field20`\tTEXT,\n" +
                "\t`Field21`\tTEXT,\n" +
                "\t`Field22`\tTEXT,\n" +
                "\t`Field23`\tTEXT,\n" +
                "\t`Field24`\tTEXT,\n" +
                "\t`Field25`\tTEXT\n" +
                ");";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /***************************************************
     //Δημιουργία συνάρτησης για να φτίαξω πίνακα στη Βάση
     //***************************************************/

    public static void createDataAgamiasB() {
        // SQLite connection string
        String url = "jdbc:sqlite:adeies.db";

        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS \n" +
                "\n" +
                " `dataAgamiasB` (\n" +
                "\t`id`\tINTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "\t`Field1`\tTEXT,\n" +
                "\t`Field2`\tTEXT,\n" +
                "\t`Field3`\tTEXT,\n" +
                "\t`Field4`\tTEXT,\n" +
                "\t`Field5`\tTEXT,\n" +
                "\t`Field6`\tTEXT,\n" +
                "\t`Field7`\tTEXT,\n" +
                "\t`Field8`\tTEXT,\n" +
                "\t`Field9`\tTEXT,\n" +
                "\t`Field10`\tTEXT,\n" +
                "\t`Field11`\tTEXT,\n" +
                "\t`Field12`\tTEXT,\n" +
                "\t`Field13`\tTEXT,\n" +
                "\t`Field14`\tTEXT,\n" +
                "\t`Field15`\tTEXT,\n" +
                "\t`Field16`\tTEXT,\n" +
                "\t`Field17`\tTEXT,\n" +
                "\t`Field18`\tTEXT,\n" +
                "\t`Field19`\tTEXT,\n" +
                "\t`Field20`\tTEXT,\n" +
                "\t`Field21`\tTEXT,\n" +
                "\t`Field22`\tTEXT,\n" +
                "\t`Field23`\tTEXT,\n" +
                "\t`Field24`\tTEXT,\n" +
                "\t`Field25`\tTEXT,\n" +
                "\t`Field26`\tTEXT,\n" +
                "\t`Field27`\tTEXT,\n" +
                "\t`Field28`\tTEXT,\n" +
                "\t`Field29`\tTEXT,\n" +
                "\t`Field30`\tTEXT,\n" +
                "\t`Field31`\tTEXT,\n" +
                "\t`Field32`\tTEXT,\n" +
                "\t`Field33`\tTEXT,\n" +
                "\t`Field34`\tTEXT,\n" +
                "\t`Field35`\tTEXT,\n" +
                "\t`Field36`\tTEXT,\n" +
                "\t`Field37`\tTEXT,\n" +
                "\t`Field38`\tTEXT\n" +
                ");\n";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception{


//        Date date = new Date();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        String todayString = sdf.format(date);


        /**
         * SET UP LICENSING
         * FOR SINGLE DEVICE
         * AND EXPIRATION DATE
         *****************************************
         *****************************************
         */
//        String expirationDateString = "2020-10-1";
//        String CustomersMAC="3C-15-C2-CF-DD-9C";
        /**
         *****************************************
         *****************************************
         */

//        Date today = sdf.parse(todayString);
//        Date expirationDate = sdf.parse(expirationDateString);
//
//
//        GetMac gm=new GetMac();
//        String mac=gm.getMac();
//
//
//        if(mac.equals(CustomersMAC))
//        {
//            if(today.after(expirationDate))
//            {
//                try {
//                    FXMLLoader loader = new FXMLLoader(Main.class.getResource("expirationWindow.fxml"));
//                    AnchorPane pane = loader.load();
//                    Scene scene = new Scene(pane);
//                    scene.getStylesheets().addAll(Main.class.getResource("style.css").toExternalForm());
//                    scene.getRoot().requestFocus();//key event needs focus
//                    primaryStage.setResizable(false);
//                    primaryStage.setTitle("Expiration Window");
//                    primaryStage.setScene(scene);
//                    primaryStage.show();
//
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            else
//            {

        createNewDatabase("adeies.db");   //Δημιουργία βάσης

        createDataProsdBaptisis();           //Δημιουργία Πίνακα

        createDataBaptisis();           //Δημιουργία Πίνακα

        createDataGamou();          //Δημιουργία Πίνακα

        createDataAgamiasA();          //Δημιουργία Πίνακα

        createDataAgamiasB();          //Δημιουργία Πίνακα


                this.primaryStage=primaryStage;
                mainWindow();
//            }

//        }
//        else {
//            try {
//                FXMLLoader loader = new FXMLLoader(Main.class.getResource("licenseWindow.fxml"));
//                AnchorPane pane = loader.load();
//                Scene scene = new Scene(pane);
//                scene.getStylesheets().addAll(Main.class.getResource("style.css").toExternalForm());
//                scene.getRoot().requestFocus();//key event needs focus
//                primaryStage.setResizable(false);
//                primaryStage.setTitle("License Window");
//                primaryStage.setScene(scene);
//                primaryStage.show();
//
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }


    }



    public void mainWindow() throws IOException {
        try {



            FXMLLoader loader = new FXMLLoader(Main.class.getResource("sample.fxml"));

            AnchorPane pane = loader.load();


            Scene scene = new Scene(pane);

            scene.getStylesheets().addAll(Main.class.getResource("style.css").toExternalForm());

            scene.getRoot().requestFocus();//key event needs focus

            primaryStage.setResizable(false);
            primaryStage.setTitle("Αρχική");
            primaryStage.setScene(scene);
            primaryStage.show();




        } catch (IOException e) {
            e.printStackTrace();
        }
    }









    public static void main(String[] args) {
        launch(args);
    }
}
