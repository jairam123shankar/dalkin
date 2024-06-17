
from allure_commons.types import AttachmentType
from selenium import webdriver
import time
from selenium.webdriver.common.by import By
import pytest

from Pages.Searchpage import Searchpage


@pytest.mark.usefixtures("setup_and_teardown")
class Testsearch():
    def test_search_for_valid_product(self):
        Serach_page = Searchpage(self.driver)
        Serach_page.enter_product_in_searchbox("hp")
        Serach_page.enter_product_xpath()
        assert Serach_page.enter_linktext_element()

    def test_search_for_invalid_product(self):
        Serach_page = Searchpage(self.driver)
        Serach_page.enter_product_in_searchbox("bikes")
        Serach_page.enter_product_xpath()
        expected_text = "There is no product that matches the search criteria."
        assert Serach_page.enter_false_product().__eq__(expected_text)


    def test_search_without_giving_input(self):
        Serach_page = Searchpage(self.driver)
        Serach_page.enter_product_in_searchbox("")
        Serach_page.enter_product_xpath()
        expected_text = "There is no product that matches the search criteria."
        assert Serach_page.enter_false_product().__eq__(expected_text)



"""@pytest.mark.usefixtures("setup_and_teardown")
class Testsearch():
    def test_search_for_valid_product(self):
        self.driver.find_element(By.NAME, "search").send_keys("hp")
        self.driver.find_element(By.XPATH, "//span[@class='input-group-btn']").click()
        assert self.driver.find_element(By.LINK_TEXT, "HP LP3065").is_displayed()

    def test_search_for_invalid_product(self):
        self.driver.find_element(By.NAME, "search").send_keys("bikes")
        self.driver.find_element(By.XPATH, "//span[@class='input-group-btn']").click()
        expected_text = "There is no product that matches the search criteria."
        assert self.driver.find_element(By.XPATH, "//input[@id='button-search']/following-sibling::p").text.__eq__(
            expected_text)

    def test_search_without_giving_input(self):
        self.driver.find_element(By.XPATH, "//input[@name='search']").send_keys("")
        self.driver.find_element(By.XPATH, "//span[@class='input-group-btn']").click()
        expected_text = "There is no product that matches the search criteria."
        assert self.driver.find_element(By.XPATH, "//input[@id='button-search']/following-sibling::p").text.__eq__(
            expected_text)"""