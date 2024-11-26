package prod.redshark.quiz.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import prod.redshark.quiz.util.DatabaseHook;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

@RestController
@RequestMapping("/api/v1")
public class ImageController {

    @GetMapping("/images/{id}")
    public ResponseEntity<String> getImageUrl(@PathVariable int id) {
        String query = "SELECT image_url FROM images WHERE id = ?";

        try (PreparedStatement preparedStatement = DatabaseHook.getNewConnection().prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String imageUrl = resultSet.getString("image_url");
                return ResponseEntity.ok(imageUrl);
            }
        } catch (NullPointerException e) {
            System.out.println("Error returning response");
            return ResponseEntity.internalServerError().body("Error");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok("");
    }
}

