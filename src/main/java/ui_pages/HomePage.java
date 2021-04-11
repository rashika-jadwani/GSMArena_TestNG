package ui_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ActionsClassUtil;

import java.util.List;

public class HomePage {

    @FindBy(xpath = "//span[@class='lines']")
    WebElement mainMenuButton;

    @FindBy(xpath = "//ul[@id='menu']/li")
    List<WebElement> mainMenuList;

    @FindBy(xpath = "(//a[text()='Home'])[1]")
    WebElement home;

    @FindBy(xpath = "(//a[text()='News'])[1]")
    WebElement news;

    @FindBy(xpath = "(//a[text()='Reviews'])[1]")
    WebElement reviews;

    @FindBy(xpath = "//a[text()='Videos']")
    WebElement videos;

    @FindBy(xpath = "//a[text()='Featured']")
    WebElement featured;

    @FindBy(xpath = "(//a[text()='Phone Finder'])[1]")
    WebElement phoneFinder;

    @FindBy(xpath = "//a[text()='Deals']")
    WebElement deals;

    @FindBy(xpath = "//a[text()='Tools']")
    WebElement tools;

    @FindBy(xpath = "(//a[text()='Coverage'])[1]")
    WebElement coverage;

    @FindBy(xpath = "//a[text()='Contact']")
    WebElement contact;


    WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void mainMenuButtonClick(){
      mainMenuButton.click();
    }

    public int checkMainMenuSize(){
        return mainMenuList.size();
    }

    public void checkNewsUrl(){
        news.click();
    }

    public void checkReviewsUrl(){
        reviews.click();
    }

    public void checkVideosUrl(){
        videos.click();
    }

    public void checkPhoneFinderUrl(){
        phoneFinder.click();
    }

    public void hoverOverReviewsCheck(){
        ActionsClassUtil actUtil = new ActionsClassUtil();
        actUtil.hoverOverElement(driver,reviews);
    }

    public void hoverOverNewsCheck(){
        ActionsClassUtil actUtil = new ActionsClassUtil();
        actUtil.hoverOverElement(driver,news);
    }

    public void hoverOverVideosCheck(){
        ActionsClassUtil actUtil = new ActionsClassUtil();
        actUtil.hoverOverElement(driver,videos);
    }


}
