package prod.redshark.quiz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import prod.redshark.quiz.util.LoginFile;

@SpringBootApplication
public class QuizServer {
    public static void main(String[] args) {
        SpringApplication.run(QuizServer.class, args);
        LoginFile.INIT("./data/login.json");
    }
}

