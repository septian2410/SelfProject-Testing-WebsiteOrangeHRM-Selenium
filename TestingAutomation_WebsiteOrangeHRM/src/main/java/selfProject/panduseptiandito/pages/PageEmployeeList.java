package selfProject.panduseptiandito.pages;

import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;

import static net.bytebuddy.implementation.bytecode.constant.IntegerConstant.FOUR;
import static selfProject.panduseptiandito.DriverSingleton.driver;
import static selfProject.panduseptiandito.drivers.utils.TestUtils.waitForElementToClose;
import static selfProject.panduseptiandito.drivers.utils.TimeDuration.THREE;
import static selfProject.panduseptiandito.drivers.utils.TimeDuration.TWO;

public class PageEmployeeList {

    private WebDriverWait wait;

    public PageEmployeeList(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void Delay(int milisecond){
        try{
            Thread.sleep(milisecond);
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
            System.out.println("Delay interupted : "+e.getMessage());
        }
    }

//  Locator

//  Page Employee List
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]")
    WebElement containerTableEmployee;

//    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[1]/div[1]/h5")
//    WebElement containerTableEmployee;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/div/div/input")
    WebElement fieldSearchEmployeeName;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/input")
    WebElement fieldSearchEmployeeId;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[3]/div/div[2]/div/div/div[2]/i")
    WebElement dropDownSearchStatus;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[4]/div/div[2]/div/div/div[2]/i")
    WebElement dropDownSearchInclude;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[5]/div/div[2]/div/div/input")
    WebElement fieldSearchSupervisorName;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[6]/div/div[2]/div/div/div[2]/i")
    WebElement dropDownSearchJobTitle;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[7]/div/div[2]/div/div/div[2]/i")
    WebElement dropDownSearchSubUnit;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]")
    WebElement buttonSearchEmployee;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[1]")
    WebElement buttonReset;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[1]/button")
    WebElement buttonAddEmployee;

//    FORM ADD
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]")
    WebElement containerFormAdd;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[1]/div/div/div[2]/div[1]/div[2]/input")
    WebElement fieldAddFirstName;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[1]/div/div/div[2]/div[2]/div[2]/input")
    WebElement fieldAddMidName;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[1]/div/div/div[2]/div[3]/div[2]/input")
    WebElement fieldAddLastName;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[2]/div/div/div[2]/input")
    WebElement fieldAddEmployeeId;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/button[2]")
    WebElement buttonSaveEmployee;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/button[1]\n")
    WebElement buttonCancelSaveEmployee;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[1]/div/div[2]/div/button")
    WebElement buttonAddImage;

    @FindBy(xpath = "//input[@type='file']")
    WebElement fileInput;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[2]/div/label/span")
    WebElement buttonCreateLoginDetails;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[3]/div/div[1]/div/div[2]/input")
    WebElement fieldUsernameLoginDetails;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[4]/div/div[1]/div/div[2]/input")
    WebElement fieldPasswordLoginDetails;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[4]/div/div[2]/div/div[2]/input")
    WebElement fieldConfPasswordLoginDetails;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[3]/div/div[2]/div/div[2]/div[1]/div[2]/div/label/span")
    WebElement bulletPointEnabledLoginDetails;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[3]/div/div[2]/div/div[2]/div[2]/div[2]/div/label/span")
    WebElement bulletPointDisabledLoginDetails;


//    FORM EDIT (Personal Details)
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]")
    WebElement containerFormEdit;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div/div/div/div[2]/div[1]/div[2]/input")
    WebElement fieldEditEmployeeFirstName;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div/div/div/div[2]/div[2]/div[2]/input")
    WebElement fieldEditEmployeeMidName;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div/div/div/div[2]/div[3]/div[2]/input")
    WebElement fieldEditEmployeeLastName;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div[1]/div[1]/div/div[2]/input")
    WebElement fieldEditEmployeeId;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div[1]/div[2]/div/div[2]/input")
    WebElement fieldOtherId;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[3]/div[2]/div[1]/div/div[2]/div/div/input")
    WebElement fieldDateBirth;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div[2]/div[2]/div/div[2]/div/div/input")
    WebElement fieldLicenseExpiryDate;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div[2]/div[1]/div/div[2]/input")
    WebElement fieldEditDriverLicenseNumber;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[3]/div[1]/div[1]/div/div[2]/div/div/div[2]/i")
    WebElement dropDopwNationality;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[3]/div[1]/div[2]/div/div[2]/div/div/div[2]/i")
    WebElement dropDownMaritalStatus;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[3]/div[2]/div[2]/div/div[2]/div[1]/div[2]/div/label/span")
    WebElement bulletPointMale;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[3]/div[2]/div[2]/div/div[2]/div[2]/div[2]/div/label/span")
    WebElement bulletPointFemale;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[4]/button")
    WebElement buttonSaveEditPersonalDetails;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[2]/div[1]/div/button")
    WebElement buttonAddAttachments;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[2]/div/form/div[1]/div/div/div/div[2]/div/div[1]")
    WebElement buttonSelectFileAttachments;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[2]/div/form/div[2]/div/div/div/div[2]/textarea")
    WebElement textAreaComment;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[2]/div/form/div[3]/button[2]")
    WebElement buttonSaveAddAttachments;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[2]/div/form/div[3]/button[1]")
    WebElement buttonCancelSaveAddAttachments;

//    PAGE JOB DETAILS

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[1]/div[2]/div[6]/a")
    WebElement buttonSubMenuJobDetails;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div/div[1]/div/div[2]/div/div/input")
    WebElement fieldJoinedDate;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div/div[2]/div/div[2]/div/div/div[2]/i")
    WebElement dropDownJobTitle;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div/div[4]/div/div[2]/div/div/div[2]/i")
    WebElement dropDownJobCategory;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div/div[7]/div/div[2]/div/div/div[2]/i")
    WebElement dropDownEmploymentStatus;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[3]/button")
    WebElement buttonSaveEditJobDetails;


//    FORM DELETE
    @FindBy(xpath = "//*[@id=\"app\"]/div[3]/div/div/div")
    WebElement containerFormDelete;

    @FindBy(xpath = "//*[@id=\"app\"]/div[3]/div/div/div/div[3]/button[2]")
    WebElement buttonDelete;

    @FindBy(xpath = "//*[@id=\"app\"]/div[3]/div/div/div/div[3]/button[1]")
    WebElement buttonCancelDelete;

//    Validation

//   (MAIN) Employee Not Found, Employee Found (SEARCH)
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[2]/div/span")
    WebElement validationSearchEmployee;

//   (ADD) empty field (EmployeeName firstname)
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[1]/div/div/div[2]/div[1]/span")
    WebElement validationAddFieldEmployeeFirstName;

//   (ADD, EDIT, DELETE) Success
    @FindBy(xpath = "//div[@id='oxd-toaster_1']/div/div/div[2]/p[2]")
    WebElement validationEmployeeSucces;

//   (EDIT)  empty field  (EmployeeName firstname)
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div/div/div/div[2]/div[1]/span")
    WebElement validationEditFieldEmployeeFirstName;

//   (ADD) Id already Exist
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[2]/div/div/span")
    WebElement validationIdAlreadyExists;

//   (ADD) too short, Missing uppercase letter, Missing special character, is guessable (Password)
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[4]/div/div[1]/div/span")
    WebElement validationPasswordInvalid;

//    (ADD) not Match (ConfirmPassword)
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[4]/div/div[2]/div/span")
    WebElement validationConfirmPasswordInvalid;

//    (EDIT) Should be a valid date in yyyy-mm-dd format
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div[2]/div[2]/div/span")
    WebElement validationLisenceDateInvalid;



//    Actions

//    Page Employee List
    public void fillSearchEmployeeName(String employee){
        waitContainerTableEmployee();
        fieldSearchEmployeeName.click();
        Actions actions = new Actions(driver);
        actions.
                keyDown(Keys.CONTROL)
                .sendKeys("a")
                .keyUp(Keys.CONTROL)
                .sendKeys(Keys.BACK_SPACE).perform();
        fieldSearchEmployeeName.sendKeys(employee);
        Delay(TWO);
    }
    public void fillSearchEmployeeId(String id){
        waitContainerTableEmployee();
        fieldSearchEmployeeId.sendKeys(id);
        Delay(TWO);
    }
    public void selectSearchStatus(String status){
        waitContainerTableEmployee();
        // 1. Klik dropdown untuk membuka opsi
        wait.until(ExpectedConditions.elementToBeClickable(dropDownSearchStatus)).click();

        // 2. Temukan dan klik opsi yang diinginkan
        WebElement statusOption = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath(String.format("//div[@role='option']//span[contains(.,'%s')]", status))
        ));

        // 3. Gunakan JavaScript click jika diperlukan
        try {
            statusOption.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", statusOption);
        }

        Delay(TWO); // Optional: Tambahkan delay jika diperlukan untuk animasi

    }
    public void selectSearchInclude(String include){
        waitContainerTableEmployee();
        Select select = new Select(dropDownSearchInclude);
        select.selectByVisibleText(include);
        Delay(TWO);
    }
    public void fillSearchSupervisor(String supervisor){
        waitContainerTableEmployee();
        fieldSearchSupervisorName.sendKeys(supervisor);
        Delay(TWO);
    }
    public void selectSearchJob(String jobTitle) {
        // 1. Klik dropdown Job Title
        WebElement jobTitleDropdown = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//label[contains(text(),'Job Title')]/following::div[contains(@class,'oxd-select-text--after')][1]")
        ));
        jobTitleDropdown.click();

        // 2. Cari opsi berdasarkan teks parameter
        WebElement jobTitleOption = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath(String.format("//div[@role='option']//span[contains(.,'%s')]", jobTitle))
        ));

        // 3. Klik opsi, fallback JS jika gagal
        try {
            jobTitleOption.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", jobTitleOption);
        }

        Delay(TWO); // jika perlu
    }
    public void selectSearchSubUnit(String subUnit){
        waitContainerTableEmployee();
        Select select = new Select(dropDownSearchSubUnit);
        select.selectByVisibleText(subUnit);
        Delay(TWO);
    }
    public void clickSearchEmployee(){
        buttonSearchEmployee.click();
        Delay(TWO);
    }
    public void clickResetSearch(){
        buttonReset.click();
        Delay(TWO);
    }
    public void clickAddEmployee(){
        waitContainerTableEmployee();
        buttonAddEmployee.click();
        Delay(TWO);
    }
    public void choiceEditEmployee(WebDriver driver,String employee){
        String xpath = String.format(
                "//div[@class='oxd-table-body']//div[contains(@class,'oxd-table-row')][.//div[normalize-space()='%s']]//i[contains(@class,'bi-pencil-fill')]",
                employee.trim()
        );

        WebElement editButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", editButton);
        Delay(TWO);
    }
//    public void choiceDeleteEmployee(WebDriver driver,String employee){
//        waitContainerTableEmployee();
//
//        String xpath = String.format(
//                "//div[@class='oxd-table-body']//div[contains(@class,'oxd-table-row')][.//div[text()='%s']]//i[contains(@class,'bi-trash')]",
//                employee.trim()
//        );
//
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement deleteButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
//        deleteButton.click();
//        Delay(TWO);
//    }

    public void choiceDeleteEmployee(WebDriver driver, String employee) {
        String xpath = String.format(
                "//div[@class='oxd-table-body']//div[contains(@class,'oxd-table-row')][.//div[normalize-space()='%s']]//i[contains(@class,'bi-trash')]",
                employee.trim()
        );

        try {
            WebElement deleteButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
            ((JavascriptExecutor)driver).executeScript("arguments[0].click();", deleteButton);
            Delay(TWO);
        } catch (TimeoutException e) {
            throw new RuntimeException("Tombol delete tidak ditemukan untuk employee: " + employee, e);
        }
    }


//    FORM ADD
    public void fillAddFirstName(String firstName){
    waitContainerFormAdd();
    fieldAddFirstName.sendKeys(firstName);
    Delay(TWO);
    }
    public void fillAddMidName(String midName){
    waitContainerFormAdd();
    fieldAddMidName.sendKeys(midName);
    Delay(TWO);
    }
    public void fillAddLastName(String lastName){
    waitContainerFormAdd();
    fieldAddLastName.sendKeys(lastName);
    Delay(TWO);
    }
    public void fillEmployeeID(String ID){
    waitContainerFormAdd();
    fieldAddEmployeeId.click();
        Actions actions = new Actions(driver);
        actions.
                keyDown(Keys.CONTROL)
                .sendKeys("a")
                .keyUp(Keys.CONTROL)
                .sendKeys(Keys.BACK_SPACE).perform();
    fieldAddEmployeeId.sendKeys(ID);
    Delay(TWO);
    }
    public void clickAddProfilImage(){
        waitContainerFormAdd();
        wait.until(ExpectedConditions.visibilityOf(buttonAddImage));
        buttonAddImage.click();
        Delay(TWO);
    }
    public void uploadImage(String fileName) throws AWTException {
        String basePath = "C:\\Users\\USER\\Downloads\\gambar\\%s";
        String fullPath = String.format(basePath, fileName);
        System.out.println("Full Path: " + fullPath);  // Cek di console

        fileInput.sendKeys(fullPath);

        // Tutup dialog file explorer dengan Robot
        Robot robot = new Robot();
        robot.delay(1000);  // Tunggu 1 detik
        robot.keyPress(KeyEvent.VK_ESCAPE);  // Tekan ESC untuk menutup
        robot.keyRelease(KeyEvent.VK_ESCAPE);
    }
    public void clickCreateLoginDetails(){
        buttonCreateLoginDetails.click();
        Delay(TWO);
    }
    public void fillUsernameLoginDetails(String username){
        fieldUsernameLoginDetails.sendKeys(username);
        Delay(TWO);
    }
    public void fillPasswordLoginDetails(String password){
        fieldPasswordLoginDetails.sendKeys(password);
        Delay(TWO);
    }
    public void fillConfirmPasswordLoginDetails(String confPassword){
        fieldConfPasswordLoginDetails.sendKeys(confPassword);
        Delay(TWO);
    }
    public void clickEnabledStatusLoginDetails(){
        bulletPointEnabledLoginDetails.click();
        Delay(TWO);
    }
    public void clickDisabledStatusLoginDetails(){
        bulletPointDisabledLoginDetails.click();
        Delay(TWO);
    }
    public void clickSaveEmployee(){
        wait.until(ExpectedConditions.visibilityOf(buttonSaveEmployee));
        buttonSaveEmployee.click();
    }
    public void clickCancelSaveEmployee(){
        wait.until(ExpectedConditions.visibilityOf(buttonCancelSaveEmployee));
        buttonCancelSaveEmployee.click();
        Delay(TWO);
    }

//    FORM EDIT

//    Page Personal Details
    public void fillOtherId(String otherId){
        fieldOtherId.click();
        Actions actions = new Actions(driver);
        actions.
                keyDown(Keys.CONTROL)
                .sendKeys("a")
                .keyUp(Keys.CONTROL)
                .sendKeys(Keys.BACK_SPACE).perform();
        fieldOtherId.sendKeys(otherId);
        Delay(TWO);
    }
    public void clearFieldFirstName(){
        wait.until(ExpectedConditions.visibilityOf(fieldEditEmployeeFirstName));
        fieldEditEmployeeFirstName.click();
        Actions actions = new Actions(driver);
        actions.
                keyDown(Keys.CONTROL)
                .sendKeys("a")
                .keyUp(Keys.CONTROL)
                .sendKeys(Keys.BACK_SPACE).perform();
        Delay(TWO);
    }
    public void clearFieldLastName(){
        wait.until(ExpectedConditions.visibilityOf(fieldEditEmployeeLastName));
        fieldEditEmployeeLastName.click();
        Actions actions = new Actions(driver);
        actions.
                keyDown(Keys.CONTROL)
                .sendKeys("a")
                .keyUp(Keys.CONTROL)
                .sendKeys(Keys.BACK_SPACE).perform();
        Delay(TWO);
    }
    public void fillEditFirstName(String firstName){
        waitContainerFormEdit();
        clearFieldFirstName();
        fieldEditEmployeeFirstName.sendKeys(firstName);
        Delay(TWO);
    }
    public void fillEditMidName(String midName){
        waitContainerFormEdit();
        fieldEditEmployeeMidName.clear();
        fieldEditEmployeeMidName.sendKeys(midName);
        Delay(TWO);
    }
    public void fillEditLastName(String lastName){
        waitContainerFormEdit();
        clearFieldLastName();
        fieldEditEmployeeLastName.sendKeys(lastName);
        Delay(TWO);
    }
    public void fillEditEmployeeID(String Id){
        fieldEditEmployeeId.click();
        Actions actions = new Actions(driver);
        actions.
                keyDown(Keys.CONTROL)
                .sendKeys("a")
                .keyUp(Keys.CONTROL)
                .sendKeys(Keys.BACK_SPACE).perform();
        Delay(TWO);
        fieldEditEmployeeId.sendKeys(Id);
    }
    public void fillEditDriverLicenseNumber(String license){
        waitContainerFormEdit();
        fieldEditDriverLicenseNumber.click();
        Actions actions = new Actions(driver);
        actions.
                keyDown(Keys.CONTROL)
                .sendKeys("a")
                .keyUp(Keys.CONTROL)
                .sendKeys(Keys.BACK_SPACE).perform();
        fieldEditDriverLicenseNumber.sendKeys(license);
        Delay(TWO);
    }
    public void choiceNationality(String nation){
        dropDopwNationality.click();
        WebElement jobTitleOption = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath(String.format("//div[@role='option']//span[contains(.,'%s')]", nation))
        ));
        try {
            jobTitleOption.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", jobTitleOption);
        }
        Delay(TWO);
    }
    public void choiceMarital(String marital){
        dropDownMaritalStatus.click();
        WebElement jobTitleOption = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath(String.format("//div[@role='option']//span[contains(.,'%s')]", marital))
        ));
        try {
            jobTitleOption.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", jobTitleOption);
        }
        Delay(TWO);
    }
    public void setDateBirth(String dateBirth){
        fieldDateBirth.click();
        Actions actions = new Actions(driver);
        actions.
                keyDown(Keys.CONTROL)
                .sendKeys("a")
                .keyUp(Keys.CONTROL)
                .sendKeys(Keys.BACK_SPACE).perform();
        fieldDateBirth.sendKeys(dateBirth);
        Delay(TWO);
    }
    public void setDateLisenceExpired(String tanggal){
        fieldLicenseExpiryDate.click();
        Actions actions = new Actions(driver);
        actions.
                keyDown(Keys.CONTROL)
                .sendKeys("a")
                .keyUp(Keys.CONTROL)
                .sendKeys(Keys.BACK_SPACE).perform();
        fieldLicenseExpiryDate.sendKeys(tanggal);
        Delay(TWO);
    }
    public void clickMale(){
        bulletPointMale.click();
        Delay(TWO);
    }
    public void clickFemale(){
        bulletPointFemale.click();
        Delay(TWO);
    }
    public void clickSaveEditPersonalDetails(){
        wait.until(ExpectedConditions.visibilityOf(buttonSaveEditPersonalDetails));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", buttonSaveEditPersonalDetails);
        wait.until(ExpectedConditions.elementToBeClickable(buttonSaveEditPersonalDetails)).click();
        Delay(TWO);
    }
    public void clickAddAttachment(){
        buttonAddAttachments.click();
        Delay(TWO);
    }
    public void uploadFileAttachment(String fileName) throws AWTException {
        String basePath = "C:\\Users\\USER\\Downloads\\gambar\\%s";
        String fullPath = String.format(basePath, fileName);
        System.out.println("Full Path: " + fullPath);  // Cek di console

        fileInput.sendKeys(fullPath);

        // Tutup dialog file explorer dengan Robot
        Robot robot = new Robot();
        robot.delay(1000);  // Tunggu 1 detik
        robot.keyPress(KeyEvent.VK_ESCAPE);  // Tekan ESC untuk menutup
        robot.keyRelease(KeyEvent.VK_ESCAPE);
        Delay(TWO);
    }
    public void fillTextAreaComment(String comment){
        textAreaComment.sendKeys(comment);
    }
    public void clickSaveAddAttachments(){
        buttonSaveAddAttachments.click();
        Delay(TWO);
    }
    public void clickCancelSaveAddAttachments(){
        buttonCancelSaveAddAttachments.click();
        Delay(TWO);
    }

//    PAGE JOB DETAILS

    public void clickSubMenuJobDetails(){
        buttonSubMenuJobDetails.click();
        Delay(TWO);
    }
    public void setJoinedDate(String joinDate){
        wait.until(ExpectedConditions.visibilityOf(fieldJoinedDate));
        fieldJoinedDate.click();
        Actions actions = new Actions(driver);
        actions.
                keyDown(Keys.CONTROL)
                .sendKeys("a")
                .keyUp(Keys.CONTROL)
                .sendKeys(Keys.BACK_SPACE).perform();
        fieldJoinedDate.sendKeys(joinDate);
        Delay(TWO);
    }
    public void selectJobTitle(String job){
        wait.until(ExpectedConditions.visibilityOf(dropDownJobTitle));
        dropDownJobTitle.click();
        WebElement jobTitleOption = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath(String.format("//div[@role='option']//span[contains(.,'%s')]", job))
        ));
        try {
            jobTitleOption.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", jobTitleOption);
        }
        Delay(TWO);
    }
    public void selectJobCategory(String categoryJob){
        wait.until(ExpectedConditions.visibilityOf(dropDownJobTitle));
        dropDownJobCategory.click();
        WebElement jobCategoryOption = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath(String.format("//div[@role='option']//span[contains(.,'%s')]", categoryJob))
        ));
        try {
            jobCategoryOption.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", jobCategoryOption);
        }
        Delay(TWO);
    }
    public void selectEmploymentStatus(String employmentStatus){
        wait.until(ExpectedConditions.visibilityOf(dropDownEmploymentStatus));
        dropDownEmploymentStatus.click();
        WebElement jobCategoryOption = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath(String.format("//div[@role='option']//span[contains(.,'%s')]", employmentStatus))
        ));
        try {
            jobCategoryOption.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", employmentStatus);
        }
    }
    public void clickSaveEditJobDetails(){
        wait.until(ExpectedConditions.visibilityOf(buttonSaveEditJobDetails));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", buttonSaveEditJobDetails);
        wait.until(ExpectedConditions.elementToBeClickable(buttonSaveEditJobDetails)).click();
        Delay(TWO);
    }

    //    FORM DELETE
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
    public void waitContainerTableEmployee(){
        wait.until(ExpectedConditions.visibilityOf(containerTableEmployee));
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

//    Validation

    //   (ADD) empty field (EmployeeName firstname)
    public String getValidationAddEmployeeFirstNameEmpty(){
        Delay(TWO);
        String validation = validationAddFieldEmployeeFirstName.getText();
        return validation;
    }

    //   (ADD) Id already Exist
    public String getValidationAddIdAlreadyExist(){
        Delay(TWO);
        String validation = validationIdAlreadyExists.getText();
        return validation;
    }

    //   (ADD) too short, Missing uppercase letter, Missing special character, is guessable (Password)
    public String getValidationAddPasswordInvalid(){
        Delay(TWO);
        String validation = validationPasswordInvalid.getText();
        return validation;
    }

    //   (ADD) not Match (ConfirmPassword)
    public String getValidationAddConfirmPasswordInvalid(){
        Delay(TWO);
        String validation = validationConfirmPasswordInvalid.getText();
        return validation;
    }

    //   (ADD, EDIT, DELETE) Success Pop-up
    public String getValidationSucces(){
//        wait.until(ExpectedConditions.visibilityOf(validationEmployeeSucces));
//        String validation = validationEmployeeSucces.getText();
//        return validation;


        // Mencocokkan semua pesan yang mengandung "Successfully"
        By toastLocator = By.xpath("//div[contains(@id,'oxd-toaster_')]//p[contains(.,'Successfully')]");

        WebElement toastElement = wait.until(
                ExpectedConditions.visibilityOfElementLocated(toastLocator)
        );
        return toastElement.getText();
    }

    //   (MAIN) Employee Not Found, Employee Found (SEARCH)
    public String getValidationSearch(){
        waitContainerTableEmployee();
        String validation = validationSearchEmployee.getText();
        return validation;
    }

    //   (EDIT)  empty field  (EmployeeName firstname)
    public String getValidationEditEmployeeFirstNameEmpty(){
        waitContainerFormEdit();
        String validation = validationEditFieldEmployeeFirstName.getText();
        return validation;
    }

    //   (EDIT) Prefil Validation
    public String getDataInFieldFirstName(){
        waitContainerFormEdit();
        wait.until(ExpectedConditions.visibilityOf(fieldEditEmployeeFirstName));
        String validasi = fieldEditEmployeeFirstName.getAttribute("value");
        return validasi;
    }

    //  (EDIT) Should be a valid date in yyyy-mm-dd format
    public String getValidationInvalidDateLisence(){
        waitContainerFormEdit();
        String validasi = validationLisenceDateInvalid.getText();
        return validasi;
    }

    // (DELETE) Canceled Form Gone
    public void validationFormDeleteGone(){
        boolean isElementGone =  waitForElementToClose(By.xpath("//*[@id=\"app\"]/div[3]/div/div/div"));
        if (isElementGone) {
            System.out.println("Form Delete Telah menghilang");
        } else {
            System.out.println("Popup masih ada.");
        }
        Delay(TWO);
    }

    //  (RESET)
    public String getFieldSearch() {
        Delay(TWO);
        String Value = fieldSearchEmployeeName.getAttribute("value");
        return Value;
    }

}


