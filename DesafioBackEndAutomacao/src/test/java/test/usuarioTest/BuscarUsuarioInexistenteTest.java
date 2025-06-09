package test.usuarioTest;

import baseTest.BaseTest;
import io.restassured.response.Response;
import jdk.jfr.Description;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import service.usuarioService.BuscarUsuarioInexistenteService;

public class BuscarUsuarioInexistenteTest extends BaseTest {

    BuscarUsuarioInexistenteService usuarioInexistente= new BuscarUsuarioInexistenteService();

    @Test
    @Description("Teste de busca de usuario inexistente onde o id passado e inexistente")
    public void TestBuscarUsuarioInexistente() {
        Response response =
            usuarioInexistente.buscarUsuarioInexistente("123")
                .then()
                .extract()
                .response();
                    response.then()
                        .statusCode(HttpStatus.SC_NOT_FOUND);
        response.prettyPrint();
    }


}
