package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class CreateDriverSessionIOS {


    public static void main(String[] args) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 11");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
        caps.setCapability(MobileCapabilityType.UDID, "77F6B8F0-8877-4EDF-8C8C-99DBE64A93FF");
        String appUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main"
                + File.separator + "resources" + File.separator + "UIKitCatalog-iphonesimulator.app";
        //caps.setCapability(MobileCapabilityType.APP, appUrl);
        caps.setCapability("simulatorStartUpTimeout",180000);
        caps.setCapability("bundleId","com.example.apple-samplecode.UICatalog");

        URL url = new URL("http://localhost:4723/wd/hub");

        AppiumDriver driver = new IOSDriver(url, caps);
    }



}
