package tooltip.pages;

import basePage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static utils.WebdriverManager.getDriver;

public class TooltipPage extends BasePage {

    private static final By IFRAME = By.cssSelector(".demo-frame");

    private static final By AGE_INPUT = By.cssSelector("#age");

    private static final By TOOLTIP = By.xpath("//div[@role='tooltip']");

    public void switchToIframe() {
        WebElement iFrame = getDriver().findElement(IFRAME);
        getDriver().switchTo().frame(iFrame);
    }

    public void hoverYourAgeInput() {
        WebElement ageInput = getDriver().findElement(AGE_INPUT);
        Actions actions = new Actions(getDriver());
        actions.moveToElement(ageInput).build().perform();
    }

    public void waitTooltipIsDesplayed() {
        WebElement tooltip = getDriver().findElement(TOOLTIP);
        new WebDriverWait(getDriver(), getTimeout()).until(
                ExpectedConditions.visibilityOf(tooltip)
        );
    }

    public String getTooltipText() {
        WebElement tooltip = getDriver().findElement(TOOLTIP);
        return tooltip.getText();
    }
}
