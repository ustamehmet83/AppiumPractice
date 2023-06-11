package mobile.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;

import java.io.File;
import java.net.URL;
import java.time.Duration;

public class Driver {
    /**
     * Creating a private constructor, so we are closing
     * access to the object of this class from outside the class
    */
    private Driver() {
    }
    /**
     * We make web driver variable private, because we want to close access
     * from outside the class. We make it static because we will
     * use it in a static method.
    */
    private static AppiumDriver driver;

    /**
     * Create a re-usable utility method which will return same driver
     * instance when we call it
    */
    public static AppiumDriver getDriver(String platformName) throws Exception {
            if (driver == null) {
                DesiredCapabilities caps = new DesiredCapabilities();
                caps.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
                caps.setCapability("newCommandTimeout", 300);

                URL url = new URL("http://0.0.0.0:4723/wd/hub");

                switch (platformName) {
                    case "Android":
                        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 5");
                        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, ConfigurationReader.getProperty("androidAutomationName"));
                        caps.setCapability(MobileCapabilityType.UDID, "emulator-5554");

                        String appUrl = System.getProperty("user.dir")
                                + File.separator + "src"
                                + File.separator + "test"
                                + File.separator + "resources"
                                + File.separator + "ApiDemos-debug.apk";
                        caps.setCapability(MobileCapabilityType.APP, appUrl);
                        System.out.println("*** Android App ***");
                        driver = new AndroidDriver(url, caps);
                        return driver;
                    case "iOS":
                        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone X");
                        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
                        caps.setCapability(MobileCapabilityType.UDID, "77F6B8F0-8877-4EDF-8C8C-99DBE64A93FF");
                        String iOSAppUrl = System.getProperty("user.dir")
                                + File.separator + "src"
                                + File.separator + "test"
                                + File.separator + "resources"
                                + File.separator + "UIKitCatalog-iphonesimulator.app";
                        caps.setCapability("simulatorStartupTimeout", 180000);
                        caps.setCapability("bundleId", "com.example.apple-samplecode.UICatalog");
                        System.out.println("***iOS Mobile Web-Safari ***");
                        driver = new AndroidDriver(url, caps);
                        return driver;
                    case "Map":
                        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 5");
                        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, ConfigurationReader.getProperty("androidAutomationName"));
                        caps.setCapability(MobileCapabilityType.UDID, "emulator-5554");
                        String appUrl2 = System.getProperty("user.dir")
                                + File.separator + "src"
                                + File.separator + "test"
                                + File.separator + "resources"
                                + File.separator + "ApiDemos-debug.apk";
                        //caps.setCapability(MobileCapabilityType.APP, appUrl2);
                        caps.setCapability("appPackage", "com.google.android.apps.maps");
                        caps.setCapability("appActivity", "com.google.android.maps.MapsActivity");
                        System.out.println("*** Android App ***");
                        driver = new AndroidDriver(url, caps);
                        return driver;
                    case "safari":
                        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
                        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
                        caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Safari");
                        caps.setCapability(MobileCapabilityType.UDID, "94f95949f949g94859f9cv9");
                        caps.setCapability("simulatorStartupTimeout", 180000);
                        System.out.println("***iOS Mobile Web-Safari ***");
                        return new IOSDriver(url, caps);
                    case "chrome":
                        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 5");
                        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, ConfigurationReader.getProperty("androidAutomationName"));
                        caps.setCapability(MobileCapabilityType.UDID, "emulator-5554");
                        caps.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");
                        String appUrl3 = System.getProperty("user.dir")
                                + File.separator + "src"
                                + File.separator + "test"
                                + File.separator + "resources"
                                + File.separator + "ApiDemos-debug.apk";
                        caps.setCapability("app", appUrl3);
                        System.out.println("*** Chrome Browser ***");
                        driver = new AndroidDriver(url, caps);
                        return driver;
                    case "saucelab":
                        caps = new DesiredCapabilities();
                        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
                        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");
                        caps.setCapability("deviceName", "Pixel 5");
                        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, ConfigurationReader.getProperty("androidAutomationName"));
                        caps.setCapability("appPackage", ConfigurationReader.getProperty("androidAppPackage"));
                        caps.setCapability("appActivity", ConfigurationReader.getProperty("androidAppActivity"));
                        String appUrl4 = System.getProperty("user.dir")
                                + File.separator + "src"
                                + File.separator + "test"
                                + File.separator + "resources"
                                + File.separator + "Android.SauceLabs.Mobile.Sample.app.2.7.1.apk";
                        caps.setCapability("app", appUrl4);
                        url = new URL("http://0.0.0.0:4723/wd/hub");
                        driver = new AndroidDriver(url, caps);
                        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                        return driver;
                    default:
                        System.out.println("Check driver");
                        throw new Exception("Invalid platform");
                }

            }
            return driver;

    }
    @AfterTest
    public void afterTest() {
        if(driver != null){
            driver.quit();
        }
    }





}
