package automatedPractice.menu.components;

import components.IComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static utils.WebdriverManager.getDriver;

public class TShirtBlock implements IComponent {

    private final static By TSHIRT_MAIN_HOVER = By.xpath("//*[@id='block_top_menu']/ul/li[3]");

    private final static By TSHIRT_LINK = By.xpath("./a");

    public String defineTshirtsBtnColor(){
        WebElement tshirtsButton = getRootElement().findElement(TSHIRT_LINK);
        return tshirtsButton.getCssValue("background-color");
    }

    public WebElement getRootElement() {
        return getDriver().findElement(TSHIRT_MAIN_HOVER);
    }
}
