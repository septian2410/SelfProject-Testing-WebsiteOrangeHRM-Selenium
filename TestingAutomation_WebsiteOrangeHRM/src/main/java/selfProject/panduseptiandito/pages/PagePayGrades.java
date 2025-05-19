package selfProject.panduseptiandito.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static selfProject.panduseptiandito.DriverSingleton.driver;
import static selfProject.panduseptiandito.drivers.utils.TestUtils.waitForElementToClose;
import static selfProject.panduseptiandito.drivers.utils.TimeDuration.TWO;

public class PagePayGrades {

    private WebDriverWait wait;

    public PagePayGrades(WebDriver driver){
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
    WebElement btnAddPayGrades;
    @FindBy(xpath = "//div[@id='oxd-toaster_1']/div/div/div[2]/p[2]")
    WebElement popUpSucces;

    public void clickAddPayGrades(){
        waitTablePayGrades();
        btnAddPayGrades.click();
        Delay(TWO);
    }
    public void actionEditPayGrades(WebDriver driver, String pay){
        String xpath = String.format(
                "//div[text()='%s']/ancestor::div[contains(@class,'oxd-table-row')]//i[contains(@class,'bi-pencil-fill')]",
                pay
        );
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement editButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        editButton.click();
        Delay(TWO);
    }
    public void actionDeletePayGrades(WebDriver driver, String pay){
        String xpath = String.format(
                "//div[text()='%s']/ancestor::div[contains(@class,'oxd-table-row')]//i[contains(@class,'bi-trash')]",
                pay
        );
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement deleteButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        deleteButton.click();
        Delay(TWO);
    }

    //    FORM ADD / FORM EDIT
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div[1]/div/form/div[1]/div/div/div/div[2]/input")
    WebElement fldPayGrade;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div[1]/div/form/div[2]/button[2]")
    WebElement btnSave;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div[1]/div/form/div[2]/button[1]")
    WebElement btnCancelSave;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div[2]/div/div[1]/div/button")
    WebElement btnAddCurrencies;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div[2]/form/div[2]/div/div[1]/div/div[2]/input")
    WebElement fldMinimumSalary;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div[2]/form/div[2]/div/div[2]/div/div[2]/input")
    WebElement fldMaximumSalary;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div[2]/form/div[1]/div/div/div/div[2]/div/div/div[2]/i")
    WebElement dropdwnCurrency;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div[2]/form/div[3]/button[2]")
    WebElement btnSaveCurrency;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div/div/span")
    WebElement lblErrPayGrades;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div[2]/form/div[1]/div/div/div/span")
    WebElement lblErrCurrency;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div[2]/form/div[2]/div/div[1]/div/span")
    WebElement lblErrMinSal;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div[2]/form/div[2]/div/div[2]/div/span")
    WebElement lblErrMaxSal;

    public void clearFldPayGrade(){
        wait.until(ExpectedConditions.visibilityOf(fldPayGrade));
        fldPayGrade.click();
        Actions actions = new Actions(driver);
        actions.
                keyDown(Keys.CONTROL)
                .sendKeys("a")
                .keyUp(Keys.CONTROL)
                .sendKeys(Keys.BACK_SPACE).perform();
        Delay(TWO);
    }
    public void clickAddCurrencies(){
        waitFormAdd();
        wait.until(ExpectedConditions.visibilityOf(btnAddCurrencies));
        btnAddCurrencies.click();
        Delay(TWO);
    }
    public void inputMinimumSalary(String minimum){
        wait.until(ExpectedConditions.visibilityOf(fldMinimumSalary));
        fldMinimumSalary.click();
        Actions actions = new Actions(driver);
        actions.
                keyDown(Keys.CONTROL)
                .sendKeys("a")
                .keyUp(Keys.CONTROL)
                .sendKeys(Keys.BACK_SPACE).perform();
        fldMinimumSalary.sendKeys(minimum);
        Delay(TWO);
    }
    public void inputMaximumSalary(String maximum){
        wait.until(ExpectedConditions.visibilityOf(fldMaximumSalary));
        fldMaximumSalary.click();
        Actions actions = new Actions(driver);
        actions.
                keyDown(Keys.CONTROL)
                .sendKeys("a")
                .keyUp(Keys.CONTROL)
                .sendKeys(Keys.BACK_SPACE).perform();
        fldMaximumSalary.sendKeys(maximum);
        Delay(TWO);
    }
    public void selectCurrency(String currency){
        waitFormAdd();

        wait.until(ExpectedConditions.elementToBeClickable(dropdwnCurrency)).click();
        WebElement currencyOption = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath(String.format("//div[@role='option']//span[contains(.,'%s')]", currency))
        ));
        try {
            currencyOption.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", currencyOption);
        }
        Delay(TWO);
    }
    public void clickSaveCurrency(){
        wait.until(ExpectedConditions.visibilityOf(btnSaveCurrency));
        btnSaveCurrency.click();
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
    public void fillNamePayGrade(String namePay){
        waitFormAdd();
        wait.until(ExpectedConditions.visibilityOf(fldPayGrade));
        fldPayGrade.click();
        Actions actions = new Actions(driver);
        actions.
                keyDown(Keys.CONTROL)
                .sendKeys("a")
                .keyUp(Keys.CONTROL)
                .sendKeys(Keys.BACK_SPACE).perform();
        fldPayGrade.sendKeys(namePay);
        Delay(TWO);
    }

//    FORM CURRENCY

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div[2]/div/div[3]/div/div[2]/div/div/div[5]/div/button[1]")
    WebElement btnDeleteCurrency;

    public void clickDeleteCurrency(){
        wait.until(ExpectedConditions.visibilityOf(btnDeleteCurrency));
        btnDeleteCurrency.click();
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

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div[3]/div/div[2]")
    WebElement tablePagGrades;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/button[2]")
    WebElement formAdd;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/button[2]")
    WebElement formEdit;
    @FindBy(xpath = "//*[@id=\"app\"]/div[3]/div/div/div")
    WebElement formDelete;

    public void waitTablePayGrades(){
        By locator = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div[3]/div/div[2]");
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
    public void waitFormAdd(){
        By locator = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/button[2]");
                wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
    public void waitFormEdit(){
        By locator = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div[2]/div/div[1]/div/h6");
                wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
    public void waitFormDelete(){
        By locator = By.xpath("//*[@id=\"app\"]/div[3]/div/div/div");
                wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

//    VALIDATION

    // (EDIT,ADD) empty field, Invalid (Pay Grades)
    public String getVerifyEmptyField(){
        waitFormAdd();
        String validation = lblErrPayGrades.getText();
        return validation;
    }

    // (EDIT,ADD) empty field, Invalid (Currency)
    public String getVerifyEmptyCurrency(){
        waitFormAdd();
        String validation = lblErrCurrency.getText();
        return validation;
    }

    // (EDIT,ADD) empty field, Invalid (Min)
    public String getVerifyErrMinSal(){
        waitFormAdd();
        String validation = lblErrMinSal.getText();
        return validation;
    }

    // (EDIT,ADD) empty field, Invalid (Max)
    public String getVerifyErrMaxSal(){
        waitFormAdd();
        wait.until(ExpectedConditions.visibilityOf(lblErrMaxSal));
        String validation = lblErrMaxSal.getText();
        return validation;
    }

    // (EDIT,ADD,DELETE) succes
    public String getVerifySucces(){
//        waitTablePayGrades();
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
        wait.until(ExpectedConditions.visibilityOf(fldPayGrade));
        String validasi = fldPayGrade.getAttribute("value");
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

