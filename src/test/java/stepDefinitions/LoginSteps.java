package stepDefinitions;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import utilities.DataReader;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class LoginSteps extends BaseClass {

    WebDriver driver;
    HomePage hp;
    LoginPage lp;
    MyAccountPage macc;

    List<HashMap<String, String>> datamap;      //Data driven
//  Aici avem datamap ce contine : list collection unde sunt hash map si in  fiecare avem randuri si coloane de unde extragem valorile


    @Given("the user navigates to login page")
    public void user_navigate_to_login_page() throws InterruptedException {
        BaseClass.getLogger().info("Goto my account-->Click on Login.. ");
        hp=new HomePage(BaseClass.getDriver());
        hp.clickMyAccount();
        hp.clickLogin();
        Thread.sleep(3000);
    }

    @When("user enters email as {string} and password as {string}")
    public void user_enters_email_as_and_password_as(String email, String pwd) throws InterruptedException {
        BaseClass.getLogger().info("Entering email and password.. ");
        lp=new LoginPage(BaseClass.getDriver());
        lp.setEmail(email);
        lp.setPassword(pwd);
        Thread.sleep(3000);
    }



    @When("the user clicks on the Login button")
    public void click_on_login_button() throws InterruptedException {
        lp.clickLogin();
        BaseClass.getLogger().info("clicked on login button...");
        Thread.sleep(3000);
    }

    @Then("the user should be redirected to the My Account Page")
    public void the_user_should_be_redirected_to_the_my_account_page() throws InterruptedException {

        String expectedTitle = "My Account";
        Assert.assertEquals(driver.getTitle(), expectedTitle);

        String expectedUrl = "https://tutorialsninja.com/demo/index.php?route=account/account";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals("User is not redirected to the My Account page!", expectedUrl, actualUrl);

        Thread.sleep(5000);

        macc=new MyAccountPage(BaseClass.getDriver());
        boolean targetpage=macc.isMyAccountPageExists();

        Assert.assertEquals(targetpage, true);

////  Varianta imbunatatita:
//
//        String expectedUrl = "https://tutorialsninja.com/demo/index.php?route=account/account";
//        String actualUrl = BaseClass.getDriver().getCurrentUrl();
//
//        Assert.assertEquals("User is not redirected to the My Account page!", expectedUrl, actualUrl);
//
//        macc = new MyAccountPage(BaseClass.getDriver());
//        boolean targetpage = macc.isMyAccountPageExists();
//
//        Assert.assertTrue("My Account page was not displayed!", targetpage);
//
//        Thread.sleep(5000); // poate fi eliminat sau înlocuit cu WebDriverWait


// Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();

    }

// *******   Data Driven test **************
    @Then("the user should be redirected to the MyAccount Page by passing email and password with excel row {string}")
    public void check_user_navigates_to_my_account_page_by_passing_email_and_password_with_excel_data(String rows) throws InterruptedException {
        try {

            datamap = DataReader.data(System.getProperty("user.dir") + "/src/testData/LoginData.xlsx", "Sheet1");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Excel Data: " + datamap);

//  VERIFICAM EXISTENTA FISIERULUI -------------------------------------------------------------------------------------
        String filePath = System.getProperty("user.dir") + "/src/testData/LoginData.xlsx";
        System.out.println("File Path: " + filePath);

        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("Error: File not found!");
        }
//  --------------------------------------------------------------------------------------------------------------------
        int index = Integer.parseInt(rows) - 1;
        String email = datamap.get(index).get("username");  //   => dupa ce capturam username-ul il scriem la email
        String pwd = datamap.get(index).get("password");    //   => dupa ce capturam pass il scriem la password
        String exp_res = datamap.get(index).get("res");

        lp = new LoginPage(BaseClass.getDriver());
        lp.setEmail(email);
        lp.setPassword(pwd);
        lp.clickLogin();
        macc = new MyAccountPage(BaseClass.getDriver());
        Thread.sleep(5000);
        try {
            boolean targetpage = macc.isMyAccountPageExists();
            System.out.println("target page: " + targetpage);
            if (exp_res.equalsIgnoreCase("Valid")) {
                if (targetpage) {
                    macc.clickLogout();
                    Assert.assertTrue(true);
                } else {
                    Assert.assertTrue(false);
                }
            }

            if (exp_res.equalsIgnoreCase("Invalid")) {
                if (targetpage) {
                    macc.clickLogout();
                    Assert.assertTrue(false);
                } else {
                    Assert.assertTrue(true);
                }
            }
        }
        catch(Exception e) {
            Assert.assertTrue(false);
        }
    }

}
