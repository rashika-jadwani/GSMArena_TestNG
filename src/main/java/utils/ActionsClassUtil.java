package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionsClassUtil {
    Actions act;

    public void hoverOverElement(WebDriver driver, WebElement element){
        act = new Actions(driver);
        act. moveToElement(element);
    }
}
