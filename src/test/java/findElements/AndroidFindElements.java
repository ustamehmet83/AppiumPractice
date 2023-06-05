package findElements;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import utils.Driver;

public class AndroidFindElements {

    public static void main(String[] args)throws Exception {
        AppiumDriver driver = Driver.getDriver("Android");

        WebElement myElement = driver.findElement(AppiumBy.accessibilityId("Accessibility")); //accessibility id
        System.out.println(myElement.getText());

        myElement = driver.findElements(AppiumBy.id("android:id/text1")).get(1);//resource-id
        System.out.println(myElement.getText());

        myElement = driver.findElements(AppiumBy.className("android.widget.TextView")).get(2);//class
        System.out.println(myElement.getText());

        myElement = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Accessibility\"]"));//xpath
        System.out.println(myElement.getText());

        myElement = driver.findElement(AppiumBy.xpath("//*[@text=\"Accessibility\"]"));//xpath text
        System.out.println(myElement.getText());

        //myElement = driver.findElement(AppiumBy.tagName("Accessibility")); not supported
       // System.out.println(myElement.getText());

    }
}

