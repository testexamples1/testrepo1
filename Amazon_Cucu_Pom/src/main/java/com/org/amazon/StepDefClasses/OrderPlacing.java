package com.org.amazon.StepDefClasses;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.org.amazon.Amazon_Cucu_Pom.Order_Placing;
import com.org.amazon.DriverClass.DriverClass;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class OrderPlacing extends DriverClass{
	
	WebDriver driver=getDriver("chrome");
	Order_Placing orplacingobj;
	Actions act;
	
	@Given("^user clicks proceed to buy option$")
	public void user_clicks_proceed_to_buy_option() throws Throwable {
		orplacingobj=new Order_Placing();
		Assert.assertEquals("Select a delivery address", orplacingobj.ValidateOrderpage());
		orplacingobj.getCheckoutbutton().click();
	}

	@When("^user enters new address where name as \"([^\"]*)\" number as \"([^\"]*)\" pincode as \"([^\"]*)\" flatno as \"([^\"]*)\" area as \"([^\"]*)\" Landmark as \"([^\"]*)\"$")
	public void user_enters_new_address_where_name_as_number_as_pincode_as_flatno_as_area_as_Landmark_as(String name, String mobnum, String pincode, String flatno, String area, String landmark) throws Throwable {
		orplacingobj.setFormname(name);
		Assert.assertEquals(name, orplacingobj.getFormname());
		orplacingobj.setFormmobnum(mobnum);
		Assert.assertEquals(mobnum, orplacingobj.getFormmobnum());
		orplacingobj.setFormpincode(pincode);
		Assert.assertEquals(pincode, orplacingobj.getFormpincode());
		orplacingobj.setFormaddline1(flatno);
		Assert.assertEquals(flatno, orplacingobj.getFormaddline1());
		orplacingobj.setFormaddline2(area);
		Assert.assertEquals(area, orplacingobj.getFormaddline2());
		orplacingobj.setFormlandmark(landmark);
		Assert.assertEquals(landmark, orplacingobj.getFormlandmark());
	}

	@Then("^select address type as \"([^\"]*)\" and click button$")
	public void select_address_type_as_and_click_button(String adtype) throws Throwable {
		Select s=new Select(orplacingobj.getAddresstype());
		orplacingobj.getAddresstype().click();
		String home="home";
		if(home=="home"){
			s.selectByValue("RES");
		}
		else{
			s.selectByValue("COM");
		}
		orplacingobj.getSubmitbutton().click();
		orplacingobj.getContinuebutton().click();
	}	
	
	@Then("^select payment options and click payments$")
	public void select_payment_options_and_click_payments() throws Throwable {
		orplacingobj.getNetbankingopt().click();
		act=new Actions(driver);
		act.moveToElement(orplacingobj.getOpt()).build().perform();
		orplacingobj.getOpt().click();
		for (WebElement banks : orplacingobj.getBanklist()) {
			String bankname=banks.getText();
			String b="State Bank of India";
			if(bankname.equalsIgnoreCase(b)){
				banks.click();
			}
		}
		orplacingobj.getContinuebutton2().click();
		orplacingobj.getPlaceorderbutton().click();
		Thread.sleep(5000);
		driver.quit();
	}

}
