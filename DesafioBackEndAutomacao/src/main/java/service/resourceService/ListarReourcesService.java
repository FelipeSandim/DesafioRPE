package service.resourceService;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ListarReourcesService {

    public Response listararResources() {
        Response response =
            given()
                .spec(specs.SetupRequestSpecification.requestSpecification())
                .contentType(ContentType.JSON)
                .when()
                .get("/api/unknown");
        return response;
    }
}
