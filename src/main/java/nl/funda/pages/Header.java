package nl.funda.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static nl.funda.helpers.WebElementUtils.click;

public class Header extends BasePage {

    @FindBy(xpath = "(//div//button[span[text()='Verkopen']])[2]")
    private WebElement sellButton;

    @FindBy(partialLinkText = "Plaats je huis op funda")
    private WebElement placeYourHouseOnFundaLink;

    @FindBy(xpath = "//button[span[text()='Inloggen']]")
    private WebElement loginButton;

    public Header(final WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public LoginPage clickLoginButton() {
        click(loginButton);
        return new LoginPage(driver);
    }

    public Header clickSellButton() {
        click(sellButton);
        return this;
    }

    public ProductsAndServicesArticlePage clickPlaceYouHouseOnFundaLink() {
        click(placeYourHouseOnFundaLink);
        return new ProductsAndServicesArticlePage(driver);
    }
}
