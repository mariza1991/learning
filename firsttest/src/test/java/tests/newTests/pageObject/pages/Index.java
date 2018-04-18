package tests.newTests.pageObject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class Index extends PageObject {

    @FindBy(name="fromPort")
    WebElement fromPortSelect;

    @FindBy(name="toPort")
    WebElement toPortSelect;

    @FindBy(css="input.btn.btn-primary")
    WebElement submitButton;

    public Index(WebDriver driver){
        super(driver);
    }

    public boolean isInitialized() {
        driver.get("http://blazedemo.com/index.php");
        return fromPortSelect.isDisplayed();
    }

    public void chooseFlight(String from, String to) {
        Select selectFrom = new Select(fromPortSelect);
        selectFrom.selectByValue(from);
        Select selectTo = new Select(toPortSelect);
        selectTo.selectByValue(to);
    }

    public Reserve submit(){
        submitButton.click();
        return new Reserve(driver);
    }
}
