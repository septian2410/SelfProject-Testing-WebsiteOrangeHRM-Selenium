package selfProject.panduseptiandito.drivers.strategies;

import org.openqa.selenium.WebDriver;
import selfProject.panduseptiandito.drivers.managers.ChromeDriverManager;
import selfProject.panduseptiandito.drivers.utils.BrowserType;

public class DriverStrategyImplementer implements IDriverStrategy {

    @Override
    public WebDriver setStrategy(String strategy) {
        switch (strategy) {
            case BrowserType.CHROME:
                return ChromeDriverManager.make();
        }
        return null;
    }
}
