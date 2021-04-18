package ui_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ActionsClassUtil;

import java.util.ArrayList;
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

    @FindBy(xpath = "//input[@id='topsearch-text']")
    WebElement searchBox;

    WebDriver driver;

    ActionsClassUtil actUtil = new ActionsClassUtil();

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
        actUtil.hoverOverElement(driver,reviews);
    }

    public void hoverOverNewsCheck(){
        actUtil.hoverOverElement(driver,news);
    }

    public void hoverOverVideosCheck(){
        actUtil.hoverOverElement(driver,videos);
    }

    public String searchAndSelectAProduct(String productName){
        searchBox.sendKeys(productName+ Keys.ENTER);
        driver.findElement(By.xpath("//span[text()='"+productName+"']")).click();
        return driver.findElement(By.xpath("//h1[contains(@class,'specs-phone-name-title')]")).getText();
    }

    public List<String> checkWhatSearchBoxReturns(String keyword){
        searchBox.sendKeys(keyword);
        List<WebElement> searchList = driver.findElements(By.xpath("//div[@class='phone-results']/ul/li/a/span"));
        List<String> searchResult = new ArrayList<>();
        for(WebElement e: searchList){
            searchResult.add(e.getText());
        }
        return searchResult;
    }


}
