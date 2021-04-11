package ui_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ActionsClassUtil;

public class phoneFinderPage {
    @FindBy(xpath = "//a[@class='pad-multiple pad-allbrands']/span[text()='All brands']")
    WebElement allBrandsButton;

    @FindBy(xpath = "//a[@class='pad-multiple pad-rumormill']/span[text()='Rumor mill']")
    WebElement rumorMillButton;

    WebDriver driver;
    ActionsClassUtil actionsObj = new ActionsClassUtil();

    public phoneFinderPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void clickOnAllBrandsButton(){
        allBrandsButton.click();
    }

    public void clickOnRumorMillutton(){
        rumorMillButton.click();
    }

    public void hoverOnAllBrandsButton(){
        actionsObj.hoverOverElement(driver,allBrandsButton);
    }

    public void hoverOnRumorMillutton(){
        actionsObj.hoverOverElement(driver,rumorMillButton);
    }
}
