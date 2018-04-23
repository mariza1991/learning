package tests.newTests.actionsApi;

import blazedemo.pages.login.LoginPage;
import org.openqa.selenium.Dimension;
import org.testng.annotations.Test;
import tests.newTests.BaseTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class BlazeDemoLoginTest extends BaseTest {

    @Test
    public void testLoginButtonProperties() {
        driver.get("http://blazedemo.com/login");
        LoginPage blazedemoLoginPage = new LoginPage();

        String actualLoginHoverColor = blazedemoLoginPage.getLoginHoverStateColor();
        assertEquals(actualLoginHoverColor, "rgba(37, 121, 169, 1)");

        Dimension normalStateSize = blazedemoLoginPage.getLoginNormalStateSize();
        assertTrue(blazedemoLoginPage.getLoginHoverStateSize().equals(normalStateSize));
    }
}
