//  In acest proiect nu avem nevoie de aceasta clasa, ea este generata ca sa vedem variante posibile
//  Clasa de unde se incarca datele este BaseClass

package driver;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class DriverManager {

        private static WebDriver driver;

        public static WebDriver getDriver() {
            if (driver == null) {
                System.setProperty("webdriver.chrome.driver", "C:/Users/CRISTIAN ZIDARESCU/IdeaProjects/Project_CucumberComplet/drivers");

                ChromeOptions options = new ChromeOptions();
                options.setPageLoadStrategy(PageLoadStrategy.NORMAL);

                driver = new ChromeDriver(options);
                driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
                driver.manage().window().maximize();
            }
            return driver;
        }

        public static void quitDriver() {
            if (driver != null) {
                driver.quit();
                driver = null;
            }
        }
}
