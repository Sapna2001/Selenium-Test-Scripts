import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String username = "XXXX";
        String accessKey = "XXXX";
        RemoteWebDriver driver = null;
        String gridURL = "@hub.lambdatest.com/wd/hub";
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

            // Navigate to the webpage
            driver.get("https://ecommerce-playground.lambdatest.io/");

            // Find the element with the name iPhone
            WebElement iphoneLink = driver.findElement(By.xpath("//a[contains(text(), 'iPhone')]"));

            // Click on the product to visit the product page
            iphoneLink.click();
            
            // Close the browser
            driver.close();
        } catch (MalformedURLException e) {
            System.out.println("Invalid grid URL");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
