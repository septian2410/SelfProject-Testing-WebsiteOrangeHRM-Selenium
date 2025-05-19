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

public class EmploymentStatusDeleteDefinition {

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

    @Given("Halaman {string} sekarang terbuka. EMPLOYMENT STATUS")
    public void openPageEmploymentStatus(String subMenu){
        pageDashboard.clickMenuAdmin();
        pageSystemUser.selectNavTabJob(subMenu);
    }

    @And("Saya menekan tombol DELETE, pada EMPLOYMENT STATUS bernama {string}")
    public void clickDeleteData(String status){
        pageEmploymentStatus.actionDeleteEmploymentStatus(driver, status);
    }

    @When("Saya menekan tombol NO, CANCEL pada FORM DELETE EMPLOYMENT STATUS")
    public void clickCancelDelete(){
        pageEmploymentStatus.clickCancelDelete();
    }

    @When("Saya menekan tombol YES, DELETE pada FORM DELETE EMPLOYMENT STATUS")
    public void clickDelete(){
        pageEmploymentStatus.clickDelete();
    }

    //    @EmploymentStatus_Delete_Failed_Canceled  @Negative
    @Then("Terlihat FORM DELETE EMPLOYMENT STATUS telah menghilang.")
    public void verifyFormIsGone(){
        pageEmploymentStatus.getVerifyFormDeleteGone();
    }

    //    @EmploymentStatus_Delete_Succes  @Positive
    @Then("EMPLOYMENT STATUS berhasil dihapus pada table dan menampilkan pesan {string}")
    public void verifySuccesDelete(String expectMsg){
        String actualMsg = pageEmploymentStatus.getVerifySucces();
        Assert.assertEquals(actualMsg, expectMsg);
        Delay(TWO);
    }

}
