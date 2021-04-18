package utils;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerUtil implements ITestListener {

    @Override
    public void onTestSuccess(ITestResult result){
        System.out.println("Test "+result.getMethod().getMethodName()+" passed");

    }

    @Override
    public void onTestFailure(ITestResult result){
        System.out.println("Test "+result.getMethod().getMethodName()+" failed");

         }

    @Override
    public void onTestSkipped(ITestResult result){
        System.out.println("Test "+result.getMethod().getMethodName()+" skipped");
    }

    @Override
    public void onTestStart(ITestResult result){

    }



}
