package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FirstTest {

    @Test
    public void test(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://yandex.ru");

        WebElement enterToEmail = driver.findElement(By.cssSelector("div[role='form'] > a.button"));
        enterToEmail.click();

        WebElement inputLogin = driver.findElement(By.name("login"));
        WebElement inputPassword = driver.findElement(By.name("passwd"));
        inputLogin.sendKeys("marina.zaitseva91@yandex.ru");
        inputPassword.sendKeys("absc");
        WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
        submit.click();

        WebElement errorMsg = driver.findElement(By.cssSelector("div.passport-Domik-Form-Error"));

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(errorMsg));

        assertTrue(errorMsg.isDisplayed());
        driver.quit();
    }
}
