package mobile.tests;

import io.appium.java_client.AppiumDriver;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    protected AppiumDriver driver;

    @BeforeTest
    public void beforeTest(){
        try {

        }catch (Exception e){
            e.printStackTrace();

        }
    }




}
