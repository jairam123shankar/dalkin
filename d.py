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
driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login")
driver.switch_to.new_window('window')
driver.get("https://www.orangehrm.com/")
driver.switch_to.new_window('window')
driver.get("https://omayo.blogspot.com/")
act="omayo (QAFox.com)"
windowid=driver.window_handles
for i in windowid:
    driver.switch_to.window(i)
    exp=driver.title

    if act==exp:
        driver.find_element(By.XPATH, "// input[ @ id = 'alert2']").click()


time.sleep(4)