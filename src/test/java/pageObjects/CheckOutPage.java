package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckOutPage extends BasePage {

    public CheckOutPage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(xpath="//input[@id='input-payment-firstname']")
    WebElement txtfirstName;

    @FindBy(xpath="//input[@id='input-payment-lastname']")
    WebElement txtlastName;


    @FindBy(xpath="//input[@id='input-payment-address-1']")
    WebElement txtaddress1;

    @FindBy(xpath="//input[@id='input-payment-address-2']")
    WebElement txtaddress2;


    @FindBy(xpath="//input[@id='input-payment-city']")
    WebElement txtcity;


    @FindBy(xpath="//input[@id='input-payment-postcode']")
    WebElement txtpin;


    @FindBy(xpath="//select[@id='input-payment-country']")
    WebElement drpCountry;


    @FindBy(xpath="//select[@id='input-payment-zone']")
    WebElement drpState;

    @FindBy(xpath="//input[@id='button-payment-address']")
    WebElement btncontinueBillingAddress;

    @FindBy(xpath="//input[@id='button-shipping-address']")
    WebElement btncontinueDeliveryAddress;

    @FindBy(xpath="//textarea[@name='comment']")
    WebElement txtDeliveryMethod;

    @FindBy(xpath="//input[@id='button-shipping-method']")
    WebElement btncontinueShippingAddress;


    @FindBy(xpath="//input[@name='agree']")
    WebElement chkboxTerms;


    @FindBy(xpath="//input[@id='button-payment-method']")
    WebElement btncontinuePaymentMethod;


    @FindBy(xpath="//strong[text()='Total:']//following::td")
    WebElement lblTotalPrice;


    @FindBy(xpath="//input[@id='button-confirm']")
    WebElement btnConfOrder;


    @FindBy(xpath="//*[@id='content']/h1")
    WebElement lblOrderConMsg;



    public void setfirstName(String firstName) {
        txtfirstName.sendKeys(firstName);
    }


    public void setlastName(String lastName) {
        txtlastName.sendKeys(lastName);
    }


    public void setaddress1(String address1) {
        txtaddress1.sendKeys(address1);
    }


    public void setaddress2(String address2) {
        txtaddress2.sendKeys(address2);
    }


    public void setcity(String city) {
        txtcity.sendKeys(city);
    }


    public void setpin(String pin) {
        txtpin.sendKeys(pin);
    }


    public void setCountry(String Country) {
        new Select(drpCountry).selectByVisibleText(Country);
    }


    public void setState(String State) {
        new Select(drpState).selectByVisibleText(State);
    }

    public void clickOnContinueAfterBillingAddress()
    {
        btncontinueBillingAddress.click();
    }

    public void clickOnContinueAfterDeliveryAddress()
    {
        btncontinueDeliveryAddress.click();
    }


    public void setDeliveryMethodComment(String deliverymsg)
    {
        txtDeliveryMethod.sendKeys(deliverymsg);

    }

    public void clickOnContinueAfterDeliveryMethod()
    {
        btncontinueShippingAddress.click();
    }

    public void selectTermsAndConditions()
    {
        chkboxTerms.click();
    }

    public void clickOnContinueAfterPaymentMethod()
    {
        btncontinuePaymentMethod.click();
    }

    public String  getTotalPriceBeforeConfOrder()
    {
        return lblTotalPrice.getText(); //$207.00

    }

    public void clickOnConfirmOrder() {
        btnConfOrder.click();
    }

    public boolean isOrderPlaced() throws InterruptedException
    {
        try
        {
            driver.switchTo().alert().accept();
            Thread.sleep(2000);
            btnConfOrder.click();
            Thread.sleep(3000);
            if(lblOrderConMsg.getText().equals("Your order has been placed!"))
                return true;
            else
                return false;
        }catch(Exception e)
        {
            return false;
        }

    }

/*  Pentru o optimizare completa avem varianta:

public class CheckOutPage extends BasePage {

    public CheckOutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="input-payment-firstname") private WebElement txtFirstName;
    @FindBy(id="input-payment-lastname") private WebElement txtLastName;
    @FindBy(id="input-payment-address-1") private WebElement txtAddress1;
    @FindBy(id="input-payment-address-2") private WebElement txtAddress2;
    @FindBy(id="input-payment-city") private WebElement txtCity;
    @FindBy(id="input-payment-postcode") private WebElement txtPostalCode;
    @FindBy(id="input-payment-country") private WebElement drpCountry;
    @FindBy(id="input-payment-zone") private WebElement drpState;
    @FindBy(id="button-payment-address") private WebElement btnContinueBilling;
    @FindBy(id="button-shipping-address") private WebElement btnContinueDelivery;
    @FindBy(name="comment") private WebElement txtDeliveryMethod;
    @FindBy(id="button-shipping-method") private WebElement btnContinueShipping;
    @FindBy(name="agree") private WebElement chkboxTerms;
    @FindBy(id="button-payment-method") private WebElement btnContinuePayment;
    @FindBy(xpath="//strong[text()='Total:']//following::td") private WebElement lblTotalPrice;
    @FindBy(id="button-confirm") private WebElement btnConfirmOrder;
    @FindBy(xpath="//*[@id='content']/h1") private WebElement lblOrderConMsg;

    private void enterText(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    private void selectDropdownByVisibleText(WebElement element, String text) {
        new Select(element).selectByVisibleText(text);
    }

    public void setFirstName(String firstName) { enterText(txtFirstName, firstName); }
    public void setLastName(String lastName) { enterText(txtLastName, lastName); }
    public void setAddress1(String address1) { enterText(txtAddress1, address1); }
    public void setAddress2(String address2) { enterText(txtAddress2, address2); }
    public void setCity(String city) { enterText(txtCity, city); }
    public void setPostalCode(String postalCode) { enterText(txtPostalCode, postalCode); }
    public void setCountry(String country) { selectDropdownByVisibleText(drpCountry, country); }
    public void setState(String state) { selectDropdownByVisibleText(drpState, state); }
    public void setDeliveryMethodComment(String deliveryMsg) { enterText(txtDeliveryMethod, deliveryMsg); }

    public void clickContinueAfterBilling() { btnContinueBilling.click(); }
    public void clickContinueAfterDelivery() { btnContinueDelivery.click(); }
    public void clickContinueAfterShipping() { btnContinueShipping.click(); }
    public void selectTermsAndConditions() { chkboxTerms.click(); }
    public void clickContinueAfterPayment() { btnContinuePayment.click(); }
    public String getTotalPriceBeforeConfirmation() { return lblTotalPrice.getText(); }
    public void clickConfirmOrder() { btnConfirmOrder.click(); }

    public boolean isOrderPlaced() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

            try { wait.until(ExpectedConditions.alertIsPresent()).accept(); } catch (NoAlertPresentException ignored) {}

            btnConfirmOrder.click();
            wait.until(ExpectedConditions.visibilityOf(lblOrderConMsg));
            return lblOrderConMsg.getText().equals("Your order has been placed!");
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}

*/

}
