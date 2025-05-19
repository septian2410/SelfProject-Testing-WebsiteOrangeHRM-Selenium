package selfProject.panduseptiandito.steps.User;

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
import selfProject.panduseptiandito.pages.PageSystemUser;

import static selfProject.panduseptiandito.drivers.utils.TimeDuration.TWO;

public class UserResetDefinition {


    private PageDashboard pageDashboard;
    private PageSystemUser pageSystemUser;
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

    @Given("halaman User Management dimuat kembali.")
    public void openPageUser(){
        pageDashboard.clickMenuAdmin();
    }

    @And("Saya mengisikan USERNAME {string} pada kolom pencarian USERNAME")
    public void inputUsername(String username){
       pageSystemUser.fillSearchUsername(username);
    }

    @When("saya menekan tombol RESET pada HALAMAN USER MANAGEMENT")
    public void clickReset(){
        pageSystemUser.clickResetSearch();
    }

    //    @Employee_Reset_Pencarian_Data_Berhasil  @Positive
    @Then("tampil kolom input pencarian USERNAME sudah kosong kembali pada HALAMAN USER MANAGEMENT")
    public void validationInputIsGone(){
        String actualMessage = pageSystemUser.getFieldSearch();
        Assert.assertTrue(actualMessage.isEmpty());
        Delay(TWO);
    }
}
