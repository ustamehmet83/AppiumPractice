package com.qa.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import io.appium.java_client.screenrecording.CanRecordScreen;
import mobile.utils.TestUtils;
import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.support.PageFactory;
import mobile.utils.Driver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


public class BasePage {
    protected static ThreadLocal <AppiumDriver> driver = new ThreadLocal<AppiumDriver>();
    protected static ThreadLocal <Properties> props = new ThreadLocal<Properties>();
    protected static ThreadLocal <HashMap<String, String>> strings = new ThreadLocal<HashMap<String, String>>();
    protected static ThreadLocal <String> platform = new ThreadLocal<String>();
    protected static ThreadLocal <String> dateTime = new ThreadLocal<String>();
    protected static ThreadLocal <String> deviceName = new ThreadLocal<String>();
    TestUtils utils = new TestUtils();

    public AppiumDriver getDriver() {
        return driver.get();
    }

    public void setDriver(AppiumDriver driver2) {
        driver.set(driver2);
    }

    public Properties getProps() {
        return props.get();
    }

    public void setProps(Properties props2) {
        props.set(props2);
    }

    public HashMap<String, String> getStrings() {
        return strings.get();
    }

    public void setStrings(HashMap<String, String> strings2) {
        strings.set(strings2);
    }

    public String getPlatform() {
        return platform.get();
    }

    public void setPlatform(String platform2) {
        platform.set(platform2);
    }

    public BasePage() {
        try {
            PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver("saucelab")), this);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @BeforeMethod
    public void beforeMethod() throws Exception {
        ((CanRecordScreen)Driver.getDriver("saucelab")).startRecordingScreen();
    }
    @AfterMethod
    public void afterMethod(ITestResult result) throws Exception {
        String media=((CanRecordScreen)Driver.getDriver("saucelab")).stopRecordingScreen();
        Map<String,String> params=result.getTestContext().getCurrentXmlTest().getAllParameters();
        String dir="videos"+ File.separator+params.get("platformName")+"_"+params.get("platformVersion")+"_"
                +params.get("deviceName")+ File.separator+ TestUtils.dateTime()
                 +File.separator+result.getTestClass().getRealClass().getSimpleName();
        File videoDir= new File(dir);
        if (!videoDir.exists()){
            videoDir.mkdirs();
        }
        FileOutputStream stream = null;
        stream = new FileOutputStream(videoDir + File.separator + result.getName() + ".mp4");
        stream.write(Base64.decodeBase64(media));
    }

}
