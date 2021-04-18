package module_phoneFinder;

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
import ui_pages.PhoneFinderPage;
import utils.PropertyFileReader;

import java.lang.invoke.MethodType;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class PhoneFinderTest extends TestBase{
    private WebDriver driver;
    private PhoneFinderPage phoneFinderObj;
    private HomePage homePageObj;
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
    @Parameters(value = {"browser"})
    public void setup(String browser, Method testMethod){
        if(browser.toLowerCase().equals("chrome")){
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ propertyFileReaderBrowser.getProperty("ChromeDriverPath"));
            driver = new ChromeDriver();
        }else if(browser.toLowerCase().equals("firefox")){
            System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+ propertyFileReaderBrowser.getProperty("FirefoxDriverPath"));
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.get(propertyFileReaderTest.getProperty("HomePageUrl"));
        homePageObj = new HomePage(driver);
        logger = extent.createTest(testMethod.getName());
        homePageObj.mainMenuButtonClick();
        homePageObj.checkPhoneFinderUrl();
        phoneFinderObj = new PhoneFinderPage(driver);
    }

    @Test
    public void clickOnAllBrands(){
        phoneFinderObj.clickOnAllBrandsButton();
        Assert.assertEquals(driver.getCurrentUrl(),propertyFileReaderTest.getProperty("AllBrandsUrl"));
    }

    @Test
    public void clickOnRumorMill(){
        phoneFinderObj.clickOnRumorMillutton();
        Assert.assertEquals(driver.getCurrentUrl(),propertyFileReaderTest.getProperty("RumourMillUrl"));
    }

    @Test
    public void getAllBrands(){
        ArrayList<String> listOfBrandsFetched = phoneFinderObj.listOfAllBrands();
        Assert.assertTrue(listOfBrandsFetched.size()!=0,"list is empty");
        System.out.println(listOfBrandsFetched);
    }

    @Test
    public void getSpecificBrand(){
        Assert.assertTrue(phoneFinderObj.openSpecificBrandPage("Google"),"Brand page doesn't exists");
    }

    @Test
    public void hoverOnAllBrands(){
        phoneFinderObj.hoverOnAllBrandsButton();
    }

    @Test
    public void hoverOnRumorMill(){
        phoneFinderObj.hoverOnRumorMillutton();
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
