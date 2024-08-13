package nl.funda.test;

import nl.funda.helpers.Home;
import nl.funda.pages.Header;
import nl.funda.pages.HomePage;
import nl.funda.pages.valueCheck.ValueCheckFeaturesPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SellerTests extends BaseTest {

    @Test
    public void checkYourHomeValue() {
        Home myHome = new Home(
                "1062 KS",
                182,
                "Koningin Wilhelminaplein",
                "Amsterdam",
                2007,
                90
        );

        ValueCheckFeaturesPage valueCheckFeaturesPage = new HomePage(driver).open()
                .onCookiesPopup().acceptAllCookies(Header.class)
                .clickSellButton()
                .clickPlaceYouHouseOnFundaLink()
                .clickDoValueCheckButton()
                .fillAddress(myHome)
                .verifyAddressResponse(myHome.getFullAddress())
                .clickAddMyHouseButton()
                .clickAppartmentRadioButton()
                .clickNextButton();

        assertAll("Correct values are pre-populated.",
                () -> assertEquals(myHome.getYearOfConstruction(), valueCheckFeaturesPage.getYearOfConstruction(), "Year of construction is incorrect."),
                () -> assertEquals(myHome.getLivingArea(), valueCheckFeaturesPage.getlivingArea(), "Living area is incorrect.")
        );

        valueCheckFeaturesPage
                .clickNextButton()
                .clickModerateTypeRadioButton()
                .clickNextButton();

        // Results verification
    }
}
