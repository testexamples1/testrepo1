package policytrayproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Policytrayframe {
	
	public static WebDriver driver;
	
	public static void main(String[]args)
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vetri SR\\Downloads\\chromedriver.exe");
		driver=new ChromeDriver();
		String url="https://policytray.com";
		driver.manage().window().maximize();
		driver.get(url);
		int frames=driver.findElements(By.tagName("frame")).size();
		System.out.println(frames);   
		
	}

}
