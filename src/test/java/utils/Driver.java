package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.URL;

public class Driver {


    public static AppiumDriver getDriver(String platformName) throws Exception {
        DesiredCapabilities caps= new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME,platformName);
        caps.setCapability("newCommandTimeout",300);

        URL url=  new URL("http://0.0.0.0:4723/wd/hub");


        switch (platformName){
            case "Android" :
                caps.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel 5");
                caps.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
                caps.setCapability(MobileCapabilityType.UDID,"emulator-5554");
                //androidCaps.setCapability(MobileCapabilityType.PLATFORM_VERSION,"11.0");
                //androidCaps.setCapability("skipUnlock","true");
                //androidCaps.setCapability("fullReset","true");
                //androidCaps.setCapability("noReset","false");
                //androidCaps.setCapability("appPackage","false");
                //androidCaps.setCapability("appActivity","false");
                String appUrl = System.getProperty("user.dir")
                        + File.separator + "src"
                        + File.separator + "main"
                        + File.separator + "resources"
                        + File.separator + "ApiDemos-debug.apk";
                caps.setCapability(MobileCapabilityType.APP, appUrl);
                System.out.println("*** Android App ***");
                return new AndroidDriver (url,caps);
            case "iOS":
                caps.setCapability(MobileCapabilityType.DEVICE_NAME,"iPhone X");
                caps.setCapability(MobileCapabilityType.AUTOMATION_NAME,"XCUITest");
                caps.setCapability(MobileCapabilityType.UDID,"77F6B8F0-8877-4EDF-8C8C-99DBE64A93FF");
                //iOSSafariCaps.setCapability("platformName","iOS");
                //iOSSafariCaps.setCapability("browserName","Safari");
                //iOSSafariCaps.setCapability(MobileCapabilityType.PLATFORM_VERSION,"12.4");
                String iOSAppUrl = System.getProperty("user.dir")
                        + File.separator + "src"
                        + File.separator + "main"
                        + File.separator + "resources"
                        + File.separator + "UIKitCatalog-iphonesimulator.app";

                caps.setCapability("simulatorStartupTimeout",180000);
                caps.setCapability("bundleId","com.example.apple-samplecode.UICatalog");
                System.out.println("***iOS Mobile Web-Safari ***");
                return new AppiumDriver(url,caps);
            case "safari":
                caps.setCapability("platformName","iOS");
                caps.setCapability("browserName","Safari");
                caps.setCapability(MobileCapabilityType.PLATFORM_VERSION,"12.4");
                caps.setCapability(MobileCapabilityType.AUTOMATION_NAME,"XCUITest");
                caps.setCapability(MobileCapabilityType.DEVICE_NAME,"iPhone X");
                System.out.println("***iOS Mobile Web-Safari ***");
                return new IOSDriver(new URL("http://0.0.0.0:4723/wd/hub"),caps);
            case "chrome":
                System.out.println("***Android Mobile Web-ChromeApp ***");
            default :
                throw new Exception("Invalid platform");
        }

    }

}
