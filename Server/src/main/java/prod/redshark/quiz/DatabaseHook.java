package prod.redshark.quiz;

import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseHook {
    String url = "jdbc:postgresql://gallery-dirt.gl.at.ply.gg:58455/";
    String user = null;
    String password = null;

    public void start(){
        try {
            FileReader reader = new FileReader("data/login.json");
            StringBuilder stringBuilder = new StringBuilder();
            int i;
            while ((i = reader.read()) != -1) {
                stringBuilder.append((char) i);
            }
            JSONObject jsonObject = new JSONObject(stringBuilder.toString());
            user = jsonObject.getString("username");
            password = jsonObject.getString("password");
            String dbname = jsonObject.getString("dbname");
            url = url + dbname;
            System.out.println(user + password + dbname);


            Connection connection = DriverManager.getConnection(url, user, password);
        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
