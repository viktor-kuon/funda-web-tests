package nl.funda.pages.valueCheck;

import nl.funda.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;
import static nl.funda.helpers.WebElementUtils.*;

public class ValueCheckFeaturesPage extends BasePage {

    @FindBy(id = "year-of-construction")
    private WebElement yearOfConstructionInput;

    @FindBy(id = "floor-area")
    private WebElement livingAreaInput;

    @FindBy(xpath = "//button[contains(text(),'Volgende')]")
    private WebElement nextButton;

    public ValueCheckFeaturesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public int getYearOfConstruction() {
        return parseInt(getAttributeValue(yearOfConstructionInput,"value"));
    }

    public float getlivingArea() {
        return parseFloat(getAttributeValue(livingAreaInput,"value"));
    }

    public ValueCheckConditionPage clickNextButton() {
        click(nextButton);
        return new ValueCheckConditionPage(driver);
    }
}
