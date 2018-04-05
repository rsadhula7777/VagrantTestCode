package TestCases;

import com.sun.javafx.PlatformUtil;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SignInTest {

	@Test
	public void shouldThrowAnErrorIfSignInDetailsAreMissing()
			throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.cleartrip.com/");

		driver.manage().window().maximize();

		waitFor(2000);

		driver.findElement(By.linkText("Your trips")).click();
		driver.findElement(By.id("SignIn")).click();

		waitFor(4000);

		driver.switchTo().frame("modal_window");

		driver.findElement(By.id("signInButton")).click();

		Thread.sleep(4000);

		String errors1 = driver.findElement(By.id("errors1")).getText();
		Assert.assertTrue(errors1
				.contains("There were errors in your submission"));

		Thread.sleep(4000);

		driver.close();
	}

	private void waitFor(int durationInMilliSeconds) {
		try {
			Thread.sleep(durationInMilliSeconds);
		} catch (InterruptedException e) {
			e.printStackTrace(); // To change body of catch statement use File |
									// Settings | File Templates.
		}
	}

	private void setDriverPath() {
		if (PlatformUtil.isMac()) {
			System.setProperty("webdriver.chrome.driver", "chromedriver");
		} else if (PlatformUtil.isWindows()) {

			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
					
		}

		else if (PlatformUtil.isLinux()) {
			System.setProperty("webdriver.chrome.driver", "chromedriver_linux");
		}

		else {

			System.out.println("No Driver mentioned");
		}

	}

}
