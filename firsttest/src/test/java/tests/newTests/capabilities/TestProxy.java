package tests.newTests.capabilities;

import org.testng.annotations.Test;
import tests.newTests.BaseTest;

public class TestProxy extends BaseTest {

    @Test
    public void testProxy(){
        //run with chrome-proxy
        driver.get("https://rutracker.org/forum/index.php"); //proxy, minsk
    }
}
