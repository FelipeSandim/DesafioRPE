package test.resourceTest;

import baseTest.BaseTest;
import io.restassured.response.Response;
import jdk.jfr.Description;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import service.resourceService.BuscarResourceInexistenteService;

public class BuscarResourceInexistenteTest extends BaseTest {

    BuscarResourceInexistenteService inexistente = new BuscarResourceInexistenteService();

    @Test
    @Description("Teste de busca de resource inexistente")
    public void TestBuscarResourceInexistente() {
        Response response = inexistente.buscarResourceInexistente()
            .then()
            .extract()
            .response();
        response.then()
            .statusCode(HttpStatus.SC_NOT_FOUND);
        response.prettyPrint();
    }
}
