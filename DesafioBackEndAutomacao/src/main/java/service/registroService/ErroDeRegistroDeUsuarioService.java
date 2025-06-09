package service.registroService;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ErroDeRegistroDeUsuarioService {

    public Response erroAoRegistrarUsuario(String email, String password) {
        Response response =
                given()
                        .spec(specs.SetupRequestSpecification.requestSpecification())
                        .contentType(ContentType.JSON)
                        .body("{\n" +
                                "    \"email\": \"" + email + "\",\n" +
                                "    \"password\": \"" + password + "\"\n" +
                                "\n}")
                        .when()
                        .post("/api/register");
        return response;
    }
}
