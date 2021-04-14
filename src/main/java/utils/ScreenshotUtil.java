package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.imageio.IIOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;

public class ScreenshotUtil {

    WebDriver driver;
    TakesScreenshot takesScreenshot;

    public ScreenshotUtil(WebDriver driver){
        this.driver=driver;
        takesScreenshot = (TakesScreenshot) driver;
    }

    public void takesScreenshotAsFile(String filename){
        File screenshotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        try {
            FileHandler.copy(screenshotFile, new File(System.getProperty("user.dir") + "/Screenshots/" + filename + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
