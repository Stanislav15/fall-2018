package com.cybertek.tests;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SleepAndImplicitWaitExample {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = Driver.getDriver();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
//        Driver.closeDriver();
    }

    @Test
    public void testSleep() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");

        driver.findElement(By.tagName("button")).click();
        Thread.sleep(10000);
        System.out.println(driver.findElement(By.id("finish")).getText());

    }



    @Test
    public void implicitWait(){
        // please wait when you are trying to find and element but cannot find it
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");
        driver.findElement(By.tagName("button")).click();

        System.out.println(driver.findElement(By.id("finish")).getText());

    }


    @Test
    public void implicitWait2(){

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        // click on remove button
        driver.findElement(By.cssSelector("form#checkbox-example>button")).click();
        // print the message
        System.out.println(driver.findElement(By.id("message")).getText());

        // click on add button
        driver.findElement(By.cssSelector("form#checkbox-example>button")).click();
        // verify checkbox is displayed
        System.out.println(driver.findElement(By.id("checkbox")).isDisplayed());

    }









}
