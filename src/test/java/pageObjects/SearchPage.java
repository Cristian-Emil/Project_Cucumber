package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchPage extends BasePage{

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//*[@id='content']/div[3]//img")
    List<WebElement> searchProducts;

    @FindBy(xpath="//input[@id='input-quantity']")
    WebElement txtQuantity;

    @FindBy(xpath="//button[@id='button-cart']")
    WebElement btnAddToCart;

    @FindBy(xpath="//div[contains(text(),'Success: You have added')]")
    WebElement cnfMsg;

    // ✅ Metodă reutilizabilă pentru a găsi un produs
    private WebElement findProductElement(String productName) {
        for (WebElement product : searchProducts) {
            if (product.getAttribute("title").equals(productName)) {
                return product;
            }
        }
        return null;
    }

    // ✅ Verifică dacă produsul există
    public boolean isProductExist(String productName) {
        return findProductElement(productName) != null;
    }

    // ✅ Selectează produsul doar dacă este găsit
    public void selectProduct(String productName) {
        WebElement product = findProductElement(productName);
        if (product != null) {
            product.click();
        }
    }

    public void setQuantity(String qty) {
        txtQuantity.clear();
        txtQuantity.sendKeys(qty);
    }

    public void addToCart() {
        btnAddToCart.click();
    }

    // ✅ Folosește WebDriverWait pentru confirmare
    public boolean checkConfMsg() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            return wait.until(ExpectedConditions.visibilityOf(cnfMsg)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

}
