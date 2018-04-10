package tests.firstHW;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import tests.TestListener;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Listeners(TestListener.class)
public class FirstTest {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void beforeClass(){
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 30);
    }

    @Test(groups = {"regress"})
    public void test1(){
        driver.get("https://yandex.ru");
        driver.findElement(By.cssSelector("div[role='form'] > a.button")).click();

        WebElement enterButton = driver.findElement(By.className("passport-Button-Text"));
        wait.until(ExpectedConditions.visibilityOf(enterButton));
        assertTrue(enterButton.isDisplayed());
    }

    @Test(groups = {"smoke"}, dependsOnMethods = {"test1"}, dataProvider = "data")
    public void test2(String email, String psw){
        WebElement inputLogin = driver.findElement(By.name("login"));
        WebElement inputPassword = driver.findElement(By.name("passwd"));
        inputLogin.sendKeys(email);
        inputPassword.sendKeys(psw);
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        WebElement errorMsg = driver.findElement(By.cssSelector("div.passport-Domik-Form-Error"));
        wait.until(ExpectedConditions.visibilityOf(errorMsg));
        assertEquals(errorMsg.getText(), "Неверный пароль"); //actual, expected
    }

    @DataProvider(name = "data")
    public Object[][] dataProvider(){
        return new Object[][]{{"marina.zaitseva@yandex.ru", "abc"}};
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
