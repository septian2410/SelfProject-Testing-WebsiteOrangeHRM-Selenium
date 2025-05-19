package selfProject.panduseptiandito.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static selfProject.panduseptiandito.DriverSingleton.driver;
import static selfProject.panduseptiandito.drivers.utils.TestUtils.waitForElementToClose;
import static selfProject.panduseptiandito.drivers.utils.TimeDuration.TWO;

public class PageSystemUser {

    private WebDriverWait wait;

    public PageSystemUser(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void Delay(int milisecond){
        try{
            Thread.sleep(milisecond);
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
            System.out.println("Delay interupted : "+e.getMessage());
        }
    }

//    Locator

//    Main Dashboard User
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input")
    WebElement fieldSearchUsername;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[1]/header/div[2]/nav/ul/li[2]")
    WebElement navTabJob;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[3]/div/div[2]/div/div/input")
    WebElement fieldSearchEmployee;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]")
    WebElement buttonSearch;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[1]")
    WebElement buttonReset;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/div/div/div[2]/i")
    WebElement dropDownSearchUserRole;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[4]/div/div[2]/div/div/div[2]/i")
    WebElement dropDownSearchStatus;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[1]/button")
    WebElement buttonAddUser;

//    Form Add User
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form")
    WebElement containerFormAdd;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div/div[2]/i")
    WebElement dropDownAddUserRole;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div/div[2]/i")
    WebElement dropDownAddStatus;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/div[2]/div/div/input")
    WebElement fieldAddEmployeeName;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[4]/div/div[2]/input")
    WebElement fieldAddUsername;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]/input")
    WebElement fieldPassword;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/input")
    WebElement fieldConfirmPassword;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/button[2]")
    WebElement buttonSaveUser;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/button[1]")
    WebElement buttonCancelSaveUser;

//    Form Edit User
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div")
    WebElement containerFormEdit;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div/div[2]/i")
    WebElement dropDownEditUserRole;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[3]/div/div[2]/div/div/div[2]/i")
    WebElement dropDownEditStatus;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/div[2]/div/div/input")
    WebElement fieldEditEmployeeName;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[4]/div/div[2]/input")
    WebElement fieldEditUsername;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/button[2]\n")
    WebElement buttonEditSaveUser;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/button[1]")
    WebElement buttonCancelEditSaveUser;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/button[2]")
    WebElement buttonEditSaveUserChangePassword;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/button[1]")
    WebElement buttonCancelEditSaveUserChangePassword;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[5]/div/div[2]/div/label/span/i")
    WebElement checkBoxChangePassword;

//  Form Delete User
    @FindBy(xpath = "//*[@id=\"app\"]/div[3]/div/div/div")
    WebElement containerFormDelete;
    @FindBy(xpath = "//*[@id=\"app\"]/div[3]/div/div/div/div[3]/button[2]")
    WebElement buttonDelete;
    @FindBy(xpath = "//*[@id=\"app\"]/div[3]/div/div/div/div[3]/button[1]")
    WebElement buttonCancelDelete;

//    Validation

    //    Search User Not Found, Search User Found
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[2]/div")
    WebElement validationSearchUser;
    //    Search User Found, Add Success, Edit Success By search
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div[2]/div")
    WebElement validationSearchUserData;
    //    (SEARCH) employee name invalid
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[3]/div/span")
    WebElement validationSearchEmployeeNameInvalid;
    //   (ADD, EDIT, DELETE) Success
    @FindBy(xpath = "//div[@id='oxd-toaster_1']/div/div/div[2]/p[2]")
    WebElement validationUserSucces;
    //   (EDIT,ADD) empty field, Invalid
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/div/span")
    WebElement validationErrEmployeeName;
    //   (EDIT,ADD) empty field, Invalid
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[4]/div/span")
    WebElement validationErrUsername;
    //    empty field Password, Should have at least 8 characters,
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/span")
    WebElement validationAddFieldPassword;
    //    empty field Password Conf, password not match,
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/span\n")
    WebElement validationAddFieldConfPassword;

    //    field password Very Weak, Weak, Strong
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/span")
    WebElement validationAddFieldPasswordType;

//  Action

//    Page User
    public void selectNavTabJob(String subMenu){
    waitTableUser();
    wait.until(ExpectedConditions.visibilityOf(navTabJob));
    navTabJob.click();
        By locator  = By.xpath(String.format("//*[contains(@class,'oxd-dropdown-menu')]//*[normalize-space()='%s']", subMenu));
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(locator)).click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", locator);
        }
        Delay(TWO);
}
    public void fillSearchUsername(String username){
        waitTableUser();
        fieldSearchUsername.click();
        Actions actions = new Actions(driver);
        actions.
                keyDown(Keys.CONTROL)
                .sendKeys("a")
                .keyUp(Keys.CONTROL)
                .sendKeys(Keys.BACK_SPACE).perform();
        fieldSearchUsername.sendKeys(username);
        Delay(TWO);
    }
    public void fillSearchEmployee(String employee){
        waitTableUser();
        fieldSearchEmployee.sendKeys(employee);
        Delay(TWO);
    }
    public void clickSearchUser(){
        buttonSearch.click();
        Delay(TWO);
    }
    public void clickResetSearch(){
        buttonReset.click();
        Delay(TWO);
    }
    public void selectSearchUserRole(String role) {
        wait.until(ExpectedConditions.elementToBeClickable(dropDownSearchUserRole)).click();
        WebElement roleOption = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath(String.format("//div[@role='option']//span[contains(.,'%s')]", role))
        ));
        try {
            roleOption.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", roleOption);
        }
        Delay(TWO);
    }
    public void selectSearchUserStatus(String status){
        wait.until(ExpectedConditions.elementToBeClickable(dropDownSearchStatus)).click();
        WebElement statusOption = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath(String.format("//div[@role='option']//span[contains(.,'%s')]", status))
        ));
        try {
            statusOption.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", statusOption);
        }
        Delay(TWO);
    }
    public void clickAddUser(){
        waitTableUser();
        buttonAddUser.click();
        Delay(TWO);
    }
    public void choiceEditUser(WebDriver driver, String username){
            String xpath = String.format(
//                    "//div[text()='%s']/ancestor::div[contains(@class,'oxd-table-row')]//i[contains(@class,'bi-pencil-fill')]",
                    "//div[@class='oxd-table-body']//div[contains(@class,'oxd-table-row')][.//div[normalize-space()='%s']]//i[contains(@class,'bi-pencil-fill')]",

                    username
            );

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement editButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
            editButton.click();
//            System.out.println("Button edit untuk user \"" + username + "\" berhasil diklik.");
        Delay(TWO);
    }
    public void choiceDeleteUser(WebDriver driver, String username){
            String xpath = String.format(
                    "//div[@class='oxd-table-body']//div[contains(@class,'oxd-table-row')][.//div[normalize-space()='%s']]//i[contains(@class,'bi-trash')]",

//                    "//div[text()='%s']/ancestor::div[contains(@class,'oxd-table-row')]//i[contains(@class,'bi-trash')]",
                    username
            );

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement editButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
            editButton.click();
//            System.out.println("Button delete untuk user \"" + username + "\" berhasil diklik.");
        Delay(TWO);
    }

//    Form Add User
    public void selectAddUserRole(String role){
        waitContainerFormAdd();

        wait.until(ExpectedConditions.elementToBeClickable(dropDownEditUserRole)).click();
        WebElement roleOption = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath(String.format("//div[@role='option']//span[contains(.,'%s')]", role))
        ));
        try {
            roleOption.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", roleOption);
        }
        Delay(TWO);
    }
    public void selectAddStatus(String status){
        waitContainerFormAdd();

        wait.until(ExpectedConditions.elementToBeClickable(dropDownAddStatus)).click();
        WebElement statusOption = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath(String.format("//div[@role='option']//span[contains(.,'%s')]", status))
        ));
        try {
            statusOption.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", statusOption);
        }
        Delay(TWO);
    }
    public void fillAddEmployeeName(String employee){
        waitContainerFormAdd();
        wait.until(ExpectedConditions.visibilityOf(fieldAddEmployeeName));
        fieldAddEmployeeName.sendKeys(employee);
        Delay(TWO);
        Delay(TWO);
        fieldAddEmployeeName.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);
        Delay(TWO);
    }
    public void fillAddUsername(String username){
        waitContainerFormAdd();
        fieldAddUsername.sendKeys(username);
        Delay(TWO);
    }
    public void fillPassword(String password){
        fieldPassword.sendKeys(password);
        Delay(TWO);
    }
    public void fillConfirmPassword(String Confpassword){
        fieldConfirmPassword.sendKeys(Confpassword);
        Delay(TWO);
    }
    public void clickSaveAddUser(){
        buttonSaveUser.click();
        Delay(TWO);
    }
    public void clickCancelSaveAddUser(){
        wait.until(ExpectedConditions.visibilityOf(buttonCancelSaveUser));
        buttonCancelSaveUser.click();
        Delay(TWO);
    }

//    Form Edit User
    public void selectEditUserRole(String role){
        waitContainerFormEdit();
        wait.until(ExpectedConditions.elementToBeClickable(dropDownAddUserRole)).click();
        WebElement roleOption = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath(String.format("//div[@role='option']//span[contains(.,'%s')]", role))
        ));
        try {
            roleOption.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", roleOption);
        }
        Delay(TWO);
    }
    public void selectEditStatus(String status){
        waitContainerFormEdit();
        wait.until(ExpectedConditions.elementToBeClickable(dropDownEditStatus)).click();
        WebElement statusOption = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath(String.format("//div[@role='option']//span[contains(.,'%s')]", status))
        ));
        try {
            statusOption.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", statusOption);
        }
        Delay(TWO);
    }
    public void fillEditEmployee(String employee){
        waitContainerFormEdit();
        wait.until(ExpectedConditions.visibilityOf(fieldEditEmployeeName));
        fieldEditEmployeeName.click();
        Actions actions = new Actions(driver);
        actions.
                keyDown(Keys.CONTROL)
                .sendKeys("a")
                .keyUp(Keys.CONTROL)
                .sendKeys(Keys.BACK_SPACE).perform();
        fieldEditEmployeeName.sendKeys(employee);
        Delay(TWO);
    }
    public void fillEditUsername(String username){
        waitContainerFormEdit();
        wait.until(ExpectedConditions.visibilityOf(fieldEditUsername));
        fieldEditUsername.click();
        Actions actions = new Actions(driver);
        actions.
                keyDown(Keys.CONTROL)
                .sendKeys("a")
                .keyUp(Keys.CONTROL)
                .sendKeys(Keys.BACK_SPACE).perform();
        fieldEditUsername.sendKeys(username);
        Delay(TWO);
    }
    public void clickEditSaveUser(){
        wait.until(ExpectedConditions.visibilityOf(buttonEditSaveUser));
        buttonEditSaveUser.click();
        Delay(TWO);
    }
    public void clickEditSaveUserChangePassword(){
        wait.until(ExpectedConditions.visibilityOf(buttonEditSaveUserChangePassword));
        buttonEditSaveUserChangePassword.click();
        Delay(TWO);

    }
    public void clickEditCancelSaveUser(){
        wait.until(ExpectedConditions.visibilityOf(buttonCancelEditSaveUser));
        buttonCancelEditSaveUser.click();
        Delay(TWO);
    }
    public void clickEditCheckBoxChangePassword(){
        checkBoxChangePassword.click();
        Delay(TWO);
    }
    public void clearFieldEditUsername(){
        wait.until(ExpectedConditions.visibilityOf(fieldEditUsername));
        fieldEditUsername.click();
        Actions actions = new Actions(driver);
        actions.
                keyDown(Keys.CONTROL)
                .sendKeys("a")
                .keyUp(Keys.CONTROL)
                .sendKeys(Keys.BACK_SPACE).perform();
        Delay(TWO);
    }

//    Form Delete User
    public void clickDelete(){
    waitContainerFormDelete();
    buttonDelete.click();
    Delay(TWO);
    }
    public void clickCancelDelete(){
    waitContainerFormDelete();
    buttonCancelDelete.click();
    Delay(TWO);
    }

//    Show Elements
    public void waitTableUser(){
        By locator = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]");
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
    public void waitContainerFormAdd(){
        wait.until(ExpectedConditions.visibilityOf(containerFormAdd));
    }
    public void waitContainerFormEdit(){
        wait.until(ExpectedConditions.visibilityOf(containerFormEdit));
    }
    public void waitContainerFormDelete(){
        wait.until(ExpectedConditions.visibilityOf(containerFormDelete));
    }

//    Validation Actual

    //    Search User Not Found, Search User Found
    public String getValidationSearch(){
        waitTableUser();
        wait.until(ExpectedConditions.visibilityOf(validationSearchUser));
        String validation = validationSearchUser.getText();
        return validation;
    }

    //    (SEARCH) employee name invalid
    public String getValidationSearchInvalidEmployeeName(){
        waitTableUser();
        wait.until(ExpectedConditions.visibilityOf(validationSearchEmployeeNameInvalid));
        String validation = validationSearchEmployeeNameInvalid.getText();
        return validation;
}

    //   (EDIT,ADD) empty field, Invalid
    public String getValidationErrEmployee(){
        waitTableUser();
        String validation = validationErrEmployeeName.getText();
        return validation;
    }

    //  (EDIT) Should be at least 5 characters, Empty
    public String getValidationErrUsername(){
        waitTableUser();
        String validation = validationErrUsername.getText();
        return validation;
    }

    //    (ADD) empty field Password, Should have at least 8 characters,
    public String getValidationErrPassword(){
        waitTableUser();
        String Validation = validationAddFieldPassword.getText();
        return Validation;
    }

    //    (ADD) not match Conf password
    public String getValidationErrConfPassword(){
        waitTableUser();
        String Validation = validationAddFieldConfPassword.getText();
        return Validation;
    }

    //    (RESET) Check field Empty
    public String getFieldSearch(){
        wait.until(ExpectedConditions.visibilityOf(fieldSearchUsername));
        String Value = fieldSearchUsername.getAttribute("value");
        return Value;
    }

    //    (EDIT,ADD) succes
    public String getValidationSucces(){
//        waitTableUser();
//        wait.until(ExpectedConditions.visibilityOf(validationUserSucces));
//        String Validation = validationUserSucces.getText();
//        return Validation;

        // Mencocokkan semua pesan yang mengandung "Successfully"
        By toastLocator = By.xpath("//div[contains(@id,'oxd-toaster_')]//p[contains(.,'Successfully')]");

        WebElement toastElement = wait.until(
                ExpectedConditions.visibilityOfElementLocated(toastLocator)
        );
        return toastElement.getText();
    }

    //    (EDIT) Prefil Validation
    public String getValidationDataInField(){
    waitContainerFormEdit();
    wait.until(ExpectedConditions.visibilityOf(fieldEditUsername));
    String validasi = fieldEditUsername.getAttribute("value");
    return validasi;
}

    // (EDIT) Canceled Form Gone
    public void getValidationFormEditGone(){
        boolean isElementGone =  waitForElementToClose(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div"));
        if (isElementGone) {
            System.out.println("Form Delete Telah menghilang");
        } else {
            System.out.println("Popup masih ada.");
        }
        Delay(TWO);
    }

    // (ADD) Canceled Form Gone
    public void getvalidationFormAddIsGone() {
        boolean isFormClosed = wait.until(ExpectedConditions.invisibilityOf(containerFormAdd));
        System.out.println(isFormClosed ? "Form ADD tertutup." : "Form Add masih terbuka!");
        Delay(TWO);
    }

    // (DELETE) Canceled Form Gone
    public void getValidationFormDeleteGone()  {
        boolean isFormClosed = wait.until(ExpectedConditions.invisibilityOf(containerFormDelete));
        System.out.println(isFormClosed ? "Form DELETE tertutup." : "Form Add masih terbuka!");
       Delay(TWO);
    }


}

