package module_searchbox;

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

import java.lang.reflect.Method;

public class SearchBoxTest extends TestBase{
    private WebDriver driver;
    private HomePage objHomepage;
    PropertyFileReader propertyFileReaderBrowser;
    PropertyFileReader propertyFileReaderTest;
    ExtentTest logger;
    ExtentReports extent;

    @BeforeClass
    public void classSetup(){
        extent = TestBase.extent;
        propertyFileReaderBrowser = new PropertyFileReader("browserSetup.txt");
        propertyFileReaderTest = new PropertyFileReader("testValidation.txt");
    }

    @BeforeMethod
    @Parameters({"browser"})
    public void setupTest(String browserName, Method testMethod){
        if(browserName.toLowerCase().equals("chrome")){
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ propertyFileReaderBrowser.getProperty("ChromeDriverPath"));
            driver = new ChromeDriver();
        } else if( browserName.toLowerCase().equals("firefox")){
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+ propertyFileReaderBrowser.getProperty("FirefoxDriverPath"));
            driver = new FirefoxDriver();
        }
        objHomepage = new HomePage(driver);
        driver.manage().window().maximize();
        logger = extent.createTest(testMethod.getName());
        driver.get(propertyFileReaderTest.getProperty("HomePageUrl"));
    }

    @Test
    public void testSearchBoxAndClick(){
        String openedPageHeader = objHomepage.searchAndSelectAProduct("Pocophone F1");
        Assert.assertTrue(openedPageHeader.contains("Pocophone F1"));
    }

    @Test
    public void testSearchBoxResults(){
       Assert.assertNotNull(objHomepage.checkWhatSearchBoxReturns("f1"));
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
