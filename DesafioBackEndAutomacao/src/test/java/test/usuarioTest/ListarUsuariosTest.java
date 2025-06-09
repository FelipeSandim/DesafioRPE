package test.usuarioTest;

import baseTest.BaseTest;
import io.restassured.response.Response;
import jdk.jfr.Description;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import service.usuarioService.ListarUsuariosService;
import static org.hamcrest.Matchers.equalTo;

public class ListarUsuariosTest extends BaseTest {

    ListarUsuariosService usuarios = new ListarUsuariosService();

    @Test
    @Description("Teste de listagem de usuarios")
    public void listarUsuarios() {
        Response response =
            usuarios.buscar()
                    .then()
                    .extract()
                    .response();
        Integer id = response.path("data[0].id");
        String email = response.path("data[0].email");
        String firstName = response.path("data[0].first_name");
        String lastName = response.path("data[0].last_name");
        String avatar = response.path("data[0].avatar");
        response.then()
                .statusCode(HttpStatus.SC_OK)
                .body("data[0].id", equalTo(id))
                .body("data[0].email", equalTo(email))
                .body("data[0].first_name", equalTo(firstName))
                .body("data[0].last_name", equalTo(lastName))
                .body("data[0].avatar", equalTo(avatar));
        response.prettyPrint();
    }
}
