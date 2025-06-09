package commons;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Elements;

import java.time.Duration;

public class BaseTest {

    public static WebDriver driver;
    public static WebDriverWait wait;

    public void iniciarNavegador(String url) {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get(url);
        Elements.driver = driver;
        Elements.wait = wait;
        driver.manage().window().maximize();
    }
    @Before
    public void abrirNavegador() {
        iniciarNavegador("https://www.americanas.com.br/");
    }

    @After
    public void fecharNavegador() {
        if (driver != null) {
            driver.quit();
        }
    }
}
