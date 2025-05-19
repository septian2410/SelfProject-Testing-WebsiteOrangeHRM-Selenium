package selfProject.panduseptiandito.pages;

import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static selfProject.panduseptiandito.DriverSingleton.driver;
import static selfProject.panduseptiandito.drivers.utils.TimeDuration.THREE;
import static selfProject.panduseptiandito.drivers.utils.TimeDuration.TWO;

public class PageDashboard {

    private WebDriverWait wait;

    public PageDashboard(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    private void Delay (int miliseconds) {
        try{
            Thread.sleep(miliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Delay interrupted: "+e.getMessage());
        }
    }

//    Locator
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[3]/p[1]")
    WebElement labelCopyRight;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a")
    WebElement buttonMenuAdmin;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[2]/a")
    WebElement buttonMenuPIM;

//    @FindBy(xpath = "//span[text()='PIM']/parent::a")
//    WebElement buttonMenuPIM;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[3]/a")
    WebElement buttonMenuLeave;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[3]/ul/li/span/p")
    WebElement dropDownProfil;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[3]/ul/li/ul/li[4]/a")
    WebElement buttonLogout;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/aside")
    WebElement asideDashboardPage;

// Action
    public void clickMenuAdmin(){
//        waitDashboardPage();
//        By menuAdminLocator = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a");
//        WebElement buttonMenuAdmin = wait.until(
//                ExpectedConditions.presenceOfElementLocated(menuAdminLocator)
//        );
//        wait.until(ExpectedConditions.visibilityOf(buttonMenuAdmin));
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", buttonMenuAdmin);
//        wait.until(ExpectedConditions.elementToBeClickable(buttonMenuAdmin)).click();

        waitDashboardPage();
        By menuAdminLocator = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a");

        // Retry mechanism untuk handle stale element
        int attempts = 0;
        while (attempts < 3) {
            try {
                // Gabungkan semua kondisi wait dalam satu statement
                WebElement buttonMenuAdmin = wait.until(ExpectedConditions.elementToBeClickable(menuAdminLocator));

                // Scroll hanya jika benar-benar diperlukan
                ((JavascriptExecutor) driver).executeScript(
                        "arguments[0].scrollIntoView({behavior: 'auto', block: 'center', inline: 'center'});",
                        buttonMenuAdmin
                );

                // Click menggunakan JavaScript sebagai fallback
                try {
                    buttonMenuAdmin.click();
                } catch (Exception e) {
                    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", buttonMenuAdmin);
                }

                // Tunggu kondisi setelah click (lebih baik daripada delay statis)
                wait.until(ExpectedConditions.urlContains("admin")); // Ganti dengan kondisi yang sesuai
                return;

            } catch (StaleElementReferenceException e) {
                attempts++;
                if (attempts == 3) throw e;
            }
        }

        Delay(TWO);
    }
    public void clickMenuPIM(){
//        waitDashboardPage();
//        By menuPimLocator = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[2]/a");
//        WebElement buttonPimLocator = wait.until(
//                ExpectedConditions.presenceOfElementLocated(menuPimLocator)
//        );
//        wait.until(ExpectedConditions.visibilityOf(buttonPimLocator));
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", buttonPimLocator);
//        wait.until(ExpectedConditions.elementToBeClickable(buttonPimLocator)).click();


        waitDashboardPage();
        By menuPimLocator = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[2]/a");

        // Retry mechanism untuk handle stale element
        int attempts = 0;
        while (attempts < 3) {
            try {
                // Gabungkan semua kondisi wait dalam satu statement
                WebElement buttonPimLocator = wait.until(ExpectedConditions.elementToBeClickable(menuPimLocator));

                // Scroll hanya jika benar-benar diperlukan
                ((JavascriptExecutor) driver).executeScript(
                        "arguments[0].scrollIntoView({behavior: 'auto', block: 'center', inline: 'center'});",
                        buttonPimLocator
                );

                // Click menggunakan JavaScript sebagai fallback
                try {
                    buttonPimLocator.click();
                } catch (Exception e) {
                    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", buttonPimLocator);
                }

                // Tunggu kondisi setelah click (lebih baik daripada delay statis)
                wait.until(ExpectedConditions.urlContains("pim")); // Ganti dengan kondisi yang sesuai
                return;

            } catch (StaleElementReferenceException e) {
                attempts++;
                if (attempts == 3) throw e;
            }
        }
        Delay(TWO);

//                for (int i = 0; i < 3; i++) { // Retry maksimal 3 kali
//            try {
//                WebElement menuPIM = wait.until(ExpectedConditions.elementToBeClickable(buttonMenuPIM));
//                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", menuPIM);
//                menuPIM.click();
//                break; // Jika berhasil, keluar dari loop
//            } catch (StaleElementReferenceException e) {
//                System.out.println("Elemen stale, mencoba lagi...");
//                if (i == 2) throw e; // Lempar exception jika retry ke-3 gagal
//            }
//        }
    }
    public void clickMenuLeave(){
        waitDashboardPage();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", buttonMenuLeave);
        wait.until(ExpectedConditions.elementToBeClickable(buttonMenuLeave)).click();
        Delay(TWO);
    }
    public void clickProfil(){
        dropDownProfil.click();
        Delay(TWO);
    }
    public void clickLogout(){
        buttonLogout.click();
        Delay(TWO);
    }


//  ShowElements
    public void waitDashboardPage() {
        By locator = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside");
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

//   validation
    public String getMsgLogin(){
        waitDashboardPage();

        String validation = labelCopyRight.getText();
        return validation;
    }

}
