package service.usuarioService;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class BuscarUsuarioInexistenteService {

    public Response buscarUsuarioInexistente(String id) {
        Response response =
                given()
                        .spec(specs.SetupRequestSpecification.requestSpecification())
                        .contentType(ContentType.JSON)
                        .when()
                        .get("/api/users/" + id);
        return response;
    }
}
