package tests.secondHW;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    WebDriver driver;
    WebDriverWait wait;
    int timeout = 10;

    @BeforeClass
    public void beforeTest(){
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, timeout);
    }

    public void fillForm(String[] selector, String[] data){
        if (selector.length != data.length) {
            throw new UnsupportedOperationException("Arrays' length are not equal");
        }
        for (int i = 0; i < selector.length; i++) {
            driver.findElement(By.cssSelector(selector[i])).sendKeys(data[i]);
        }
    }

    public String getPrice(String price){
        String[] result = price.split("\\s");
        return result[result.length - 1];
    }

    public static String getCardNumber(String cardNumber) {
        for (int i = 0; i < cardNumber.length() - 4; i++) {
            cardNumber = cardNumber.substring(0,i) + 'x' + cardNumber.substring(i+1);
        }
        return cardNumber;
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}
