# Import the necessary packages for automating the test
from selenium import webdriver
from selenium.webdriver import EdgeOptions
from selenium.webdriver.common.by import By

# Define username, access token, and grid URL required for connecting to LambdaTest Selenium Grid
username = "harisapnanair"
accessToken = "SpZZqy1aByCFHNFOpKsau5jEFfFB9SFWYou7CXcdiQ6kvUHllV"
gridUrl = "hub.lambdatest.com/wd/hub"

# Set the desired capabilities
options = EdgeOptions()
options.browser_version = "121.0"
options.platform_name = "Windows 10"
lt_options = {};
lt_options["username"] = username;
lt_options["accessKey"] = accessToken;
lt_options["project"] = "Selenium Test Scripts";
lt_options["w3c"] = True;
lt_options["plugin"] = "python-python";
options.set_capability('LT:Options', lt_options);

# Construct the URL with username, access token, and grid URL
url = "https://"+username+":"+accessToken+"@"+gridUrl

# Initialize WebDriver with remote capabilities
driver = webdriver.Remote(command_executor= url, options=options)

# Maximize the browser window to fit the screen resolution
driver.maximize_window()

# Open the LambdaTest playground webpage
driver.get("https://ecommerce-playground.lambdatest.io/")

# Find and click on the iPhone product link
iphone = driver.find_element(By.XPATH,"//a[contains(text(), 'iPhone')]")
iphone.click() 

# Close the browser
driver.quit()

