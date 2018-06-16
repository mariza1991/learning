package selenide;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.conditions.Text;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.codeborne.selenide.Configuration;
import selenide.pages.MainPage;
import selenide.pages.SearchPage;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Condition.matchesText;

public class GoogleSearchTest {

    @BeforeMethod
    public void before(){
        Configuration.browser = "chrome";
        WebDriverManager.chromedriver().setup();
    }

    @Test
    public void googleTest(){
        open("https://google.com");
        $x("//*[@id='lst-ib']").setValue("selenide").pressEnter();
        $x("//div[@class='srg']").shouldBe(visible);

        $$x("//div[@class='g']").shouldHave(size(10));
        $$x("//div[@class='g']").get(0).should(matchesText("selenide"));
    }

    @Test
    public void refactoring(){
        MainPage main = new MainPage();
        main.openMainPage();
        SearchPage search = main.inputQuery("selenide");
        search.resultAppeared();
        search.resultQuantity(10);
        search.firstStringContains("selenide");
    }
}
