# Import the required packages
from selenium import webdriver
from selenium.webdriver.common.by import By
import time

# Initialize Chrome WebDriver
driver = webdriver.Chrome()

# Open the specified URL
driver.get("https://ecommerce-playground.lambdatest.io/")

# Find the link containing the text "iPhone" using XPath and 
iphoneLink = driver.find_element(By.XPATH,"//a[contains(text(), 'iPhone')]")

# Click on the link
iphoneLink.click()

# Wait
time.sleep(5000)

# Close the browser
driver.quit()
