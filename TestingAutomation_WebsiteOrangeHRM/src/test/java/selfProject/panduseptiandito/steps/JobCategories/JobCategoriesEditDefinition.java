package selfProject.panduseptiandito.steps.JobCategories;

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
import selfProject.panduseptiandito.pages.PageJobCategories;
import selfProject.panduseptiandito.pages.PageSystemUser;

import static selfProject.panduseptiandito.drivers.utils.TimeDuration.TWO;

public class JobCategoriesEditDefinition {

    private PageDashboard pageDashboard;
    private PageSystemUser pageSystemUser;
    private PageJobCategories pageJobCategories;
    private WebDriver driver;

    @Before
    public void setup() {
        driver = DriverSingleton.getDriver(BrowserType.CHROME);
        pageDashboard = new PageDashboard(driver);
        pageSystemUser = new PageSystemUser(driver);
        pageJobCategories = new PageJobCategories(driver);
    }

    public void Delay(int milisecond) {
        try {
            Thread.sleep(milisecond);
        } catch (InterruptedException e) {
            Thread.currentThread();
            System.out.println("Delay Interuppted : " + e.getMessage());
        }
    }

    @Given("Saya telah mengakses bagian {string} JOB CATEGORIES")
    public void openPageJobCategories(String subMenu){
        pageDashboard.clickMenuAdmin();
        pageSystemUser.selectNavTabJob(subMenu);
    }

    @And("Saya menekan tombol EDIT, pada JOB CATEGORY bernama {string} pada HALAMAN JOB CATEGORIES")
    public void clickEditData(String category){
        pageJobCategories.actionEditJobCategories(driver, category);
    }

    @When("Saya menekan tombol CANCEL pada FORM EDIT JOB CATEGORIES")
    public void clickCancelEdit(){
        pageJobCategories.clickCancelSave();
    }

    @When("Saya mengosongkan kolom JOB CATEGORIES pada FORM EDIT JOB CATEGORIES")
    public void clearField(){
        pageJobCategories.clearfldJobCategory();
    }

    @When("Saya menekan tombol SAVE pada FORM EDIT JOB CATEGORIES")
    public void clickSaveEdit(){
        pageJobCategories.clickSave();
    }

    @When("Saya memasukkan JOB CATEGORY BARU yaitu {string} pada FORM EDIT JOB CATEGORIES")
    public void inputNewJobCategory(String category){
        pageJobCategories.fillJobCategory(category);
    }

    //    @JobCategories_Edit_Failed_Canceled  @Negative
    @Then("Terlihat FORM EDIT JOB CATEGORIES telah menghilang.")
    public void verifyFormIsGone(){
        pageJobCategories.getVerifyFormEditGone();
    }

    //    @JobCategories_Edit_Failed_FieldEmpty, AlreadyExists  @Negative
    @Then("FITUR EDIT JOB CATEGORIES menampilkan label pesan error pada JOB CATEGORY {string}")
    public void verifyErrfield(String expectMsg){
        String actualMsg = pageJobCategories.getVerifyEmptyField();
        Assert.assertEquals(actualMsg, expectMsg);
        Delay(TWO);
    }

    //    @JobCategories_Edit_Prefill_Validation  @Positive
    @Then("Data {string} berhasil terisi otomatis pada FORM EDIT JOB CATEGORIES sesuai data pada tabel JOB CATEGORIES.")
    public void verifPrefill(String expectMsg){
        String actualMsg = pageJobCategories.getVerifyDataInField();
        Assert.assertEquals(actualMsg, expectMsg);
        Delay(TWO);
    }

    //    @JobCategories_Edit_Succes  @Positive
    @Then("Data mengalami perubahan serta, FITUR EDIT JOB CATEGORIES berhasil menampilkan pesan {string}")
    public void verifySuccesEdit(String expectMsg){
        String actualMsg = pageJobCategories.getVerifySucces();
        Assert.assertEquals(actualMsg, expectMsg);
        Delay(TWO);
    }


}
