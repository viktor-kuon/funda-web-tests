package nl.funda.test;

import nl.funda.helpers.SortingOption;
import nl.funda.pages.HomePage;
import nl.funda.pages.ListingsPage;
import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;

import static nl.funda.helpers.Constants.RENT_TYPE;
import static org.junit.jupiter.api.Assertions.*;

public class SearchTests extends BaseTest {

    @Test
    public void searchBuyListingsBySingleLocationFromHomePage() {
        HomePage homePage = new HomePage(driver);
        final String searchLocation = "Amsterdam";
        String searchTagText;
        Boolean locationInTitleIsCorrect;
        Boolean searchResultsContainCorrectLocation;

        ListingsPage listingsPage = homePage.open()
                .onCookiesPopup().acceptAllCookies(HomePage.class)
                .fillSearchBox(searchLocation)
                .selectLocationSuggestion(0);

        searchTagText = listingsPage.getTextOfSearchTag(0);
        locationInTitleIsCorrect = listingsPage.assertLocationInTitle(searchLocation);
        searchResultsContainCorrectLocation = listingsPage.listingsContainCorrectLocations(searchLocation);

        assertAll("Assert location in the search results",
                () -> assertEquals(searchLocation, searchTagText, "Location tag displays incorrect location."),
                () -> assertTrue(locationInTitleIsCorrect, "Incorrect location title."),
                () -> assertTrue(searchResultsContainCorrectLocation, "Listings contain incorrect location.")
        );
    }

    @Test
    public void sortRentListingsByRentPriceAsc() {
        ListingsPage listingsPage = new ListingsPage(driver);

        final Boolean sortedByRentPriceAsc = listingsPage.open(RENT_TYPE)
                .onCookiesPopup().acceptAllCookies(ListingsPage.class)
                .applySorting(SortingOption.PRICE_LOW_TO_HIGH)
                .resultsSortedByRentPriceAsc();

        assertTrue(sortedByRentPriceAsc, "Listings are not sorted by price from low to high.");
    }
}
