package sel4features;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumFourFeatures {

	@Test
	public void webElementScreenshot() throws IOException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();

		WebElement logo = driver.findElement(By.xpath("//div[@id='divLogo']/img"));
		File file = logo.getScreenshotAs(OutputType.FILE);
		File screenShotFile = new File("logo.png");
		FileUtils.copyFile(file, screenShotFile);
		driver.quit();
	}

	@Test
	public void openNewtabofBrowser() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("http://newtours.demoaut.com/");
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		// below code will switch to new tab
		driver.switchTo().window(tabs.get(1));
		// perform whatever actions you want in new tab then close it
		driver.close();
		// Switch back to your original tab
		driver.switchTo().window(tabs.get(0));
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());

	}

	@Test
	public void openNewBrowserWindow() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.switchTo().newWindow(WindowType.WINDOW);
		driver.get("http://newtours.demoaut.com/");
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		ArrayList<String> windows = new ArrayList<String>(driver.getWindowHandles());
		// below code will switch to new tab
		driver.switchTo().window(windows.get(1));
		// perform whatever actions you want in new tab then close it
		driver.close();
		// Switch back to your original tab
		driver.switchTo().window(windows.get(0));
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		driver.close();
	}
}
