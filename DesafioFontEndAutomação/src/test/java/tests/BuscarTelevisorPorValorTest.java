package tests;


import commons.BaseTest;
import jdk.jfr.Description;
import org.junit.Test;
import pages.CategoriaTelevisoresPage;
import pages.HomePage;

public class BuscarTelevisorPorValorTest extends BaseTest {

    HomePage homePage = new HomePage();
    CategoriaTelevisoresPage televisoresPage = new CategoriaTelevisoresPage()
            ;
    @Test
    @Description("Teste para buscar Televisor por Valor, onde sera impresso no console o nome, o preco e avaliação daquelas que tem o valor igual ou acima de R$ 3.500 ")
    public void test() {
        homePage.buscarProduto("Smart TV");
        televisoresPage.filtrarTelevisorPorValor();
        televisoresPage.imprimirProdutosAcimaDe3500();
    }
}
