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

public class JobTitleAddDefinition {

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

    @Given("Tab {string} telah dimuat.")
    public void openPageJobDetail(String subMenu){
        pageDashboard.clickMenuAdmin();
        pageSystemUser.selectNavTabJob(subMenu);
    }

    @When("Saya menekan tombol ADD pada HALAMAN JOB TITLE")
    public void clickAddJobTitle(){
        pageJobTitles.clickAddJobTitle();
    }

    @And("Saya menekan tombol SAVE pada pada FORM ADD JOB TITLE")
    public void clickSaveAdd(){
        pageJobTitles.clickSaveJobTitle();
    }

    @And("Saya menekan tombol CANCEL pada pada FORM JOB TITLE")
    public void clickCancelSaveAdd(){
        pageJobTitles.clickCancelSaveJobTitle();
    }

    @And("Saya memasukkan JOB TITLE {string} pada FORM JOB TITLE")
    public void inputJobTitle(String job){
        pageJobTitles.fillJobTitle(job);
    }

    @When("Saya memasukkan JOB DESCRIPTION {string} pada FORM JOB TITLE")
    public void inputJobDescription(String description){
        pageJobTitles.fillJobDescription(description);
    }

    @And("Saya memilih file {string} untuk di Upload pada JOB SPESIFICATION pada FORM JOB TITLE")
    public void uploadFile(String urlFile) throws AWTException {
        pageJobTitles.uploadFile(urlFile);
        Delay(TWO);
    }

    @When("Saya memasukkan NOTE {string} pada FORM JOB TITLE")
    public void inputNote(String note){
        pageJobTitles.fillJobNote(note);
    }

    //    @Job_Add_Failed_FieldEmpty, AlreadyExists  @Negative
    @Then("FITUR TAMBAHKAN JOB TITLE menampilkan pesan error pada field JOB TITLE {string}")
    public void verifyFieldEmpty(String expectedMsg){
        String actualMsg = pageJobTitles.getVerifyEmptyField();
        Assert.assertEquals(actualMsg, expectedMsg);
        Delay(TWO);
    }

    //    @Job_Add_Failed_Canceled  @Negative
    @Then("Terlihat FORM ADD JOB TITLE telah hilang.")
    public void verifyFormIsGone(){
        pageJobTitles.getVerifynFormAddGone();
    }

    //    @Job_Add_Succes  @Positive
    @Then("FITUR TAMBAHKAN JOB TITLE menampilkan pesan Success {string}")
    public void verifySucces(String expectedMsg){
        String actualMsg = pageJobTitles.getVerifySucces();
        Delay(TWO);
    }

}
