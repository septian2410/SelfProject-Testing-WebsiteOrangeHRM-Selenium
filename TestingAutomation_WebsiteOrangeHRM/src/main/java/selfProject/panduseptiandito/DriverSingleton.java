package selfProject.panduseptiandito;

import org.openqa.selenium.WebDriver;
import selfProject.panduseptiandito.drivers.strategies.DriverStrategyImplementer;

public class DriverSingleton {

    public static WebDriver driver;

    public static WebDriver getDriver(String browser) {
        if (driver == null) {
            driver = new DriverStrategyImplementer().setStrategy(browser);
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}
