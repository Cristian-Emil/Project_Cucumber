package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    // Elements
    @FindBy(xpath = "//span[text()='My Account']")
    WebElement lnkMyAccount;

    @FindBy(linkText = "Register")
    WebElement lnkRegister;

    @FindBy(xpath = "//a[contains(text(),'Login')]") // XPath mai sigur pentru Login
    WebElement linkLogin;

    @FindBy(xpath="//input[@placeholder='Search']")
    WebElement txtSearchbox;

    @FindBy(xpath="//div[@id='search']//button[@type='button']")
    WebElement btnSearch;

    // Action Methods
    public void clickMyAccount() {
        waitForElement(lnkMyAccount);
        lnkMyAccount.click();
    }

    public void clickRegister() {
        waitForElement(lnkRegister);
        lnkRegister.click();
    }

    public void clickLogin() {
        waitForElement(linkLogin);
        linkLogin.click();
    }

    public void enterProductName(String pName) {
        waitForElement(txtSearchbox);
        txtSearchbox.sendKeys(pName);
    }

    public void clickSearch() {
        waitForElement(btnSearch);
        btnSearch.click();
    }

    // Helper method to wait for elements
    private void waitForElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

/* Varianta optimizata este :

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    // Elements
    @FindBy(xpath = "//span[text()='My Account']")
    private WebElement lnkMyAccount;

    @FindBy(linkText = "Register")
    private WebElement lnkRegister;

    @FindBy(xpath = "//a[contains(text(),'Login')]")
    private WebElement lnkLogin;

    @FindBy(xpath="//input[@placeholder='Search']")
    private WebElement txtSearchBox;

    @FindBy(xpath="//div[@id='search']//button[@type='button']")
    private WebElement btnSearch;

    // Helper methods
    private void waitForVisibility(WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.visibilityOf(element));
    }

    private void waitForClickability(WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.elementToBeClickable(element));
    }

    // Action Methods
    public void clickMyAccount() {
        waitForClickability(lnkMyAccount);
        lnkMyAccount.click();
    }

    public void clickRegister() {
        waitForClickability(lnkRegister);
        lnkRegister.click();
    }

    public void clickLogin() {
        waitForClickability(lnkLogin);
        lnkLogin.click();
    }

    public void searchProduct(String productName) {
        waitForVisibility(txtSearchBox);
        txtSearchBox.sendKeys(productName);
        waitForClickability(btnSearch);
        btnSearch.click();
    }
}


*/


}
