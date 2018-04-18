package tests.newTests.pageObject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class Reserve extends PageObject {

    @FindBy(css="h3")
    WebElement actualHeader;

    WebElement chooseFlight = this.randomNumber();

    public Reserve(WebDriver driver){
        super(driver);
    }

    public boolean isInitialized(WebDriverWait wait) {
        return wait.until(ExpectedConditions.titleIs("BlazeDemo - reserve"));
    }

    public String getActualHeader(){
        return actualHeader.getText();
    }

    public ArrayList chooseFlight(){
        ArrayList flightDetails = new ArrayList();

        String expectedAirline = chooseFlight.findElement(By.xpath("./td[3]")).getText();
        String expectedFlightNumber = chooseFlight.findElement(By.xpath("./td[2]")).getText();
        String expectedPrice = chooseFlight.findElement(By.xpath("./td[6]")).getText();

        flightDetails.add(expectedAirline);
        flightDetails.add(expectedFlightNumber);
        flightDetails.add(expectedPrice);
        return flightDetails;
    }

    public Purchase submit(){
        chooseFlight.findElement(By.xpath("./td[1]")).click();
        return new Purchase(driver);
    }

    private WebElement randomNumber(){
        Integer chooseRandomFlight = 1 + (int) (Math.random()*5);
        WebElement chooseFlight = driver.findElement(By.xpath("//table/tbody/tr[" + chooseRandomFlight + "]"));
        return chooseFlight;
    }
}
