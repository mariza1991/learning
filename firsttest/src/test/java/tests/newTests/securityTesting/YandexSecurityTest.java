package tests.newTests.securityTesting;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import testData.XssCheatSheet;
import tests.newTests.BaseTest;
import utils.FileReader;
import yandex.pages.passport.PassportPage;
import yandex.pages.search.YandexSearchPage;

import java.io.IOException;

public class YandexSecurityTest extends BaseTest {

    @Test(dataProvider = "xssTests")
    public void test(String name, String xssQuery){
        driver.get("https://www.yandex.ru/");
        YandexSearchPage searchPage = new YandexSearchPage();
        PassportPage passpotPage = searchPage.clickOnEmailBlock();
        System.out.println(name);
        passpotPage.inputToContentBlockLogin(xssQuery);
    }

    @DataProvider(name = "xssTests")
    protected Object[][] xssDataProvider() throws IOException {
        //load from file + read string ?

    //    Object test = FileReader.readFromFile("src/main/testData/xssCheatSheet.txt");
        String[] lines = XssCheatSheet.myArr;

        Object[][] cheatsheet = new Object[lines.length][2];
        int count = 0;
            for (String line : lines) {
                cheatsheet[count][0] = line;
                count++;
            }

        return cheatsheet;

    //    return new Object[][]{{"email", "<scripr>alert(\"xx\");</script>"}};
    }
}
