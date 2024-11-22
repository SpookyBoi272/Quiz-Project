package prod.redshark.quiz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import prod.redshark.quiz.util.DatabaseHook;

import java.sql.Connection;

@SpringBootApplication
public class JavaApiApplication {
    public static Connection connection;
    public static void main(String[] args) {
        SpringApplication.run(JavaApiApplication.class, args);
        DatabaseHook databaseHook = new DatabaseHook();
        connection = databaseHook.getConnection();
    }
}

