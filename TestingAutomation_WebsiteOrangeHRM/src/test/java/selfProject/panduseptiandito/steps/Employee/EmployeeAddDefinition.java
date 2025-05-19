package selfProject.panduseptiandito.steps.Employee;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import selfProject.panduseptiandito.DriverSingleton;
import selfProject.panduseptiandito.drivers.utils.BrowserType;
import selfProject.panduseptiandito.pages.PageDashboard;
import selfProject.panduseptiandito.pages.PageEmployeeList;

import java.awt.*;

import static selfProject.panduseptiandito.drivers.utils.TestUtils.waitForElementToClose;
import static selfProject.panduseptiandito.drivers.utils.TimeDuration.TWO;

public class EmployeeAddDefinition {

    private WebDriver driver;
    private PageEmployeeList pageEmployeeList;
    private PageDashboard pageDashboard;

    @Before
    public void setup(){
        driver = DriverSingleton.getDriver(BrowserType.CHROME);
        pageDashboard = new PageDashboard(driver);
        pageEmployeeList = new PageEmployeeList(driver);
    }

    public void Delay(int milisecond){
        try{
            Thread.sleep(milisecond);
        }catch (InterruptedException e){
            Thread.currentThread();
            System.out.println("Delay Interuppted : "+e.getMessage());
        }
    }

    @Given("halaman Employee telah dimuat.")
    public void openEmployeePage(){
        pageDashboard.clickMenuPIM();
    }

    @And("Saya menekan tombol ADD pada halaman Employee List")
    public void clickAddEmployee(){
        pageEmployeeList.clickAddEmployee();
    }

    @When("Saya langsung menekan tombol SAVE pada form add employee")
    public void clickBtnSave(){
        pageEmployeeList.clickSaveEmployee();
    }

    @And("Saya menekan kembali tombol ADD pada halaman Employee List")
    public void clickAddEmployeeAgain(){
        pageEmployeeList.clickAddEmployee();
    }

    @When("Saya menekan tombol ADD PROFIL, lalu mengupload foto profil dengan nama {string}")
    public void uploadProfilImage(String urlPict) throws AWTException {
        pageEmployeeList.clickAddProfilImage();
        pageEmployeeList.uploadImage(urlPict);
        Delay(TWO);
    }

    @And("Saya memasukkan FIRST NAME employee baru {string}")
    public void inputFirstName(String firstname){
        pageEmployeeList.fillAddFirstName(firstname);
    }

    @When("Saya memasukkan LAST NAME employee baru {string}")
    public void inputLastName(String lastname){
        pageEmployeeList.fillAddLastName(lastname);
    }

    @And("Saya memasukkan EMPLOYEE ID baru {string}")
    public void inputEmployeeID(String ID){
    pageEmployeeList.fillEmployeeID(ID);
    }

    @And("Saya menekan tombol SAVE pada form add employee")
    public void clickSaveEmployee(){
        pageEmployeeList.clickSaveEmployee();
    }

    @When ("Saya menekan CREATE LOGIN DETAILS")
    public void clickCreateLoginDetails(){
        pageEmployeeList.clickCreateLoginDetails();
    }

    @And("Saya memasukkan USERNAME baru {string}")
    public void inputNewUsername(String username){
        pageEmployeeList.fillUsernameLoginDetails(username);
    }

    @When("Saya memasukkan PASSWORD baru {string}")
    public void inputNewPassword(String password){
        pageEmployeeList.fillPasswordLoginDetails(password);
    }

    @And("Saya memasukkan CONFIRMASI PASSWORD baru {string}")
    public void inputNewConfirmPassword(String confPassword){
        pageEmployeeList.fillConfirmPasswordLoginDetails(confPassword);
    }

    @And("Saya menekan tombol CANCEL pada FORM ADD EMPLOYEE")
    public void clickCancelAdd(){
        pageEmployeeList.clickCancelSaveEmployee();
    }

    //   Canceled  @Negative
    @Then("Terlihat formulir ADD EMPLOYEE telah hilang.")
    public void validationFormAddGone(){
        boolean isElementGone =  waitForElementToClose(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]"));
        if (isElementGone) {
            System.out.println("Form Add Telah menghilang");
        } else {
            System.out.println("Popup masih ada.");
        }
        Delay(TWO);
    }

    //    FieldEmpty  @Negative
    @Then("fitur tambahkan employee menampilkan label pesan error {string}")
    public void validationFieldEmpty(String expectedMsg){
        String actualMsg = pageEmployeeList.getValidationAddEmployeeFirstNameEmpty();
        Assert.assertEquals(actualMsg, expectedMsg);
        Delay(TWO);
    }

    //    IdAlreadyExists  @Negative
    @Then("fitur tambahkan employee menampilkan label pesan error ID {string}")
    public void validationIdAlreadyExists(String expectedMsg){
        String actualMsg = pageEmployeeList.getValidationAddIdAlreadyExist();
        Assert.assertEquals(actualMsg, expectedMsg);
        Delay(TWO);
    }

    //    Passwordtooshort, PasswordMissingUpperCase, PasswordMissingSpecialCharacter, PasswordIsGuessable
    @Then("fitur tambahkan employee menampilkan label pesan error PASSWORD {string}")
    public void validationInvalidPassword(String expectedMsg){
        String actualMsg = pageEmployeeList.getValidationAddPasswordInvalid();
        Assert.assertEquals(actualMsg, expectedMsg);
        Delay(TWO);
    }

    //    PasswordNotMatch
    @Then("fitur tambahkan employee menampilkan label pesan error PASSWORD CONFIRMASI {string}")
    public void validationInvalidConfPassword(String expectedMsg){
        String actualMsg = pageEmployeeList.getValidationAddConfirmPasswordInvalid();
        Assert.assertEquals(actualMsg, expectedMsg);
        Delay(TWO);
    }

    //    Add_Succes , Add_Succes_with_CreateLoginDetails  @Positive
    @Then("fitur tambahkan employee menampilkan pesan Success {string}")
    public void validationSucces(String expectedMsg){
        String actualMsg = pageEmployeeList.getValidationSucces();
        Assert.assertTrue(actualMsg.contains(expectedMsg));
        Delay(TWO);
    }



}
