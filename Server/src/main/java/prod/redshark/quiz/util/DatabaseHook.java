package prod.redshark.quiz.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseHook {
    private Connection connection;

    public DatabaseHook() {
        LoginFile loginFile = new LoginFile("data/login.json");

        try{
            System.out.println(loginFile.getConnectionURL()+loginFile.getUsername()+loginFile.getPwd());
            this.connection = DriverManager.getConnection(loginFile.getConnectionURL(), loginFile.getUsername(), loginFile.getPwd());

            System.out.println("Successfully connected to the SQL server");
        } catch (SQLException e) {
            System.out.println("There was a problem connecting to the SQL server");
        }

    }

    public Connection getConnection() {
        return connection;
    }
}
