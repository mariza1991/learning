package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

public class WebdriverManager {

    static WebDriver driver;

    public static WebDriver getInstance(){
        if (driver == null) {
            driver = new ChromeDriver();
        }
        return driver;
    }

    public static WebDriver getDriver(String driverUserChoice) {
        if (driverUserChoice.equals("mozilla")) {
            driver = new FirefoxDriver();
        } else if (driverUserChoice.equals("opera")) {
            OperaOptions oo = new OperaOptions();
            oo.setBinary("E:/Programms/opera/52.0.2871.64/opera.exe");
            driver = new OperaDriver();
        } else if (driverUserChoice.equals("chrome")) {
            driver = new ChromeDriver();
        } else {
            driver = getInstance();
        }
        return driver;
    }
}
