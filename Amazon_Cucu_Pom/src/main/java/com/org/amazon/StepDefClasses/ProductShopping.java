package com.org.amazon.StepDefClasses;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.org.amazon.Amazon_Cucu_Pom.Product_Shopping;
import com.org.amazon.DriverClass.DriverClass;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ProductShopping extends DriverClass{
    WebDriver driver=getDriver("chrome");
    Product_Shopping prodshopobj;
    Actions act;

	@Given("^user enters product name as \"([^\"]*)\" in search text$")
	public void user_enters_product_name_as_in_search_text(String prodname) throws Throwable {
		prodshopobj=new Product_Shopping();
		prodshopobj.setSearch_bar(prodname);
		Assert.assertEquals(prodname, prodshopobj.getSearch_bar());
		prodshopobj.getSearch_button().click();
	}
	
	@When("^product search result should be displayed$")
	public void product_search_result_should_be_displayed() throws Throwable {
		Assert.assertEquals("Amazon.in: iphone xs", prodshopobj.validateTitle());
	}

	@Then("^user selects desired product$")
	public void user_selects_desired_product() throws Throwable {
		act=new Actions(driver);
		act.moveToElement(prodshopobj.getProd_browse()).build().perform();
		prodshopobj.getProd_select().click();		
	}
}
