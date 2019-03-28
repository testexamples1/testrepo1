package day5;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Framehandl {

	public static WebDriver driver;
	
	public static void main(String[] args)throws NoSuchElementException, InterruptedException
	{
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vetri SR\\Downloads\\chromedriver.exe");
		
		driver=new ChromeDriver();
		driver.get("https://www.toolsqa.com/selenium-webdriver/switch-commands/");
		driver.manage().window().maximize(); 
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		int size=driver.findElements(By.tagName("frame")).size();
		for(int i=0;i<=size;i++)
		{
			driver.switchTo().frame(i);
			System.out.println(i);
			//WebElement framefooter1=driver.findElement(By.);
			//framefooter1.click();
		}
	driver.close();
	}
	

}
