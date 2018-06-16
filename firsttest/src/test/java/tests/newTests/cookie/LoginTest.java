package tests.newTests.cookie;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import tests.TestListener;
import tests.newTests.BaseTest;
import helpers.demo99.Authorization;

import java.util.Set;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

@Listeners({TestListener.class})
public class LoginTest extends BaseTest {

    private Set<Cookie> cookies;

    @Test
    public void test(){
        driver.manage().deleteAllCookies();
        driver.get("http://www.demo.guru99.com/test/cookie/selenium_aut.php");
        driver.findElement(By.name("username")).sendKeys("my@email.com");
        driver.findElement(By.name("password")).sendKeys("password");
        driver.findElement(By.name("submit")).click();
        cookies = driver.manage().getCookies();
        assertTrue(false);
        assertFalse(cookies.isEmpty());
    }

    @Test
    public void test2() {
        driver.manage().deleteAllCookies();
        driver.get("http://www.demo.guru99.com/test/cookie/selenium_aut.php");
        Authorization auth = new Authorization();
        auth.authorizeMe("email@email.com", "password");
        driver.manage().deleteAllCookies();
        auth.authorizeMe("email@email.com", "password");
        driver.navigate().refresh();
    }
}
