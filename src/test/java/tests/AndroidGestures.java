package tests;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import utils.Driver;
import utils.DriverUtils;


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

}
