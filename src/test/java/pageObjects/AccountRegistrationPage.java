package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountRegistrationPage extends BasePage {

    public AccountRegistrationPage(WebDriver driver) {
        super(driver);
    }

    // Elements
    @FindBy(name = "firstname")
    WebElement txtFirstname;

    @FindBy(name = "lastname")
    WebElement txtLastname;  // Corectat numele variabilei

    @FindBy(name = "email")
    WebElement txtEmail;

    @FindBy(name = "telephone")
    WebElement txtTelephone;

    @FindBy(name = "password")
    WebElement txtPassword;

    @FindBy(name = "confirm")
    WebElement txtConfirmPassword;

    @FindBy(name = "agree")
    WebElement chkdPolicy;

    @FindBy(xpath = "//input[contains(@value, 'Continue')]")
//      xpath = "//input[@value='Continue']"
    WebElement btnContinue;

    @FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
    WebElement msgConfirmation;

//  Apasam butonul de continue
    @FindBy(xpath = "//*[@id=\"content\"]/div/div/a")
    WebElement btnContinue1;

// Action Methods

////   Pentru a face clasa mai robusta, putem adauga verificari înainte de a introduce datele:
//    public void setEmail(String email) {
//        if (email != null && email.contains("@")) {
//            waitForElement(txtEmail);
//            txtEmail.sendKeys(email);
//        } else {
//            throw new IllegalArgumentException("Email invalid: " + email);
//        }
//    }


    public void setFirstName(String fname) {
        waitForElement(txtFirstname);
        txtFirstname.sendKeys(fname);
    }

    public void setLastName(String lname) {
        waitForElement(txtLastname);
        txtLastname.sendKeys(lname);
    }

    public void setEmail(String email) {
        waitForElement(txtEmail);
        txtEmail.sendKeys(email);
    }

    public void setTelephone(String tel) {
        waitForElement(txtTelephone);
        txtTelephone.sendKeys(tel);
    }

    public void setPassword(String pwd) {
        waitForElement(txtPassword);
        txtPassword.sendKeys(pwd);
    }

    public void setConfirmPassword(String pwd) {
        waitForElement(txtConfirmPassword);
        txtConfirmPassword.sendKeys(pwd);
    }

    public void setPrivacyPolicy() {
        waitForElement(chkdPolicy);
        chkdPolicy.click();
    }

    public void clickContinue() {
        waitForElement(btnContinue);
        btnContinue.click();
    }

    public String getConfirmationMsg() {

//        waitForElement(msgConfirmation);
//        return msgConfirmation.getText();

        try{
            return(msgConfirmation.getText());
        } catch(Exception e){
            return(e.getMessage());
        }
    }

    public void clickContinue1() {
        waitForElement(btnContinue1);
        btnContinue1.click();
    }

// Helper method to wait for elements
    private void waitForElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(45));
        wait.until(ExpectedConditions.visibilityOf(element));
    }


    // Metodă pentru a completa tot formularul într-un singur apel
    public void fillRegistrationForm(String fname, String lname, String email, String tel, String pwd) {
        setFirstName(fname);
        setLastName(lname);
        setEmail(email);
        setTelephone(tel);
        setPassword(pwd);
        setConfirmPassword(pwd);
        setPrivacyPolicy();
        clickContinue();
    }


}
