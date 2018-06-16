package htmlElements;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;

public class SearchArrow extends HtmlElement {

    @FindBy(id="text")
    private TextInput searchInput;

    @FindBy(css="button[type='submit']")
    private Button searchButton;

    public void searchFor(String text) {
        searchInput.clear();
        searchInput.sendKeys(text);
        searchButton.click();
    }
}
