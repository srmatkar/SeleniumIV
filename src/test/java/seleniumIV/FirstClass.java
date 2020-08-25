package seleniumIV;

import static org.testng.Assert.assertEquals;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.Log;
import org.openqa.selenium.devtools.network.Network;
import org.openqa.selenium.devtools.network.model.ConnectionType;
import org.openqa.selenium.devtools.network.model.LoadingFailed;
import org.openqa.selenium.devtools.network.model.LoadingFinished;
import org.openqa.selenium.devtools.security.Security;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstClass {
	WebDriver driver;
	
	
	@BeforeClass
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver", ".//Drivers//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
	}
	

	@Test(description = "Enable Network Offline")
	public void enableWorkoffline() {
	DevTools dt = ((ChromiumDriver)driver).getDevTools();
	dt.createSession();
	dt.send(Network.enable(Optional.of(10000), Optional.empty(), Optional.empty()));
	dt.send(Network.emulateNetworkConditions(true, 100, 1000, 2000, Optional.of(ConnectionType.wifi)));
	dt.addListener(Network.loadingFailed(), loadingFailed -> assertEquals(loadingFailed.getErrorText(), "net::ERR_INTERNET_DISCONNECTED"));
	driver.get("https://www.arrkgroup.com/");
	}
	
	@Test(description = "Enable Network Online")
	public void enableWorkOnline() {
	DevTools dt = ((ChromiumDriver)driver).getDevTools();
	dt.createSession();
	dt.send(Network.enable(Optional.of(10000), Optional.empty(), Optional.empty()));
	dt.send(Network.emulateNetworkConditions(false, 100, 1000, 2000, Optional.of(ConnectionType.wifi)));
	driver.get("https://www.arrkgroup.com/");
	}
	
	@Test
	public void consolLogs() {
	//	System.setProperty("webdriver.chrome.driver", ".//Drivers//chromedriver.exe");
//		ChromeOptions co = new ChromeOptions(); 
//		co.addArguments("--silent");
//		co.addArguments("--no-sandbox");
//		driver = new ChromeDriver(co);
		DevTools devTools = ((ChromiumDriver) driver).getDevTools();
		devTools.createSession();
		devTools.send(Log.enable());
		devTools.addListener(Log.entryAdded(), entry -> System.out.println(entry.asSeleniumLogEntry()));
		driver.get("https://www.arrkgroup.com/");
	}
	
	
	@Test(description = "Opening website with NET::ERR_CERT_AUTHORITY_INVALID error")
	public void openInsecureWebsite() {
		DevTools dt = ((ChromiumDriver)driver).getDevTools();
		dt.createSession();
		dt.send(Security.setIgnoreCertificateErrors(true));
		driver.get("https://pbn.arrkgroup.co.uk/whizibleSEM");
	}

}
