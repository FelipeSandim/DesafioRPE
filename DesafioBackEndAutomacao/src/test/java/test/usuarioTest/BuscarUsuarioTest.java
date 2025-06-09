package test.usuarioTest;

import baseTest.BaseTest;
import io.restassured.response.Response;
import jdk.jfr.Description;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import service.usuarioService.BuscarUsuarioService;

import static org.hamcrest.Matchers.equalTo;

public class BuscarUsuarioTest extends BaseTest {

    BuscarUsuarioService usuario = new BuscarUsuarioService();

    @Test
    @Description(" Teste de busca de um unico usuario com sucesso ")
    public void buscarUsuario() {
        Response response =
            usuario.buscarUsuario()
                .then()
                .extract()
                .response();
        Integer id = response.path("data.id");
        String email = response.path("data.email");
        String firstName = response.path("data.first_name");
        String lastName = response.path("data.last_name");
        String avatar = response.path("data.avatar");
        String url = response.path("support.url");
        String text = response.path("support.text");
        response.then()
            .statusCode(HttpStatus.SC_OK)
            .body("data.id", equalTo(id))
            .body("data.email", equalTo(email))
            .body("data.first_name", equalTo(firstName))
            .body("data.last_name", equalTo(lastName))
            .body("data.avatar", equalTo(avatar))
            .body("support.url", equalTo(url))
            .body("support.text", equalTo(text));
        response.prettyPrint();
    }
}
