from selenium.webdriver.common.by import By


class Searchpage:

    def __init__(self,driver):
        self.driver = driver

    Serachbox_name="search"
    Searchbox_xpath="//span[@class='input-group-btn']"
    serachbox_link_text="HP LP3065"
    no_product="//input[@id='button-search']/following-sibling::p"

    def enter_product_in_searchbox(self,product_name):
        self.driver.find_element(By.NAME, self.Serachbox_name).click()
        self.driver.find_element(By.NAME, self.Serachbox_name).clear()
        self.driver.find_element(By.NAME, self.Serachbox_name).send_keys(product_name)

    def enter_product_xpath(self):
        self.driver.find_element(By.XPATH, self.Searchbox_xpath).click()

    def enter_linktext_element(self):
        return self.driver.find_element(By.LINK_TEXT, self.serachbox_link_text).is_displayed()

    def enter_false_product(self):
        return self.driver.find_element(By.XPATH, self.no_product).text



