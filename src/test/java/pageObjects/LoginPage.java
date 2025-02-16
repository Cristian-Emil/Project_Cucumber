package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"input-email\"]")
//     //input[@id='input-email']
    WebElement txtEmailAddress;

    @FindBy(xpath = "//*[@id=\"input-password\"]")
//  //input[@id='input-password']
    WebElement txtPassword;

    @FindBy(xpath = "//input[@value='Login']")
    WebElement btnLogin;


    public void setEmail(String email) {
        txtEmailAddress.sendKeys(email);
    }

    public void setPassword(String pwd) {
        txtPassword.sendKeys(pwd);
    }

    public void clickLogin() {
        btnLogin.click();
    }

/* Varianta optimizata este :

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "input-email")
    private WebElement txtEmailAddress;

    @FindBy(id = "input-password")
    private WebElement txtPassword;

    @FindBy(xpath = "//input[@value='Login']")
    private WebElement btnLogin;

    // Metode helper pentru așteptare
    private void waitForVisibility(WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.visibilityOf(element));
    }

    private void waitForClickability(WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.elementToBeClickable(element));
    }

    // Metodă combinată pentru login
    public void login(String email, String password) {
        waitForVisibility(txtEmailAddress);
        txtEmailAddress.sendKeys(email);

        waitForVisibility(txtPassword);
        txtPassword.sendKeys(password);

        waitForClickability(btnLogin);
        btnLogin.click();
    }
}

*/

}
