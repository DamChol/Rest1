import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;

import static io.restassured.RestAssured.given;

public class FilterPosts {

    @Test
    public void filterPosts() {
        given().queryParam("id", "2")
                .when().get("http://localhost:3004/posts")
                .then().log().all();
    }

    @Test
    public void filterPostsAuthorTitle() {

        Map<String,Object> params = new HashMap<>();

        params.put("author","Adam");
        params.put("title","pierwszy poST");

        given().queryParams(params)
                .when().get("http://localhost:3004/posts")
                .then().log().all()

                .statusLine(Matchers.containsString("OK"));
    }


}
