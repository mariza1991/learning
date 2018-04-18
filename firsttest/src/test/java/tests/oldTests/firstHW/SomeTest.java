package tests.oldTests.firstHW;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class SomeTest {

    @Test
    public void useWaitTest() {
        OperaOptions oo = new OperaOptions();
        oo.setBinary("E:/Programms/opera/52.0.2871.64/opera.exe");
        WebDriver driver = new OperaDriver(oo);

        WebDriverWait wait = new WebDriverWait(driver, 10);
        String baseUrl = "http://book.theautomatedtester.co.uk";
        String uri = "/chapter1";
        driver.get(baseUrl + uri);

        String expectedText = "The following text has been loaded from another page on this site. It has been " +
                "loaded in an asynchronous fashion so that we can work through the AJAX section of this chapter";
        WebElement linkAjax = driver.findElement(By.id("loadajax"));
        linkAjax.click();
        WebElement textAreaAjax = driver.findElement(By.cssSelector("#ajaxdiv"));
        wait.until(ExpectedConditions.visibilityOf(textAreaAjax));

        wait.until(ExpectedConditions.textToBePresentInElement(textAreaAjax, expectedText));
        assertTrue(textAreaAjax.isDisplayed());
        assertEquals(textAreaAjax.getText(), expectedText);
        driver.quit();
    }
}
