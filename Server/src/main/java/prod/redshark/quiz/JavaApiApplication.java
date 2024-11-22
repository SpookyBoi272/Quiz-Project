package prod.redshark.quiz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import prod.redshark.quiz.util.DatabaseHook;

@SpringBootApplication
public class JavaApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(JavaApiApplication.class, args);
        DatabaseHook databaseHook = new DatabaseHook();
    }
}

