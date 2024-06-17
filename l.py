from selenium import webdriver
import time
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.common.by import By

serv_obj = Service("C:\\Users\\kusuma\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe")
# "C:\Selenium_Libraries\chromedriver-win64\chromedriver-win64\chromedriver.exe"


driver = webdriver.Chrome(service=serv_obj)
# driver = webdriver.Chrome()
driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login")
time.sleep(5)

driver.find_element(By.NAME, "username").clear()
driver.find_element(By.NAME,"username").send_keys("Admin")
time.sleep(5)

driver.find_element(By.NAME,"password").send_keys("admin123")
time.sleep(5)

driver.find_element(By.XPATH,"//button[normalize-space()='Login']").click()

time.sleep(4)

act_title=driver.title
exp_title="jack"
if act_title==exp_title:
    print("pass")
else:
    print("fail")

driver.close()
