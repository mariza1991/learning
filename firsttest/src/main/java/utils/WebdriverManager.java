package utils;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class WebdriverManager {

    private static WebDriver driver;

    private static final String PATH_TO_PROPERTIES = "properties/settings.properties";

    private static final String PROXY = PropertyReader.getPropertyFromFile(PATH_TO_PROPERTIES, "proxy");

    public static WebDriver getDriver() {
        String browserName =
                PropertyReader.getPropertyFromFile(PATH_TO_PROPERTIES, "browser");
        if (driver == null) {
            switch (browserName) {
                case "opera":
                    createOperaDriver();
                    break;
                case "mozilla":
                    createFirefoxDriver();
                    break;
                case "chrome":
                    createChromeDriver(false);
                    break;
                case "chrome-headless":
                    createChromeDriver(true);
                    break;
                case "chrome-proxy":
                    createChromeWithProxy();
                    break;
                case "chrome-ssl":
                    createChromeWithSSL();
                    break;
                case "chrome-remote":
                    createChromeRemote();
                    break;
                case "chrome-selenoid":
                    createSelenoidRemote();
                    break;
                case "ie":
                    createIEDriver(); //not working
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

    private static WebDriver createChromeRemote(){
        try {
            driver = new RemoteWebDriver(new URL("http://192.168.0.3:4444/wd/hub"), //my hub address
                    DesiredCapabilities.chrome());
            driver.manage().window().maximize();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }

    private static WebDriver createSelenoidRemote(){
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setBrowserName("chrome");
            capabilities.setVersion("latest");
        //    capabilities.setCapability("enableVNC", "true");

            driver = new RemoteWebDriver(
                    URI.create("http://localhost:4444/wd/hub").toURL(),
                    capabilities
            );
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }

    private static WebDriver createChromeWithSSL(){
        ChromeOptions options = new ChromeOptions();
        options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        driver = new ChromeDriver(options);
        return driver;
    }

    private static WebDriver createChromeWithProxy(){
        Proxy proxy = new Proxy();
        proxy.setHttpProxy(PROXY);

        ChromeOptions options = new ChromeOptions();
        options.setCapability(CapabilityType.PROXY, proxy);
        driver = new ChromeDriver(options);
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
