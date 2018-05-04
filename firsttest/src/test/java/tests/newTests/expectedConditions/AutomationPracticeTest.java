package tests.newTests.expectedConditions;

import automatedPractice.menu.MenuPage;
import automatedPractice.tshirts.TShirtsPage;
import org.testng.annotations.Test;
import tests.newTests.BaseTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static utils.WebdriverManager.getDriver;

public class AutomationPracticeTest extends BaseTest {

    @Test
    public void test(){
        getDriver().get("http://automationpractice.com/index.php");
        MenuPage menu = new MenuPage();
        menu.openWomenMenu();
        TShirtsPage tshirtsPage = menu.chooseTshirtsFromMenu();
        tshirtsPage.resultsIsDisplayed();
        assertTrue(menu.tshirtIsActive());
        assertEquals(tshirtsPage.getResultsHeader(), "T-SHIRTS ");
        assertEquals(tshirtsPage.getBannerText(), "T-shirts");
    }
}
