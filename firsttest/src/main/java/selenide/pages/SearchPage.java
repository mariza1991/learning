package selenide.pages;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.matchesText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class SearchPage {

    public void resultAppeared(){
        $x("//div[@class='srg']").shouldBe(visible);
    }

    public void resultQuantity(int quantity){
        $$x("//div[@class='g']").shouldHave(size(quantity));
    }

    public void firstStringContains(String query){
        $$x("//div[@class='g']").get(0).should(matchesText(query));
    }
}
