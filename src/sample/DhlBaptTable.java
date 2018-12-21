package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.prefs.Preferences;

public class DhlBaptTable {

    /*******************************
    //Σύνδεση με Βάση
    ******************************/

    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:adeies.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
            System.out.println("good");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }


}
