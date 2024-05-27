package com.lambdatest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.HashMap;
import java.util.Map;

public class JavaSeleniumScript {
    String username = "XXX";
    String accessKey = "XXX";
    public static RemoteWebDriver driver = null;

    public String gridURL = "@hub.lambdatest.com/wd/hub";
    public String status = "failed";

    @Before
    public void setUp() throws Exception {
        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setCapability("platformName", "Windows 10");
        browserOptions.setCapability("browserVersion", "latest");

        Map<String, Object> ltOptions = new HashMap<>();
        ltOptions.put("build", "Java_Selenium_Script");
        ltOptions.put("name", "Java_Selenium_Script");
        ltOptions.put("selenium_version", "4.15.2");
        ltOptions.put("w3c", true);
        ltOptions.put("plugin", "junit-junit");
        browserOptions.setCapability("LT:Options", ltOptions);

        try {
            driver = new RemoteWebDriver(new URL("https://" + username + ":" + accessKey + gridURL), browserOptions);
        } catch (MalformedURLException e) {
            System.out.println("Invalid grid URL");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testSimple() throws Exception {
        try {
        	// Maximize the browser window to fit the screen resolution
            driver.manage().window().maximize();

            // Open the LambdaTest playground webpage
            driver.get("https://ecommerce-playground.lambdatest.io/");
            
            // Find and click on the iPhone product link
            driver.findElement(By.xpath("//a[contains(text(), 'iPhone')]")).click();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    @After
    public void close() throws Exception {
        if (driver != null) {
            driver.executeScript("lambda-status=" + status);
            driver.quit();
        }
    }
}

