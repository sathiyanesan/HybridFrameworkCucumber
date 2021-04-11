package com.qa.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public WebDriver driver;

	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

	public WebDriver init_driver(String browser) {

		/*
		 * this method is used to initialize the above thread local webdriver on the
		 * basis of the given driver
		 */
		System.out.println("browser value is : " + browser);

		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver());

		} else if (browser.equals("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver());
		}

		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();
	}

	public static synchronized WebDriver getDriver() {
		/*
		 * this method is used to Get driver with thread local
		 */
		return tlDriver.get();
	}

}
