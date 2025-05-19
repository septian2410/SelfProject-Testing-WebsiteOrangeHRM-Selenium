package selfProject.panduseptiandito.steps.Employee;

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
import selfProject.panduseptiandito.pages.PageEmployeeList;

import static selfProject.panduseptiandito.drivers.utils.TimeDuration.TWO;

public class EmployeeDeleteDefinition {

    private PageEmployeeList pageEmployeeList;
    private PageDashboard pageDashboard;
    private WebDriver driver;

    @Before
    public void setup() {
        driver = DriverSingleton.getDriver(BrowserType.CHROME);
        pageDashboard = new PageDashboard(driver);
        pageEmployeeList = new PageEmployeeList(driver);
    }

    public void Delay(int milisecond) {
        try {
            Thread.sleep(milisecond);
        } catch (InterruptedException e) {
            Thread.currentThread();
            System.out.println("Delay Interuppted : " + e.getMessage());
        }
    }

    @Given("Halaman Employee sekarang terbuka.")
    public void openPageEmployee(){
        pageDashboard.clickMenuPIM();
    }

    @And("Saya menekan tombol DELETE, pada employee bernama {string}")
    public void clickDeleteData(String employee){
        pageEmployeeList.choiceDeleteEmployee(driver, employee);

    }
    @When("Saya menekan tombol NO, CANCEL pada FORM DELETE EMPLOYEE")
    public void clickCancelDelete(){
        pageEmployeeList.clickCancelDelete();
    }
    @When("Saya menekan tombol YES, DELETE pada FORM DELETE EMPLOYEE")
    public void clickDelete(){
        pageEmployeeList.clickDelete();
    }

//    @Employee_Delete_Failed_Canceled  @Negative
    @Then("Terlihat FORM DELETE EMPLOYEE telah menghilang.")
    public void validationFormGone(){
        pageEmployeeList.validationFormDeleteGone();
    }

//    @Employee_Delete_Succes  @Positive
    @Then("employee berhasil dihapus pada table dan menampilkan pesan {string}")
    public void validationDeleteSucces(String expectedMsg){
        String actualMsg = pageEmployeeList.getValidationSucces();
        Assert.assertEquals(actualMsg, expectedMsg);
        Delay(TWO);
    }

}
