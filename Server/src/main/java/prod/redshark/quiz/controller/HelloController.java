package prod.redshark.quiz.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static prod.redshark.quiz.JavaApiApplication.connection;

@RestController
@RequestMapping("/api/v1")
public class HelloController {

    @GetMapping("/images/{id}")
    public ResponseEntity<String> getImageUrl(@PathVariable int id) {
        String imageUrl = null;
        String query = "SELECT image_url FROM images WHERE id = ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                imageUrl = resultSet.getString("image_url");
            }
        } catch (Exception e) {
            System.out.println("Error returning response");
        }
        return ResponseEntity.ok(imageUrl);
    }



}

