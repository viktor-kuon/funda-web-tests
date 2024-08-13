package nl.funda.pages.valueCheck;

import nl.funda.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ValueCheckResultsPage extends BasePage {

    public ValueCheckResultsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
