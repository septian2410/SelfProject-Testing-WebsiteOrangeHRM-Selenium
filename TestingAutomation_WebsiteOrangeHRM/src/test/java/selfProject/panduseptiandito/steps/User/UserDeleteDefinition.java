package selfProject.panduseptiandito.steps.User;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import selfProject.panduseptiandito.DriverSingleton;
import selfProject.panduseptiandito.drivers.utils.BrowserType;
import selfProject.panduseptiandito.pages.PageDashboard;
import selfProject.panduseptiandito.pages.PageSystemUser;

import static selfProject.panduseptiandito.drivers.utils.TimeDuration.TWO;

public class UserDeleteDefinition {

    private PageSystemUser pageSystemUser;
    private PageDashboard pageDashboard;
    private WebDriver driver;

    @Before
    public void setup() {
        driver = DriverSingleton.getDriver(BrowserType.CHROME);
        pageDashboard = new PageDashboard(driver);
        pageSystemUser = new PageSystemUser(driver);
    }

    public void Delay(int milisecond) {
        try {
            Thread.sleep(milisecond);
        } catch (InterruptedException e) {
            Thread.currentThread();
            System.out.println("Delay Interuppted : " + e.getMessage());
        }
    }

    @Given("Halaman User sekarang terbuka.")
    public void openPageUser(){
        pageDashboard.clickMenuAdmin();
    }

    @And("Saya menekan tombol DELETE, pada USERNAME bernama {string}")
    public void clickDeleteData(String username){
        pageSystemUser.choiceDeleteUser(driver, username);
    }

    @When("Saya menekan tombol NO, CANCEL pada FORM DELETE USER")
    public void clickCancel(){
        pageSystemUser.clickCancelDelete();
    }

    @When("Saya menekan tombol YES, DELETE pada FORM DELETE USER")
    public void clickDelete(){
        pageSystemUser.clickDelete();
    }

    //    @User_Delete_Failed_Canceled  @Negative
    @Then("Terlihat FORM DELETE USER telah menghilang.")
    public void validationFormIsGone()  {
        pageSystemUser.getValidationFormDeleteGone();
    }

    //    @User_Delete_Succes  @Positive
    @Then("USER berhasil dihapus pada table dan menampilkan pesan {string}")
    public void validationSucces(String expectedMsg){
        String actualMsg = pageSystemUser.getValidationSucces();
        Delay(TWO);
    }

}
