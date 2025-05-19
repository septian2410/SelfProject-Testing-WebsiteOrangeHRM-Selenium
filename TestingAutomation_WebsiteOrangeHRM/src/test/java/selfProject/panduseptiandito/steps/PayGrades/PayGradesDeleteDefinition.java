package selfProject.panduseptiandito.steps.PayGrades;

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
import selfProject.panduseptiandito.pages.PagePayGrades;
import selfProject.panduseptiandito.pages.PageSystemUser;

import static selfProject.panduseptiandito.drivers.utils.TimeDuration.TWO;

public class PayGradesDeleteDefinition {

    private PageDashboard pageDashboard;
    private PageSystemUser pageSystemUser;
    private PagePayGrades pagePayGrades;
    private WebDriver driver;

    @Before
    public void setup() {
        driver = DriverSingleton.getDriver(BrowserType.CHROME);
        pageDashboard = new PageDashboard(driver);
        pageSystemUser = new PageSystemUser(driver);
        pagePayGrades = new PagePayGrades(driver);
    }

    public void Delay(int milisecond) {
        try {
            Thread.sleep(milisecond);
        } catch (InterruptedException e) {
            Thread.currentThread();
            System.out.println("Delay Interuppted : " + e.getMessage());
        }
    }

    @Given("Halaman {string} sekarang terbuka. PAY GRADES")
    public void openPagePayGrades(String subMenu){
        pageDashboard.clickMenuAdmin();
        pageSystemUser.selectNavTabJob(subMenu);
    }

    @And("Saya menekan tombol DELETE, pada PAY GRADES bernama {string}")
    public void clickDeleteData(String pay){
        pagePayGrades.actionDeletePayGrades(driver,pay);
    }

    @When("Saya menekan tombol NO, CANCEL pada FORM DELETE PAY GRADES")
    public void clickCancelDelete(){
        pagePayGrades.clickCancelDelete();
    }

    @When("Saya menekan tombol YES, DELETE pada FORM DELETE PAY GRADES")
    public void clickDelete(){
        pagePayGrades.clickDelete();
    }

    //    @PayGrades_Delete_Failed_Canceled  @Negative
    @Then("Terlihat FORM DELETE PAY GRADES telah menghilang.")
    public void verifyFormIsGone(){
        pagePayGrades.getVerifyFormDeleteGone();
    }

    //    @PayGrades_Delete_Succes  @Positive
    @Then("PAY GRADES berhasil dihapus pada table dan menampilkan pesan {string}")
    public void verifySuccesDelete(String expectMsg){
        String actualMsg = pagePayGrades.getVerifySucces();
        Assert.assertEquals(actualMsg, expectMsg);
        Delay(TWO);
    }

}
