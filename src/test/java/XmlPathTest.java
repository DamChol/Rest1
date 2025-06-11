import io.restassured.path.xml.XmlPath;
import org.testng.annotations.Test;

import java.util.List;

public class XmlPathTest {

    @Test
    public void testXmlPath() {

        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n";

        String nazwa = XmlPath.from(xml).get("filmy.film.nazwa[0]");
        List<String> nazwyFilmow = XmlPath.from(xml).getList("filmy.film.nazwa");
        String gatunek = XmlPath.from(xml).get("filmy.film[0].@gatunek");
    }
}
