package factory;


import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

public class BaseClass1 {


    static WebDriver driver;
    static Properties prop;
    static Logger logger;

    public static WebDriver initilizeBrowser() throws IOException
    {

//  Aici apelam driverul de Chrome. A fost necesar sa generam clasa de DRIVER in proiectul nostru Cucumber.
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");

//      Aici importam cele 3 elemente - execution environment, browser si operetion sistem din Property File
        prop = getProperties();
        String executionEnv = prop.getProperty("execution_env");
        String browser = prop.getProperty("browser").toLowerCase();
        String os = prop.getProperty("os").toLowerCase();

        if(executionEnv.equalsIgnoreCase("remote"))
        {
            DesiredCapabilities capabilities = new DesiredCapabilities();

            //os
            switch (os) {
                case "windows":
                    capabilities.setPlatform(Platform.WINDOWS);
                    break;
                case "mac":
                    capabilities.setPlatform(Platform.MAC);
                    break;
                case "linux":
                    capabilities.setPlatform(Platform.LINUX);
                    break;
                default:
                    System.out.println("No matching OS");
                    return null;
            }

//browser
            switch (browser) {
                case "chrome":
                    capabilities.setBrowserName("chrome");
                    break;
                case "edge":
                    capabilities.setBrowserName("MicrosoftEdge");
                    break;
                case "firefox":
                    capabilities.setBrowserName("firefox");
                    break;
                default:
                    System.out.println("No matching browser");
                    return null;
            }

            driver.manage().window().maximize();

            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
//            driver = new RemoteWebDriver(new URL("https://tutorialsninja.com/demo/"),capabilities);
        }
        else if(executionEnv.equalsIgnoreCase("local"))
        {
            switch(browser.toLowerCase())
            {
                case "chrome":
                    driver=new ChromeDriver();
                    break;
                case "edge":
                    driver=new EdgeDriver();
                    break;
                case "firefox":
                    driver=new FirefoxDriver();
                    break;
                default:
                    System.out.println("No matching browser");
                    driver=null;
            }
        }
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(25));

        return driver;

    }

    public static WebDriver getDriver() {
        return driver;
    }

//    public static Properties getProperties() throws IOException
//    {
//        FileReader file=new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
//        prop=new Properties();
//        prop.load(file);
//        return prop;
//    }

//  In locul liniilor de mai sus comentate o sa folosim vsariante urmatoare pt mai multa acuratete:
    public static Properties getProperties() throws IOException
    {
        if (prop == null) {
            try (FileReader file = new FileReader(System.getProperty("user.dir") + "/src/test/resources/config.properties")) {
                prop = new Properties();
                prop.load(file);
            }
        }
        return prop;
    }

    public static Logger getLogger()
    {
        logger= LogManager.getLogger(); //Log4j
        return logger;
    }

    public static String randomeString()
    {
        String generatedString= RandomStringUtils.randomAlphabetic(5);
        return generatedString;
    }


    public static String randomeNumber()
    {
        String generatedString=RandomStringUtils.randomNumeric(10);
        return generatedString;
    }


    public static String randomAlphaNumeric()
    {
        String str=RandomStringUtils.randomAlphabetic(5);
        String num=RandomStringUtils.randomNumeric(10);
        return str+num;
    }

}
