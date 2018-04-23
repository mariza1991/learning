package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

public class WebdriverManager {

    private static WebDriver driver;

    public static WebDriver getInstance(){
        if (driver == null) {
            createChromeDriver();
        }
        return driver;
    }

    public static WebDriver getDriver(String driverUserChoice) {
        if (driver == null) {
            if (driverUserChoice.equals("mozilla")) {
                createFirefoxDriver();
            } else if (driverUserChoice.equals("opera")) {
                createOperaDriver();
            } else if (driverUserChoice.equals("chrome")) {
                createChromeDriver();
            } else {
                createChromeDriver();
            }
        }
        return driver;
    }

    private static WebDriver createChromeDriver(){
        driver = new ChromeDriver();
        return driver;
    }

    private static WebDriver createOperaDriver(){
        OperaOptions oo = new OperaOptions();
        oo.setBinary("E:/Programms/opera/52.0.2871.64/opera.exe");
        driver = new OperaDriver();
        return driver;
    }

    private static WebDriver createFirefoxDriver(){
        driver = new FirefoxDriver();
        return driver;
    }
}
