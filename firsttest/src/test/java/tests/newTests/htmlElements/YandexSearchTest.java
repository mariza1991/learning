package tests.newTests.htmlElements;

import htmlElements.ResultPage;
import htmlElements.SearchPage;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class YandexSearchTest {

    @Test
    public void test(){
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.yandex.ru");
        SearchPage searchPage = new SearchPage(driver);
        ResultPage resultPage = searchPage.searchFor("otus");
        assertEquals(resultPage.getResults().size(), 11);
        driver.quit();
    }
}
