import org.testng.annotations.Test;

import static io.restassured.RestAssured.when;

public class GetPostTest {
    public static void main(String[] args) {

    }

    @Test
    public void getPost () {
        when().get("http://localhost:3004/posts").then().log().body();
    }
}
