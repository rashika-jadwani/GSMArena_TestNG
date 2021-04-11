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
        driver.manage().window().maximize();
        objHomePage = new HomePage(driver);
        driver.get("https://www.gsmarena.com/");
        objHomePage.mainMenuButtonClick();
    }

    @Test(priority = 1)
    public void goToNewsPage(){
        objHomePage.checkNewsUrl();
    }

    @Test(priority = 1)
    public void goToReviewsPage(){
        objHomePage.checkReviewsUrl();
    }

    @Test(priority = 1)
    public void goToVideosPage(){
        objHomePage.checkVideosUrl();
    }

    @Test(priority = 1)
    public void goToPhoneFinderPage(){
        objHomePage.checkPhoneFinderUrl();
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


    @AfterClass
    public void closedown(){
        driver.quit();
    }
}
