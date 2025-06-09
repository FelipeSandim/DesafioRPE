package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.Elements;

public class BasePage extends Elements {
    public static void click(By by){
        waitElement(by);
        element(by).click();
    }
    public static void sendKeys(By by, String texto){
        waitElement(by);
        element(by).sendKeys(texto);
    }
    public void waitVisibility(By by) {
        Elements.wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
}