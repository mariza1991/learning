package tests.newTests.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.WebdriverManager;

public class BaseTest {

    WebDriver driver;
    WebDriverWait wait;
    int timeout = 10;

    //показываю тут Singleton в действии, метод getDriver("") вызывает getInstance()
    @BeforeClass
    public void beforeTest(){
        driver = WebdriverManager.getDriver("");
        wait = new WebDriverWait(driver, timeout);
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
