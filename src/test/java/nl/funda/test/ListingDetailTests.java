package nl.funda.test;

import nl.funda.pages.ListingsPage;
import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;
import java.util.concurrent.atomic.AtomicReference;

import static nl.funda.helpers.Constants.BUY_TYPE;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListingDetailTests extends BaseTest {

    @Test
    public void sendEmailFromListingDetailPage() throws UnsupportedEncodingException {
        final AtomicReference<String> listingTitle = new AtomicReference<>();

        final String expectedAddress = new ListingsPage(driver).open(BUY_TYPE, "Amsterdam")
                .onCookiesPopup().acceptAllCookies(ListingsPage.class)
                .clickNthListing(0)
                .rememberTitle(listingTitle)
                .clickSendEmailButton()
                .getTitleText();

        assertEquals(expectedAddress, listingTitle.get());

        // complete sending an email
    }
}
