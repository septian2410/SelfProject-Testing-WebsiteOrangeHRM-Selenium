package selfProject.panduseptiandito.drivers.utils;

public class BrowserType {

    public static final String CHROME = "chrome";

    // mencegah instantiate (constractor)
    private BrowserType(){
        throw new UnsupportedOperationException("This is a constant class and cannot be instantiate");
    }

}
