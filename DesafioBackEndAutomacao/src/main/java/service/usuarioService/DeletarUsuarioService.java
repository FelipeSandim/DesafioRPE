package service.usuarioService;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class DeletarUsuarioService {

    public Response deletarUsuario() {
        Response response =
            given()
                .spec(specs.SetupRequestSpecification.requestSpecification())
                .contentType(ContentType.JSON)
                .when()
                .delete("/api/users/2");
        return response;
    }
}
