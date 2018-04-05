# TestVagrant hiring challenge for applicants 

#Total 3 Test cases have been scripted 1)SignInTest 2)HotelBookingTest 3)FlightBookingTest with some errors

-I have added Maven Compiler Plugin & Maven Sure Fire Plugin to pom.xml
-Create testng.xml
-Configured the Java Classes in tesng.xml

<?xml version="1.0" encoding="UTF-8"?>
    <!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
<suite name="SignInTest" verbose="1" >
  <test name="TestCases" >
    <classes>
        <class name="TestCases.SignInTest"/> 
        <class name="TestCases.HotelBookingTest"/> 
        <class name="TestCases.FlightBookingTest"/>
    </classes>
 </test>
</suite>

# 1.SignIn Test

Frame ID is not mentioned so Test cases is failing here.I have added the code to swich in to the frame

#driver.switchTo().frame("modal_window");

# 2.Hotel Booking Test

Changed few Locators
@FindBy(xpath = "//a[@title='Hotels']")
@FindBy(xpath = "//select[@id='travellersOnhome']/option")

Used #JavaScriptExecutor to click on Hotel link,Entering the city name & Clicking on Search Hotels Button

No need of selecting 1 room, 2 adults again as this option is selected by default

# 3.Flight Booking Test

Changed Locator ID:ToTag
Changed Locator //section[@id='GlobalNav']/descendant::strong to assert search results display





