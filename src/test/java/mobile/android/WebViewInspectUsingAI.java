package mobile.android;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;
import mobile.utils.Driver;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;


public class WebViewInspectUsingAI {
    @Test
    public void testAndroid() throws Exception {

        AppiumDriver driver= Driver.getDriver("Android");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(AppiumBy.accessibilityId("Views")).click();


        WebElement element = driver.findElement(AppiumBy.id("android:id/list"));
        driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "direction", "up",
                "percent", 0.75

        ));
        driver.findElement(AppiumBy.accessibilityId("WebView2")).click();
        Thread.sleep(3000);
        System.out.println(driver.findElement(AppiumBy.xpath("//android.webkit.WebView/android.view.View[1]")).getText());

    }
    @Test
    public void testIOS() throws Exception {

        AppiumDriver driver= Driver.getDriver("iOS");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(AppiumBy.accessibilityId("Views")).click();

        WebElement element = driver.findElement(AppiumBy.
                iOSNsPredicateString("type == \"XCUIElementTypeTable\""));
        Map<String, Object> params = new HashMap<>();
        params.put("direction", "up");
        params.put("element", ((RemoteWebElement) element).getId());
        driver.executeScript("mobile: swipe", params);

        driver.findElement(AppiumBy.accessibilityId("Web View")).click();
        Thread.sleep(3000);
        System.out.println(driver.findElement(AppiumBy.accessibilityId("This is HTML content inside a WKWebView ."))
                .getAttribute("label"));

    }
}
