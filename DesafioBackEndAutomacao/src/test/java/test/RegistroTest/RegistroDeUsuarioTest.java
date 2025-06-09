package test.RegistroTest;

import baseTest.BaseTest;
import io.restassured.response.Response;
import jdk.jfr.Description;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import service.registroService.RegistrarUsuarioService;

import static org.hamcrest.Matchers.equalTo;

public class RegistroDeUsuarioTest extends BaseTest {

    RegistrarUsuarioService registrar = new RegistrarUsuarioService();

    @Test
    @Description("Teste de registro de usuário com sucesso")
    public void registroDeUsuario() {
        Response response =
            registrar.registrarUsuario("eve.holt@reqres.in", "pistol")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response();
        Integer id = response.then().extract().path("id");
        String token = response.then().extract().path("token");
        response.then().body("id", equalTo(id));
        response.then().body("token", equalTo(token));
        response.prettyPrint();
    }
}
