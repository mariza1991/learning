package tests.newTests.expectedConditions;

import org.testng.annotations.Test;
import tests.newTests.BaseTest;
import tooltip.pages.TooltipPage;

import static org.testng.Assert.assertEquals;

public class TooltipTest extends BaseTest {

    @Test
    public void test(){
        driver.get("https://jqueryui.com/tooltip/");
        TooltipPage tooltipPage = new TooltipPage();
        tooltipPage.switchToIframe();
        tooltipPage.hoverYourAgeInput();
        tooltipPage.waitTooltipIsDesplayed();
        String text = tooltipPage.getTooltipText();
        assertEquals(text, "We ask for your age only for statistical purposes.");
    }
}
