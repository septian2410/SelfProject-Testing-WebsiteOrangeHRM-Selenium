package selfProject.panduseptiandito.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static selfProject.panduseptiandito.DriverSingleton.driver;
import static selfProject.panduseptiandito.drivers.utils.TimeDuration.TWO;

public class PageEmploymentStatus {

    private WebDriverWait wait;

    public PageEmploymentStatus(WebDriver driver){
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

//    LOCATOR

    //    MAIN DASH
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div[2]/div/span")
    WebElement lblResultSearch;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div[1]/div/button")
    WebElement btnAddEmploymentStatus;
    @FindBy(xpath = "//div[@id='oxd-toaster_1']/div/div/div[2]/p[2]")
    WebElement popUpSucces;

    public void clickAddEmploymentStatus(){
        waitTableJobEmploymentStatus();
        btnAddEmploymentStatus.click();
        Delay(TWO);
    }
    public void actionEditEmploymentStatus(WebDriver driver, String status){
        String xpath = String.format(
                "//div[text()='%s']/ancestor::div[contains(@class,'oxd-table-row')]//i[contains(@class,'bi-pencil-fill')]",
                status
        );
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement editButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        editButton.click();
        Delay(TWO);
    }
    public void actionDeleteEmploymentStatus(WebDriver driver, String status){
        String xpath = String.format(
                "//div[text()='%s']/ancestor::div[contains(@class,'oxd-table-row')]//i[contains(@class,'bi-trash')]",
                status
        );
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement deleteButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        deleteButton.click();
        Delay(TWO);
    }

    //    FORM ADD / FORM EDIT
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/input")
    WebElement fldEmploymentStatus;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div[1]/div/form/div[2]/button[2]")
    WebElement btnSave;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div[1]/div/form/div[2]/button[1]")
    WebElement btnCanceSave;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/span")
    WebElement lblErrEmploymentStatus;

    public void clickSave(){
        waitFormAdd();
        wait.until(ExpectedConditions.visibilityOf(btnSave));
        btnSave.click();
        Delay(TWO);
    }
    public void clickCancelSave(){
        waitFormAdd();
        wait.until(ExpectedConditions.visibilityOf(btnCanceSave));
        btnCanceSave.click();
        Delay(TWO);
    }
    public void fillNameEmploymentStatus(String status){
        waitFormAdd();
        wait.until(ExpectedConditions.visibilityOf(fldEmploymentStatus));
        fldEmploymentStatus.click();
        Actions actions = new Actions(driver);
        actions.
                keyDown(Keys.CONTROL)
                .sendKeys("a")
                .keyUp(Keys.CONTROL)
                .sendKeys(Keys.BACK_SPACE).perform();
        fldEmploymentStatus.sendKeys(status);
        Delay(TWO);
    }
    public void clearfldEmploymentStatus(){
        wait.until(ExpectedConditions.visibilityOf(fldEmploymentStatus));
        fldEmploymentStatus.click();
        Actions actions = new Actions(driver);
        actions.
                keyDown(Keys.CONTROL)
                .sendKeys("a")
                .keyUp(Keys.CONTROL)
                .sendKeys(Keys.BACK_SPACE).perform();
        Delay(TWO);
    }


    //    FORM DELETE
    @FindBy(xpath = "//*[@id=\"app\"]/div[3]/div/div/div/div[3]/button[2]")
    WebElement btnDelete;
    @FindBy(xpath = "//*[@id=\"app\"]/div[3]/div/div/div/div[3]/button[1]")
    WebElement btnCancelDelete;

    public void clickDelete(){
        waitFormDelete();
        wait.until(ExpectedConditions.visibilityOf(btnDelete));
        btnDelete.click();
        Delay(TWO);
    }
    public void clickCancelDelete(){
        waitFormDelete();
        wait.until(ExpectedConditions.visibilityOf(btnCancelDelete));
        btnCancelDelete.click();
        Delay(TWO);
    }

//    SHOW ELEMENT
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/button[2]")
    WebElement formAdd;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/button[1]")
    WebElement formEdit;
    @FindBy(xpath = "//*[@id=\"app\"]/div[3]/div/div/div")
    WebElement formDelete;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div[3]/div/div[2]")
    WebElement tableJobEmploymentStatus;

    public void waitFormAdd(){
        By locator = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/button[2]");
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
    public void waitFormEdit(){
        By locator = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/button[1]");
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
    public void waitFormDelete(){
        By locator = By.xpath("//*[@id=\"app\"]/div[3]/div/div/div");
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
    public void waitTableJobEmploymentStatus(){
        By locator = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div[3]/div/div[2]");
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

//    VALIDATION

    // (EDIT,ADD) empty field, Invalid
    public String getVerifyEmptyField(){
        waitFormAdd();
        wait.until(ExpectedConditions.visibilityOf(lblErrEmploymentStatus));
        String validation = lblErrEmploymentStatus.getText();
        return validation;
    }

    // (EDIT,ADD,DELETE) succes
    public String getVerifySucces(){
//        wait.until(ExpectedConditions.visibilityOf(popUpSucces));
//        String Validation = popUpSucces.getText();
//        return Validation;

        // Mencocokkan semua pesan yang mengandung "Successfully"
        By toastLocator = By.xpath("//div[contains(@id,'oxd-toaster_')]//p[contains(.,'Successfully')]");

        WebElement toastElement = wait.until(
                ExpectedConditions.visibilityOfElementLocated(toastLocator)
        );
        return toastElement.getText();

    }

    // (EDIT) Prefil Validation
    public String getVerifyDataInField(){
        waitFormEdit();
        wait.until(ExpectedConditions.visibilityOf(fldEmploymentStatus));
        String validasi = fldEmploymentStatus.getAttribute("value");
        return validasi;
    }

    // (EDIT) Canceled Form Gone
    public void getVerifyFormEditGone(){
        boolean isElementGone =  wait.until(ExpectedConditions.invisibilityOf(formEdit));
        if (isElementGone) {
            System.out.println("FORM EDIT tertutup.");
        } else {
            System.out.println("Popup masih ada.");
        }
        Delay(TWO);
    }

    // (ADD) Canceled Form Gone
    public void getVerifyFormAddIsGone() {
        boolean isFormClosed = wait.until(ExpectedConditions.invisibilityOf(formAdd));
        System.out.println(isFormClosed ? "FORM ADD tertutup." : "Form Add masih terbuka!");
        Delay(TWO);
    }

    // (DELETE) Canceled Form Gone
    public void getVerifyFormDeleteGone()  {
        boolean isFormClosed = wait.until(ExpectedConditions.invisibilityOf(formDelete));
        System.out.println(isFormClosed ? "FORM DELETE tertutup." : "Form Add masih terbuka!");
        Delay(TWO);
    }

}
