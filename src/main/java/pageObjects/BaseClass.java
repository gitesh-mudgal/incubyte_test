package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.logging.Level;

public class BaseClass {

    public static WebDriver driver;

    public static void startBrowser(){

            System.setProperty("java.util.logging.config.file", "logging.properties");
            ChromeOptions options = new ChromeOptions();
            LoggingPreferences logs = new LoggingPreferences();

            logs.enable(LogType.BROWSER, Level.ALL);
            logs.enable(LogType.DRIVER, Level.ALL);
            options.setCapability("goog:loggingPrefs", logs);
            options.addArguments("--remote-allow-origins=*");

            System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "target/chromedriver.log");
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();

    }
    public static void tearDown() {
            driver.close();
    }
    public static void wait(String xpath){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }
}
