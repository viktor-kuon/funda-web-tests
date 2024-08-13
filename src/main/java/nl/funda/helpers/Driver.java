package nl.funda.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class Driver {

    private static WebDriver driver;
    private static Properties props;

    private Driver() {
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            initializeDriver();
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    private static void initializeDriver() {
        loadProperties();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("user-agent=" + props.getProperty("user_agent"));
        options.addArguments("--disable-search-engine-choice-screen");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    private static void loadProperties() {
        if (props == null) {
            props = new Properties();
            try (FileInputStream file = new FileInputStream("config")) {
                props.load(file);
            } catch (IOException e) {
                throw new RuntimeException("Failed to load configuration file", e);
            }
        }
    }
}
