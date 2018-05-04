package tests.newTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.WebdriverManager;

public class BaseTest {

    public WebDriver driver;
    public WebDriverWait wait;
    int timeout = 30;

    @BeforeClass
    public void beforeTest(){
        driver = WebdriverManager.getDriver();
        wait = new WebDriverWait(driver, timeout);
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
