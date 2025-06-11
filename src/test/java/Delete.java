import org.testng.annotations.Test;

import static io.restassured.RestAssured.when;

public class Delete {

    @Test
    public void delete () {

        when().delete("http://localhost:3004/posts/1").then().log().all();
    }
}
