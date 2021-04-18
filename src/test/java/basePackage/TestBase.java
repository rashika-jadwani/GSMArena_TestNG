package basePackage;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;

public class TestBase {

    public ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;

    @BeforeTest
    public void testsetSetup() {
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + File.separator + "Reports" + File.separator + "AutomationReport.html");
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setDocumentTitle("GSM Arena Test Report");
        htmlReporter.config().setReportName("TestNG reports");
        htmlReporter.config().setTheme(Theme.DARK);
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Tester 1", "Rashika Jadvani");
        extent.setSystemInfo("Tester 2", "Rahul Jadhwani");
    }

    @AfterTest
    public void testsetClosure(){
        extent.flush();
    }
}
