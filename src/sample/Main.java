package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main extends Application {
    Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception{


        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String todayString = sdf.format(date);


        /**
         * SET UP LICENSING
         * FOR SINGLE DEVICE
         * AND EXPIRATION DATE
         *****************************************
         *****************************************
         */
        String expirationDateString = "2020-10-1";
        String CustomersMAC="3C-15-C2-CF-DD-9C";
        /**
         *****************************************
         *****************************************
         */

        Date today = sdf.parse(todayString);
        Date expirationDate = sdf.parse(expirationDateString);


        GetMac gm=new GetMac();
        String mac=gm.getMac();


        if(mac.equals(CustomersMAC))
        {
            if(today.after(expirationDate))
            {
                try {
                    FXMLLoader loader = new FXMLLoader(Main.class.getResource("expirationWindow.fxml"));
                    AnchorPane pane = loader.load();
                    Scene scene = new Scene(pane);
                    scene.getStylesheets().addAll(Main.class.getResource("style.css").toExternalForm());
                    scene.getRoot().requestFocus();//key event needs focus
                    primaryStage.setResizable(false);
                    primaryStage.setTitle("Expiration Window");
                    primaryStage.setScene(scene);
                    primaryStage.show();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else
            {
                this.primaryStage=primaryStage;
                mainWindow();
            }

        }
        else {
            try {
                FXMLLoader loader = new FXMLLoader(Main.class.getResource("licenseWindow.fxml"));
                AnchorPane pane = loader.load();
                Scene scene = new Scene(pane);
                scene.getStylesheets().addAll(Main.class.getResource("style.css").toExternalForm());
                scene.getRoot().requestFocus();//key event needs focus
                primaryStage.setResizable(false);
                primaryStage.setTitle("License Window");
                primaryStage.setScene(scene);
                primaryStage.show();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }


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
