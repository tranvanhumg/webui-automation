package vn.amabuy.capabilities.firefox;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import net.thucydides.core.webdriver.DriverSource;

public class MyCustomeFirefoxDriver implements DriverSource {
	@Override
	public WebDriver newDriver() {

//        	profile.setPreference("browser.download.folderList", 2);
//        	profile.setPreference("browser.helperApps.alwaysAsk.force", false);
//        	profile.setPreference("browser.download.manager.showWhenStarting",false);
//        	profile.setPreference("browser.download.downloadDir","C:\Downloads");
//        	profile.setPreference("browser.download.dir","C:\Downloads");
//        	profile.setPreference("browser.download.downloadDir","C:\Downloads");
//        	profile.setPreference("browser.download.defaultFolder","C:\Downloads");

		// 1. Profile
//    		FirefoxProfile profile = new FirefoxProfile();
//    		profile.setPreference("browser.startup.homepage", "http://www.google.com");
//    		profile.setPreference("browser.privatebrowsing.autostart", true);//nac danh
//
//    		// 2. DesiredCapabilities
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
//		capabilities.setCapability(CapabilityType.TAKES_SCREENSHOT, false);
//		capabilities.setCapability(FirefoxDriver.PROFILE, profile);
//		capabilities.setJavascriptEnabled(true);
//		capabilities.setCapability("networkConnectionEnabled", false);
//		capabilities.setCapability("browserConnectionEnabled", false);
		capabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);

		// 3. FirefoxOptions
		// FirefoxOptions options = new FirefoxOptions();
		FirefoxOptions options = new FirefoxOptions(capabilities);
//    		options.addArguments("--headless");
//		options.addArguments("--width=800");
//		options.addArguments("--height=800");
		//options.addArguments("-private");// nac danh
		// options.addArguments("--incognito");
		options.addArguments("start-maximized");

		// capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options);
		// 4. Driver
		return new FirefoxDriver(options);

	}

	@Override
	public boolean takesScreenshots() {
		return true;
	}
}
