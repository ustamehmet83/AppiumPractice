package com.qa.listeners;

import mobile.utils.Driver;
import mobile.utils.TestUtils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

public class TestListener implements ITestListener {




    public void onTestFailure(ITestResult result){

        if (result.getThrowable()!=null){
            StringWriter sw= new StringWriter();
            PrintWriter pw= new PrintWriter(sw);
            result.getThrowable().printStackTrace(pw);
            System.out.println(sw.toString());
        }
        Map<String, String> params = result.getTestContext().getCurrentXmlTest().getAllParameters();

        String imagePath = "screenshots" + File.separator + params.get("platformName")+"_"+params.get("platformVersion")
                + "_" + params.get("deviceName") + File.separator + TestUtils.dateTime() + File.separator
                + result.getTestClass().getRealClass().getSimpleName() + File.separator + result.getName() + ".png";

        String completeImagePath = System.getProperty("user.dir") + File.separator + imagePath;

        try {
        File file= Driver.getDriver("saucelab").getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File(completeImagePath));
            Reporter.log("This is sample screenshot");
            Reporter.log("<a href='"+completeImagePath+"'> <img src='"+ completeImagePath+"'height='400' width='400'/> </a>");
            System.out.println("completeImagePath = " + completeImagePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
