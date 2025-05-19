package selfProject.panduseptiandito.steps.JobCategories;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import selfProject.panduseptiandito.DriverSingleton;
import selfProject.panduseptiandito.drivers.utils.BrowserType;
import selfProject.panduseptiandito.pages.PageDashboard;
import selfProject.panduseptiandito.pages.PageJobCategories;
import selfProject.panduseptiandito.pages.PageSystemUser;

import static selfProject.panduseptiandito.drivers.utils.TimeDuration.TWO;

public class JobCategoriesDeleteDefinition {

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

    @Given("Halaman {string} sekarang terbuka. JOB CATEGORIES")
    public void openPageJobCategories(String subMenu){
        pageDashboard.clickMenuAdmin();
        pageSystemUser.selectNavTabJob(subMenu);
    }

    @And("Saya menekan tombol DELETE, pada JOB CATEGORY bernama {string}")
    public void clickDeleteData(String category){
        pageJobCategories.actionDeleteJobCategories(driver, category);
    }

    @When("Saya menekan tombol NO, CANCEL pada FORM DELETE JOB CATEGORY")
    public void clickCancelDelete(){
        pageJobCategories.clickCancelDelete();
    }

    @When("Saya menekan tombol YES, DELETE pada FORM DELETE JOB CATEGORY")
    public void clickDelete(){
        pageJobCategories.clickDelete();
    }

    //    @JobCategories_Delete_Failed_Canceled  @Negative
    @Then("Terlihat FORM DELETE JOB CATEGORY telah menghilang.")
    public void verifyFormIsGone(){
        pageJobCategories.getVerifyFormDeleteGone();
    }

    //    @JobCategories_Delete_Succes  @Positive
    @Then("JOB CATEGORY berhasil dihapus pada table dan menampilkan pesan {string}")
    public void verifySuccesDelete(String expectMsg){
        String actualMsg = pageJobCategories.getVerifySucces();
        Delay(TWO);
    }

}
