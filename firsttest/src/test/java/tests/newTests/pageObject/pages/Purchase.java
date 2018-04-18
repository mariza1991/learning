package tests.newTests.pageObject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

import static org.testng.Assert.assertEquals;

public class Purchase extends PageObject {

    String[] userData = {
            "TestName",
            "TestAddress",
            "TestCity",
            "Alabama",
            "123BE",
            "0000111122223333",  //expected [5]
            "12",  //expected [6]
            "2020",  //expected [7]
            "Marina Zaitseva",
    };
    enum cardType {visa, amex, dinersclub};

    @FindBy(css="h2")
    WebElement actualHeader;

    @FindBy(css=".container > p:nth-of-type(1)")
    WebElement airlineElement;

    @FindBy(css=".container > p:nth-of-type(2)")
    WebElement flightNumberElement;

    @FindBy(css=".btn.btn-primary")
    WebElement submitButton;

    private String actualPrice = driver.findElement(By.cssSelector(".container > p:nth-of-type(3)")).getText();

    private String feesPrice = driver.findElement(By.cssSelector(".container > p:nth-of-type(4)")).getText();

    private String totalPrice = driver.findElement(By.cssSelector(".container > p:nth-of-type(5)")).getText();

    public Purchase(WebDriver driver){
        super(driver);
    }

    public boolean isInitialized(WebDriverWait wait) {
        return wait.until(ExpectedConditions.titleIs("BlazeDemo Purchase"));
    }

    public String getActualHeader(){
        return actualHeader.getText();
    }

    public void checkFlightDetails(ArrayList flightDetails){

        String actualAirline = airlineElement.getText();
        String actualFlightNumber = flightNumberElement.getText();

        assertEquals(actualAirline, "Airline: " + flightDetails.get(0));
        assertEquals(actualFlightNumber, "Flight Number: " + flightDetails.get(1));
        String actualPriceStr = String.valueOf(flightDetails.get(2));
        assertEquals(actualPrice, "Price: " + actualPriceStr.substring(1, actualPriceStr.length()));
    }

    public void checkTotalPrice(){
        String part1 = getPrice(actualPrice);
        String part2 = getPrice(feesPrice);
        double totalActualPrice = Double.parseDouble(part1) + Double.parseDouble(part2);
        double totalExpectedPrice = Double.parseDouble(getPrice(totalPrice));
        assertEquals(totalActualPrice, totalExpectedPrice);
    }

    public void fillForm(String name){
        cardType myCard = cardType.valueOf(name);

        String[] selector = {
                "#inputName",
                "#address",
                "#city",
                "#state",
                "#zipCode",
                "#creditCardNumber",
                "#creditCardMonth",
                "#creditCardYear",
                "#nameOnCard",
        };
        if (selector.length != userData.length) {
            throw new UnsupportedOperationException("Arrays' length are not equal");
        }
        for (int i = 0; i < selector.length; i++) {
            if (selector[i].equals("#creditCardMonth") || selector[i].equals("#creditCardYear")) {
                driver.findElement(By.cssSelector(selector[i])).clear();
            }
            driver.findElement(By.cssSelector(selector[i])).sendKeys(userData[i]);
        }
        WebElement selectCard = driver.findElement(By.cssSelector("#cardType"));
        Select selectTestCard = new Select(selectCard);
        selectTestCard.selectByValue(myCard.toString());
    }

    public ArrayList getExpectedData(){
        ArrayList expectedData = new ArrayList();
        expectedData.add(userData[5]);
        expectedData.add(userData[6]);
        expectedData.add(userData[7]);
        return expectedData;
    }

    public Confirmation submit(){
        submitButton.click();
        return new Confirmation(driver);
    }

    private String getPrice(String price){
        String[] result = price.split("\\s");
        return result[result.length - 1];
    }

}
