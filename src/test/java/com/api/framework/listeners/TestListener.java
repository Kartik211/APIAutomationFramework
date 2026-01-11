package com.api.framework.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.ITestResult;

import com.api.framework.reports.ExtentManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;


public class TestListener implements ITestListener, ITestNGListener{
	
	private static ExtentReports extent = ExtentManager.getExtent();
	private static ThreadLocal<ExtentTest> test=new ThreadLocal<>();
	
	@Override
	public void onTestStart(ITestResult result) {
		ExtentTest extentTest=
				extent.createTest(result.getMethod().getMethodName());
		test.set(extentTest);
	}
	
	@Override
    public void onTestSuccess(ITestResult result) {
        test.get().pass("Test Passed");
    }
	
	@Override
	public void onTestFailure(ITestResult result) {
		test.get().fail(result.getThrowable());
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		test.get().skip("Test Skip");
	}
	
	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}
}
