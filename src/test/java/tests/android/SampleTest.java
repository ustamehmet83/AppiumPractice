package tests.android;

import utils.Driver;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;


public class SampleTest {

    @Test
    public void sampleTest() throws Exception {
        AppiumDriver driver = Driver.getDriver("Android");
        WebElement el1 = driver.findElement(AppiumBy.accessibilityId("Accessibility"));
        el1.click();
        WebElement el2 = driver.findElement(AppiumBy.accessibilityId("Accessibility Node Provider"));
        el2.click();
    }

}
