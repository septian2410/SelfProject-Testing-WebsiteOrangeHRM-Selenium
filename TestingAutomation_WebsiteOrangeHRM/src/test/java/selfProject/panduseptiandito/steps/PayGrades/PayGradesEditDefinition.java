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

public class PayGradesEditDefinition {

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

    @Given("Saya telah mengakses bagian {string} PAY GRADES")
    public void openPagePayGrades(String subMenu){
        pageDashboard.clickMenuAdmin();
        pageSystemUser.selectNavTabJob(subMenu);
    }

    @And("Saya menekan tombol EDIT, pada CURRENCY bernama {string} pada HALAMAN PAY GRADES")
    public void clickEditPay(String currency){
        pagePayGrades.actionEditPayGrades(driver, currency);
    }

    @When("Saya menekan tombol CANCEL pada FORM EDIT PAY GRADES")
    public void clickCancelEdit(){
        pagePayGrades.clickCancelSave();
    }

    @When("Saya mengosongkan kolom PAY GRADES pada FORM EDIT PAY GRADES")
    public void clearPayGrades(){
        pagePayGrades.clearFldPayGrade();
    }

    @When("Saya menekan tombol SAVE pada FORM EDIT PAY GRADES")
    public void clickSaveEdit(){
        pagePayGrades.clickSave();
    }

    @When("Saya memasukkan PAY GRADES BARU yaitu {string} pada FORM EDIT PAY GRADES")
    public void inputNewPayGrades(String pay){
        pagePayGrades.fillNamePayGrade(pay);
    }

    @And("Saya mengganti CURRENCY lama dengan menghapusnya")
    public void deleteCurrency(){
        pagePayGrades.clickDeleteCurrency();
        pagePayGrades.clickDelete();
    }

    @When("Saya kembali menekan tombol ADD pada FORM CURRENCIES")
    public void clickAddCurrencies(){
        pagePayGrades.clickAddCurrencies();
    }

    @And("Saya memilih CURRENCY mata uang baru {string} pada FORM CURRENCIES")
    public void selectNewCurrency(String currency){
        pagePayGrades.selectCurrency(currency);
    }

    @When("Saya memasukkan MINIMUM SALARY baru {string} pada FORM CURRENCIES")
    public void inputNewMinSal(String min){
        pagePayGrades.inputMinimumSalary(min);
    }

    @And("Saya memasukkan MAXIMUM SALARY baru {string} pada FORM CURRENCIES")
    public void inputNewMaxSal(String max){
        pagePayGrades.inputMaximumSalary(max);
    }

    @When("Saya menekan tombol SAVE CURRENCY pada FORM CURRENCIES")
    public void clickSaveCurrency(){
        pagePayGrades.clickSaveCurrency();
    }

    //    @PayGrades_Edit_Failed_Canceled  @Negative
    @Then("Terlihat FORM EDIT PAY GRADE telah menghilang.")
    public void verifyFormIsGone(){
        pagePayGrades.getVerifyFormEditGone();
    }

    //    @PayGrades_Edit_Failed_FieldEmpty  @Negative
    @Then("FITUR EDIT PAY GRADES menampilkan label pesan error pada PAY GRADES {string}")
    public void verifyEmptyField(String expectMsg){
        String actualMsg = pagePayGrades.getVerifyEmptyField();
        Assert.assertEquals(actualMsg, expectMsg);
        Delay(TWO);
    }

    //    @PayGrades_Edit_Prefill_Validation  @Positive
    @Then("Data {string} berhasil terisi otomatis pada FORM EDIT PAY GRADES sesuai data pada tabel PAY GRADES.")
    public void verifyPrefill(String expectMsg){
        String actualMsg =  pagePayGrades.getVerifyDataInField();
        Assert.assertEquals(actualMsg, expectMsg);
        Delay(TWO);
    }

    //    @PayGrades_Edit_Succes  @Positive
    @Then("Data mengalami perubahan serta, FITUR EDIT PAY GRADES berhasil menampilkan pesan {string}")
    public void verifySuccesEdit(String expectMsg){
        String actualMsg = pagePayGrades.getVerifySucces();
        Assert.assertEquals(actualMsg, expectMsg);
        Delay(TWO);
    }

}
