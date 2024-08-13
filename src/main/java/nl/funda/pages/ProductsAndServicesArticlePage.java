package nl.funda.pages;

import nl.funda.pages.valueCheck.ValueCheckAddressPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static nl.funda.helpers.WebElementUtils.forceClick;

public class ProductsAndServicesArticlePage extends BasePage {

    @FindBy(partialLinkText = "Doe de Waardecheck")
    private WebElement doValueCheckButton;

    public ProductsAndServicesArticlePage(final WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public ValueCheckAddressPage clickDoValueCheckButton() {
        forceClick(doValueCheckButton);
        return new ValueCheckAddressPage(driver);
    }
}
