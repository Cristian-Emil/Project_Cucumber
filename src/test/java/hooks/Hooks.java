package hooks;

import factory.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.junit.AfterClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import java.io.IOException;
import java.util.Properties;

public class Hooks extends BaseClass {

    //    private WebDriver driver;
    WebDriver driver;
    //    private Properties prop;
    Properties prop;

    @Before
    public void setUp() throws IOException {
        if (driver == null) { // Verifică dacă driver-ul nu este deja inițializat
            prop = BaseClass.getProperties();
            driver = BaseClass.initilizeBrowser();
            driver.get(prop.getProperty("appURL"));

//  AICI MAXIMIZAM TOATE ECRANELE DE BROWSER CAND LE RULAM:
            driver.manage().window().maximize();

        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) { // Verifică dacă driver-ul nu este deja închis
            driver.quit();
            driver = null;
        }
    }

    @AfterStep
    public void addScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                TakesScreenshot ts = (TakesScreenshot) driver;
                byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", scenario.getName());
            } catch (WebDriverException e) {
                System.out.println("Eroare la realizarea capturii de ecran: " + e.getMessage());
            }
        }
    }

/*  O modalitate de gestionare a metodelor Before si After este :

@Before
public void setUp() throws IOException {
    if (isDriverNotInitialized()) {
        initializeDriver();
    }
}

@After
public void tearDown() {
    if (isDriverInitialized()) {
        closeDriver();
    }
}

private boolean isDriverNotInitialized() {
    return driver == null;
}

private boolean isDriverInitialized() {
    return driver != null;
}

private void initializeDriver() throws IOException {
    prop = BaseClass.getProperties();
    driver = BaseClass.initilizeBrowser();
    driver.get(prop.getProperty("appURL"));
}

private void closeDriver() {
    driver.quit();
    driver = null;
}

*/





/* O metoda optimizata pentru screenshot este :

@AfterStep
public void addScreenshot(Scenario scenario) {
    if (scenario.isFailed()) {
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        } catch (WebDriverException e) {
            System.out.println("Eroare la realizarea capturii de ecran: " + e.getMessage());
            scenario.attach(("Error while capturing screenshot: " + e.getMessage()).getBytes(), "text/plain", "error");
        }
    }
}

*/

}
