package pages;

import org.openqa.selenium.By;
import utils.Elements;

public class HomePage extends BasePage{

    private static final By fecharModal = By.cssSelector("#close-button-1454703513200");
    private static final By aceitarCookies = By.cssSelector("#dm876A");
    private static final By preencherCampoBusca = By.cssSelector("input[aria-label='search']");
    private static final By clicarBotaoBusca = By.cssSelector("button[data-testid='fs-search-button']");

    public void buscarProduto(String produto){
        if (Elements.driver.findElements(fecharModal).size() > 0) {
            click(fecharModal);
        }
        click(aceitarCookies);
        sendKeys(preencherCampoBusca, produto);
        click(clicarBotaoBusca);
    }
}
