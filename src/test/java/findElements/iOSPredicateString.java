package findElements;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Driver;

public class iOSPredicateString {
    public static void main(String[] args) throws Exception {
        AppiumDriver driver = Driver.getDriver("iOS");


        WebElement myElement = driver.findElement
                (AppiumBy.iOSNsPredicateString
                ("type==\"XCUIElementTypeStaticText\" OR name==\"Activity Indicators\""));
        System.out.println("myElement = " + myElement);
        //By myElement1=AppiumBy.iOSNsPredicateString("");

        myElement = driver.findElement
                (AppiumBy.iOSNsPredicateString
                ("name CONTAINS\"Activity Indicators\""));
        System.out.println("myElement = " + myElement);


        myElement = driver.findElements
                (AppiumBy.iOSNsPredicateString
                ("name==\"Alert Views\" OR name==\"Activity Indicators\"")).get(1);
        System.out.println("myElement = " + myElement);


    }

}
