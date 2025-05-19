package selfProject.panduseptiandito.steps;

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
import selfProject.panduseptiandito.pages.PageLogin;

import static selfProject.panduseptiandito.drivers.utils.TimeDuration.TWO;

public class StepLogin {

    private PageLogin pageLogin;
    private PageDashboard pageDashboard;
    private WebDriver driver;

    @Before
    public void setup(){
        driver = DriverSingleton.getDriver(BrowserType.CHROME);
        pageLogin = new PageLogin(driver);
        pageDashboard = new PageDashboard(driver);
    }

    public void Delay(int milisecond){
        try{
            Thread.sleep(milisecond);
        }catch (InterruptedException e){
            Thread.currentThread();
            System.out.println("Delay Interuppted : "+e.getMessage());
        }
    }

    @Given("saya membuka halaman login pada Web Admin OrangeHRM")
    public void openLoginPage(){
        driver.get("http://localhost/local/orangehrm./web/index.php/auth/login");
        pageLogin.waitPageLogin();
    }

    @When("saya langsung menekan tombol login")
    public void clickLogin(){
        pageLogin.clickLogin();
        Delay(TWO);
    }

    @And("saya memasukkan username {string}")
    public void inputUsername(String username){
        pageLogin.fillUsername(username);
    }

    @And("saya memasukkan password {string}")
    public void inputPassword(String password){
        pageLogin.fillPassword(password);
    }

    @When("saya menekan tombol login")
    public void clickLoginAgain(){
        pageLogin.clickLogin();
    }

//    @Admin_Login_Failed_FieldEmpty @Negative
    @Then("tampil label validasi {string} pada inputan kosong username halaman login")
    public void validationFieldEmpty(String expectedMsg){
        String actualMsg = pageLogin.getErrUsernameNull();
        Assert.assertEquals(actualMsg, expectedMsg);
        Delay(TWO);
    }

//    @Admin_Login_Failed_KredensialInvalid @Negative
    @Then("tampil label validasi {string} pada halaman login")
    public void validationInvalidCredential(String expectedMsg){
        String actualMsg = pageLogin.getErrInvalidCredential();
        Assert.assertEquals(actualMsg, expectedMsg);
        Delay(TWO);
    }

//    @Admin_Login_Succes  @Positive
    @Then("tampil halaman Dashboard OranngeHRM dengan copyright {string}")
    public void validationSuccesLogi(String expectedMsg){
        String actualMsg = pageDashboard.getMsgLogin();
        Assert.assertEquals(actualMsg, expectedMsg);
        Delay(TWO);
    }


}
