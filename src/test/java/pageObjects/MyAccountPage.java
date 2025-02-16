package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyAccountPage extends BasePage {

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h2[text()='My Account']") // MyAccount Page heading
    WebElement msgHeading;

    @FindBy(xpath = "//div[@class='list-group']//a[text()='Logout']")
    WebElement lnkLogout;

// ✅ Metodă îmbunătățită pentru verificarea existenței paginii MyAccount
    public boolean isMyAccountPageExists() {
        return waitForElement(msgHeading);
    }

// ✅ Metodă îmbunătățită pentru Logout
    public void clickLogout() {
        if (waitForElement(lnkLogout)) {
            lnkLogout.click();
        }
    }

// ✅ Metodă de așteptare pentru elemente
    private boolean waitForElement(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
/*  Varianta optimizata este :

public class MyAccountPage extends BasePage {

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h2[text()='My Account']") // Titlul paginii
    private WebElement msgHeading;

    @FindBy(xpath = "//div[@class='list-group']//a[text()='Logout']")
    private WebElement lnkLogout;

    // ✅ Verifică dacă My Account page este afișată
    public boolean isMyAccountPageExists() {
        return waitForElement(msgHeading, 10) != null;
    }

    // ✅ Click pe Logout, returnează true dacă a reușit
    public boolean clickLogout() {
        WebElement logoutButton = waitForElement(lnkLogout, 10);
        if (logoutButton != null) {
            logoutButton.click();
            return true;
        }
        return false;
    }

    // ✅ Metodă reutilizabilă pentru așteptare
    private WebElement waitForElement(WebElement element, int timeout) {
        try {
            return new WebDriverWait(driver, Duration.ofSeconds(timeout))
                .until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            return null;
        }
    }
}


*/

}
