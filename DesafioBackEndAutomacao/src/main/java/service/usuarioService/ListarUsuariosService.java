package service.usuarioService;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ListarUsuariosService {

    public Response buscar() {
        Response response =
            given()
                .spec(specs.SetupRequestSpecification.requestSpecification())
                .contentType(ContentType.JSON)
                .when()
                .get("/api/users?page=2");
        return response;
    }

}
