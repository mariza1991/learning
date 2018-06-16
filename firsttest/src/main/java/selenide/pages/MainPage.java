package selenide.pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

public class MainPage {

    private static final By INPUT_SEARCH = By.xpath("//*[@id='lst-ib']");

    public MainPage openMainPage() {
        open("https://google.com");
        return this;
    }

    public SearchPage inputQuery(String query){
        $x("//*[@id='lst-ib']").setValue(query).pressEnter();
        return page(SearchPage.class);
    }
}
