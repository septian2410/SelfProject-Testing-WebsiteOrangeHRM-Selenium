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

public class PayGradesAddDefinition {

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

    @Given("Tab {string} telah dimuat. PAY GRADES")
    public void openPagePayGrades(String subMenu){
        pageDashboard.clickMenuAdmin();
        pageSystemUser.selectNavTabJob(subMenu);
    }

    @When("Saya menekan tombol ADD pada HALAMAN PAY GRADE")
    public void clickAddPayGrades(){
        pagePayGrades.clickAddPayGrades();
    }

    @And("Saya menekan tombol CANCEL pada pada FORM ADD PAY GRADE")
    public void clickCancelSave(){
        pagePayGrades.clickCancelSave();
    }

    @When("Saya menekan tombol SAVE pada FORM ADD PAY GRADE")
    public void clickSave(){
        pagePayGrades.clickSave();
    }

    @And("Saya memasukkan PAY GRADE {string} pada FORM ADD PAY GRADE")
    public void inputPayGrade(String payGrade){
        pagePayGrades.fillNamePayGrade(payGrade);
    }

    @And("Saya menekan tombol ADD pada FORM CURRENCIES")
    public void clickAddCurrencies(){
        pagePayGrades.clickAddCurrencies();
    }

    @And("Saya kembali menekan tombol SAVE pada FORM ADD PAY GRADE")
    public void clickAgainSave(){
        pagePayGrades.clickSaveCurrency();
    }

    @When("Saya memilih CURRENCY mata uang {string} pada FORM CURRENCIES")
    public void selectCurrency(String currency){
        pagePayGrades.selectCurrency(currency);
    }

    @And("Saya memasukkan MINIMUM SALARY {string} pada FORM CURRENCIES")
    public void inputMinSal(String min){
        pagePayGrades.inputMinimumSalary(min);
    }

    @When("Saya memasukkan MAXIMUM SALARY {string} pada FORM CURRENCIES")
    public void inputMaxSal(String max){
        pagePayGrades.inputMaximumSalary(max);
    }

    //    @PayGrades_Add_Failed_Canceled  @Negative
    @Then("Terlihat FORM ADD PAY GRADE telah hilang.")
    public void verifyCanceled(){
        pagePayGrades.getVerifyFormAddIsGone();
    }

    //    @PayGrades_Add_Failed_FieldEmpty, AlreadyExists  @Negative
    @Then("FITUR TAMBAHKAN PAY GRADE menampilkan pesan ERROR pada field PAY GRADE {string}")
    public void verifyFieldEmpty(String expectMsg){
        String actualMsg = pagePayGrades.getVerifyEmptyField();
        Delay(TWO);
    }

    //    @PayGrades_Add_Failed_CurrencyEmpty  @Positive
    @Then("FITUR TAMBAHKAN PAY GRADE menampilkan pesan ERROR pada field CURRENCY {string}")
    public void verifyEmptyCurrency(String expectMsg){
        String actualMsg = pagePayGrades.getVerifyEmptyCurrency();
        Assert.assertEquals(actualMsg, expectMsg);
        Delay(TWO);
    }

    //    @PayGrades_Add_Failed_SalaryInvalid, MinimumSalaryHigherThanMaximumSalary  @Positive
    @Then("FITUR TAMBAHKAN PAY GRADE menampilkan pesan ERROR pada field MINIMUM SALARY {string}")
    public void verifyMinSalaryInvalid(String expectMsg){
        String actualMsg = pagePayGrades.getVerifyErrMinSal();
        Assert.assertEquals(actualMsg, expectMsg);
        Delay(TWO);
    }

    //    @PayGrades_Add_Failed_MaximumSalaryLowerThanMinimumSalary  @Positive
    @Then("FITUR TAMBAHKAN PAY GRADE menampilkan pesan ERROR pada field MAXIMUM SALARY {string}")
    public void verifyMaxSalaryInvalid(String expectMsg){
        String actualMsg = pagePayGrades.getVerifyErrMaxSal();
        Assert.assertEquals(actualMsg, expectMsg);
        Delay(TWO);
    }

    //    @PayGrades_Add_Succes  @Positive
    @Then("FITUR TAMBAHKAN PAY GRADE menampilkan pesan Success {string}")
    public void verifySuccesAdd(String expectMsg){
        String actualMsg = pagePayGrades.getVerifySucces();
        Assert.assertEquals(actualMsg, expectMsg);
        Delay(TWO);
    }


}
