package com.org.amazon.AmazonValidatewithCucumber;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddtoCart extends DriverClass{
	
	WebDriver driver=getDriver("chrome");
	Actions a;
	
	@Given("^user has selected product and product window opens$")
	public void user_has_selected_product_and_product_window_opens() throws Throwable {
	    String MainWindow=driver.getWindowHandle();
	    String ChildWindow1=MainWindow;
	    String ChildWindow2=ChildWindow1;
	    for (String Handle : driver.getWindowHandles()) {
			if(!(ChildWindow1.equals(Handle))){
				ChildWindow1=Handle;
				driver.switchTo().window(ChildWindow1);
			}
		}
	}

	@When("^user selects necessary specs before adding to cart$")
	public void user_selects_necessary_specs_before_adding_to_cart() throws Throwable {
		System.out.println("Changing my Preference of Phone Colour from Space Grey to Silver");
		a=new Actions(driver);
		WebElement colour=driver.findElement(By.xpath("//li[@title='Click to select Silver']"));
		a.moveToElement(colour).build().perform();
		colour.click();
	}
	
	@When("^user checks if product is in stock$")
	public void user_checks_if_product_is_in_stock() throws Throwable {
		String availability=driver.findElement(By.xpath("//div[@id='availability']")).getText();
		if(!(availability.contains("In stock") || availability.contains("Order it now"))){
			System.out.println("Product not In Stock Please Try again later or Select different Product");
			Thread.sleep(2000);
		}
		
	}

	@Then("^user clicks add to cart$")
	public void user_clicks_add_to_cart() throws Throwable {
		String b=driver.findElement(By.xpath("//span[@id='nav-cart-count']")).getText();
		String c="0";
		if(b.equals(c)){
			driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
		    driver.findElement(By.xpath("//a[@id='hlb-view-cart-announce']")).click();
		    
		}
		else{
			driver.findElement(By.xpath("//a[@aria-label='1 item in cart']")).click();
			for (WebElement element : driver.findElements(By.xpath("//div[@data-name='Active Items']/div/div/div//div/div/div/div/div/span/span/input[@value='Delete']"))) {
				element.click();				
			}
			driver.navigate().back();
			user_selects_necessary_specs_before_adding_to_cart();
			driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
		    driver.findElement(By.xpath("//a[@id='hlb-view-cart-announce']")).click();   		
		}	    
	}
}
