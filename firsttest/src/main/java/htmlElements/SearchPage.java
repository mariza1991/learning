package htmlElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

public class SearchPage {

    private WebDriver driver;

    @FindBy(css="div.home-arrow__search")
    private SearchArrow searchArrow;

    public SearchPage(WebDriver driver){
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(driver)), this);
        this.driver = driver;
    }

    public ResultPage searchFor(String request){
        searchArrow.searchFor(request);
        return new ResultPage(driver);
    }
}
