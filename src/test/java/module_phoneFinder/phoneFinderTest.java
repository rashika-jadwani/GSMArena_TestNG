package module_phoneFinder;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ui_pages.HomePage;
import ui_pages.phoneFinderPage;

public class phoneFinderTest {
    private WebDriver driver;
    private phoneFinderPage phoneFinderObj;
    private HomePage homePageObj;

    @BeforeMethod
    @Parameters(value = {"browser"})
    public void setup(String browser){
        if(browser.toLowerCase().equals("chrome")){
            System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/drivers/chromedriver.exe");
            driver = new ChromeDriver();
        }else if(browser.toLowerCase().equals("firefox")){
            System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"/drivers/geckodriver.exe");
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.get("https://www.gsmarena.com/");
        homePageObj = new HomePage(driver);
        homePageObj.mainMenuButtonClick();
        homePageObj.checkPhoneFinderUrl();
        phoneFinderObj = new phoneFinderPage(driver);
    }

    @Test
    public void clickOnAllBrands(){
        phoneFinderObj.clickOnAllBrandsButton();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.gsmarena.com/makers.php3");
    }

    @Test
    public void clickOnRumorMill(){
        phoneFinderObj.clickOnRumorMillutton();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.gsmarena.com/rumored.php3");
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
