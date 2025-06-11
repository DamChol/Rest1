import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetSpecificFieldValue {

    @Test
    public void checkSpecificField() {

        Response response = RestAssured.get("http://localhost:3004/posts/2");
        String author = response.path("author");

        Assert.assertEquals(author,"Mohit");
    }

        @Test
        public void checkSpecificFieldJsonPath() {

            Response response = RestAssured.get("http://localhost:3004/posts/2");
            JsonPath jsonPath = new JsonPath(response.asString());
//            String author = jsonPath.get("author");
            String author = RestAssured.get("http://localhost:3004/posts/2").path("author");
            Assert.assertEquals(author,"Mohit");

            String response2 = RestAssured.get("http://localhost:3004/posts/2").asString();
            String author2 = JsonPath.from(response2).getString("author");
            Assert.assertEquals(author,"Mohit");

        }


}
