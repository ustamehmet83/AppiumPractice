package tests;

import utils.Driver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class CreateDriverSessionAndroid {

    @Test
    public void test1() throws Exception {
        AppiumDriver driver=Driver.getDriver("Android");
        System.out.println("session id: = " + driver.getSessionId());

    }

    @Test
    public void test2() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 5");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.UDID, "emulator-5554");
        //capabilities.setCapability("avd","Pixel_5");
        //capabilities.setCapability("avdLaunchTimeout","180000");
        String appUrl = System.getProperty("user.dir")
                + File.separator + "src"
                + File.separator + "main"
                + File.separator + "resources"
                + File.separator + "ApiDemos-debug.apk";
        //capabilities.setCapability("appPackage","ios.appium.android.apis");
       // capabilities.setCapability("appActivity","ios.appium.android.apis.ApiDemos");
        //capabilities.setCapability("appActivity","ios.appium.android.apis.accessibility.CustomViewAccessibilityActivity");

        capabilities.setCapability(MobileCapabilityType.APP, appUrl);
        URL url = new URL("http://localhost:4723/wd/hub");
        AppiumDriver driver = new AndroidDriver(url, capabilities);
    }


}
