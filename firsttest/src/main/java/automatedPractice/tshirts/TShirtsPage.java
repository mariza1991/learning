package automatedPractice.tshirts;

import automatedPractice.tshirts.components.ResultsBlock;
import basePage.BasePage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static utils.WebdriverManager.getDriver;

public class TShirtsPage extends BasePage {

    ResultsBlock results;

    public String getResultsHeader(){
        results = new ResultsBlock();
        return results.getTextFromHeader();
    }

    public String getBannerText(){
        results = new ResultsBlock();
        return results.getTextFromBanner();
    }

    public void resultsIsDisplayed(){
        results = new ResultsBlock();
        new WebDriverWait(getDriver(), getTimeout()).until(
                ExpectedConditions.visibilityOf(results.getHeader())
        );
        try {
            new WebDriverWait(getDriver(), getTimeout()).until(
                    ExpectedConditions.numberOfElementsToBe(results.getFoundedResults(), 1)
            );
        } catch (Exception ex) {
           ex.printStackTrace();
        }
    }
}
