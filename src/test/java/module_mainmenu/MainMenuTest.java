package module_mainmenu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import ui_pages.HomePage;

public class MainMenuTest {
    private HomePage objHomePage;
    private WebDriver driver;


    @BeforeClass
    @Parameters({"browser"})
    public void setupClass(String browserName){
        if(browserName.toLowerCase().equals("chrome")){
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");
            driver = new ChromeDriver();
        } else if( browserName.toLowerCase().equals("firefox")){
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        }
        objHomePage = new HomePage(driver);
    }

    @BeforeMethod
    public void testSetup(){
        driver.get("https://www.gsmarena.com/");
    }

    @Test
    public void goToNewsPage(){

    }

    @Test
    public void goToReviewsPage(){

    }

    @Test
    public void goToVideosPage(){

    }

    @Test
    public void goToPhoneFinderPage(){

    }


    @Test
    public void mainMenuContents(){
        Assert.assertEquals(objHomePage.checkMainMenuSize(),10);
    }

    @AfterMethod
    public void testCleanup(){
        driver.quit();
    }


    @AfterClass
    public void closedown(){
    }
}
