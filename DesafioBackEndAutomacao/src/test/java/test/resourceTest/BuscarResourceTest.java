package test.resourceTest;

import baseTest.BaseTest;
import io.restassured.response.Response;
import jdk.jfr.Description;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import service.resourceService.BuscarResourceService;

import static org.hamcrest.Matchers.equalTo;

public class BuscarResourceTest extends BaseTest {

    BuscarResourceService resource = new BuscarResourceService();

    @Test
    @Description("Teste para buscar uma resource com sucesso")
    public void buscararResource() {
        Response response = resource.buscarResource()
                .then()
                .extract()
                .response();
        Integer id = response.path("data.id");
        String name = response.path("data.name");
        Integer year = response.path("data.year");
        String color = response.path("data.color");
        String pantoneValue = response.path("data.pantone_value");
        Object primeiroProduto = response.path("data");
        System.out.println(primeiroProduto.toString());
        response.then()
                .statusCode(HttpStatus.SC_OK)
                .body("data.id", equalTo(id))
                .body("data.name", equalTo(name))
                .body("data.year", equalTo(year))
                .body("data.color", equalTo(color))
                .body("data.pantone_value", equalTo(pantoneValue));
        response.prettyPrint();
    }
}
