import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameDetailsTest {
    private static final String BASE_URL = "https://pokeapi.co/api/v2";

    @Test
    @DisplayName("Verify game details")
    @Feature("Game")
    @Story("Get game details")
    public void testGetGameDetails() {
        String endpoint = "/generation/1";

        Response response = given().baseUri(BASE_URL)
                .when().get(endpoint)
                .then().log().all().extract().response();

        assertEquals(200, response.statusCode());

        String expectedName = "generation-i";
        String actualName = response.path("name");
        assertEquals(expectedName, actualName);
    }
}
