package nl.funda.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.atomic.AtomicReference;

import static nl.funda.helpers.WebElementUtils.forceClick;

public class ListingDetailPage extends BasePage{

    @FindBy(css = "h1 span:first-child")
    private WebElement title;

    @FindBy(partialLinkText = "Stuur e-mail")
    private WebElement sendEmailButton;

    public ListingDetailPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public ListingDetailPage rememberTitle(final AtomicReference<String> title) {
        title.set(this.title.getText());
        return this;
    }

    public ContactEmailPage clickSendEmailButton() {
        forceClick(sendEmailButton);
        return new ContactEmailPage(driver);
    }
}
