package tests.newTests.actionsApi;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import tests.newTests.BaseTest;

import java.io.File;
import java.io.IOException;

public class DragAndDropTest extends BaseTest {

    @Test
    public void test(){
        driver.get("http://demo.guru99.com/test/drag_drop.html");
        WebElement bankBlock = driver.findElement(By.cssSelector("#credit2 a"));
        WebElement accountDebitSideBlock = driver.findElement(By.id("bank"));

        Actions actionFirstColumn = new Actions(driver);
        actionFirstColumn.dragAndDrop(bankBlock, accountDebitSideBlock).build().perform();

        WebElement AmmountBlock = driver.findElement(By.cssSelector("#fourth a"));
        WebElement ammountDebitSideBlock = driver.findElement(By.id("amt7"));
        Actions actionSecondColumn = new Actions(driver);
        actionSecondColumn.dragAndDrop(AmmountBlock, ammountDebitSideBlock).build().perform();
    }
}
