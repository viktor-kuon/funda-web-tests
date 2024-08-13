package nl.funda.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static nl.funda.helpers.WebElementUtils.*;

public class HomePage extends BasePage {

    @FindBy(css = "[data-testid='search-box']")
    private WebElement searchBox;

    @FindBy(css = "[data-testid=SearchBox-location-suggestion")
    private List<WebElement> locationSuggestions;

    public HomePage(final WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public HomePage open() {
        driver.get(BASE_URL);
        return this;
    }

    public HomePage fillSearchBox(final String text) {
        fillText(searchBox, text);
        return this;
    }

    public ListingsPage selectLocationSuggestion(final int index) {
        final int locationSuggestionsSize = getSize(locationSuggestions);
        if (locationSuggestionsSize <= index) {
            throw new IllegalArgumentException(String.format("Unable to find location suggestion with index %d. " +
                    "Total number of suggestions is %d.", index, locationSuggestionsSize));
        }
        click(locationSuggestions, index);
        return new ListingsPage(driver);
    }
}
