package automatedPractice.menu;

import automatedPractice.menu.components.TShirtBlock;
import automatedPractice.menu.components.WomenBlock;
import automatedPractice.tshirts.TShirtsPage;
import basePage.BasePage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static utils.WebdriverManager.getDriver;

public class MenuPage extends BasePage {

    WomenBlock womenMenu;

    TShirtBlock tshirtsMenu;

    public void openWomenMenu(){
        womenMenu = new WomenBlock();
        womenMenu.hoverWomenMain();
        new WebDriverWait(getDriver(), getTimeout()).until(
                ExpectedConditions.visibilityOf(womenMenu.getWomenMenu())
        );
    }

    public TShirtsPage chooseTshirtsFromMenu(){
        womenMenu = new WomenBlock();
        womenMenu.clickOnTshirtsLink();
        return new TShirtsPage();
    }

    public Boolean tshirtIsActive() {
        tshirtsMenu = new TShirtBlock();
        return tshirtsMenu.defineTshirtsBtnColor().equals("rgba(51, 51, 51, 1)");
    }
}
