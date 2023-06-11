package mobile.findElements;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import mobile.utils.Driver;

public class DifferentWaysOfDefiningElements {

    public DifferentWaysOfDefiningElements(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @FindBy(xpath = "//*[@text=\"Accessibility\"]")
    private WebElement myElement4;

    public static void main(String[] args) throws Exception {

        AppiumDriver driver= Driver.getDriver("Android");


        DifferentWaysOfDefiningElements differentWaysOfDefiningElements= new DifferentWaysOfDefiningElements(driver);
        System.out.println("myElement4.getText() = " + differentWaysOfDefiningElements.myElement4.getText());

        By myElement2=By.xpath("//*[@text=\"Accessibility\"]");
        System.out.println(driver.findElement(myElement2).getText());

        By myElement3=AppiumBy.accessibilityId("Accessibility");
        System.out.println(driver.findElement(myElement3).getText());

        WebElement myElement=driver.findElement(AppiumBy.accessibilityId("Accessibility"));
        System.out.println(myElement.getText());

        driver.findElement(myElement2).click();

    }
}
