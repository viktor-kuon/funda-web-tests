package nl.funda.test;

import nl.funda.helpers.Driver;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

public abstract class BaseTest {

    protected WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = Driver.getDriver();
    }

    @AfterEach
    public void tearDown() {
        Driver.quitDriver();
    }
}
