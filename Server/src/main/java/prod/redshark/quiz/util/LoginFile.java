package prod.redshark.quiz.util;

import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LoginFile {

    private String username;
    private String pwd;
    private String dbName;
    private String dbHost;

    public LoginFile(String fileName){
        try(FileReader fileReader = new FileReader(fileName)) {
            StringBuilder stringBuilder = new StringBuilder();

            //read file till the end
            int i;
            while ((i = fileReader.read()) != -1){
                stringBuilder.append((char)i);
            }

            //convert into json
            JSONObject jsonObject = new JSONObject(stringBuilder.toString());

            dbHost = jsonObject.getString("dbHost");
            username = jsonObject.getString("username");
            pwd = jsonObject.getString("password");
            dbName = jsonObject.getString("dbName");

            System.out.println("File '" + fileName + "' was read successfully");
        } catch (FileNotFoundException e) {
            System.out.println("File '" + fileName +"' was not found");
        } catch (IOException e) {
            System.out.println("Error reading the file");
        }
    }

    public String getConnectionURL(){
        return "jdbc:postgresql://" +
                dbHost +
                "/" +
                dbName;
    }

    public String getPwd() {
        return pwd;
    }

    public String getUsername() {
        return username;
    }
}
