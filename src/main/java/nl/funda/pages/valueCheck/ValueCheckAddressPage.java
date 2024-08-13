package nl.funda.pages.valueCheck;

import nl.funda.helpers.Home;
import nl.funda.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static nl.funda.helpers.WebElementUtils.*;

public class ValueCheckAddressPage extends BasePage {

    @FindBy(id = "address-postalcode")
    private WebElement postalCodeInput;

    @FindBy(id = "address-number")
    private WebElement houseNumberInput;

    @FindBy(css = "[data-test-id=address-response]")
    private WebElement addressResponse;

    @FindBy(css = "[data-test-id=address-submit]")
    private WebElement addMyHouseButton;

    public ValueCheckAddressPage(final WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public ValueCheckAddressPage fillAddress(final Home address) {
        fillText(postalCodeInput, address.getPostalCode());
        fillText(houseNumberInput, String.valueOf(address.getHouseNumber()));
        return this;
    }

    public ValueCheckAddressPage verifyAddressResponse(final String text) {
        verifyTextToBePresent(addressResponse, text);
        return this;
    }

    public ValueCheckHomeTypePage clickAddMyHouseButton() {
        click(addMyHouseButton);
        return new ValueCheckHomeTypePage(driver);
    }
}
