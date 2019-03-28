package day5;

import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Windowhandles {
	
	public static WebDriver driver;
	
	public static void main(String[] args)throws NoSuchElementException
	{
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vetri SR\\Downloads\\chromedriver.exe");
		driver=new ChromeDriver();
		String url="https://www.toolsqa.com/selenium-webdriver/switch-commands/";
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		String parentwindow=driver.getWindowHandle();
		System.out.println("HANDLE+"+parentwindow);
		//driver.findElement(By.linkText("Facebook")).click();
		
		Set<String> childwindow=driver.getWindowHandles();
		System.out.println("Handles="+childwindow);
		
		for(String handle1:childwindow)
		{
		driver.switchTo().window(handle1);
			driver.findElement(By.linkText("Facebook")).click();
			System.out.println("Handle1="+handle1);
			
			
		}
		
		driver.close();
		
		driver.switchTo().window(parentwindow);
		
		
		driver.close();
		
		
	}

}
