package baseTest;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public abstract class BaseTest  {

    @BeforeAll
    public static void setUp() {
    RestAssured.baseURI = "https://reqres.in/";
}
}
