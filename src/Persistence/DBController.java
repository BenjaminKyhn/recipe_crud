package Persistence;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBController {

    public Connection getConnection() {
        Connection conn;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/idealfood?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
            return conn;
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

}
