package module_phoneFinder;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import ui_pages.HomePage;
import ui_pages.PhoneFinderPage;
import utils.PropertyFileReader;

import java.util.ArrayList;

public class PhoneFinderTest {
    private WebDriver driver;
    private PhoneFinderPage phoneFinderObj;
    private HomePage homePageObj;
    PropertyFileReader propertyFileReaderBrowser;
    PropertyFileReader propertyFileReaderTest;

    @BeforeClass
    public void classSetup(){
        propertyFileReaderBrowser = new PropertyFileReader("browserSetup.txt");
        propertyFileReaderTest = new PropertyFileReader("testValidation.txt");
    }

    @BeforeMethod
    @Parameters(value = {"browser"})
    public void setup(String browser){
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
    public void cleanup(){
        driver.quit();
    }


}
