package blazedemo.pages.login.components;

import components.IComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static utils.WebdriverManager.getDriver;
import static utils.WebdriverManager.getDriver;

public class LoginBlock implements IComponent {

    private final static By LOGIN_BLOCK = By.cssSelector(".panel.panel-default");

    private final static By LOGIN_BLOCK_HEADER = By.className("panel-heading");

    private final static By LOGIN_BLOCK_EMAIL_INPUT = By.id("email");

    private final static By LOGIN_BLOCK_PASSWORD_INPUT = By.id("password");

    private final static By LOGIN_BUTTON = By.cssSelector("[class*='btn']");

    public void moveMouseToLoginBtn(){
        Actions moveMouseToLoginBtn = new Actions(getDriver());
        WebElement loginBtn = getRootElement().findElement(LOGIN_BUTTON);
        moveMouseToLoginBtn.moveToElement(loginBtn).perform();
    }

    public Dimension defineLoginBtnSize(){
        WebElement loginButton = getRootElement().findElement(LOGIN_BUTTON);
        return loginButton.getSize();
    }

    public String defineLoginBtnColor(){
        WebElement loginButton = getRootElement().findElement(LOGIN_BUTTON);
        return loginButton.getCssValue("background-color");
    }

    public WebElement getRootElement() {
        return getDriver().findElement(LOGIN_BLOCK);
    }
}
