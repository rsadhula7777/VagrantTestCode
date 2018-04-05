package TestCases;

import java.util.List;

import com.sun.javafx.PlatformUtil;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class HotelBookingTest {

   // WebDriver driver = new ChromeDriver();

    @FindBy(xpath = "//a[@title='Hotels']")
    private WebElement hotelLink;

    @FindBy(id = "Tags")
    private WebElement localityTextBox;

    @FindBy(id = "SearchHotelsButton")
    private WebElement searchButton;

    @FindBy(xpath = "//select[@id='travellersOnhome']/option")
    private WebElement travellerSelection;

    @Test
    public void shouldBeAbleToSearchForHotels() throws InterruptedException {
        //setDriverPath();
    	
    	System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
        driver.get("https://www.cleartrip.com/");
        
    	driver.manage().window().maximize();
        
        WebElement element = driver.findElement(By.xpath("//a[@title='Hotels']"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
        
        
        WebElement wb = driver.findElement(By.id("Tags"));
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].value='Indiranagar, Bangalore';", wb);
        jse.executeScript("document.getElementById('Tags').value='Indiranagar, Bangalore';");
        
        
       

       // new Select(travellerSelection).selectByVisibleText("1 room, 2 adults");
        Thread.sleep(10000);
       
        
        WebElement element1 = driver.findElement(By.id("SearchHotelsButton"));
        JavascriptExecutor executor1 = (JavascriptExecutor)driver;
        executor1.executeScript("arguments[0].click();", element1);
      
        //searchButton.click();
        
        Thread.sleep(5000);

        driver.quit();

    }

    private void setDriverPath() {
        if (PlatformUtil.isMac()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver");
        }
        if (PlatformUtil.isWindows()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        }
        if (PlatformUtil.isLinux()) {
            System.setProperty("webdriver.chrome.driver", "chromedriver_linux");
        }
    }

}
