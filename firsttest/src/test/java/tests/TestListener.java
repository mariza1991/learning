package tests;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.log4testng.Logger;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static utils.WebdriverManager.getDriver;

public class TestListener implements ITestListener {

    private static final String PATH_TO_SCRENSHOT = "src/main/output/";

    private Logger logger = Logger.getLogger(TestListener.class);

    public void onTestStart(ITestResult iTestResult) {
        logger.info("Please, write me something ...");
    }

    public void onTestSuccess(ITestResult iTestResult) {

    }

    public void onTestFailure(ITestResult iTestResult) {

        DateFormat dateFormat = new SimpleDateFormat("MM.dd.yyyy.HH.mm.ss");
        Date today = Calendar.getInstance().getTime();
        String reportDate = dateFormat.format(today);

        File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(srcFile, new File(PATH_TO_SCRENSHOT + "screenshot." + reportDate + ".png"));
        } catch (IOException e) {}

        /**
        iTestResult.getEndMillis();
        logger.error("STRANGE TEXT " + iTestResult.getTestName() + iTestResult.getTestClass());
        StringWriter sb = new StringWriter();
        PrintWriter pw = new PrintWriter(sb);
        Throwable cause = iTestResult.getThrowable();
        cause.printStackTrace(pw);
        logger.error(sb.getBuffer().toString());
        */
    }

    public void onTestSkipped(ITestResult iTestResult) {

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    public void onStart(ITestContext iTestContext) {
        logger.info("Some strange text ... ");
    }

    public void onFinish(ITestContext iTestContext) {

    }
}
