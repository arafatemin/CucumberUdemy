package Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class DriverFactory {
    public static Properties properties;
    public String url;
    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    public DriverFactory(){
        try{
            properties = new Properties();
            FileInputStream inputStream = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/bowser_url.properties");
            properties.load(inputStream);
        }
        catch (IOException io){
            System.out.println(io.getMessage());
        }
    }



    public static WebDriver getDriver() {
        if (webDriver.get() == null) {
            WebDriver driver = createDriver();
            webDriver.set(driver);
        }
        return webDriver.get();
    }


    public String getUrl(){
        url = properties.getProperty("url");
        return url;
    }



    private static WebDriver createDriver() {
        WebDriver driver = null;



        switch (getBrowserType()) {
            case "chrome" -> {
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                driver = new ChromeDriver(chromeOptions);
                break;
            }
            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                driver = new FirefoxDriver(firefoxOptions);
                break;
            }
        }
        driver.manage().window().maximize();
        return driver;
    }


    private static String getBrowserType(){
        String browserType = null;
        browserType = properties.getProperty("browser").toLowerCase().trim();
        return browserType;
    }

    public static void cleanupDriver() {
        webDriver.get().close();
        webDriver.get().quit();
        webDriver.remove();
    }



    public String generateRandomNumber(int length){
        return RandomStringUtils.randomNumeric(length);
    }

    public String generateRandomString(int length){
        return RandomStringUtils.randomAlphabetic(length);
    }






}
