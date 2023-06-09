package mobile.tests;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class test1 {
    AppiumDriver driver;

    @Test
    public void invalidUsername() {
        WebElement usernameTextFlf = driver.findElement(AppiumBy.accessibilityId("test-Username"));
        usernameTextFlf.sendKeys("invalidUsername");
        WebElement passTextFld = driver.findElement(AppiumBy.accessibilityId("test-Password"));
        passTextFld.sendKeys("invalidPassword");
        WebElement loginBTn = driver.findElement(AppiumBy.accessibilityId("test-LOGIN"));
        loginBTn.click();
        WebElement invalidLgnTxt = driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-Error message\"]/android.widget.TextView"));
        String expectText = "Username and password do not match any user in this service.";
        Assert.assertEquals(expectText, (invalidLgnTxt.getText()));
    }
    @Test
    public void successfulLogin() {
        WebElement usernameTextFlf = driver.findElement(AppiumBy.accessibilityId("test-Username"));
        usernameTextFlf.sendKeys("standard_user");
        WebElement passTextFld = driver.findElement(AppiumBy.accessibilityId("test-Password"));
        passTextFld.sendKeys("secret_sauce");
        WebElement loginBTn = driver.findElement(AppiumBy.accessibilityId("test-LOGIN"));
        loginBTn.click();
        WebElement productTitle = driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-Cart drop zone\"]/android.view.ViewGroup/android.widget.TextView"));
        productTitle.isDisplayed();
        String productText="PRODUCTS";
        Assert.assertEquals(productText,productTitle.getText());
    }


    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");
        caps.setCapability("deviceName", "Pixel 5");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        caps.setCapability("appPackage", "com.swaglabsmobileapp");
        caps.setCapability("appActivity", "com.swaglabsmobileapp.SplashActivity");
        caps.setCapability("app", "C:\\Users\\mehme\\OneDrive\\Desktop\\Appium\\Android.SauceLabs.Mobile.Sample.app.2.7.1.apk");
        URL url = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver(url, caps);
        String sessionId = driver.getSessionId().toString();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @AfterClass
    public void afterClass() {
        //driver.quit();
    }

}
