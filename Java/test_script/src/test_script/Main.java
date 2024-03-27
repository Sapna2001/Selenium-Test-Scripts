package test_script;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
	public static void main(String[] args) {
		// Start the session
		WebDriver driver = new ChromeDriver();
		
		// Navigate to the webpage
		driver.get("https://ecommerce-playground.lambdatest.io/");

		// Find the element with the name iPhone
		WebElement iphoneLink = driver.findElement(By.xpath("//a[contains(text(), 'iPhone')]"));
		
		// Click on the product to visit the product page
		iphoneLink.click();
    
		// Close the session
		driver.close();
	}
}
