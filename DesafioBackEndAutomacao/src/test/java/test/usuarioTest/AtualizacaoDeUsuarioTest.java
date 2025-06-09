package test.usuarioTest;

import baseTest.BaseTest;
import io.restassured.response.Response;
import jdk.jfr.Description;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import service.usuarioService.AtualizacaoDeUsuarioService;

import static org.hamcrest.Matchers.equalTo;

public class AtualizacaoDeUsuarioTest extends BaseTest {

    AtualizacaoDeUsuarioService atualizar = new AtualizacaoDeUsuarioService();

    @Test
    @Description("Teste de atualização de usuário com sucesso")
    public void atualizarUsuario() {
        Response response =
                atualizar.atualizarUsuario("Ronaldo", "Analista de Testes")
                        .then()
                        .statusCode(HttpStatus.SC_OK)
                        .extract()
                        .response();
        String updatedAt = response.path("updatedAt");
        response.then().body( Matchers.containsString("Ronaldo"));
        response.then().body( Matchers.containsString("Analista de Testes"))
                .body("updatedAt", equalTo(updatedAt));
        response.prettyPrint();
    }
}
