package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WebdriverManager {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        String driverFromProperties =
                PropertyReader.getPropertyFromFile("properties/settings.properties", "browser");
        if (driver == null) {
            switch (driverFromProperties) {
                case "opera":
                    createOperaDriver();
                    break;
                case "mozilla":
                    createFirefoxDriver();
                    break;
                case "ie":
                    createIEDriver(); //not working
                    break;
                case "chrome":
                    createChromeDriver(false);
                    break;
                case "chrome-headless":
                    createChromeDriver(true);
                    break;
                    default:
                        createChromeDriver(false);
                        break;
            }
        }
        return driver;
    }

    private static WebDriver createChromeDriver(Boolean headless){
        if (headless) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            driver = new ChromeDriver(options);
        } else {
            driver = new ChromeDriver();
        }
        return driver;
    }

    private static WebDriver createOperaDriver(){
        /**    OperaOptions oo = new OperaOptions();
        oo.setBinary("opera.exe");
        driver = new OperaDriver(oo);*/

        OperaOptions oo = new OperaOptions();
        oo.setBinary("E://Programms/opera/52.0.2871.64/opera.exe");
        driver = new OperaDriver(oo);
        return driver;
    }

    private static WebDriver createFirefoxDriver(){
        driver = new FirefoxDriver();
        return driver;
    }

    private static WebDriver createIEDriver(){
        DesiredCapabilities capability = DesiredCapabilities.internetExplorer();
        capability.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
        driver = new InternetExplorerDriver();
        return driver;
    }
}
