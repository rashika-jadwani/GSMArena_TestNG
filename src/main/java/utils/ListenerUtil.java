package utils;

import org.testng.IAnnotationTransformer;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ListenerUtil implements ITestListener, IAnnotationTransformer {

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

    public void transform(
            ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        annotation.setRetryAnalyzer(RetryUtil.class);

    }
    }




