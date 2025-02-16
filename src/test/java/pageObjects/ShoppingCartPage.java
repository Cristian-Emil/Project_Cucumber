package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ShoppingCartPage extends BasePage{

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//div[@id='cart']")
    WebElement btnItems;

    @FindBy(xpath="//strong[normalize-space()='View Cart']")
    WebElement lnkViewCart;

    @FindBy(xpath="//*[@id='content']/div[2]/div/table//strong[text()='Total:']//following::td")
    WebElement lblTotalPrice;

    @FindBy(xpath="//a[text()='Checkout']")
    WebElement btnCheckout;

    // ✅ Folosește WebDriverWait pentru a aștepta elementul să devină clicabil
    public void clickItemsToNavigateToCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(btnItems)).click();
    }

    // ✅ Folosește WebDriverWait pentru a aștepta vizibilitatea linkului
    public void clickViewCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(lnkViewCart)).click();
    }

    // ✅ Verifică dacă prețul total este valid
    public String getTotalPrice() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(lblTotalPrice));
            return lblTotalPrice.getText();
        } catch (Exception e) {
            return "Price not found or error occurred!";
        }
    }

    // ✅ Folosește WebDriverWait pentru a aștepta ca butonul Checkout să devină clicabil
    public void clickOnCheckout() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(btnCheckout)).click();
    }

}
