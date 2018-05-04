package automatedPractice.menu.components;

import components.IComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static utils.WebdriverManager.getDriver;

public class WomenBlock implements IComponent {

    private final static By WOMEN_MAIN_HOVER = By.xpath("//*[@id='block_top_menu']/ul/li[1]");

    private final static By WOMEN_MENU = By.xpath("./ul[contains(@class, 'first-in-line-xs')]");

    private final static By TSHIRTS_LINK = By.xpath(".//a[@title='T-shirts']");

    public void hoverWomenMain() {
        Actions moveMouthToWomenMainHover = new Actions(getDriver());
        WebElement womenMainHover = getRootElement().findElement(WOMEN_MAIN_HOVER);
        moveMouthToWomenMainHover.moveToElement(womenMainHover).perform();
    }

    public void clickOnTshirtsLink() {
        WebElement tshirtLink = getRootElement().findElement(TSHIRTS_LINK);
        tshirtLink.click();
    }

    public WebElement getWomenMenu() {
        return getRootElement().findElement(WOMEN_MENU);
    }

    public WebElement getRootElement() {
        return getDriver().findElement(WOMEN_MAIN_HOVER);
    }
}
