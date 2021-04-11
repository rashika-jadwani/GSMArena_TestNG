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
        driver.get("https://www.gsmarena.com/");
    }

    @Test(priority = 1)
    public void goToNewsPage(){

    }

    @Test(priority = 1)
    public void goToReviewsPage(){

    }

    @Test(priority = 1)
    public void goToVideosPage(){

    }

    @Test(priority = 1)
    public void goToPhoneFinderPage(){

    }

    @Test
    public void hoverOverMainMenuCheck(){
    }


    @Test(priority = 0)
    public void mainMenuContents(){
        Assert.assertEquals(objHomePage.checkMainMenuSize(),10);
    }


    @AfterClass
    public void closedown(){
        driver.quit();
    }
}
