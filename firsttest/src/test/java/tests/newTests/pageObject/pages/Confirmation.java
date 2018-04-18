package tests.newTests.pageObject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Confirmation extends PageObject {

    @FindBy(css = "h1")
    WebElement expectedHeader;

    @FindBy(css = "tbody tr:nth-child(1) > td:nth-child(2)")
    WebElement id;

    @FindBy(css = "tbody tr:nth-child(2) > td:nth-child(2)")
    WebElement status;

    @FindBy(css = "tbody tr:nth-child(3) > td:nth-child(2)")
    WebElement currency;

    @FindBy(css = "tbody tr:nth-child(4) > td:nth-child(2)")
    WebElement cardNumberActual;

    @FindBy(xpath = "//table//tr[5]/td[2]")
    WebElement cardDateActual;

    @FindBy(xpath = "//table//tr[7]/td[2]")
    WebElement date;

    public Confirmation(WebDriver driver){
        super(driver);
    }

    public boolean isInitialized(WebDriverWait wait) {
        return wait.until(ExpectedConditions.textToBePresentInElement(expectedHeader, "Thank you for your purchase today!"));
    }

    public void checkConfirmation(String cardNumberExpected, String cardMonthExpected, String cardYearExpected){
        assertTrue(id.isDisplayed());
        assertTrue(status.isDisplayed());
        assertEquals(currency.getText(), "USD");

        assertEquals(cardNumberActual.getText(), getCardNumber(cardNumberExpected));
        assertEquals(cardDateActual.getText(), cardMonthExpected + " /" + cardYearExpected);

        assertTrue(date.isDisplayed());
    }

    private static String getCardNumber(String cardNumber) {
        for (int i = 0; i < cardNumber.length() - 4; i++) {
            cardNumber = cardNumber.substring(0,i) + 'x' + cardNumber.substring(i+1);
        }
        return cardNumber;
    }
}
