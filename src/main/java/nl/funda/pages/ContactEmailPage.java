package nl.funda.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static nl.funda.helpers.WebElementUtils.getText;

public class ContactEmailPage extends BasePage {

    @FindBy(className = "object-header__title")
    private WebElement title;

    public ContactEmailPage(final WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getTitleText() {
        return getText(title);
    }
}
