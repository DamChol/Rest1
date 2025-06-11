import io.restassured.http.ContentType;
import model.Post;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class VerifyResponse {

    @Test
    public void verify() {

        String expected = "{\n" +
                "  \"id\": \"2\",\n" +
                "  \"title\": \"Node.js\",\n" +
                "  \"author\": \"Mohit\"\n" +
                "}";

        given().log().all()
                .when().get("http://localhost:3004/posts/{postId}",2)
                .then().log().all().body(Matchers.equalTo(expected));
    }

    @Test
    public void getPostContain() {
        given().log().all()
                .when().get("http://localhost:3004/posts/{postId}",2)
                .then().log().all().body(Matchers.containsStringIgnoringCase("mhit"));
    }


    @Test
    public void checkSpecificField() {
        given().log().all()
                .when().get("http://localhost:3004/posts/{postId}",2)
                .then().log().all().body("title", Matchers.equalTo("Node.js"))
                .and().log().all().body("author", Matchers.equalTo("Mohit   "));
    }

    @Test
    public void getPostObject() {

        Integer id = 2;
        Post newPost = given().log().all()
                .when().
                        get("http://localhost:3004/posts/{postId}",2)
                .then().
                            log().all().
                                        body("title", Matchers.equalTo("Node.js"))
                .and().
                            log().all().
                                        body("author", Matchers.equalTo("Mohit")).extract().as(Post.class);

        Assert.assertEquals(newPost.getAuthor(), "Mohit");
        Assert.assertEquals(newPost.getTitle(), "Node.js");
        Assert.assertEquals(newPost.getId(),id);
    }

    @Test
    public void addPostObject() {

        Post newPost = new Post();
        newPost.setTitle("tytulek");
        newPost.setAuthor("Adamek");

        Post createdPost =
                given().
                        log().all().contentType(ContentType.JSON).body(newPost)
                .when().
                        post("http://localhost:3004/posts")
                .then().
                        log().all().extract().body().as(Post.class);

        Assert.assertEquals(newPost, createdPost);

    }


}
