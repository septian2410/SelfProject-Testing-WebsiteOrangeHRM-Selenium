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

import static selfProject.panduseptiandito.drivers.utils.TimeDuration.THREE;
import static selfProject.panduseptiandito.drivers.utils.TimeDuration.TWO;

public class EmploymentStatusAddDefinition {

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

    @Given("Tab {string} telah dimuat. EMPLOYMENT STATUS")
    public void openPageEmploymentStatus(String subMenu){
        pageDashboard.clickMenuAdmin();
        pageSystemUser.selectNavTabJob(subMenu);
    }

    @When("Saya menekan tombol ADD pada HALAMAN EMPLOYMENT STATUS")
    public void clickAddEmploymentStatus(){
        pageEmploymentStatus.clickAddEmploymentStatus();
    }

    @And("Saya menekan tombol CANCEL pada pada FORM ADD EMPLOYMENT STATUS")
    public void clickCancelSave(){
        pageEmploymentStatus.clickCancelSave();
    }

    @When("Saya menekan tombol SAVE pada FORM ADD EMPLOYMENT STATUS")
    public void clickSave(){
        pageEmploymentStatus.clickSave();
    }

    @And("Saya memasukkan EMPLOYMENT STATUS {string} pada FORM ADD EMPLOYMENT STATUS")
    public void inputEmploymentStatus(String status){
        pageEmploymentStatus.fillNameEmploymentStatus(status);
    }

    //    @EmploymentStatus_Add_Failed_Canceled  @Negative
    @Then("Terlihat FORM ADD EMPLOYMENT STATUS telah hilang.")
    public void verifyFormIsGone(){
        pageEmploymentStatus.getVerifyFormAddIsGone();
    }

    //    @EmploymentStatus_Add_Failed_FieldEmpty , AlreadyExists  @Negative
    @Then("FITUR TAMBAHKAN EMPLOYMENT STATUS menampilkan pesan ERROR pada field EMPLOYMENT STATUS {string}")
    public void verifyEmptyEmploymentStatus(String expectMsg){
        String actualMsg = pageEmploymentStatus.getVerifyEmptyField();
        Assert.assertEquals(actualMsg, expectMsg);
        Delay(TWO);
    }

    //    @EmploymentStatus_Add_Succes  @Positive
    @Then("FITUR TAMBAHKAN EMPLOYMENT STATUS menampilkan pesan Success {string}")
    public void verifySuccesAdd(String expectMsg){
        String actualMsg = pageEmploymentStatus.getVerifySucces();
        Assert.assertEquals(actualMsg, expectMsg);
        Delay(TWO);
    }

}
