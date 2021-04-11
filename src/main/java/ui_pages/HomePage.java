package ui_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {

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

    @FindBy(xpath = "((//a[text()='Phone Finder'])[1]")
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

    public int checkMainMenuSize(){
        return mainMenuList.size();
    }
}
