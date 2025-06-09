package test.resourceTest;

import baseTest.BaseTest;
import io.restassured.response.Response;
import jdk.jfr.Description;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import service.resourceService.ListarReourcesService;

import static org.hamcrest.Matchers.equalTo;

public class ListarResourcesTest extends BaseTest {

    ListarReourcesService resources = new ListarReourcesService();

    @Test
    @Description("Teste para listar todas as resources com sucesso")
    public void listarResources() {
        Response response = resources.listararResources()
            .then()
            .statusCode(HttpStatus.SC_OK)
            .extract()
            .response();
        Integer id = response.path("data[0].id");
        String name = response.path("data[0].name");
        Integer year = response.path("data[0].year");
        String color = response.path("data[0].color");
        String pantoneValue = response.path("data[0].pantone_value");
        Object primeiroProduto = response.path("data[0]");
        System.out.println(primeiroProduto.toString());
        response.then()
            .body("data[0].id", equalTo(id))
            .body("data[0].name", equalTo(name))
            .body("data[0].year", equalTo(year))
            .body("data[0].color", equalTo(color))
            .body("data[0].pantone_value", equalTo(pantoneValue));
        response.prettyPrint();
    }
}
