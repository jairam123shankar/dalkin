import pytest
from selenium import webdriver
import time

from utilities import ReadConfiguration


@pytest.fixture()
def setup_and_teardown(request):
    browser = ReadConfiguration.read_configuration("basic info", "browser")
    driver = None
    if browser.__eq__("chrome"):
        driver = webdriver.Chrome()
    elif browser.__eq__("firefox"):
        driver = webdriver.Firefox()
    elif browser.__eq__("edge"):
        driver = webdriver.Edge()
    else:
        print("provide a valid browser name")
    app_url = ReadConfiguration.read_configuration("basic info", "url")
    driver.maximize_window()
    driver.get(app_url)
    driver.implicitly_wait(7)
    driver.maximize_window()
    request.cls.driver = driver
    yield
    time.sleep(3)
    driver.close()


"""@pytest.fixture()
def setup_and_teardown(request):
    driver = webdriver.Chrome()
    driver.maximize_window()
    driver.get("https://tutorialsninja.com/demo/")
    driver.implicitly_wait(7)
    driver.maximize_window()
    request.cls.driver=driver
    yield
    time.sleep(3)
    driver.close()"""
