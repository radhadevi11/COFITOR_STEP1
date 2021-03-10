package step1_BPR_RN.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    public Connection getConnection()  {
        String url = "jdbc:mysql://localhost:3306/cofitor?useSSL=false";
        //?user=root root@127.0.0.1:3306
        try {
            Connection con = DriverManager.getConnection(url, "root", "radha");
            return con;
        }
        catch ( SQLException e){
            System.out.println("Could not connect to DB using url: " + url);
            throw new RuntimeException("Could not connect to database", e);
        }
    }
}
