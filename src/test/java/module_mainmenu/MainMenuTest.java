package module_mainmenu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import ui_pages.HomePage;
import utils.PropertyFileReader;
import utils.ScreenshotUtil;

public class MainMenuTest {
    private HomePage objHomePage;
    private WebDriver driver;
    PropertyFileReader propertyFileReaderBrowser;
    PropertyFileReader propertyFileReaderTest;

    @BeforeClass
    public void classSetup(){
        propertyFileReaderBrowser = new PropertyFileReader("browserSetup.txt");
        propertyFileReaderTest = new PropertyFileReader("testValidation.txt");
    }

    @BeforeMethod
    @Parameters({"browser"})
    public void setup(String browserName){
        if(browserName.toLowerCase().equals("chrome")){
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ propertyFileReaderBrowser.getProperty("ChromeDriverPath"));
            driver = new ChromeDriver();
        } else if( browserName.toLowerCase().equals("firefox")){
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+ propertyFileReaderBrowser.getProperty("FirefoxDriverPath"));
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        objHomePage = new HomePage(driver);
        driver.get(propertyFileReaderTest.getProperty("HomePageUrl"));
        objHomePage.mainMenuButtonClick();
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
    public void closedown(){
        driver.quit();
    }
}
