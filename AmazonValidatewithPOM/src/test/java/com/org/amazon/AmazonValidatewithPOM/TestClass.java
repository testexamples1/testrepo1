package com.org.amazon.AmazonValidatewithPOM;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class TestClass extends DriverClass{
	SignIn s;
	ProductShopping ps;
	AddtoCart ac;
	OrderPlacing op;
	Actions a;
	@BeforeClass
	public static void launch(){
		driver=getDriver("chrome");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@AfterClass
	public static void close() throws InterruptedException{
		Thread.sleep(5000);
		driver.quit();
	}
	
	@Test
	    public void Signin(){
		s=new SignIn(driver);
		s.getSignin_button().click();
		s.setEmail("arunrajrat@gmail.com");
		Assert.assertEquals("arunrajrat@gmail.com", s.getEmail());
		s.getCont_button().click();
		s.setPass("arunprotein");
		Assert.assertEquals("arunprotein", s.getPass());
		s.getSubmit().click();
	}
	@Test
	public void Productshopping() throws InterruptedException{
		ps=new ProductShopping(driver);
		ps.setSearch_bar("iphone xs");
		Assert.assertEquals("iphone xs", ps.getSearch_bar());
		ps.getSearch_button().click();
		a=new Actions(driver);
		a.moveToElement(ps.getProd_browse()).build().perform();
		ps.getProd_select().click();
	}
	@Test
	public void Addtocart() throws InterruptedException{
		ac=new AddtoCart(driver);
		ac.getSelect_colour();
	    WebElement we=ac.getSelect_colour();
	    a.moveToElement(we).build().perform();
		we.click();
		String avail=ac.getAvailability().getText();
		if(!(avail.contains("Only 1 left in stock (more on the way)."))){
			System.out.println("Product not In Stock Please Try again later or Select different Product");
			Thread.sleep(2000);
		}
		String count=ac.getCart_count().getText();
		String c="0";
		if(count.equals(c)){
			ac.getAddtocart().click();
		    ac.getViewcart().click();
		    
		}
		else{
			ac.getEditcart().click();
			for (WebElement element : ac.getDeletecartitems()) {
				element.click();				
			}
			driver.navigate().back();
			ac.getAddtocart().click();
		    ac.getViewcart().click();   		
		}	
	}
	@Test
	public void Orderplacing(){
		op=new OrderPlacing(driver);
		op.getCheckoutbutton().click();
		op.setFormname("Arun");
		Assert.assertEquals("Arun", op.getFormname());
		op.setFormmobnum("9025860389");
		Assert.assertEquals("9025860389", op.getFormmobnum());
		op.setFormpincode("600001");
		Assert.assertEquals("600001", op.getFormpincode());
		op.setFormaddline1("80, 81, Broadway Rd, Mannady");
		Assert.assertEquals("80, 81, Broadway Rd, Mannady", op.getFormaddline1());
		op.setFormaddline2("George Town");
		Assert.assertEquals("George Town", op.getFormaddline2());
		op.setFormlandmark("near abc");
		Assert.assertEquals("near abc", op.getFormlandmark());
		Select s=new Select(op.getAddresstype());
		op.getAddresstype().click();
		String home="home";
		if(home=="home"){
			s.selectByValue("RES");
		}
		else{
			s.selectByValue("COM");
		}
		op.getSubmitbutton().click();
		op.getContinuebutton().click();
		op.getNetbankingopt().click();
		a=new Actions(driver);
		a.moveToElement(op.getOpt()).build().perform();
		op.getOpt().click();
		for (WebElement banks : op.getBanklist()) {
			String bankname=banks.getText();
			String b="State Bank of India";
			if(bankname.equalsIgnoreCase(b)){
				banks.click();
			}
		}
		op.getContinuebutton2().click();
		op.getPlaceorderbutton().click();
	}

}
