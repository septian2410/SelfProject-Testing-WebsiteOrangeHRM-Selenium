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
import selfProject.panduseptiandito.pages.PageJobTitles;
import selfProject.panduseptiandito.pages.PageSystemUser;

import static selfProject.panduseptiandito.drivers.utils.TimeDuration.TWO;

public class JobCategoriesAddDefinition {

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

    @Given("Tab {string} telah dimuat. JOB CATEGORIES")
    public void openPageJobCategories(String subMenu){
        pageDashboard.clickMenuAdmin();
        pageSystemUser.selectNavTabJob(subMenu);
    }

    @When("Saya menekan tombol ADD pada HALAMAN JOB CATEGORIES")
    public void clickAddJobCategories(){
        pageJobCategories.clickAddJobCategories();
    }

    @And("Saya menekan tombol CANCEL pada pada FORM ADD JOB CATEGORIES")
    public void clickCancelSave(){
        pageJobCategories.clickCancelSave();
    }

    @When("Saya menekan tombol SAVE pada FORM ADD JOB CATEGORIES")
    public void clickSave(){
        pageJobCategories.clickSave();
    }

    @And("Saya memasukkan JOB CATEGORY {string} pada FORM ADD JOB CATEGORIES")
    public void inputJobCategory(String category){
        pageJobCategories.fillJobCategory(category);
    }

    //    @JobCategories_Add_Failed_Canceled  @Negative
    @Then("Terlihat FORM ADD JOB CATEGORIES telah hilang.")
    public void verifyFormIsGone(){
        pageJobCategories.getVerifyFormAddIsGone();
    }

    //    @JobCategories_Add_Failed_FieldEmpty, AlreadyExists  @Negative
    @Then("FITUR TAMBAHKAN JOB CATEGORIES menampilkan pesan ERROR pada field JOB CATEGORY {string}")
    public void verifyErrEmpty(String expectMsg){
        String actualMsg = pageJobCategories.getVerifyEmptyField();
        Assert.assertEquals(actualMsg, expectMsg);
        Delay(TWO);
    }

    //    @JobCategories_Add_Succes  @Positive
    @Then("FITUR TAMBAHKAN JOB CATEGORIES menampilkan pesan Success {string}")
    public void verifySuccesAdd(String expectMsg){
        String actualMsg = pageJobCategories.getVerifySucces();
        Assert.assertEquals(actualMsg, expectMsg);
        Delay(TWO);
    }

}
