package service.resourceService;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class BuscarResourceInexistenteService {

    public Response buscarResourceInexistente() {
        Response response =
            given()
                .spec(specs.SetupRequestSpecification.requestSpecification())
                .contentType(ContentType.JSON)
                .when()
                .get("/api/unknown/23");
        return response;
    }
}
