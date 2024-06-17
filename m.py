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
driver.get("https://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html")
driver.implicitly_wait(10)
driver.find_element(By.XPATH,"//input[@id='datepicker']").click()

year="2013"
month="June"
day="6"


while True:
    y1=driver.find_element(By.XPATH,"//span[@class='ui-datepicker-year']").text
    m1=driver.find_element(By.XPATH,"//span[@class='ui-datepicker-month']").text
    if year==y1 and month==m1:
        break
    else:
        driver.find_element(By.XPATH, "//span[@class='ui-icon ui-icon-circle-triangle-w']").click()



x=driver.find_elements(By.XPATH,"//body[1]/div[4]/table[1]/tbody[1]/tr/td//a")
for i in x:
    if i.text==day:
        i.click()






#driver.find_element(By.XPATH, "//span[@class='ui-icon ui-icon-circle-triangle-w']").click()





time.sleep(5)
