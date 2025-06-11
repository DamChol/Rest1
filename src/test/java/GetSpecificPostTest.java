import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class GetSpecificPostTest {

    @Test
    public void getPost() {
        given().log().all()
                .when().get("http://localhost:3004/posts/{postId}",2)
                .then().log().all();
    }

}
