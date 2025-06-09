package test.usuarioTest;

import baseTest.BaseTest;
import io.restassured.response.Response;
import jdk.jfr.Description;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import service.usuarioService.DeletarUsuarioService;

import static org.hamcrest.Matchers.equalTo;

public class DeletarUsuarioTest extends BaseTest {

    DeletarUsuarioService deletar = new DeletarUsuarioService();

    @Test
    @Description("Teste de exclusão de usuário com sucesso")
    public void deletarUsuario() {
        Response response =
            deletar.deletarUsuario()
            .then()
            .statusCode(HttpStatus.SC_NO_CONTENT)
            .extract()
            .response();
        response.prettyPrint();
    }
}
