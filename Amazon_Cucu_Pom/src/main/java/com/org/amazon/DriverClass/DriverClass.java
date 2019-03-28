package com.org.amazon.DriverClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverClass {
	protected static WebDriver driver;
	
	protected static WebDriver getDriver(String browser) {
		if(driver==null){
			if(browser=="chrome"){
				ChromeOptions option=new ChromeOptions();
				option.addArguments("--start-maximized","--ignore-certificate-errors","--disable-popup-blocking","--disable-infobars");
				System.setProperty("webdriver.chrome.driver", "C:/Users/ArunPrasath/workspace/Amazon_Cucu_Pom/src/test/chromedriver.exe");
			    driver=new ChromeDriver(option);
			}
			else if(browser=="firefox"){
				System.setProperty("webdriver.chrome.driver", "C:/Users/ArunPrasath/workspace/Amazon_Cucu_Pom/src/test/geckodriver.exe");
				driver=new FirefoxDriver();
			}
		}
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
		
	}
	

}
