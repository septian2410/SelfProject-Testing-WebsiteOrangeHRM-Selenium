package selfProject.panduseptiandito.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {
                "src/test/resources/1 featuresMenuLogin (Web Admin)/Login.feature",

                "src/test/resources/2 featuresMenuPIM (Employee)/1EmployeeSearch.feature",
                "src/test/resources/2 featuresMenuPIM (Employee)/2EmployeeReset.feature",
                "src/test/resources/2 featuresMenuPIM (Employee)/3EmployeeAdd.feature",
                "src/test/resources/2 featuresMenuPIM (Employee)/4EmployeeEdit.feature",
                "src/test/resources/2 featuresMenuPIM (Employee)/5EmployeeDelete.feature",

                "src/test/resources/3 featuresMenuAdmin (UserManagement)/1UserSearch.feature",
                "src/test/resources/3 featuresMenuAdmin (UserManagement)/2UserReset.feature",
                "src/test/resources/3 featuresMenuAdmin (UserManagement)/3UserAdd.feature",
                "src/test/resources/3 featuresMenuAdmin (UserManagement)/4UserEdit.feature",
                "src/test/resources/3 featuresMenuAdmin (UserManagement)/5UserDelete.feature",

                "src/test/resources/4 featuresMenuAdmin (JobTitles)/1JobAdd.feature",
                "src/test/resources/4 featuresMenuAdmin (JobTitles)/2JobEdit.feature",
                "src/test/resources/4 featuresMenuAdmin (JobTitles)/3JobDelete.feature",

                "src/test/resources/5 featuresMenuAdmin (PayGrades)/1PayGradesAdd.feature",
                "src/test/resources/5 featuresMenuAdmin (PayGrades)/2PayGradesEdit.feature",
                "src/test/resources/5 featuresMenuAdmin (PayGrades)/3PayGradesDelete.feature",

                "src/test/resources/6 featuresMenuAdmin (EmploymentStatus)/1EmploymentStatusAdd.feature",
                "src/test/resources/6 featuresMenuAdmin (EmploymentStatus)/2EmploymentStatusEdit.feature",
                "src/test/resources/6 featuresMenuAdmin (EmploymentStatus)/3EmploymentStatusDelete.feature",

                "src/test/resources/7 featuresMenuAdmin (JobCategories)/1JobCategoriesAdd.feature",
                "src/test/resources/7 featuresMenuAdmin (JobCategories)/2JobCategoriesEdit.feature",
                "src/test/resources/7 featuresMenuAdmin (JobCategories)/3JobCategoriesDelete.feature",

//                "src/test/resources/8 featuresMenuAdmin (WorkShifts)/1WorkShiftsAdd.feature",
//                "src/test/resources/8 featuresMenuAdmin (WorkShifts)/2WorkShiftsEdit.feature",
//                "src/test/resources/8 featuresMenuAdmin (WorkShifts)/3WorkShiftsDelete.feature",

                "src/test/resources/featuresMenuLogout/Logout.feature",



        },

        glue = {
                "selfProject.panduseptiandito.hooks",
                "selfProject.panduseptiandito.steps",
        },

        plugin = {
                "pretty",
                "html:target/cucumbers/reports.html",
                "json:target/cucumbers/reports.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",

        }
)

public class RunnerTest extends AbstractTestNGCucumberTests {
}
