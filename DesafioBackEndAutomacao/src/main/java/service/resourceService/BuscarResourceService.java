package service.resourceService;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class BuscarResourceService {

    public Response buscarResource() {
        Response response =
                given()
                        .spec(specs.SetupRequestSpecification.requestSpecification())
                        .contentType(ContentType.JSON)
                        .when()
                        .get("/api/unknown/2");
        return response;
    }
}
