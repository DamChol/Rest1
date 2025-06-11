import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class JsonPathTest {


    @Test
    public void checkSpecificFieldJsonPath() {

        Response response = RestAssured.get("http://localhost:3004/posts");
        System.out.println(response.asString());

//        List<String> winnerNames = response.path("author");

List<Integer> adamsId = response.path("findAll {it.author=='Adam'}.id");

//
//        String secretString = response.path("secretString");
//        List<Integer> winningNumbers = response.path("winning-numbers");
//        String firstWinnerName = response.path("winners.name[0]");
//        String firstWinnerName1 = response.path("winners[0].name");
//        String secondWinnerName = response.path("winners[1].name");
//        String lastWinnerName = response.path("winners[-1].name");
//        Map<String,?> winner = response.path("winners[0]");
//        List<Map<String,?>> winners = response.path("winners");


//        Map<String,?> winnerInfo = response.path("winners.find {it.name=='Andrew' }");
//        Integer winnerId = response.path("winners.find {it.name=='Andrew'}.winnerId");
//        Integer maxNumber = response.path("winning-numbers.max()");
//        Integer minNumber = response.path("winning-numbers.min()");
//        Map<String,?> winnerMaxId = response.path("winners.max {it.winnerId}");
//        Integer moneySum = response.path("winners.collect {it.money}.sum()");
//
    }


}
