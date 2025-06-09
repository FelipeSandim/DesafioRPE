package service.usuarioService;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class AlteracaoDeUsuarioService {

    public Response alterarUsuario(String name, String job) {
    Response response =
            given()
                    .spec(specs.SetupRequestSpecification.requestSpecification())
                    .contentType(ContentType.JSON)
                    .body("{\n" +
                            "    \"name\": \"" + name + "\",\n" +
                            "    \"job\": \"" + job + "\"\n" +
                            "\n}")
                    .when()
                    .put("/api/users/2");
    return response;
    }
}
