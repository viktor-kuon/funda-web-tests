package nl.funda.pages;

import org.openqa.selenium.WebDriver;

public abstract class BasePage {

    public static final String BASE_URL = "https://www.funda.nl/";

    protected WebDriver driver;

    public BasePage(final WebDriver driver) {
        this.driver = driver;
    }

    public CookiesPopup onCookiesPopup() {
        return new CookiesPopup(driver);
    }
}
