package selfProject.panduseptiandito.steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import selfProject.panduseptiandito.DriverSingleton;
import selfProject.panduseptiandito.drivers.utils.BrowserType;
import selfProject.panduseptiandito.pages.PageDashboard;
import selfProject.panduseptiandito.pages.PageLogin;

import static selfProject.panduseptiandito.drivers.utils.TimeDuration.TWO;

public class StepLogout {


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

    @When("saya menekan tombol PROFIL ADMIN")
    public void clickProfil(){
        pageDashboard.clickProfil();
    }

    @And("saya menekan tombol LOGOUT")
    public void clickLogout(){
        pageDashboard.clickLogout();
    }

    @Then("Tampil kembali dashboard LOGIN dengan logo teks {string}")
    public void verifyLogout(String expecMsg){
        String actualMsg = pageLogin.getMsgLogoutSucces();
        Assert.assertEquals(actualMsg, expecMsg);
        Delay(TWO);
    }
}
