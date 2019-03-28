package day7;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Redbus {

	public static WebDriver driver;
	
	
	public void findElements(String Source,String Values)
	{
		List<WebElement> WebElem=driver.findElements(By.xpath(Source));
		
		for(WebElement text:WebElem)
		{
			
			System.out.println(text.getText());
			
			if(text.getText().equals(Values))
			{
				text.click();
				break;
				
			}
			
		}
		
	}
	
	public static void main(String[] args)throws InterruptedException 
	{
		Redbus redbus=new Redbus();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Vetri SR\\Downloads\\chromedriver.exe");
		
	    driver=new ChromeDriver(options);
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS );
		
		//driver.findElement(By.id("src")).sendKeys("chen");
		
		//driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS );
		
		/*String elementlist = null;
		
		List<WebElement> element=driver.findElements(By.xpath(elementlist));
		for(WebElement text:element)
		{
			System.out.println(text.getText());
			String value = null;
			if(text.getText().equals(value))
			{
				text.click();
				break;
				
			}
		}*/
		
		driver.findElement(By.xpath("//input[@id='src']")).sendKeys("chen");
		String sourceDropdown="//input[@id='src']/parent::div/ul/li";
	     redbus.findElements(sourceDropdown,"Tambaram, Chennai");
	     
	     
	     
	     
	     
	     
//driver.close();
}


	
}