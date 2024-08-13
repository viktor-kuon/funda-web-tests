package nl.funda.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static nl.funda.helpers.WebElementUtils.click;

public class CookiesPopup extends BasePage {

    @FindBy(id = "didomi-notice-agree-button")
    private WebElement acceptAllCookiesButton;

    public CookiesPopup(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public <T extends BasePage> T acceptAllCookies(Class<T> pageClass) {
        click(acceptAllCookiesButton);
        return PageFactory.initElements(driver, pageClass);
    }
}
