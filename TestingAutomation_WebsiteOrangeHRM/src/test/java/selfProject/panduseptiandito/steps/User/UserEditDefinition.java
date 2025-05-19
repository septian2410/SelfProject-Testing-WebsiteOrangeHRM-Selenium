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

public class UserEditDefinition {

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

    @Given("Saya telah mengakses bagian User Management.")
    public void openPageUser(){
        pageDashboard.clickMenuAdmin();    }

    @And("Saya menekan tombol EDIT, pada USER bernama {string} pada HALAMAN USER MANAGEMENT")
    public void clickEditData(String user){
       pageSystemUser.choiceEditUser(driver,user);
    }

    @When("Saya memasukkan USERNAME BARU yaitu {string} pada FORM EDIT USER")
    public void inputNewUsername(String username){
        pageSystemUser.fillEditUsername(username);
    }

//    And Saya memasukkan NAMA EMPLOYEE BARU yaitu "Dummy Statis Data Baru" pada FORM EDIT USER

    @When("Saya memilih USER ROLE BARU yaitu {string} pada FORM EDIT USER")
    public void selectNewUserRole(String role){
        pageSystemUser.selectEditUserRole(role);
    }

    @And("Saya memilih STATUS USER BARU yaitu {string} pada FORM EDIT USER")
    public void selectNewStatusUser(String status){
        pageSystemUser.selectEditStatus(status);
    }

    @When("Saya menekan tombol CHANGE PASSWORD pada FORM EDIT USER")
    public void clickChangePassword(){
        pageSystemUser.clickEditCheckBoxChangePassword();
    }

    @And("Saya memasukkan PASSWORD BARU yaitu {string} pada FORM EDIT USER")
    public void inputNewPassword(String password){
        pageSystemUser.fillPassword(password);
    }

    @When("Saya memasukkan CONFIRMASI PASSWORD BARU yaitu {string} pada FORM EDIT USER")
    public void inputNewConfPassword(String confPassword){
            pageSystemUser.fillConfirmPassword(confPassword);
    }

    @And("Saya mengklik tombol SAVE pada FORM EDIT USER")
    public void clickSaveEditUserChangePassword(){
        pageSystemUser.clickEditSaveUserChangePassword();
    }

    @And("Saya menekan tombol SAVE pada FORM EDIT USER")
    public void clickSaveEditUser(){
        pageSystemUser.clickEditSaveUser();
    }

    @When("Saya menekan tombol CANCEL pada FORM EDIT USER")
    public void clickCancelEdit(){
        pageSystemUser.clickEditCancelSaveUser();
    }

    @When("Saya mengosongkan kolom USERNAME pada FORM EDIT USER")
    public void clearFieldUsername(){
        pageSystemUser.clearFieldEditUsername();
    }

    @And("Saya memasukkan NAMA EMPLOYEE BARU yaitu {string} pada FORM EDIT USER")
    public void inputNewEmployee(String employee){
        pageSystemUser.fillEditEmployee(employee);
    }


    //    @User_Edit_Failed_Canceled  @Negative
    @Then("Terlihat FORM EDIT USER telah menghilang.")
    public void validationFormIsGone(){
        pageSystemUser.getValidationFormEditGone();
    }

    //    @User_Edit_Failed_FieldEmpty, UsernameTooShort  @Negative
    @Then("FITUR EDIT USER menampilkan label pesan error pada USERNAME {string}")
    public void validationErrUsername(String expectedMsg){
        String actualMsg = pageSystemUser.getValidationErrUsername();
        Assert.assertEquals(actualMsg, expectedMsg);
        Delay(TWO);
    }

    //    @User_Edit_Failed_EmployeeNameInvalid  @Positive
    @Then("FITUR EDIT USER menampilkan label pesan error pada EMPLOYEE NAME {string}")
    public void validationErrEmployee(String expectedMsg){
        String actualMsg = pageSystemUser.getValidationErrEmployee();
        Assert.assertEquals(actualMsg, expectedMsg);
        Delay(TWO);
    }

    //    @User_Edit_Prefill_Validation  @Positive
    @Then("Data {string} berhasil terisi otomatis pada FORM EDIT EMPLOYEE sesuai data pada tabel USER.")
    public void validationPrefil(String expectedMsg){
        String actualMsg = pageSystemUser.getValidationDataInField();
        Assert.assertEquals(actualMsg, expectedMsg);
        Delay(TWO);
    }

    //    @User_Edit_Succes, Without_ChangePassword  @Positive
    @Then("Data mengalami perubahan serta, FITUR EDIT USER berhasil menampilkan pesan {string}")
    public void validationSucces(String expectedMsg){
        String actualMsg = pageSystemUser.getValidationSucces();
        Assert.assertEquals(actualMsg, expectedMsg);
        Delay(TWO);
    }





}
