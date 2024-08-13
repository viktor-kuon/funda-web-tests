package nl.funda.pages.valueCheck;

import nl.funda.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static nl.funda.helpers.WebElementUtils.click;

public class ValueCheckConditionPage extends BasePage {

    @FindBy(css = "[for=buildingType-poor]")
    private WebElement moderateTypeRadioButton;

    @FindBy(xpath = "//button[contains(text(),'Volgende')]")
    private WebElement nextButton;

    public ValueCheckConditionPage(final WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public ValueCheckConditionPage clickModerateTypeRadioButton() {
        click(moderateTypeRadioButton);
        return this;
    }

    public ValueCheckResultsPage clickNextButton() {
        click(nextButton);
        return new ValueCheckResultsPage(driver);
    }
}
