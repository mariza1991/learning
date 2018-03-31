package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomeworkTest {

    @Test
    public void test() {
        WebDriver driver = new ChromeDriver();
        driver.get("http://blazedemo.com/index.php");

        driver.findElement(By.name("fromPort")).click();
        driver.findElement(By.xpath("//form/select[1]/option[3]")).click();

        driver.findElement(By.name("toPort")).click();
        driver.findElement(By.xpath("//form/select[2]/option[4]")).click();

        driver.findElement(By.cssSelector("input.btn.btn-primary")).click();

        WebElement chooseFlight = driver.findElement(By.cssSelector("input.btn.btn-small"));

        WebDriverWait wait = new WebDriverWait(driver, 30);

        //waiting for next page loads
        wait.until(ExpectedConditions.titleIs("BlazeDemo - reserve"));
        wait.until(ExpectedConditions.visibilityOf(chooseFlight));

        assertTrue(chooseFlight.isDisplayed());
        driver.quit();
    }
}
