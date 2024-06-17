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
driver.maximize_window()
act="Human Resources Management Software | OrangeHRM"
driver.find_element(By.XPATH,"//a[normalize-space()='OrangeHRM, Inc']").click()
windowid=driver.window_handles
a=windowid[0]
b=windowid[1]
driver.switch_to.new_window(b)
driver.find_element(By.XPATH,"//input[@id='Form_submitForm_EmailHomePage']").send_keys("gemini")
act=ActionChains(driver)
act.send_keys(Keys.ENTER).perform()


'''for i in windowid:
    driver.switch_to.window(i)
    exp=driver.title
    print(exp)
    if act==exp:
        driver.switch_to.window(i)
        driver.find_element(By.XPATH,"//input[@id='Form_submitForm_EmailHomePage']").send_keys("gemini")
        act=ActionChains(driver)
        act.send_keys(Keys.ENTER).perform()'''




#Human Resources Management Software | OrangeHRM
time.sleep(4)
