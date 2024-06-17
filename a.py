from selenium import webdriver
import time
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.common.by import By
from selenium.webdriver.support.select import Select

serv_obj = Service("C:\\Users\\kusuma\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe")
# "C:\Selenium_Libraries\chromedriver-win64\chromedriver-win64\chromedriver.exe"


driver = webdriver.Chrome(service=serv_obj)
driver.implicitly_wait(10)
driver.get("https://omayo.blogspot.com/")
driver.maximize_window()
drop=Select(driver.find_element(By.XPATH,"//select[@id='drop1']"))
drop.select_by_visible_text("doc 4")



'''driver.get("https://selenium143.blogspot.com/")
driver.maximize_window()
driver.back()
driver.forward()'''

#t1=driver.find_elements(By.XPATH,"//button[@name='samename']")
#driver.find_element(By.XPATH,"//input[@value='blue' or @id='checkbox2']").click()
#driver.find_element(By.XPATH,"//input[@value='orange' or @id='checkbox1']").click()



time.sleep(5)

""""
driver.save_screenshot("photo.png")
driver.get_screenshot_as_file("new.png")
"""
