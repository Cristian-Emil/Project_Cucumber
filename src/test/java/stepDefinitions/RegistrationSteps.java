package stepDefinitions;

import factory.BaseClass;
import hooks.Hooks;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;

import java.util.Map;

public class RegistrationSteps {

    public RegistrationSteps() {
        this.driver = Hooks.getDriver(); // ✅ Ia driver-ul din Hooks, care il ia din BaseClass
    }

    WebDriver driver;
    HomePage hp;
    LoginPage lp;
    AccountRegistrationPage regpage;


    @Given("the user navigates to Register Account page")
    public void user_navigates_to_register_account_page() {
        hp=new HomePage(BaseClass.getDriver());
        hp.clickMyAccount();
        hp.clickRegister();

    }

//  Incarcam valorile din clasa Registration.feature, valori care sunt scrise sub forma de tabel, utilizam linia urmatoare
    @When("the user enters the details into below fields")
    public void user_enters_the_details_into_below_fields(DataTable dataTable) {

/*  Cum incarcam mai multi parametrii intr-un pas din feature files folosind clasa TestRunner .

    Separam valorile individual, ele fiind scrise sub forma de grup cheie-valoare
    hash map (sau hartă de dispersie) este o structură de date care stochează perechi cheie-valoare și
    oferă acces rapid la valori pe baza cheilor acestora
    Data Table e conectat cu Cucumber deci se importa - io.cucumber.datatable.DataTable;
    Hash Map este conectat cu Java deci se importa - java.util.Map
    Deci convertim Data Table in Hash Map  folosind dataMAP si asMap - este pasul necesar pt a incarca valorile.
*/
        Map<String, String> dataMap = dataTable.asMap(String.class,String.class);
        regpage=new AccountRegistrationPage(BaseClass.getDriver());
        regpage.setFirstName(dataMap.get("firstName"));
        regpage.setLastName(dataMap.get("lastName"));
        regpage.setEmail(BaseClass.randomAlphaNumeric()+"@hotmail.com");
        regpage.setTelephone(dataMap.get("telephone"));
        regpage.setPassword(dataMap.get("password"));
        regpage.setConfirmPassword(dataMap.get("password"));

    }


    @When("the user selects Privacy Policy")
    public void user_selects_privacy_policy() {
        regpage.setPrivacyPolicy();
    }

    @When("the user clicks on Continue button")
    public void user_clicks_on_continue_button() {
        regpage.clickContinue();
    }


    @Then("the user account should get created successfully")
    public void user_account_should_get_created_successfully() {

        WebElement successMsg = driver.findElement(By.xpath("//h1[contains(text(),'Your Account Has Been Created!')]"));
        Assert.assertTrue(successMsg.isDisplayed());

        String confmsg=regpage.getConfirmationMsg();
        Assert.assertEquals(confmsg, "Your Account Has Been Created!");

        AccountRegistrationPage regPage = new AccountRegistrationPage(driver);
        regPage.clickContinue1();

    }


}
