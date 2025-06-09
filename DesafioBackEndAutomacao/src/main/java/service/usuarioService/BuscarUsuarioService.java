package service.usuarioService;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class BuscarUsuarioService {

    public Response buscarUsuario() {
        Response response =
            given()
                .spec(specs.SetupRequestSpecification.requestSpecification())
                .contentType(ContentType.JSON)
                .when()
                .get("/api/users/2");
        return response;
    }
}
