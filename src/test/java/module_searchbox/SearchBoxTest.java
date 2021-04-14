package module_searchbox;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import ui_pages.HomePage;
import utils.PropertyFileReader;

public class SearchBoxTest {
    private WebDriver driver;
    private HomePage objHomepage;
    PropertyFileReader propertyFileReaderBrowser;
    PropertyFileReader propertyFileReaderTest;

    @BeforeClass
    public void classSetup(){
        propertyFileReaderBrowser = new PropertyFileReader("browserSetup.txt");
        propertyFileReaderTest = new PropertyFileReader("testValidation.txt");
    }

    @BeforeMethod
    @Parameters({"browser"})
    public void setupTest(String browserName){
        if(browserName.toLowerCase().equals("chrome")){
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ propertyFileReaderBrowser.getProperty("ChromeDriverPath"));
            driver = new ChromeDriver();
        } else if( browserName.toLowerCase().equals("firefox")){
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+ propertyFileReaderBrowser.getProperty("FirefoxDriverPath"));
            driver = new FirefoxDriver();
        }
        objHomepage = new HomePage(driver);
        driver.manage().window().maximize();
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
    public void teardown(){
        driver.quit();
    }
}
