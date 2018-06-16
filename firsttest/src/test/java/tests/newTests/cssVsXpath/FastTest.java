package tests.newTests.cssVsXpath;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import tests.newTests.BaseTest;

public class FastTest extends BaseTest {

    @Test
    public void test(){
        driver.get("http://www.rambler.ru");
        long startTimeXpath = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            driver.findElements(By.cssSelector("#main > div._2CMA > nav > div._1AJ4 > div._2Fze"));
        }
        long endTimeXpath = System.currentTimeMillis();

        long startTimeCss = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            driver.findElements(By.xpath("//*[@id='main']/div[1]/nav/div[2]/div[1]"));
        }
        long endTimeCss = System.currentTimeMillis();

        System.out.println("XPATH time: " + (endTimeXpath - startTimeXpath)/100);
        System.out.println("CSS time: " + (endTimeCss - startTimeCss)/100);
    }
}
