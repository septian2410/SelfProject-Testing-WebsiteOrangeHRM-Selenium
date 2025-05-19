package selfProject.panduseptiandito.steps.User;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import selfProject.panduseptiandito.DriverSingleton;
import selfProject.panduseptiandito.drivers.utils.BrowserType;
import selfProject.panduseptiandito.pages.PageDashboard;
import selfProject.panduseptiandito.pages.PageSystemUser;

import static selfProject.panduseptiandito.drivers.utils.TimeDuration.TWO;

public class UserSearchDefinition {

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

    @Given("Saya membuka halaman User.")
    public void openPageUser(){
        pageDashboard.clickMenuAdmin();
    }

    @When("Saya memasukkan {string} di kolom pencarian USERNAME")
    public void inputUsername(String username){
        pageSystemUser.fillSearchUsername(username);
    }

    @And("Saya menekan tombol SEARCH pada HALAMAN USER MANAGEMENT")
    public void clickSearchUser(){
        pageSystemUser.clickSearchUser();
    }

    @And("Saya memilih USER ROLE {string} di kolom pilihan USER ROLE")
    public void selectUserRole(String role){
        pageSystemUser.selectSearchUserRole(role);
    }

    @When("Saya memasukkan {string} di kolom pencarian EMPLOYEE NAME pada HALAMAN USER MANAGEMENT")
    public void inputEmployeeName(String employee){
        pageSystemUser.fillSearchEmployee(employee);
    }

    @And("Saya memilih STATUS USER {string} di kolom pilihan STATUS USER")
    public void selectStatusUser(String status){
        pageSystemUser.selectSearchUserStatus(status);
    }

    //    Search NotFound By Username  @Negative
    @Then("tidak ada USER yang ditampilkan, serta muncul label bertuliskan {string}")
    public void validationSearchNotFound(String expectedMsg){
        String actualMsg = pageSystemUser.getValidationSearch();
        Assert.assertEquals(actualMsg, expectedMsg);
        Delay(TWO);
    }

    //    Search Can't Interact By EmployeeNameInvalid  @Negative
    @Then("tidak ada USER yang ditampilkan, serta muncul label error Employee Name {string}")
    public void validationEmployeeInvalid(String expectedMsg){
        String actualMsg = pageSystemUser.getValidationSearchInvalidEmployeeName();
        Assert.assertEquals(actualMsg, expectedMsg);
        Delay(TWO);
    }

    //    Search Data Found By Username , EmployeeName, Username And UserRole, Username And StatusUser, Incremental Filter Combination  @Positive
    @Then("FITUR SEARCH USER berhasil menampilkan data pencarian {string}")
    public void validationSearchFound(String expectedMsg){
        String actualMsg = pageSystemUser.getValidationSearch();
        Assert.assertEquals(actualMsg, expectedMsg);
        Delay(TWO);
        WebElement element = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Delay(TWO);
    }

    @When("Tanpa Reset,Saya kembali memasukkan {string} di kolom pencarian USERNAME")
    public void inputAgainUsername(String username){
        pageSystemUser.fillSearchUsername(username);
    }




}
