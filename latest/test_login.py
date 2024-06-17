import pytest
import self
from selenium import webdriver
import time
from selenium.webdriver.chrome.service import Service

from selenium.webdriver.common.by import By

from Pages.App_login import login


@pytest.mark.usefixtures("setup_and_teardown")
class Testlogin():
    def test_login_with_valid_credentials(self):
        new_login = login(self.driver)
        new_login.login_line1()
        new_login.login_line2()
        new_login.login_line3("jai123@gmail.com")
        new_login.login_line4("Candyjai@63")
        new_login.login_line5()
        assert new_login.login_line6()
        new_login.login_line8()

    def test_login_without_credentials(self):
        new_login = login(self.driver)
        new_login.login_line1()
        new_login.login_line2()
        new_login.login_line3("")
        new_login.login_line4("")
        new_login.login_line5()
        assert new_login.login_line7()



"""@pytest.mark.usefixtures("setup_and_teardown")
class Testlogin():
    def test_login_with_valid_credentials(self):
        self.driver.find_element(By.XPATH, "//i[@class='fa fa-user']").click()
        self.driver.find_element(By.XPATH, "//li[@class='dropdown open']//li[2]").click()
        self.driver.find_element(By.XPATH, "//input[@id='input-email']").send_keys("jai123@gmail.com")
        self.driver.find_element(By.XPATH, "//input[@id='input-password']").send_keys("Candyjai@63")
        self.driver.find_element(By.XPATH, "//input[@value='Login']").click()
        assert self.driver.find_element(By.XPATH, "//a[normalize-space()='Edit your account information']").is_displayed()
        self.driver.find_element(By.XPATH, "//a[normalize-space()='Modify your wish list']").click()

    def test_login_without_credentials(self):
        self.driver.find_element(By.XPATH, "//i[@class='fa fa-user']").click()
        self.driver.find_element(By.XPATH, "//li[@class='dropdown open']//li[2]").click()
        self.driver.find_element(By.XPATH, "//input[@id='input-email']").send_keys("")
        self.driver.find_element(By.XPATH, "//input[@id='input-password']").send_keys("")
        self.driver.find_element(By.XPATH, "//input[@value='Login']").click()
        assert self.driver.find_element(By.XPATH, "//div[@class='alert alert-danger alert-dismissible']").is_displayed()"""