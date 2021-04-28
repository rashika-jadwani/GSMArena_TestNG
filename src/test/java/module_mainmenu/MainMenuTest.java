package module_mainmenu;

import basePackage.TestBase;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import ui_pages.HomePage;
import utils.PropertyFileReader;
import utils.ScreenshotUtil;

import java.lang.reflect.Method;

public class MainMenuTest extends TestBase{
    private HomePage objHomePage;
    private WebDriver driver;
    PropertyFileReader propertyFileReaderBrowser;
    PropertyFileReader propertyFileReaderTest;
    ExtentReports extent;
    ExtentTest logger;

    @BeforeClass
    public void classSetup(){
        extent = TestBase.extent;
        propertyFileReaderBrowser = new PropertyFileReader("browserSetup.txt");
        propertyFileReaderTest = new PropertyFileReader("testValidation.txt");
    }

    @BeforeMethod
    @Parameters({"browser"})
    public void setup(String browserName, Method testMethod){
        if(browserName.toLowerCase().equals("chrome")){
           // System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ propertyFileReaderBrowser.getProperty("ChromeDriverPath"));
            driver = new ChromeDriver();
        } else if( browserName.toLowerCase().equals("firefox")){
          //  System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+ propertyFileReaderBrowser.getProperty("FirefoxDriverPath"));
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        objHomePage = new HomePage(driver);
        driver.get(propertyFileReaderTest.getProperty("HomePageUrl"));
        objHomePage.mainMenuButtonClick();
        logger = extent.createTest(testMethod.getName());
    }

    @Test(priority = 1)
    public void goToNewsPage(){
        objHomePage.checkNewsUrl();
        ScreenshotUtil ssUtil = new ScreenshotUtil(driver);
        ssUtil.takesScreenshotAsFile("NewsSS");
        Assert.assertEquals(driver.getCurrentUrl(),propertyFileReaderTest.getProperty("NewsPageUrl"));
    }

    @Test(priority = 1)
    public void goToReviewsPage(){
        objHomePage.checkReviewsUrl();
        Assert.assertEquals(driver.getCurrentUrl(),propertyFileReaderTest.getProperty("ReviewsPageUrl"));
    }

    @Test(priority = 1)
    public void goToVideosPage(){
        objHomePage.checkVideosUrl();
        Assert.assertEquals(driver.getCurrentUrl(),propertyFileReaderTest.getProperty("VideosPageUrl"));
    }

    @Test(priority = 1)
    public void goToPhoneFinderPage(){
        objHomePage.checkPhoneFinderUrl();
        Assert.assertEquals(driver.getCurrentUrl(),propertyFileReaderTest.getProperty("PhoneFinderPageUrl"));
    }

    @Test(priority = 2)
    public void hoverOverMainMenuCheck(){
        objHomePage.hoverOverNewsCheck();
        objHomePage.hoverOverReviewsCheck();
        objHomePage.hoverOverVideosCheck();
    }


    @Test(priority = 0)
    public void mainMenuContents(){
        Assert.assertEquals(objHomePage.checkMainMenuSize(),10);
    }


    @AfterMethod
    public void closedown(ITestResult result){
        if (result.getStatus()==ITestResult.SUCCESS){
            logger.log(Status.PASS,"Test case: "+result.getMethod()+" passed");
        }else if (result.getStatus()==ITestResult.FAILURE){
            logger.log(Status.FAIL,"Test case: "+result.getMethod()+" failed");
        }
        driver.quit();
    }
}
