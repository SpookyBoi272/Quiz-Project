package prod.redshark.quiz.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseHook {

    public static Connection getNewConnection() {
        try{
            Connection connection = DriverManager.getConnection(LoginFile.getConnectionURL(), LoginFile.getUsername(), LoginFile.getPwd());
            System.out.println("Successfully connected to the SQL server");
            return connection;
        }catch (SQLException e){
            System.out.println("There was a problem connecting to the SQL server");
            return null;
        }
    }
}
