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

public class PageWorkShifts {

    private WebDriverWait wait;

    public PageWorkShifts(WebDriver driver){
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
    WebElement btnAddWorkShifts;
    @FindBy(xpath = "//div[@id='oxd-toaster_1']/div/div/div[2]/p[2]")
    WebElement popUpSucces;

    public void clickAddWorkShifts(){
        waitTableWorkShifts();
        wait.until(ExpectedConditions.visibilityOf(btnAddWorkShifts));
        btnAddWorkShifts.click();
        Delay(TWO);
    }
    public void actionEditWorkShifts(WebDriver driver, String shifts){
        waitTableWorkShifts();
        String xpath = String.format(
                "//div[text()='%s']/ancestor::div[contains(@class,'oxd-table-row')]//i[contains(@class,'bi-pencil-fill')]",
                shifts
        );
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement editButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        editButton.click();
        Delay(TWO);
    }
    public void actionDeleteWorkShifts(WebDriver driver, String shifts){
        waitTableWorkShifts();
        String xpath = String.format(
                "//div[text()='%s']/ancestor::div[contains(@class,'oxd-table-row')]//i[contains(@class,'bi-trash')]",
                shifts
        );
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement deleteButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        deleteButton.click();
        Delay(TWO);
    }

    //    FORM ADD / FORM EDIT
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div[1]/div/form/div[1]/div/div/div/div[2]/input")
    WebElement fldShift;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[4]/button[2]")
    WebElement btnSave;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[4]/button[1]")
    WebElement btnCancelSave;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/div/div/div/div[2]/div/div[1]/input")
    WebElement fldAssignedEmployees;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]/div/div/i")
    WebElement btnTimeShiftFrom;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]/div/div/input")
    WebElement fldTimeShiftFrom;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/div/div/i")
    WebElement btnTimeShifTo;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/div/div/input")
    WebElement fldTimeShifTo;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div/div/span")
    WebElement lblErrShift;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/span")
    WebElement lblErrTimeFrom;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/span")
    WebElement lblErrTimeTo;

    public void clearFldShift(){
        wait.until(ExpectedConditions.visibilityOf(fldShift));
        fldShift.click();
        Actions actions = new Actions(driver);
        actions.
                keyDown(Keys.CONTROL)
                .sendKeys("a")
                .keyUp(Keys.CONTROL)
                .sendKeys(Keys.BACK_SPACE).perform();
        Delay(TWO);
    }
    public void fillShift(String shift){
        waitFormAdd();
        wait.until(ExpectedConditions.visibilityOf(fldShift));
        fldShift.click();
        Actions actions = new Actions(driver);
        actions.
                keyDown(Keys.CONTROL)
                .sendKeys("a")
                .keyUp(Keys.CONTROL)
                .sendKeys(Keys.BACK_SPACE).perform();
        fldShift.sendKeys(shift);
        Delay(TWO);
    }

    public void clickTimeShiftFrom(){
        waitFormAdd();
        wait.until(ExpectedConditions.visibilityOf(btnTimeShiftFrom));
        btnTimeShiftFrom.click();
        Delay(TWO);
    }
    public void clickTimeShiftTo(){
        waitFormAdd();
        wait.until(ExpectedConditions.visibilityOf(btnTimeShifTo));
        btnTimeShifTo.click();
        Delay(TWO);
    }

    public void clickSave(){
        waitFormAdd();
        wait.until(ExpectedConditions.visibilityOf(btnSave));
        btnSave.click();
        Delay(TWO);
    }
    public void clickCancelSave(){
        waitFormAdd();
        wait.until(ExpectedConditions.visibilityOf(btnCancelSave));
        btnCancelSave.click();
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

//    SHOW ELEMENTS

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div[3]")
    WebElement tableWorkShifts;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[4]/button[2]")
    WebElement formAdd;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[4]/button[2]")
    WebElement formEdit;
    @FindBy(xpath = "//*[@id=\"app\"]/div[3]/div/div/div")
    WebElement formDelete;

    public void waitTableWorkShifts(){
        By locator = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div[3]");
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
    public void waitFormAdd(){
        By locator = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[4]/button[2]");
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
    public void waitFormEdit(){
        By locator = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[4]/button[2]");
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
    public void waitFormDelete(){
        By locator = By.xpath("//*[@id=\"app\"]/div[3]/div/div/div");
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

//    VALIDATION

    // (EDIT,ADD) empty field, Invalid
    public String getVerifyEmptyField(){
        waitFormAdd();
        String validation = lblErrShift.getText();
        return validation;
    }

    // (EDIT,ADD,DELETE) succes
    public String getVerifySucces(){
        waitTableWorkShifts();
        wait.until(ExpectedConditions.visibilityOf(popUpSucces));
        String Validation = popUpSucces.getText();
        return Validation;
    }

    // (EDIT) Prefil Validation
    public String getVerifyDataInField(){
        waitFormEdit();
        wait.until(ExpectedConditions.visibilityOf(fldShift));
        String validasi = fldShift.getAttribute("value");
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
