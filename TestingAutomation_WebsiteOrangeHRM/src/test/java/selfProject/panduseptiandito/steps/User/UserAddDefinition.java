package selfProject.panduseptiandito.steps.User;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import selfProject.panduseptiandito.DriverSingleton;
import selfProject.panduseptiandito.drivers.utils.BrowserType;
import selfProject.panduseptiandito.pages.PageDashboard;
import selfProject.panduseptiandito.pages.PageSystemUser;

import static selfProject.panduseptiandito.drivers.utils.TimeDuration.TWO;

public class UserAddDefinition {


    private PageDashboard pageDashboard;
    private PageSystemUser pageSystemUser;
    private WebDriver driver;

    @Before
    public void setup() {
        driver = DriverSingleton.getDriver(BrowserType.CHROME);
        pageDashboard = new PageDashboard(driver);
        pageSystemUser = new PageSystemUser(driver);
    }

    public void Delay(int milisecond) {
        try {
            Thread.sleep(milisecond);
        } catch (InterruptedException e) {
            Thread.currentThread();
            System.out.println("Delay Interuppted : " + e.getMessage());
        }
    }


    @Given("Tab User Management telah dimuat.")
    public void openPageUser(){
        pageDashboard.clickMenuAdmin();
    }

    @When("Saya menekan tombol ADD USER pada HALAMAN USER MANAGEMENT")
    public void clickAddUser(){
        pageSystemUser.clickAddUser();
    }

    @And("Saya memasukkan EMPLOYEE NAME {string} pada FORM ADD USER")
    public void inputEmployeeName(String employee){
        pageSystemUser.fillAddEmployeeName(employee);
    }

    @When("Saya memasukkan USERNAME {string} pada FORM ADD USER")
    public void inputUsername(String username){
        pageSystemUser.fillAddUsername(username);
    }

    @And("Saya memilih USER ROLE baru yaitu {string} pada FORM ADD USER")
    public void selectUserRole(String role){
        pageSystemUser.selectAddUserRole(role);
    }

    @When("Saya memilih STATUS USER baru yaitu {string} pada FORM ADD USER")
    public void selectStatusUser(String status){
        pageSystemUser.selectAddStatus(status);
    }

    @And("Saya memasukkan PASSWORD baru {string} pada FORM ADD USER")
    public void inputPassword(String password){
        pageSystemUser.fillPassword(password);
    }

    @When("Saya memasukkan CONFIRMASI PASSWORD baru {string} pada FORM ADD USER")
    public void inputConfPassword(String confPassword){
        pageSystemUser.fillConfirmPassword(confPassword);
    }

    @And("Saya menekan tombol SAVE pada pada FORM ADD USER")
    public void clickSaveAddUser(){
        pageSystemUser.clickSaveAddUser();
    }

    @And("Saya menekan tombol CANCEL pada pada FORM ADD USER")
    public void clickCancel(){
        pageSystemUser.clickCancelSaveAddUser();
    }

    //    @User_Add_Failed_FieldEmpty, Invalid  @Negative
    @Then("FITUR TAMBAHKAN USER menampilkan pesan error pada field EMPLOYEE NAME {string}")
    public void validationFieldEmpty(String expectedMsg){
        String actualMsg = pageSystemUser.getValidationErrEmployee();
        Assert.assertEquals(actualMsg, expectedMsg);
        Delay(TWO);
    }

    //    @User_Add_Failed_CancelAddEmployee  @Negative
    @Then("Terlihat FORM ADD USER telah hilang.")
    public void validationFormIsGone() throws InterruptedException {
        pageSystemUser.getvalidationFormAddIsGone();
    }

    //    @User_Add_Failed_with_Passwordtooshort, PasswordMissingUpperCase, PasswordMissingSpecialCharacter, PasswordIsGuessable  @Negative
    @Then("FITUR TAMBAHKAN USER menampilkan label pesan error PASSWORD {string}")
    public void validationErrPassword(String expecteMsg){
        String actualMsg = pageSystemUser.getValidationErrPassword();
        Assert.assertEquals(actualMsg, expecteMsg);
        Delay(TWO);
    }

    //    @User_Add_Failed_with_PasswordNotMatch @Negative
    @Then("FITUR TAMBAHKAN USER menampilkan label pesan error CONFIRMASI PASSWORD {string}")
    public void validationErrConfPassword(String expecteMsg){
        String actualMsg = pageSystemUser.getValidationErrConfPassword();
        Assert.assertEquals(actualMsg, expecteMsg);
        Delay(TWO);
    }

    //    @User_Add_Succes  @Positive
    @Then("FITUR TAMBAHKAN USER menampilkan pesan Success {string}")
    public void validationAddSuccess(String expectedMsg){
        String actualMsg = pageSystemUser.getValidationSucces();
        Assert.assertEquals(actualMsg, expectedMsg);
        Delay(TWO);
    }



}
