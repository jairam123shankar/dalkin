from selenium import webdriver
import time
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.common.by import By
from selenium.webdriver.support.select import Select
from selenium.webdriver import ActionChains
from selenium.webdriver import Keys

serv_obj=Service("C:\\Users\\kusuma\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe")
driver=webdriver.Chrome(service=serv_obj)
driver.implicitly_wait(10)
driver.get("https://tutorialsninja.com/demo/")
print(driver.title)
driver.maximize_window()









time.sleep(7)








