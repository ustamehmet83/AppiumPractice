package com.qa;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.util.HashMap;


public class BaseTest {

    protected static HashMap<String,String>strings= new HashMap<String,String>();

    public BaseTest() {
        try {
            PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver("saucelab")), this);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



}
