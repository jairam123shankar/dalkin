from selenium.webdriver.common.by import By
from selenium import webdriver


class login():

    def __init__(self,driver):
        self.driver = driver

    login1 = "//i[@class='fa fa-user']"
    login2 = "//li[@class='dropdown open']//li[2]"
    login3 = "//input[@id='input-email']"
    login4 = "//input[@id='input-password']"
    login5 = "//input[@value='Login']"
    login6= "//a[normalize-space()='Edit your account information']"
    login7="//div[@class='alert alert-danger alert-dismissible']"
    login8="//a[normalize-space()='Modify your wish list']"

    def login_line1(self):
        self.driver.find_element(By.XPATH, self.login1).click()

    def login_line2(self):
        self.driver.find_element(By.XPATH,self.login2).click()

    def login_line3(self, input):
        self.driver.find_element(By.XPATH,self.login3).send_keys(input)

    def login_line4(self, input1):
        self.driver.find_element(By.XPATH,self.login4).send_keys(input1)

    def login_line5(self):
        self.driver.find_element(By.XPATH, self.login5).click()

    def login_line6(self):
        return self.driver.find_element(By.XPATH, self.login6).is_displayed()

    def login_line7(self):
        return self.driver.find_element(By.XPATH, self.login7).is_displayed()

    def login_line8(self):
        self.driver.find_element(By.XPATH, self.login8).click()

