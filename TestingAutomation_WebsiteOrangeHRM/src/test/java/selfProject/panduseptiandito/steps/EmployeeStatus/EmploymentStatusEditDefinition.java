package selfProject.panduseptiandito.steps.EmployeeStatus;

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
import selfProject.panduseptiandito.pages.PageEmploymentStatus;
import selfProject.panduseptiandito.pages.PageSystemUser;

import static selfProject.panduseptiandito.drivers.utils.TimeDuration.TWO;

public class EmploymentStatusEditDefinition {

    private PageDashboard pageDashboard;
    private PageSystemUser pageSystemUser;
    private PageEmploymentStatus pageEmploymentStatus;
    private WebDriver driver;

    @Before
    public void setup() {
        driver = DriverSingleton.getDriver(BrowserType.CHROME);
        pageDashboard = new PageDashboard(driver);
        pageSystemUser = new PageSystemUser(driver);
        pageEmploymentStatus = new PageEmploymentStatus(driver);
    }

    public void Delay(int milisecond) {
        try {
            Thread.sleep(milisecond);
        } catch (InterruptedException e) {
            Thread.currentThread();
            System.out.println("Delay Interuppted : " + e.getMessage());
        }
    }

    @Given("Saya telah mengakses bagian {string} EMPLOYMENT STATUS")
    public void openPageEmploymentStatus(String subMenu){
        pageDashboard.clickMenuAdmin();
        pageSystemUser.selectNavTabJob(subMenu);
    }

    @And("Saya menekan tombol EDIT, pada CURRENCY bernama {string} pada HALAMAN EMPLOYMENT STATUS")
    public void clickEditData(String currency){
        pageEmploymentStatus.actionEditEmploymentStatus(driver, currency);
    }

    @When("Saya menekan tombol CANCEL pada FORM EDIT EMPLOYMENT STATUS")
    public void clickCancelDelete(){
        pageEmploymentStatus.clickCancelSave();
    }

    @When("Saya mengosongkan kolom EMPLOYMENT STATUS pada FORM EDIT EMPLOYMENT STATUS")
    public void clearEmploymentStatus(){
        pageEmploymentStatus.clearfldEmploymentStatus();
    }

    @When("Saya menekan tombol SAVE pada FORM EDIT EMPLOYMENT STATUS")
    public void clickSaveEdit(){
        pageEmploymentStatus.clickSave();
    }

    @When("Saya memasukkan EMPLOYMENT STATUS BARU yaitu {string} pada FORM EDIT EMPLOYMENT STATUS")
    public void inputNewEmploymentStatus(String newStatus){
        pageEmploymentStatus.fillNameEmploymentStatus(newStatus);
    }

    //    @EmploymentStatus_Edit_Failed_Canceled  @Negative
    @Then("Terlihat FORM EDIT EMPLOYMENT STATUS telah menghilang.")
    public void verifyFormIsGone(){
        pageEmploymentStatus.getVerifyFormEditGone();
    }

    //    @EmploymentStatus_Edit_Failed_FieldEmpty, AlreadyExists  @Negative
    @Then("FITUR EDIT EMPLOYMENT STATUS menampilkan label pesan error pada EMPLOYMENT STATUS {string}")
    public void verifyEmptyEmployment(String expectMsg){
        String actualMsg = pageEmploymentStatus.getVerifyEmptyField();
        Assert.assertEquals(actualMsg, expectMsg);
        Delay(TWO);
    }



    //    @EmploymentStatus_Edit_Prefill_Validation  @Positive
    @Then("Data {string} berhasil terisi otomatis pada FORM EDIT EMPLOYMENT STATUS sesuai data pada tabel EMPLOYMENT STATUS.")
    public void verifyPrefill(String expectMsg){
        String actualMsg = pageEmploymentStatus.getVerifyDataInField();
        Assert.assertEquals(actualMsg, expectMsg);
        Delay(TWO);
    }

    //    @EmploymentStatus_Edit_Succes  @Positive
    @Then("Data mengalami perubahan serta, FITUR EDIT EMPLOYMENT STATUS berhasil menampilkan pesan {string}")
    public void verifySuccesEdit(String expectMsg){
        String actualMsg = pageEmploymentStatus.getVerifySucces();
        Assert.assertEquals(actualMsg, expectMsg);
        Delay(TWO);
    }


}
