from selenium import webdriver
import time
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.common.by import By
from selenium.webdriver import Keys
from selenium.webdriver import ActionChains
from selenium.webdriver.support.select import Select
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.support import expected_conditions


serv_obj=Service("C:\\Users\\kusuma\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe")
driver=webdriver.Chrome(service=serv_obj)
driver.implicitly_wait(10)
driver.get("https://demo.opencart.com/admin/index.php?route=common/dashboard&user_token=814242430fe75d75c40d0a121a1f3ee6")
driver.find_element(By.XPATH,"//input[@name='username']").send_keys("demo")
driver.find_element(By.XPATH, "//input[@name='password']").send_keys("demo")
driver.find_element(By.XPATH, "//button[@type='submit']").click()
time.sleep(4)
driver.find_element(By.XPATH,"//button[@class='btn-close']").click()
time.sleep(4)
'''driver.find_element(By.XPATH,"//a[normalize-space()='Sales']").click()
time.sleep(4)'''
driver.find_element(By.XPATH,"//body[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[3]/a[1]").click()
name=driver.find_elements(By.XPATH,"//tbody/tr/td[4]")
print(driver.current_url)