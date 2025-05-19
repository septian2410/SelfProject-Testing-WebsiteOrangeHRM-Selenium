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

public class EmployeeResetDefinition {

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

    @Given("halaman Employee dimuat kembali.")
    public void openPageEmployee(){
        pageDashboard.clickMenuPIM();
    }

    @And("Saya mengisikan EMPLOYEE NAME {string} pada kolom pencarian Employee Name")
    public void inputEmployeeName(String name){
        pageEmployeeList.fillSearchEmployeeName(name);
    }

    @When("saya menekan tombol RESET")
    public void clickReset(){
        pageEmployeeList.clickResetSearch();
    }

    //    @Employee_Reset_Pencarian_Data_Berhasil  @Positive
    @Then("tampil kolom input pencarian Employee Name sudah kosong kembali pada halaman Employee")
    public void validation(){
        String actualMessage = pageEmployeeList.getFieldSearch();
        Assert.assertTrue(actualMessage.isEmpty());
        Delay(TWO);
    }



}
