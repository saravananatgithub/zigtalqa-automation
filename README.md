# zigtalqa-automation

This is a maven project , can be imported in IDE like eclipse as maven project. Tests are in TestNG framework.

The env.properties can be modified to run the tests against any target env like qademo, dev or prod by changing the env property as shown below

# testenv=dev
   OR
# testenv=qademo

Also, to run the tests in chrome browser in windows, the driver exe file is zipped . This should be unzipped and path of this should be provided in env.properties as shown below
driver-path=C:/sarva/selenium/chromedriver.exe

