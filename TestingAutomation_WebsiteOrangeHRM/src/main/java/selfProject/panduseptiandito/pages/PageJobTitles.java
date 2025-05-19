package selfProject.panduseptiandito.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;

import static selfProject.panduseptiandito.DriverSingleton.driver;
import static selfProject.panduseptiandito.drivers.utils.TestUtils.waitForElementToClose;
import static selfProject.panduseptiandito.drivers.utils.TimeDuration.TWO;

public class PageJobTitles {

    private WebDriverWait wait;

    public PageJobTitles(WebDriver driver){
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

//    MAIN DASHBOARD
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div[1]/div/button")
    WebElement btnAddJobTitles;
    @FindBy(xpath = "//div[@id='oxd-toaster_1']/div/div/div[2]/p[2]")
    WebElement verifyUserSucces;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div[2]/div/span")
    WebElement lblResultSearch;

    public void actionEditJobData(WebDriver driver, String job){
        String xpath = String.format(
                "//div[text()='%s']/ancestor::div[contains(@class,'oxd-table-row')]//i[contains(@class,'bi-pencil-fill')]",
                job
        );
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement editButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        editButton.click();
        Delay(TWO);
    }
    public void actionDeleteJobData(WebDriver driver, String job){
        String xpath = String.format(
                "//div[text()='%s']/ancestor::div[contains(@class,'oxd-table-row')]//i[contains(@class,'bi-trash')]",
                job
        );
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement deleteButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        deleteButton.click();
        Delay(TWO);
    }
    public void clickAddJobTitle(){
        waitTableJob();
        btnAddJobTitles.click();
        Delay(TWO);
    }

//    FORM ADD / EDIT
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/span")
    WebElement lblErrJobTitle;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/input")
    WebElement fldJobTitle;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/textarea")
    WebElement fldJobDescription;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/div/div[2]/div/div[1]")
    WebElement btnJobSpesification;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[4]/div/div[2]/textarea")
    WebElement fldJobNote;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[5]/button[2]")
    WebElement btnSaveJobTitle;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[5]/button[1]")
    WebElement btnCancelSaveJobTitle;
    @FindBy(xpath = "//input[@type='file']")
    WebElement fileInput;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/div[1]/div[2]/div/div[2]/div[3]/div[2]/div/label/span")
    WebElement changeFile;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/div[2]/div/div[2]/div/div[1]")
    WebElement btnNewJobSpesification;

    public void clearFieldJobTitle(){
        wait.until(ExpectedConditions.visibilityOf(fldJobTitle));
        fldJobTitle.click();
        Actions actions = new Actions(driver);
        actions.
                keyDown(Keys.CONTROL)
                .sendKeys("a")
                .keyUp(Keys.CONTROL)
                .sendKeys(Keys.BACK_SPACE).perform();
        Delay(TWO);
    }
    public void fillJobTitle(String job){
        waitFormAdd();
        wait.until(ExpectedConditions.visibilityOf(fldJobTitle));
        fldJobTitle.click();
        Actions actions = new Actions(driver);
        actions.
                keyDown(Keys.CONTROL)
                .sendKeys("a")
                .keyUp(Keys.CONTROL)
                .sendKeys(Keys.BACK_SPACE).perform();
        fldJobTitle.sendKeys(job);
        Delay(TWO);
    }
    public void fillJobDescription(String description){
        waitFormAdd();
        fldJobDescription.click();
        Actions actions = new Actions(driver);
        actions.
                keyDown(Keys.CONTROL)
                .sendKeys("a")
                .keyUp(Keys.CONTROL)
                .sendKeys(Keys.BACK_SPACE).perform();
        fldJobDescription.sendKeys(description);
        Delay(TWO);
    }
    public void fillJobNote(String note){
        waitFormAdd();
        fldJobNote.click();
        Actions actions = new Actions(driver);
        actions.
                keyDown(Keys.CONTROL)
                .sendKeys("a")
                .keyUp(Keys.CONTROL)
                .sendKeys(Keys.BACK_SPACE).perform();
        fldJobNote.sendKeys(note);
        Delay(TWO);
    }
    public void clickSaveJobTitle(){
        waitFormAdd();
        wait.until(ExpectedConditions.visibilityOf(btnSaveJobTitle));
        btnSaveJobTitle.click();
        Delay(TWO);
    }
    public void clickCancelSaveJobTitle(){
        waitFormAdd();
        wait.until(ExpectedConditions.visibilityOf(btnCancelSaveJobTitle));
        btnCancelSaveJobTitle.click();
        Delay(TWO);
    }
    public void uploadFile(String urlFile) throws AWTException {
        waitFormAdd();
        btnJobSpesification.click();
        Delay(TWO);

        String basePath = "C:\\Users\\USER\\Downloads\\gambar\\%s";
        String fullPath = String.format(basePath, urlFile);
        System.out.println("Full Path: " + fullPath);  // Cek di console

        fileInput.sendKeys(fullPath);

        // Tutup dialog file explorer dengan Robot
        Robot robot = new Robot();
        robot.delay(1000);  // Tunggu 1 detik
        robot.keyPress(KeyEvent.VK_ESCAPE);  // Tekan ESC untuk menutup
        robot.keyRelease(KeyEvent.VK_ESCAPE);
        Delay(TWO);
    }
    public void uploadNewFile(String urlFile) throws AWTException {
        waitFormAdd();
        changeFile.click();
        btnNewJobSpesification.click();
        Delay(TWO);

        String basePath = "C:\\Users\\USER\\Downloads\\gambar\\%s";
        String fullPath = String.format(basePath, urlFile);
        System.out.println("Full Path: " + fullPath);  // Cek di console

        fileInput.sendKeys(fullPath);

        // Tutup dialog file explorer dengan Robot
        Robot robot = new Robot();
        robot.delay(1000);  // Tunggu 1 detik
        robot.keyPress(KeyEvent.VK_ESCAPE);  // Tekan ESC untuk menutup
        robot.keyRelease(KeyEvent.VK_ESCAPE);
        Delay(TWO);
    }

//    FORM DELETE
    @FindBy(xpath = "//*[@id=\"app\"]/div[3]/div/div/div/div[3]/button[2]")
    WebElement btnDeleteJobTitle;
    @FindBy(xpath = "//*[@id=\"app\"]/div[3]/div/div/div/div[3]/button[1]")
    WebElement btnCancelDeleteJobTitle;

    public void clickDelete(){
        waitFormDelete();
        btnDeleteJobTitle.click();
        Delay(TWO);
    }
    public void clickCancelDelete(){
        waitFormDelete();
        btnCancelDeleteJobTitle.click();
        Delay(TWO);
    }

//    SHOW ELEMENT PAGE

    public void waitTableJob(){
        By locator = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div[3]/div");
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
    public void waitFormAdd(){
        By locator = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/h6");
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
    public void waitFormEdit(){
        By locator = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/h6");
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
    public void waitFormDelete(){
        By locator = By.xpath("//*[@id=\"app\"]/div[3]/div/div/div");
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

//    GET VALIDATIOM

    // (EDIT,ADD,DELETE) succes
    public String getVerifySucces(){
//        wait.until(ExpectedConditions.visibilityOf(verifyUserSucces));
//        String msg = verifyUserSucces.getText();
//        return msg;

        // Mencocokkan semua pesan yang mengandung "Successfully"
        By toastLocator = By.xpath("//div[contains(@id,'oxd-toaster_')]//p[contains(.,'Successfully')]");

        WebElement toastElement = wait.until(
                ExpectedConditions.visibilityOfElementLocated(toastLocator)
        );
        return toastElement.getText();
    }

    // (EDIT,ADD) empty field, Invalid
    public String getVerifyEmptyField(){
        wait.until(ExpectedConditions.visibilityOf(lblErrJobTitle));
        String msg = lblErrJobTitle.getText();
        return msg;
    }

    // (EDIT) Canceled Form Gone
    public void getVerifynFormEditGone(){
        boolean isElementGone =  waitForElementToClose(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/h6"));
        if (isElementGone) {
            System.out.println("FORM EDIT tertutup.");
        } else {
            System.out.println("Popup masih ada.");
        }
        Delay(TWO);
    }

   // (ADD) Canceled Form Gone
    public void getVerifynFormAddGone(){
        boolean isElementGone =  waitForElementToClose(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/h6"));
        if (isElementGone) {
            System.out.println("FORM ADD tertutup.");
        } else {
            System.out.println("Popup masih ada.");
        }
        Delay(TWO);
    }

    // (DELETE) Canceled Form Gone
    public void getVerifynFormDeleteGone(){
        boolean isElementGone =  waitForElementToClose(By.xpath("//*[@id=\"app\"]/div[3]/div/div/div"));
        if (isElementGone) {
            System.out.println("FORM DELETE tertutup.");
        } else {
            System.out.println("Popup masih ada.");
        }
        Delay(TWO);
    }

    // (EDIT) Prefil Validation
    public String getVerifyDataInField(){
        waitFormEdit();
        wait.until(ExpectedConditions.visibilityOf(fldJobTitle));
        String validasi = fldJobTitle.getAttribute("value");
        return validasi;
    }
}
