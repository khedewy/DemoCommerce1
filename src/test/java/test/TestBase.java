package test;

import helpers.CaptureScreenshoots;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

public class TestBase {
    WebDriver driver;

    @BeforeTest
    @Parameters({"browser"})
    public void Setdriver(@Optional("firefox") String browserName){
        if (browserName.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.navigate().to("https://demo.nopcommerce.com/");
            driver.manage().window().maximize();

        }

        else if (browserName.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.navigate().to("https://demo.nopcommerce.com/");
            driver.manage().window().maximize();

        }
    }

    @AfterTest
    public void ColsDriver(){
        driver.close();
    }

    @AfterMethod
    public void screenshots(ITestResult result){
        if (result.getStatus() == ITestResult.FAILURE){
            System.out.println("taking screenshots");
            CaptureScreenshoots.takingScreenshoots(driver,result.getName());

        }

    }
}
