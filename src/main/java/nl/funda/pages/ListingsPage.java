package nl.funda.pages;

import nl.funda.elements.Listing;
import nl.funda.helpers.SortingOption;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

import static nl.funda.helpers.WebElementUtils.*;

public class ListingsPage extends BasePage {

    private static final String LISTING_CSS = "[data-test-id=search-result-item]";

    @FindBy(css = "#tags-container div")
    private List<WebElement> searchTags;

    @FindBy(css = "[data-test-id=sorting-dropdown]")
    private WebElement sortingDropdown;

    @FindBy(css = "h1 div:nth-child(2)")
    private WebElement locationTitle;

    @FindBy(css = LISTING_CSS)
    private List<WebElement> listings;

    public ListingsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public ListingsPage open(String pageType, String... selectedAreas) throws UnsupportedEncodingException {
        String url = buildSearchUrl(pageType, selectedAreas);
        driver.get(url);
        return this;
    }

    public String getTextOfSearchTag(final int index) {
        final int searchTagsNumber = getSize(searchTags);
        if (searchTagsNumber <= index) {
            throw new IllegalArgumentException(String.format("Unable to find search tag with index %d. " +
                    "Total number of search tags is %d.", index, searchTagsNumber));
        }
        return getText(searchTags, index);
    }

    public Boolean assertLocationInTitle(final String location) {
        return getText(locationTitle).contains(location);
    }

    public List<Listing> getListings() {
        List<WebElement> listings = driver.findElements(By.cssSelector(LISTING_CSS));

        return listings.stream()
                .map(item -> new Listing(item, driver))
                .collect(Collectors.toList());
    }

    public Boolean listingsContainCorrectLocations(String... locations) {
        for (Listing item : getListings()) {
            String postalCodeAndCity = item.getPostalCodeAndCity();
            boolean containsExpectedLocation = false;

            for (String location : locations) {
                if (postalCodeAndCity.contains(location)) {
                    containsExpectedLocation = true;
                    break;
                }
            }

            if (!containsExpectedLocation) {
                return false;
            }
        }

        return true;
    }

    public ListingDetailPage clickNthListing(final int index) {
        final List<Listing> listings = getListings();
        final int listingsNumber = listings.size();

        if (listingsNumber <= index) {
            throw new IllegalArgumentException(String.format("Unable to find listing with index %d. " +
                    "Total number of listings is %d.", index, listingsNumber));
        }

        return listings.get(index).clickStreetAndHouseNumber();
    }

    public ListingsPage applySorting(final SortingOption sortingOption) {
        selectByValue(sortingDropdown, sortingOption.getValue());
        verifyAttributeToBe(sortingDropdown, "value", sortingOption.getValue());
        return new ListingsPage(driver);
    }

    public Boolean resultsSortedByRentPriceAsc() {
        List<Listing> listings = getListings();
        int size = listings.size();

        for (int i = 0; i < size - 1; i++) {
            try{
                String currentRentPriceString = listings.get(i).getRentPrice();
                String nextRentPriceString = listings.get(i + 1).getRentPrice();

                int currentRentPriceNumeric = getNumericPrice(currentRentPriceString);
                int nextRentPriceNumeric = getNumericPrice(nextRentPriceString);

                if (currentRentPriceNumeric > nextRentPriceNumeric) {
                    return false;
                }
            }
            catch (StaleElementReferenceException e) {
                listings = getListings();
                size = listings.size();
                i = -1;
            }
        }

        return true;
    }

    private String buildSearchUrl(String pageType, String... selectedAreas) throws UnsupportedEncodingException {
        String encodedAreas = URLEncoder.encode(String.format("[%s]", String.join(",", selectedAreas)), StandardCharsets.UTF_8.toString());

        return String.format("%szoeken/%s?selected_area=%s", BASE_URL, pageType, encodedAreas);
    }

    private int getNumericPrice(String priceString) {
        String priceNumeric = priceString.replaceAll("\\D", "");
        return Integer.parseInt(priceNumeric);
    }
}
