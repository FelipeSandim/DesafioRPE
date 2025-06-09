package test.delayTest;

import baseTest.BaseTest;
import io.restassured.response.Response;
import jdk.jfr.Description;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import service.delayService.DelaySevice;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DelayedTest extends BaseTest {

    DelaySevice delay = new DelaySevice();

    @Test
    @Description("Teste de delay, onde a página deve apresentar um atraso para apresentar os dados de 3 segundos" +
            "podendo se estender para 3.5 segundos, ao passo que se o tempo for menor que 3 segundos, o teste quebra" +
            "e exibe uma mensagem de erro mostrando o tempo de resposta e dizendo se exedeu o tempo estimado ou se a resposta foi precoce, " +
            "e o mesmo acontece se o tempo for maior que 3.5 segundos.")
    public void testGetListOfUsersWithDelay() {
        long startTime = System.currentTimeMillis();
        Response response =
            delay.delay()
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response();
        response.then().body("page ", equalTo(1));
        response.then().body("data[0].id", notNullValue());
        long endTime = System.currentTimeMillis();
        long responseTime = endTime - startTime;

        System.out.println("Tempo de resposta da requisição com delay: " + responseTime + " ms");

        long expectedMinTime = 3000;
        long acceptableMaxTime = 3500;

        assertTrue(responseTime >= expectedMinTime,
                "O tempo de resposta (" + responseTime + " ms) foi menor que o esperado de " + expectedMinTime + ", delay não funcionou.");

        assertTrue(responseTime <= acceptableMaxTime,
                "Tempo de resposta: " + responseTime + " ms excedeu o tempo máximo aceitável de " + acceptableMaxTime + " ms.");

        System.out.println("Teste de delay Realizado com sucesso.");
    }
}
