package yandex.pages.search;

import basePage.BasePage;
import yandex.pages.passport.PassportPage;
import yandex.pages.search.components.EmailBlock;

public class YandexSearchPage extends BasePage {

    EmailBlock emailBlock;

    public PassportPage clickOnEmailBlock(){
        emailBlock = new EmailBlock();
        emailBlock.clickOnEnterToEmailButton();
        return new PassportPage();
    }
}
