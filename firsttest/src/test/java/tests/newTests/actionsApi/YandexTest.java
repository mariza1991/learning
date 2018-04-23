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
        YandexSearchPage searchPage = new YandexSearchPage();
        PassportPage passpotPage = searchPage.clickOnEmailBlock();
        String aactualColor = passpotPage.getSignInBackgroundColor();
        assertEquals(aactualColor, "rgba()");
        assertTrue(passpotPage.isContentBlockDisplayed());
    }
}
