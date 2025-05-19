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

import static selfProject.panduseptiandito.drivers.utils.TimeDuration.TWO;

public class JobTitleDeleteDefinition {


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

    @Given("Halaman {string} sekarang terbuka.")
    public void openPageJobTitle(String subMenu){
        pageDashboard.clickMenuAdmin();
        pageSystemUser.selectNavTabJob(subMenu);
    }

    @And("Saya menekan tombol DELETE, pada JOB TITLE bernama {string}")
    public void clickDeleteData(String job){
        pageJobTitles.actionDeleteJobData(driver, job);
    }

    @When("Saya menekan tombol NO, CANCEL pada FORM DELETE JOB TITLE")
    public void clickCancelDelete(){
        pageJobTitles.clickCancelDelete();
    }

    //    @Job_Delete_Failed_Canceled  @Negative
    @Then("Terlihat FORM DELETE JOB TITLE telah menghilang.")
    public void verifyFormIsGone(){
        pageJobTitles.getVerifynFormDeleteGone();
    }

    @When("Saya menekan tombol YES, DELETE pada FORM DELETE JOB TITLE")
    public void clickDelete(){
        pageJobTitles.clickDelete();
    }

    //    @Job_Delete_Succes  @Positive
    @Then("JOB TITLE berhasil dihapus pada table dan menampilkan pesan {string}")
    public void verifySuccesDelete(String expectedMsg){
        String actualMsg = pageJobTitles.getVerifySucces();
        Assert.assertEquals(actualMsg, expectedMsg);
        Delay(TWO);
    }

}
