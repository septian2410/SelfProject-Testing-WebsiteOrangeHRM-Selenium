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

import java.awt.*;

import static selfProject.panduseptiandito.drivers.utils.TimeDuration.TWO;

public class EmployeeEditDefinition {

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

    @Given("Saya telah mengakses bagian Employee.")
    public void openPageEmployee() {
        pageDashboard.clickMenuPIM();
    }

    @And("Saya menekan tombol EDIT, pada employee bernama {string}")
    public void clickEditData(String data) {
        pageEmployeeList.choiceEditEmployee(driver, data);
    }

    @When("Saya menghapus first name pada kolom FIRST NAME")
    public void clearFieldFirst() {
        pageEmployeeList.clearFieldFirstName();
    }

    @When("Saya menekan tombol SAVE pada FORM PERSONAL DETAILS")
    public void clickSaveEditEmployee() {
        pageEmployeeList.clickSaveEditPersonalDetails();
    }

    @When("Saya memasukkan FIRST NAMA EMPLOYEE BARU yaitu {string} pada kolom inputan Employee Name")
    public void inputFirstName(String first) {
        pageEmployeeList.fillEditFirstName(first);
    }

    @And("Saya memasukkan LAST NAMA EMPLOYEE BARU yaitu {string} pada kolom inputan Employee Name")
    public void inputLastName(String last) {
        pageEmployeeList.fillEditLastName(last);
    }

    @When("Saya memasukkan EMPLOYEE ID BARU yaitu {string} pada kolom inputan Employee ID")
    public void inputNewID(String Id) {
        pageEmployeeList.fillEditEmployeeID(Id);
    }

    @And("Saya memasukkan OTHER ID BARU berupa NO NIK yaitu {string} pada kolom inputan Other ID")
    public void inputOtherId(String otherId) {
        pageEmployeeList.fillOtherId(otherId);
    }

    @When("Saya mengatur tanggal LICENSE EXPIRY DATE Yaitu {string} pada FORM PERSONAL DETAILS")
    public void setDateLisenceExpired(String tanggal) {
        pageEmployeeList.setDateLisenceExpired(tanggal);
    }

    @And("Saya memasukkan DRIVER'S LICENSE NUMBER BARU yaitu {string} pada kolom inputan Driver's License Number")
    public void inputDriverLisence(String driverLisence) {
        pageEmployeeList.fillEditDriverLicenseNumber(driverLisence);
    }

    @When("Saya mengatur NATIONALITY yaitu {string} pada FORM PERSONAL DETAILS")
    public void setNationality(String nationality) {
        pageEmployeeList.choiceNationality(nationality);
    }

    @And("Saya mengatur MARITAL STATUS yaitu {string} pada FORM PERSONAL DETAILS")
    public void setMaritalStatus(String maritalStatus) {
        pageEmployeeList.choiceMarital(maritalStatus);
    }

    @When("Saya mengatur DATE OF BIRTH pada tanggal {string} pada FORM PERSONAL DETAILS")
    public void setDateBirth(String dateBirth) {
        pageEmployeeList.setDateBirth(dateBirth);
    }

    @And("Saya memilih Gender Male pada FORM PERSONAL DETAILS")
    public void clickGenderMale() {
        pageEmployeeList.clickMale();
    }

    @When("Saya menekan tombol ADD ATTACHMENT, kemudian mengupload file bernama {string} sebagai dokumen probadi")
    public void uploadDokument(String dokument) throws AWTException {
        pageEmployeeList.clickAddAttachment();
        pageEmployeeList.uploadFileAttachment(dokument);
    }

    @And("Saya menambahkan COMMENT {string} pada kolom inputan Comment")
    public void inputComment(String comment) {
        pageEmployeeList.fillTextAreaComment(comment);
    }

    @When("Saya menekan tombol SAVE ADD ATTACHMENT pada FORM PERSONAL DETAILS")
    public void clickSaveAddAttachment() {
        pageEmployeeList.clickSaveAddAttachments();
    }

    @And("Saya menekan Sub menu JOB DETAILS")
    public void clickSubMenuJobDetails() {
        pageEmployeeList.clickSubMenuJobDetails();
    }

    @When("Saya mengatur waktu JOINED DATE pada tanggal {string} pada FORM JOB DETAILS")
    public void setJoinedDate(String joinedDate) {
        pageEmployeeList.setJoinedDate(joinedDate);
    }

    @And("Saya memilih JOB DETAILS {string} pada FORM JOB DETAILS")
    public void selectJobDetails(String job) {
        pageEmployeeList.selectJobTitle(job);
    }

    @When("Saya memilih JOB CATEGORY {string} pada FORM JOB DETAILS")
    public void selectJobCategory(String categoryJob) {
        pageEmployeeList.selectJobCategory(categoryJob);
    }

    @And("Saya memilih EMPLOYMENT STATUS sebagai {string} pada FORM JOB DETAILS")
    public void selectEmploymentStatus(String statusEmployment) {
        pageEmployeeList.selectEmploymentStatus(statusEmployment);
    }

    @When("Saya menekan tombol SAVE pada FORM JOB DETAILS")
    public void clickSaveEditJobDetails(){
        pageEmployeeList.clickSaveEditJobDetails();
    }

    //    @Edit_Failed_FieldEmpty  @Negative
    @Then("FITUR EDIT EMPLOYEE menampilkan label pesan error pada kolom FIRST NAME yaitu {string}")
    public void validationErrFieldEmpty(String expectedMsg) {
        String actualMsg = pageEmployeeList.getValidationEditEmployeeFirstNameEmpty();
        Assert.assertEquals(actualMsg, expectedMsg);
        Delay(TWO);
    }

    //    @Edit_Prefill_Validation  @Positive
    @Then("Data {string} berhasil terisi otomatis pada FORM EDIT EMPLOYEE sesuai data pada tabel employee.")
    public void validation1(String expectedMsg) {
        String actualMessage = pageEmployeeList.getDataInFieldFirstName();
        Assert.assertEquals(actualMessage, expectedMsg);
        Delay(TWO);
    }

    //    @Edit_Succes_WithoutChange,
    @Then("Data tidak mengalami perubahan serta, FITUR EDIT EMPLOYEE berhasil menampilkan pesan {string}")
    public void validation2(String expectedMsg) {
        String actualMsg = pageEmployeeList.getValidationSucces();
        Assert.assertEquals(actualMsg, expectedMsg);
        Delay(TWO);
    }

    //    Edit_Succes  @Positive
    @Then("Data mengalami perubahan serta, FITUR EDIT EMPLOYEE berhasil menampilkan pesan {string}")
    public void validation3(String expectedMsg) {
        String actualMsg = pageEmployeeList.getValidationSucces();
        Assert.assertEquals(actualMsg, expectedMsg);
        Delay(TWO);

    }
}
