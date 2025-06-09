package test.usuarioTest;

import baseTest.BaseTest;
import io.restassured.response.Response;
import jdk.jfr.Description;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import service.usuarioService.CriarUsuarioService;

import static org.hamcrest.Matchers.equalTo;

public class CriarUsuarioTest extends BaseTest {

    CriarUsuarioService criar = new CriarUsuarioService();

    @Test
    @Description(" Teste de criação de usuario com sucesso ")
    public void criarUsuario() {
        Response response =
            criar.criarUsuario("João", "Devops")
                .then()
                .statusCode(HttpStatus.SC_CREATED)
                .extract()
                .response();
        String id = response.then().extract().path("id");
        String createdAt = response.path("createdAt");

        response.then().body( Matchers.containsString("João"));
        response.then().body( Matchers.containsString("Devops"));
        response.then().body("id", equalTo(id));
        response.then().body("createdAt", equalTo(createdAt));
        response.prettyPrint();

    }
}
