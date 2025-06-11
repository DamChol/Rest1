import org.testng.annotations.Test;

import static io.restassured.RestAssured.when;
import static io.restassured.module.jsv.JsonSchemaValidator.*;

public class SchemaValidaton {

    @Test
    public void getPost() {

                when()
                        .get("http://localhost:3004/posts/{postId}",1)
                .then()
                        .assertThat().body(matchesJsonSchemaInClasspath("postSchema.json"));
    }
}
