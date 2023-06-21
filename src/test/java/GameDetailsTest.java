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
    @DisplayName("Get Generation by ID")
    @Feature("Game")
    @Story("Get game details")
    public void testGetGenerationById() {
        int generationId = 1;

        Response response = given()
                .baseUri(BASE_URL)
                .pathParam("id", generationId)
                .when()
                .get("/generation/{id}")
                .then()
                .log()
                .all()
                .extract()
                .response();

        assertEquals(200, response.statusCode());
        assertEquals(generationId, (Integer) response.path("id"));
    }

    @Test
    @DisplayName("Get Generation by Name")
    @Feature("Game")
    @Story("Get game details")
    public void testGetGenerationByName() {
        String generationName = "red-blue";

        Response response = given()
                .baseUri(BASE_URL)
                .pathParam("name", generationName)
                .when()
                .get("/generation/{name}")
                .then()
                .log()
                .all()
                .extract()
                .response();

        assertEquals(200, response.statusCode());
        assertEquals(generationName, response.path("name"));
    }

    @Test
    @DisplayName("Get Generation with Invalid ID")
    @Feature("Game")
    @Story("Get game details")
    public void testGetGenerationWithInvalidId() {
        int invalidGenerationId = 9999;

        Response response = given()
                .baseUri(BASE_URL)
                .pathParam("id", invalidGenerationId)
                .when()
                .get("/generation/{id}")
                .then()
                .log()
                .all()
                .extract()
                .response();

        assertEquals(404, response.statusCode());
    }

    @Test
    @DisplayName("Get Generation with Invalid Name")
    @Feature("Game")
    @Story("Get game details")
    public void testGetGenerationWithInvalidName() {
        String invalidGenerationName = "invalid-generation";

        Response response = given()
                .baseUri(BASE_URL)
                .pathParam("name", invalidGenerationName)
                .when()
                .get("/generation/{name}")
                .then()
                .log()
                .all()
                .extract()
                .response();

        assertEquals(404, response.statusCode());
    }
}
