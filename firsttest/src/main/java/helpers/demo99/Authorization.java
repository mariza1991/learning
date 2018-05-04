package helpers.demo99;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;

import java.util.Map;
import java.util.Set;
import static utils.WebdriverManager.getDriver;

public class Authorization {

  //  Map<String, Set<Cookie>> userCookies = new HashMap <>();

    //TODO: update lang settings and other for this method
    public void authorizeMe(String username, String password){
    /**    Set<Cookie> userCookies = userCookies.get(username);
        if(userCookies == null) {
            getInstance().findElement(By.name("username")).sendKeys("my@email.com");
            getInstance().findElement(By.name("password")).sendKeys("password");
            getInstance().findElement(By.name("submit")).click();
            Set<Cookie> cookies = getInstance().manage().getCookies();
            userCookies.put(username,cookies);
        } else {
            userCookies.forEach(cookie -> getInstance().manage().addCookie(cookie));
        }*/
    }
}
