package tests.secondHW;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SecondTest extends BaseTest {

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
    String[] data = {
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

    @Test (dataProvider = "testData")
    public void testOrder(String from, String to){
        driver.get("http://blazedemo.com/index.php");

        //choose flight
        WebElement selectFrom = driver.findElement(By.xpath("//*/select[@name='fromPort']"));
        Select select = new Select(selectFrom);
        select.selectByValue(from);
        WebElement selectTo = driver.findElement(By.xpath("//*/select[@name='toPort']"));
        Select selectNext = new Select(selectTo);
        selectNext.selectByValue(to);
        driver.findElement(By.cssSelector("input.btn.btn-primary")).click();

        //check options header
        wait.until(ExpectedConditions.titleIs("BlazeDemo - reserve"));
        String expectedHeader = "Flights from " + from + " to " + to + ":";
        WebElement actualHeader = driver.findElement(By.xpath("//h3"));
        assertEquals(actualHeader.getText(), expectedHeader);

        //choose random option
        Integer chooseRandomFlight = 1 + (int) (Math.random()*5);
        WebElement chooseFlight = driver.findElement(By.xpath("//table/tbody/tr[" + chooseRandomFlight + "]"));
        WebElement orderTable = driver.findElement(By.cssSelector(".table"));
        wait.until(ExpectedConditions.visibilityOf(orderTable));

        String expectedAirline = chooseFlight.findElement(By.xpath("./td[3]")).getText();
        String expectedFlightNumber = chooseFlight.findElement(By.xpath("./td[2]")).getText();
        String expectedPrice = chooseFlight.findElement(By.xpath("./td[6]")).getText();
        chooseFlight.findElement(By.xpath("./td[1]")).click();

        //check purchase
        wait.until(ExpectedConditions.titleIs("BlazeDemo Purchase"));
        String expectedPurchaseHeader = "Your flight from " + from + " to " + to + " has been reserved.";
        WebElement actualPurchaseHeader = driver.findElement(By.xpath("//h2"));
        assertEquals(actualPurchaseHeader.getText(), expectedPurchaseHeader);

        //check details from options page
        String actualAirline = driver.findElement(By.xpath("//h2/following-sibling::p[1]")).getText();
        String actualFlightNumber = driver.findElement(By.xpath("//h2/following-sibling::p[2]")).getText();
        String actualPrice = driver.findElement(By.xpath("//h2/following-sibling::p[3]")).getText();
        assertEquals(actualAirline, "Airline: " + expectedAirline);
        assertEquals(actualFlightNumber, "Flight Number: " + expectedFlightNumber);
        assertEquals(actualPrice, "Price: " + expectedPrice.substring(1, expectedPrice.length()));

        //check total price
        String part1 = getPrice(actualPrice);
        String part2 = getPrice(driver.findElement(By.xpath("//h2/following-sibling::p[4]")).getText());
        double totalActualPrice = Double.parseDouble(part1) + Double.parseDouble(part2);
        double totalExpectedPrice = Double.parseDouble(getPrice(driver.findElement(By.xpath("//h2/following-sibling::p[5]")).getText()));
        assertEquals(totalActualPrice, totalExpectedPrice);

        //fill and submit form
        fillForm(selector, data);
        WebElement selectCard = driver.findElement(By.cssSelector("#cardType"));
        Select selectTestCard = new Select(selectCard);
        selectTestCard.selectByValue("amex");
        driver.findElement(By.cssSelector(".btn.btn-primary")).click();

        //check final page
        wait.until(ExpectedConditions.titleIs("BlazeDemo Confirmation"));
        wait.until(ExpectedConditions.textToBePresentInElement(By.xpath("//h1"), "Thank you for your purchase today!"));

        assertTrue(driver.findElement(By.xpath("//table//tr[1]/td[2]")).isDisplayed());
        assertTrue(driver.findElement(By.xpath("//table//tr[2]/td[2]")).isDisplayed());
        assertEquals(driver.findElement(By.xpath("//table//tr[3]/td[2]")).getText(), "USD");
        assertEquals(driver.findElement(By.xpath("//table//tr[4]/td[2]")).getText(), getCardNumber(data[5]));

        /** These two checks found a bug - pre-filled fields "#creditCardMonth", "#creditCardYear"
         * from http://blazedemo.com/purchase.php page should clean after user clicks on them. They didn't
         *
         assertEquals(driver.findElement(By.xpath("//table//tr[5]/td[2]")).getText(), data[6] + "/" + data[7]);
         assertTrue(driver.findElement(By.xpath("//table//tr[7]/td[2]")).isDisplayed());
         */
    }

    @DataProvider(name = "testData")
    public Object[][] dataProvider(){
        return new Object[][]{{"San Diego", "Dublin"}, {"Paris", "Berlin"}};
    }

}
