package nl.funda.pages;

import nl.funda.helpers.WebElementDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static nl.funda.helpers.WebElementUtils.click;
import static nl.funda.helpers.WebElementUtils.getText;

public class Listing {

    private final WebDriver driver;

    @FindBy(css = "[data-test-id=street-name-house-number]")
    private WebElement streetAndHouseNumber;

    @FindBy(css = "[data-test-id=postal-code-city]")
    private WebElement postalCodeAndCity;

    @FindBy(css = "[data-test-id=price-rent]")
    private WebElement rentPrice;

    public Listing(final WebElement rootElement, final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new WebElementDecorator(rootElement), this);
    }

    public ListingDetailPage clickStreetAndHouseNumber() {
        click(streetAndHouseNumber);
        return new ListingDetailPage(driver);
    }

    public String getPostalCodeAndCity() {
        return getText(postalCodeAndCity);
    }

    public String getRentPrice() {
        return getText(rentPrice);
    }
}
