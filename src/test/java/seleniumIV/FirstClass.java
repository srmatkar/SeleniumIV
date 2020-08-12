package seleniumIV;

import java.util.Optional;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.devtools.Command;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.Log;
import org.openqa.selenium.devtools.network.Network;
import org.testng.annotations.Test;


import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstClass{
	WebDriver driver;

	/*
	 * @Test public void enableWorkoffline() {
	 * WebDriverManager.chromedriver().setup();
	 * //System.setProperty("webdriver.chrome.driver",
	 * ".//Drivers//chromedriver.exe"); driver = new ChromeDriver(); DevTools
	 * devTools = ((ChromiumDriver) driver).getDevTools(); devTools.createSession();
	 * // devTools.send(enable(Optional.empty(), Optional.empty(),
	 * Optional.empty())); }
	 * 
	 * @Test public void consolLogs() {
	 * System.setProperty("webdriver.chrome.driver",
	 * ".//Drivers//chromedriver.exe"); ChromeOptions co = new ChromeOptions(); //
	 * co.addArguments("--silent"); co.addArguments("--no-sandbox"); driver = new
	 * ChromeDriver(co); DevTools devTools = ((ChromeDriver)driver).getDevTools();
	 * 
	 * devTools.createSession();
	 * devTools.send(org.openqa.selenium.devtools.Log.enable());
	 * devTools.addListener(Log.entryAdded(), entry ->
	 * System.out.println(entry.asSeleniumLogEntry()));
	 * driver.get("https://www.arrkgroup.com/"); }
	 */
}
