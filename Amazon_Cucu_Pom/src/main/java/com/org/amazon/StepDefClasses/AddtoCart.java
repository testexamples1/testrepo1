package com.org.amazon.StepDefClasses;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.org.amazon.Amazon_Cucu_Pom.Add_to_Cart;
import com.org.amazon.DriverClass.DriverClass;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddtoCart extends DriverClass{
	
	WebDriver driver=getDriver("chrome");
	Add_to_Cart addtocartobj;
	Actions act;
	
	@Given("^user has selected product and product window opens$")
	public void user_has_selected_product_and_product_window_opens() throws Throwable {
	   addtocartobj=new Add_to_Cart();
	   String MainWindow=driver.getWindowHandle();
	    String ChildWindow1=MainWindow;
	    String ChildWindow2=ChildWindow1;
	    for (String Handle : driver.getWindowHandles()) {
			if(!(ChildWindow1.equals(Handle))){
				ChildWindow1=Handle;
				driver.switchTo().window(ChildWindow1);
			}
		}
	   Assert.assertEquals("Apple iPhone Xs Max (512GB) - Space Grey: Amazon.in: Electronics", addtocartobj.validateProdpage());
	}

	@When("^user selects necessary specs before adding to cart$")
	public void user_selects_necessary_specs_before_adding_to_cart() throws Throwable {
		act.moveToElement(addtocartobj.getSelect_colour()).build().perform();
		addtocartobj.getSelect_colour().click();
	}
	
	@When("^user checks if product is in stock$")
	public void user_checks_if_product_is_in_stock() throws Throwable {
		String avail=addtocartobj.getAvailability().getText();
		if(!(avail.contains("Only 1 left in stock (more on the way)."))){
			System.out.println("Product not In Stock Please Try again later or Select different Product");
			Thread.sleep(5000);
			driver.quit();
		}
	}

	@Then("^user clicks add to cart$")
	public void user_clicks_add_to_cart() throws Throwable {
		String count=addtocartobj.getCart_count().getText();
		String c="0";
		if(count.equals(c)){
			addtocartobj.getAddtocart().click();
			addtocartobj.getViewcart().click();
		}
		else{
			addtocartobj.getEditcart().click();
			for (WebElement element : addtocartobj.getDeletecartitems()) {
				element.click();
			}
			driver.navigate().back();
			addtocartobj.getAddtocart().click();
			addtocartobj.getViewcart().click();
		}
	}
		
}
