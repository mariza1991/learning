package basePage;

import utils.PropertyReader;

public abstract class BasePage {

    public static int getTimeout() {
        return Integer.parseInt(PropertyReader.getPropertyFromFile("properties/settings.properties", "timeout"));
    }
}
