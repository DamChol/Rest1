import io.restassured.http.ContentType;
import model.Post;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class UpdatePost {

    @Test
    public void replacePost() {

        Map<String, Object> updatePost = new HashMap<>();
        updatePost.put("title", "updated title");
        updatePost.put("author", "updated author");

        given().log().all().contentType(ContentType.JSON).body(updatePost)
                .when().put("http://localhost:3004/posts/1")
                .then().log().all();
    }

    @Test
    public void replacePostObject () {

        Post post = new Post();
        post.setTitle("title 3");
        post.setAuthor("author 3");
        given().log().all().contentType(ContentType.JSON).body(post)
                .when().put("http://localhost:3004/posts/1")
                .then().log().all();
    }

    @Test
    public void updatePostObject() {
        Post post = new Post();

        post.setTitle("Nowy tytul");

        given().log().all().contentType(ContentType.JSON).body(post)
                .when().patch("http://localhost:3004/posts/1")
                .then().log().all();

    }

}
