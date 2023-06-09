package mobile.android;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;
import utils.Driver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;


public class AndroidGestures {

    /**
     * long click Android
     **/
    public static void longClickGesture(AppiumDriver driver, int x, int y, int duration) {
        driver.executeScript("mobile: longClickGesture", ImmutableMap.of(
                "x", x,
                "y", y,
                "duration", duration
        ));
    }

    public static void clickGesture(AppiumDriver driver) {
        WebElement element = driver.findElement(AppiumBy.accessibilityId("Views"));

        ((JavascriptExecutor) driver).executeScript("mobile: clickGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId()
        ));
    }

    /**
     * Drag Android
     **/
    public static void dragGesture(AppiumDriver driver) {
        WebElement element = driver.findElement
                (AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));//drag element id
        ((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "endX", 649,
                "endY", 662
        ));

    }

    /**
     * Zoom In Android
     **/
    public static void pinchOpenGesture(AppiumDriver driver) throws Exception {
        //Thread.sleep(3000);
        //driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"SKIP\"]")).click();
        Thread.sleep(5000);
        driver.executeScript("mobile: pinchOpenGesture", ImmutableMap.of(
                "left", 200,
                "top", 470,
                "width", 600,//endx-left
                "height", 600,//endy-height
                "percent", 0.75

        ));

    }

    /**
     * Swipe Up Android
     **/
    public static void swipeUpGesture(AppiumDriver driver) {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        WebElement element = driver.findElement(AppiumBy.id("android:id/list"));
        driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
                // "left", 100, "top", 100, "width", 600, "height", 600,
                "elementId", ((RemoteWebElement) element).getId(),
                "direction", "up",
                "percent", 0.75

        ));
    }

    /**
     * Swipe Left Android
     * should change clicked button
     * and element which will swipe left
     **/
    public static void swipeLeftGesture(AppiumDriver driver) {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();
        WebElement element = driver.findElement(AppiumBy.
                xpath("//*[@resource-id=\"io.appium.android.apis:id/gallery\"]/android.widget.ImageView[1]"));

        driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
//                "left", 100, "top", 100, "width", 600, "height", 600,
                "elementId", ((RemoteWebElement) element).getId(),
                "direction", "left",
                "percent", 0.75
        ));
    }

    /**
     * Scroll Android
     *
     *
     **/
    public static void scrollGesture(AppiumDriver driver) {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        WebElement element = driver.findElement(AppiumBy.id("android:id/list"));
        boolean canScrollMore=true;
        while(canScrollMore) {
            canScrollMore = (Boolean) driver.executeScript("mobile: scrollGesture", ImmutableMap.of(
                    //"left", 100, "top", 100, "width", 600, "height", 600,
                    "elementId", ((RemoteWebElement) element).getId(),
                    "direction", "down",
                    "percent", 1.0

            ));
        }

    }

    /**
     * Scroll iOS
     *
     *
     **/
    public static void swipeGesture(AppiumDriver driver) {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        WebElement element = driver.findElement(AppiumBy.id("android:id/list"));
        boolean canScrollMore=true;
        while(canScrollMore) {
            canScrollMore = (Boolean) driver.executeScript("mobile: scrollGesture", ImmutableMap.of(
                    //"left", 100, "top", 100, "width", 600, "height", 600,
                    "elementId", ((RemoteWebElement) element).getId(),
                    "direction", "down",
                    "percent", 1.0

            ));
        }

    }

    public static class CreateDriverSessionAndroid {

        @Test
        public void test1() throws Exception {
            AppiumDriver driver= Driver.getDriver("Android");
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
}
