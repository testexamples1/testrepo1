package day5;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class simplepopuphandels {

	public static WebDriver  driver;
	public static void main(String[] args) {
		
	
		
System.setProperty("webdriver.chrome.driver","E:\\Software\\chromedriver.exe");
	    
	    driver=new ChromeDriver();
		driver.manage().window().maximize();
	
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_alert");
	    //driver.switchTo().frame(iframeresult);


	}

}
