package module_searchbox;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ui_pages.HomePage;

public class SearchBoxTest {
    private WebDriver driver;
    private HomePage objHomepage;

    @BeforeMethod
    @Parameters({"browser"})
    public void setupTest(String browserName){
        if(browserName.toLowerCase().equals("chrome")){
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");
            driver = new ChromeDriver();
        } else if( browserName.toLowerCase().equals("firefox")){
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        }
        objHomepage = new HomePage(driver);
        driver.manage().window().maximize();
        driver.get("https://www.gsmarena.com/");
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
