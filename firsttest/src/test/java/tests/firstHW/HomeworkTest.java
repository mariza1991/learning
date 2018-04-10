package tests.firstHW;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class HomeworkTest {

    WebDriver driver;
    WebDriverWait wait;
    int timeout = 10;

    @BeforeClass
    public void beforeClass(){
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, timeout);
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
    }

    @Test
    public void test() {
        driver.get("http://blazedemo.com/index.php");
        WebElement selectFrom = driver.findElement(By.name("fromPort"));
        Select select = new Select(selectFrom);
        select.selectByValue("Philadelphia");

        WebElement selectTo = driver.findElement(By.name("toPort"));
        Select selectNext = new Select(selectTo);
        selectNext.selectByValue("Berlin");
        driver.findElement(By.cssSelector("input.btn.btn-primary")).click();

        WebElement chooseFlight = driver.findElement(By.cssSelector("input.btn.btn-small"));

        //waiting for next page loads
        wait.until(ExpectedConditions.titleIs("BlazeDemo - reserve"));
        wait.until(ExpectedConditions.textToBePresentInElementValue(chooseFlight, "Choose This Flight"));
        assertTrue(chooseFlight.isDisplayed());
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
