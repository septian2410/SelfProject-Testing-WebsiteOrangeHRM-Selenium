package selfProject.panduseptiandito.hooks;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import selfProject.panduseptiandito.DriverSingleton;
import selfProject.panduseptiandito.drivers.utils.BrowserType;

public class Hook {

//    Chrome testing
    @BeforeTest
    public static void init() {
        System.out.println("Initializing driver...");
        DriverSingleton.getDriver(BrowserType.CHROME);
    }

    @AfterTest
    public static void teardown() {
        System.out.println("Quitting driver...");
        DriverSingleton.quitDriver();
    }

}
