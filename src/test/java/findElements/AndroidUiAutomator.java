package findElements;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Driver;

public class AndroidUiAutomator {
    public static void main(String[] args) throws Exception {

        AppiumDriver driver= Driver.getDriver("Android");
        WebElement myElement=driver.findElement(AppiumBy.
                androidUIAutomator("new UiSelector().text(\"Accessibility\")"));
        By myElement1=AppiumBy.androidUIAutomator("new UiSelector().text(\"Accessibility\")");
        System.out.println("myElement.getText() = " + myElement.getText());

        myElement= driver.findElements(AppiumBy.
                androidUIAutomator("new UiSelector().classname(\"Accessibility\")")).get(2);
        System.out.println("myElement.getText() = " + myElement.getText());

        myElement= driver.findElement(AppiumBy.
                androidUIAutomator("new UiSelector().description(\"Accessibility\")"));
        System.out.println("myElement.getText() = " + myElement.getText());

        myElement= driver.findElements(AppiumBy.
                androidUIAutomator("new UiSelector().resourceId(\"android:id/text1\")")).get(1);
        System.out.println("myElement.getText() = " + myElement.getText());




    }
}
