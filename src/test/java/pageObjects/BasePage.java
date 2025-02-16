package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    public BasePage(WebDriver driver)
    {
        this.driver= driver;
        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

//  Adaugam linia ca sa ichidem browserul la final:
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }

/* Avcem aici o varianta optimizata :

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        maximizeWindow();
    }

    private void maximizeWindow() {
        driver.manage().window().maximize();
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}

 */



}
