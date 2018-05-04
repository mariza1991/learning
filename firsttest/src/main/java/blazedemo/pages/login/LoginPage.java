package blazedemo.pages.login;

import blazedemo.pages.login.components.LoginBlock;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.Actions;
import blazedemo.pages.BasePage;

public class LoginPage extends BasePage {

    LoginBlock loginBlock;

    public String getLoginHoverStateColor(){
        loginBlock = new LoginBlock();
        loginBlock.moveMouseToLoginBtn();
        return loginBlock.defineLoginBtnColor();
    }

    public Dimension getLoginHoverStateSize(){
        loginBlock = new LoginBlock();
        loginBlock.moveMouseToLoginBtn();
        return loginBlock.defineLoginBtnSize();
    }

    public Dimension getLoginNormalStateSize(){
        loginBlock = new LoginBlock();
        return loginBlock.defineLoginBtnSize();
    }
}
