package mobile.iOS;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import mobile.utils.Driver;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class iOSInteractsWithApps {

    public static void main(String[] args) throws Exception {
        AppiumDriver driver = Driver.getDriver("iOS");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        By activityIndicators = AppiumBy.accessibilityId("Activity Indicators");
        driver.findElement(activityIndicators).click();

        Thread.sleep(5000);

        Map<String, Object> params = new HashMap<>();
        params.put("bundleId", "com.example.apple-samplecode.UICatalog");
        final boolean isInstalled = (Boolean)driver.executeScript("mobile: isAppInstalled", params);
        System.out.println(isInstalled);


        //      System.out.println(driver.queryAppState("com.example.apple-samplecode.UICatalog"));
        //     Thread.sleep(5000);
        //      driver.terminateApp("com.example.apple-samplecode.UICatalog");
        //      Thread.sleep(5000);
        //      System.out.println(driver.queryAppState("com.example.apple-samplecode.UICatalog"));
        //      Thread.sleep(5000);
        String iOSAppUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main"
                + File.separator + "resources" + File.separator + "UIKitCatalog-iphonesimulator.app";
        //      driver.installApp(iOSAppUrl);
        //      driver.runAppInBackground(Duration.ofMillis(5000));
        //      driver.activateApp("com.apple.Preferences");
        //      Thread.sleep(5000);
        //      driver.activateApp("com.example.apple-samplecode.UICatalog");

    }
}
