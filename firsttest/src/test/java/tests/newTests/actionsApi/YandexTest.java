package tests.newTests.actionsApi;

import org.testng.annotations.Test;
import tests.newTests.BaseTest;
import yandex.pages.passport.PassportPage;
import yandex.pages.search.YandexSearchPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class YandexTest extends BaseTest {

    @Test
    public void test(){
        driver.get("https://www.yandex.ru/");
        assertTrue(false);
        YandexSearchPage searchPage = new YandexSearchPage();
        PassportPage passpotPage = searchPage.clickOnEmailBlock();
        String aactualColor = passpotPage.getSignInBackgroundColor();
        assertEquals(aactualColor, "rgba(0, 0, 0, 0)");
        assertTrue(passpotPage.isContentBlockDisplayed());
    }
}
