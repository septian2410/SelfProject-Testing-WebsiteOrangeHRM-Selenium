package selfProject.panduseptiandito.steps.Employee;

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
import selfProject.panduseptiandito.pages.PageEmployeeList;

import static selfProject.panduseptiandito.drivers.utils.TimeDuration.TWO;

public class EmployeeSearchDefinition {


    private WebDriver driver;
    private PageEmployeeList pageEmployeeList;
    private PageDashboard pageDashboard;

    @Before
    public void setup(){
        driver = DriverSingleton.getDriver(BrowserType.CHROME);
        pageDashboard = new PageDashboard(driver);
        pageEmployeeList = new PageEmployeeList(driver);
    }

    public void Delay(int milisecond){
        try{
            Thread.sleep(milisecond);
        }catch (InterruptedException e){
            Thread.currentThread();
            System.out.println("Delay Interuppted : "+e.getMessage());
        }
    }

    @Given("Saya membuka halaman Employee.")
    public void openEmployeePage(){
        pageDashboard.clickMenuPIM();
    }

    @When("Saya memasukkan {string} di kolom pencarian EMPLOYEE NAME")
    public void inputSearchEmployeeName(String name){
        pageEmployeeList.fillSearchEmployeeName(name);
    }

    @And("Saya menekan tombol SEARCH pada FORM ADD EMPLOYEE")
    public void clickButtonSearch(){
        pageEmployeeList.clickSearchEmployee();
    }

    @When("Saya menghapus kolom pencarian employee")
    public void clearFieldEmployeName(){
    }

    @When("Saya memasukkan {string} di kolom pencarian EMPLOYEE ID")
    public void inputEmployeeId(String ID){
        pageEmployeeList.fillSearchEmployeeId(ID)   ;
    }

    @When("Saya memilih EMPLOYEMENT STATUS {string} di kolom pilihan EMPLOYEMENT STATUS")
    public void selectEmployementStatus(String status){
        pageEmployeeList.selectSearchStatus(status);
    }

    @And("Saya memilih JOB TITLE {string} di kolom pilihan JOB TITLE")
    public void selectJobTitle(String job){
        pageEmployeeList.selectSearchJob(job);
    }

    @When("Tanpa Reset,Saya kembali memasukkan {string} di kolom pencarian EMPLOYEE NAME")
    public void inputNewEmployeeName(String name){
        pageEmployeeList.fillSearchEmployeeName(name);
    }

    //    @Employee_Search_Data_NotFound  @Negative
    @Then("tidak ada employee yang ditampilkan, serta muncul label bertuliskan {string}")
    public void validationNotFound(String expectedMsg){
        String actualMsg = pageEmployeeList.getValidationSearch();
        Assert.assertEquals(actualMsg, expectedMsg);
        Delay(TWO);
    }

/*        @Employee_Search_Data_ColumnEmpty  @Negative
    @Then("tampilkan semua employee tabel data")
    public void goneResultSearch(){
        boolean isElementGone =  waitForElementToClose(By.xpath("//*[@id=\"changelist-search\"]/div/span"));
        if (isElementGone) {
            System.out.println("Result Search Telah menghilang");
        } else {
            System.out.println("Popup masih ada.");
        }
        Delay(TWO);
    }*/

//    EmployeeName, EmployeeID, JobTitle And EmployeeStatus, JobTitle And EmployeeName, Search_Incremental_Filter_Combination  @Positive
    @Then("fitur search employee berhasil menampilkan data pencarian {string}")
    public void validationFound(String expectedMsg){
        String actualMsg = pageEmployeeList.getValidationSearch();
        Assert.assertEquals(actualMsg, expectedMsg);
        Delay(TWO);
        WebElement element = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Delay(TWO);
    }

//    And Saya menekan tombol SEARCH pada FORM ADD EMPLOYEE
//    Then fitur search employee berhasil menampilkan data pencarian "(1) Record Found"
//
//    @Employee_Search_Incremental_Filter_Combination @Positive
//    Scenario:  Incremental Employee Search Functionality
//    When Saya memasukkan "Riku" di kolom pencarian EMPLOYEE NAME
//    When Saya memilih JOB TITLE "Software Engineer" di kolom pencarian EMPLOYEE ID
//    And Saya menekan tombol SEARCH pada FORM ADD EMPLOYEE
//    Then fitur search employee berhasil menampilkan data pencarian "(1) Record Found"
//    When Tanpa Reset,Saya kembali memasukkan "Djhonny" di kolom pencarian EMPLOYEE NAME
//    And Saya menekan tombol SEARCH pada FORM ADD EMPLOYEE
//    Then fitur search employee berhasil menampilkan data pencarian "(1) Record Found"



}
