package Auto.Utility;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;

import static org.apache.logging.log4j.LogManager.getLogger;

public class DriverFactory {
    private static Logger logger = getLogger(DriverFactory.class.getName());

    public WebDriver getDriver(String browser)
    {

        if (browser == null)
            browser = "chrome";
        logger.info("# WebDriver instance for browser: " + browser);

        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
            return new ChromeDriver();
        }
        else if (browser.equalsIgnoreCase("ie")) {
        System.setProperty("webdriver.ie.driver", "src/drivers/IEDriverServer.exe");
        return new InternetExplorerDriver();
    }   else {
        System.setProperty("webdriver.gecko.driver","src/drivers/geckodriver.exe");
            return new FirefoxDriver();
        }
    }

}