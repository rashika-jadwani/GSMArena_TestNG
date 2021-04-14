package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class WaitUtil {

    WebDriver driver;
    Wait wait;

    public WaitUtil(WebDriver driver){
        this.driver = driver;
    }

    public void waitForElementToBeClickable(WebElement element, int timeOut){
        wait = new WebDriverWait(driver, timeOut);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void waitForElementVisibility(WebElement element, int timeOut){
        wait = new WebDriverWait(driver, timeOut);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForPresenceOfAlert(int timeOut){
        wait = new WebDriverWait(driver, timeOut);
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public void waitForElementToBeClickable(WebElement element, int pollingPeriod, int timeOut){
        wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(timeOut)).pollingEvery(Duration.ofSeconds(pollingPeriod)).ignoring(Exception.class);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForElementVisibility(WebElement element, int pollingPeriod, int timeOut){
        wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(timeOut)).pollingEvery(Duration.ofSeconds(pollingPeriod)).ignoring(Exception.class);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForPresenceOfAlert(int pollingPeriod, int timeOut){
        wait = new FluentWait(driver).withTimeout(Duration.ofSeconds(timeOut)).pollingEvery(Duration.ofSeconds(pollingPeriod)).ignoring(Exception.class);
        wait.until(ExpectedConditions.alertIsPresent());
    }



}
