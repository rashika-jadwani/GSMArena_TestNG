package ui_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ActionsClassUtil;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class phoneFinderPage {
    @FindBy(xpath = "//a[@class='pad-multiple pad-allbrands']/span[text()='All brands']")
    WebElement allBrandsButton;

    @FindBy(xpath = "//a[@class='pad-multiple pad-rumormill']/span[text()='Rumor mill']")
    WebElement rumorMillButton;

    @FindBy(xpath = "//div[starts-with(@class,'brandmenu')]/ul/li/a")
    List<WebElement> listOfBrands;


    WebDriver driver;
    ActionsClassUtil actionsObj = new ActionsClassUtil();

    public phoneFinderPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnAllBrandsButton() {
        allBrandsButton.click();
    }

    public void clickOnRumorMillutton() {
        rumorMillButton.click();
    }

    public void hoverOnAllBrandsButton() {
        actionsObj.hoverOverElement(driver, allBrandsButton);
    }

    public void hoverOnRumorMillutton() {
        actionsObj.hoverOverElement(driver, rumorMillButton);
    }

    public ArrayList<String> listOfAllBrands() {
        ArrayList<String> listOfBrandsName = new ArrayList<String>();
        for (WebElement e : listOfBrands) {
            listOfBrandsName.add(e.getText());
        }
        return listOfBrandsName;
    }

    public boolean openSpecificBrandPage(String brandName) {
        ArrayList<String> abc = listOfAllBrands();
        for (String s : abc) {
            if (s.equalsIgnoreCase(brandName)) {
                driver.findElement(By.xpath("//a[text()='"+brandName+"']")).click();
                return true;
            }
        }
            return false;
    }
}
