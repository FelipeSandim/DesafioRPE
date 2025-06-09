package test.RegistroTest;

import baseTest.BaseTest;
import io.restassured.response.Response;
import jdk.jfr.Description;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import service.registroService.ErroDeRegistroDeUsuarioService;

import static org.hamcrest.Matchers.equalTo;

public class ErroDeRegistroTest extends BaseTest {

    ErroDeRegistroDeUsuarioService registrar = new ErroDeRegistroDeUsuarioService();

    @Test
    @Description("Teste de erro ao registrar um novo usuário, onde a senha deve ser preenchido.")
    public void registroDeUsuario() {
        Response response =
            registrar.erroAoRegistrarUsuario("GxOg9@example", "")
                .then()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .extract()
                .response();
        response.then().body("error", equalTo("Missing password"));
        response.prettyPrint();
    }

    @Test
    @Description("Teste de erro ao registrar um novo usuário, onde o email deve ser preenchido.")
    public void registroDeUsuarioSemEmail() {
        Response response =
                registrar.erroAoRegistrarUsuario("", "Ashe123")
                        .then()
                        .statusCode(HttpStatus.SC_BAD_REQUEST)
                        .extract()
                        .response();
        response.then().body("error", equalTo("Missing email or username"));
        response.prettyPrint();
    }

    @Test
    @Description("Teste de erro ao registrar um novo usuário, onde os campos email e senha estão em branco.")
    public void registroDeUsuarioSemEmailESemSenha() {
        Response response =
                registrar.erroAoRegistrarUsuario("", "")
                        .then()
                        .statusCode(HttpStatus.SC_BAD_REQUEST)
                        .extract()
                        .response();
        response.then().body("error", equalTo("Missing email or username"));
        response.prettyPrint();
    }
}
