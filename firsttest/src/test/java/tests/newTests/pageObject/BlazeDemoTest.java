package tests.newTests.pageObject;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tests.newTests.BaseTest;
import tests.newTests.pageObject.pages.Confirmation;
import tests.newTests.pageObject.pages.Index;
import tests.newTests.pageObject.pages.Purchase;
import tests.newTests.pageObject.pages.Reserve;

import java.util.ArrayList;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class BlazeDemoTest extends BaseTest {

    @Test (dataProvider = "testData")
    public void test(String from, String to){
        Index indexPage = new Index(driver);
        assertTrue(indexPage.isInitialized());
        indexPage.chooseFlight(from, to);

        Reserve reservePage = indexPage.submit();
        assertTrue(reservePage.isInitialized(wait));

        String expectedReserveHeader = "Flights from " + from + " to " + to + ":";
        assertEquals(reservePage.getActualHeader(), expectedReserveHeader);

        ArrayList expectedFlightDetails = reservePage.chooseFlight();

        Purchase purchasePage = reservePage.submit();
        assertTrue(purchasePage.isInitialized(wait));

        String expectedPurchaseHeader = "Your flight from " + from + " to " + to + " has been reserved.";
        assertEquals(purchasePage.getActualHeader(), expectedPurchaseHeader);

        purchasePage.checkFlightDetails(expectedFlightDetails);
        purchasePage.checkTotalPrice();

        purchasePage.fillForm("visa");
        Confirmation confirmationPage = purchasePage.submit();
        assertTrue(confirmationPage.isInitialized(wait));


        confirmationPage.checkConfirmation(purchasePage.getExpectedData().get(0).toString(),
                purchasePage.getExpectedData().get(1).toString(),
                purchasePage.getExpectedData().get(2).toString());
    }

    @DataProvider(name = "testData")
    public Object[][] dataProvider(){
        return new Object[][]{{"Portland", "Rome"}};
    }
    //, {"Paris", "Berlin"}
}
