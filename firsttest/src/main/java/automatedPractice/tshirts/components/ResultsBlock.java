package automatedPractice.tshirts.components;

import components.IComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utils.WebdriverManager.getDriver;

public class ResultsBlock implements IComponent {

    private final static By RESULTS_BLOCK = By.cssSelector("#center_column");

    private final static By TSHIRTS_BANNER = By.cssSelector("div.cat_desc > span");

    private final static By TSHIRTS_HEADER = By.cssSelector("h1 > span");

    private final static By RESULTS_FOUNDED = By.cssSelector("a.product_img_link > img");

    public String getTextFromHeader() {
        WebElement tshirtsHeader = getRootElement().findElement(TSHIRTS_HEADER);
        return tshirtsHeader.getText();
    }

    public String getTextFromBanner() {
        WebElement tshirtsHeader = getRootElement().findElement(TSHIRTS_BANNER);
        return tshirtsHeader.getText();
    }

    public By getFoundedResults() {
        return RESULTS_FOUNDED;
    }

    public WebElement getHeader() {
        return getRootElement().findElement(TSHIRTS_HEADER);
    }

    public WebElement getRootElement() {
        return getDriver().findElement(RESULTS_BLOCK);
    }
}
