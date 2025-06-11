import io.restassured.http.ContentType;
import model.Post;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class AddPostTest {



    @Test
    public void addPost() {

        String newPost = "{\n" +
                "        \"title\": \"pierwszy poST\",\n" +
                "        \"author\": \"Adam\"\n" +
                "    }";

        given().log().all().contentType(ContentType.JSON).body(newPost)
                .when().post("http://localhost:3004/posts")
                .then().log().all();
    }

    @Test
    public void addPostFromFile() {
        File newPost = new File("src/test/resources/post.json");
        given().log().all().contentType(ContentType.JSON).body(newPost)
                .when().post("http://localhost:3004/posts")
                .then().log().all();

    }


    @Test
    public void addPostMap() {

        Map<String,Object> newPost = new HashMap<>();

        newPost.put("title", "tutul z mapy");
        newPost.put("author", "Adam");

        given().log().all().contentType(ContentType.JSON).body(newPost)
                .when().post("http://localhost:3004/posts")
                .then().log().all();

    }

    @Test
    public void addPostObject() {

        Post newPost = new Post();
        newPost.setTitle("tytul");
        newPost.setAuthor("Adam");

        given().log().all().contentType(ContentType.JSON).body(newPost)
                .when().post("http://localhost:3004/posts")
                .then().log().all();

    }


}
