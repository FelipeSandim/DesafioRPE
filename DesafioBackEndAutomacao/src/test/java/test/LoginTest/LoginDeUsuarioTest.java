package test.LoginTest;

import baseTest.BaseTest;
import io.restassured.response.Response;
import jdk.jfr.Description;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import service.loginService.LoginDeUsuarioService;

import static org.hamcrest.Matchers.equalTo;

public class LoginDeUsuarioTest extends BaseTest {

    LoginDeUsuarioService login = new LoginDeUsuarioService();

    @Test
    @Description("Teste de login de usuário com sucesso")
    public void loginDeUsuario() {
        Response response =
        login.loginDeUsuario("eve.holt@reqres.in", "cityslicka")
            .then()
            .statusCode(HttpStatus.SC_OK)
            .extract()
            .response();
        String token = response.then().extract().path("token");
        response.then().body("token", equalTo(token));
        response.prettyPrint();
    }
}
