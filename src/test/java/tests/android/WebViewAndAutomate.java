package tests.android;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import utils.Driver;

import java.time.Duration;
import java.util.Set;

public class WebViewAndAutomate {

    public static void main(String[] args) throws Exception {
        AppiumDriver driver= Driver.getDriver("Android");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(AppiumBy.accessibilityId("Views")).click();

        WebElement element = driver.findElement(AppiumBy.id("android:id/list"));
        driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "direction", "up",
                "percent", 0.75

        ));
        driver.findElement(AppiumBy.accessibilityId("WebView")).click();
        Set<String>contextHandles= ((AndroidDriver)driver).getContextHandles();

        for (String contextHandle: contextHandles){
            System.out.println(contextHandle);
        }

        ((AndroidDriver) driver).context("WEBVIEW");
        driver.findElement(AppiumBy.cssSelector("body>h1")).getText();
        System.out.println(driver.findElement(
        AppiumBy.xpath("//*[@id=\"i_am_a_textbox\"]")).getText());

        ((AndroidDriver) driver).context("NATIVE_APP");

    }


}
