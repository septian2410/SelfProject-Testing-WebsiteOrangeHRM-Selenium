package selfProject.panduseptiandito.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static selfProject.panduseptiandito.drivers.utils.TimeDuration.TWO;

public class PageLogin {

    private WebDriverWait wait;

    public PageLogin(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    private void Delay (int miliseconds) {
        try{
            Thread.sleep(miliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Delay interrupted: "+e.getMessage());
        }
    }

//    Locator
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input")
    WebElement fieldUsername;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input")
    WebElement fieldPassword;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")
    WebElement buttonLogin;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/h5")
    WebElement labelLogin;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/div/div/div[1]/p")
    WebElement labelInvalidCredentials;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/span\n")
    WebElement labelFieldUsernameNull;

//    Actions
    public void fillUsername(String username) {
        fieldUsername.clear();
        fieldUsername.sendKeys(username);
        Delay(TWO);
    }
    public void fillPassword(String password) {
        fieldPassword.clear();
        fieldPassword.sendKeys(password);
        Delay(TWO);
    }
    public void clickLogin(){
        buttonLogin.click();
        Delay(TWO);
    }

//    Show Elements
    public void waitPageLogin(){
        By locator = By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]");
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

//    Validation
//    username invalid, password invalid
    public String getErrInvalidCredential(){
        waitPageLogin();
        String validation = labelInvalidCredentials.getText();
        return validation;
    }
    public String getErrUsernameNull(){
        waitPageLogin();
        String validation = labelFieldUsernameNull.getText();
        return validation;
    }
    public String getMsgLogoutSucces() {
        waitPageLogin();
        String validation = labelLogin.getText();
        return validation;
    }

}
