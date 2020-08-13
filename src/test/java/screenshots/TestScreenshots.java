package screenshots;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestScreenshots {

	WebDriver driver;

	@BeforeClass
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://demo.nopcommerce.com/");
	}

	@AfterClass
	public void tearDown() {
		driver.close();
	}
	
	// This is change made by user 2

	@Test(description = "full page screenshot using selenium")
	public void test1() throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File srcScreenshot = ts.getScreenshotAs(OutputType.FILE);
		File trgScrshot = new File("fullPage.png");
		FileUtils.copyFile(srcScreenshot, trgScrshot);

	}

	@Test(description = "page section screenshot using selenium")
	public void test2() throws IOException {

		WebElement pageSection = driver.findElement(By.xpath("//div[@class='product-grid home-page-product-grid']"));
		File srcImage = pageSection.getScreenshotAs(OutputType.FILE);
		File trgSectionScrshot = new File("pageSection.png");
		FileUtils.copyFile(srcImage, trgSectionScrshot);

	}

	@Test(description = "highlight webelements")
	public void test3() throws IOException {

		WebElement pageSection = driver.findElement(By.xpath("//div[@class='product-grid home-page-product-grid']"));
		Actions act = new Actions(driver);
		act.moveToElement(pageSection).build().perform();
		highLightWebElement(driver, pageSection);
		TakesScreenshot ts = (TakesScreenshot) driver;
		File srcScreenshot = ts.getScreenshotAs(OutputType.FILE);
		File trgScrshot = new File("Highlighted.png");
		FileUtils.copyFile(srcScreenshot, trgScrshot);

	}

	void highLightWebElement(WebDriver driver, WebElement we) {

		System.out.println("hello");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='3px solid red'", we);

	}

	public void highlightElement(WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element,
				"color: yellow; border: 2px solid yellow;");

	}

}
