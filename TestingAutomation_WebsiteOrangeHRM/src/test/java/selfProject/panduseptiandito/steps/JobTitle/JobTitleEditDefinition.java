package selfProject.panduseptiandito.steps.JobTitle;

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
import selfProject.panduseptiandito.pages.PageJobTitles;
import selfProject.panduseptiandito.pages.PageSystemUser;

import java.awt.*;

import static selfProject.panduseptiandito.drivers.utils.TimeDuration.TWO;

public class JobTitleEditDefinition {

    private PageDashboard pageDashboard;
    private PageSystemUser pageSystemUser;
    private PageJobTitles pageJobTitles;
    private WebDriver driver;

    @Before
    public void setup() {
        driver = DriverSingleton.getDriver(BrowserType.CHROME);
        pageDashboard = new PageDashboard(driver);
        pageSystemUser = new PageSystemUser(driver);
        pageJobTitles = new PageJobTitles(driver);
    }

    public void Delay(int milisecond) {
        try {
            Thread.sleep(milisecond);
        } catch (InterruptedException e) {
            Thread.currentThread();
            System.out.println("Delay Interuppted : " + e.getMessage());
        }
    }

    @Given("Saya telah mengakses bagian {string}")
    public void openPageJobTitle(String subMenu){
        pageDashboard.clickMenuAdmin();
        pageSystemUser.selectNavTabJob(subMenu);
    }

    @And("Saya menekan tombol EDIT, pada JOB bernama {string} pada HALAMAN JOB TITLES")
    public void clicEditData(String Job){
        pageJobTitles.actionEditJobData(driver,Job);
    }

    @When("Saya menekan tombol CANCEL pada FORM EDIT JOB TITLES")
    public void clickCancelEdit(){
        pageJobTitles.clickCancelSaveJobTitle();
    }

    @When("Saya mengosongkan kolom JOB TITLE pada FORM EDIT JOB TITLES")
    public void clearFieldJobTitle(){
        pageJobTitles.clearFieldJobTitle();
    }

    @When("Saya menekan tombol SAVE pada FORM EDIT JOB TITLES")
    public void clickSaveEdit(){
        pageJobTitles.clickSaveJobTitle();
    }

    @When("Saya memasukkan JOB TITLE BARU yaitu {string} pada FORM EDIT JOB TITLES")
    public void inputJobTitle(String job){
        pageJobTitles.fillJobTitle(job);
    }

    @And("Saya memasukkan JOB DESCRIPTION BARU {string} pada FORM EDIT JOB TITLES")
    public void inputJobDescription(String description){
        pageJobTitles.fillJobDescription(description);
    }

    @When("Saya memilih file baru {string} untuk di Upload pada JOB SPESIFICATION pada FORM EDIT JOB TITLES")
    public void uploadNewFile(String urlFile) throws AWTException {
        pageJobTitles.uploadNewFile(urlFile);
    }

    @And("Saya memasukkan NOTE BARU {string} pada FORM EDIT JOB TITLES")
    public void inputNote(String note){
        pageJobTitles.fillJobNote(note);
    }

    //    @Job_Edit_Failed_Canceled  @Negative
    @Then("Terlihat FORM EDIT JOB TITLES telah menghilang.")
    public void verifyFormIsGone(){
        pageJobTitles.getVerifynFormEditGone();
    }

    //    @Job_Edit_Failed_FieldEmpty  @Negative
    @Then("FITUR EDIT JOB TITLE menampilkan label pesan error pada JOB TITLE {string}")
    public void verifyErrFieldEmpty(String expectedMsg){
        String actualMsg = pageJobTitles.getVerifyEmptyField();
        Assert.assertEquals(actualMsg,expectedMsg);
        Delay(TWO);
    }

    //    @Job_Edit_Prefill_Validation  @Positive
    @Then("Data {string} berhasil terisi otomatis pada FORM EDIT JOB TITLES sesuai data pada tabel JOB.")
    public void verifyPrefill(String expectedMsg){
        String actualMsg = pageJobTitles.getVerifyDataInField();
        Assert.assertEquals(actualMsg, expectedMsg);
        Delay(TWO);
    }

    //    @User_Edit_Succes  @Positive
    @Then("Data mengalami perubahan serta, FITUR EDIT JOB TITLES berhasil menampilkan pesan {string}")
    public void verifySuccesEdit(String expectedMsg){
        String actualMsg = pageJobTitles.getVerifySucces();
        Assert.assertEquals(actualMsg,expectedMsg);
        Delay(TWO);
    }


}
