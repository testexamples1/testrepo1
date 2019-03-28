package com.org.amazon.AmazonValidatewithCucumber;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ProductShopping extends DriverClass{
    WebDriver driver=getDriver("chrome");
    WebElement we;
    Actions a;

	@Given("^user enters product name as \"([^\"]*)\" in search text$")
	public void user_enters_product_name_as_in_search_text(String prodname) throws Throwable {
	    driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys(prodname);
	    driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys(Keys.ENTER);
	}
	
	@When("^product search result should be displayed$")
	public void product_search_result_should_be_displayed() throws Throwable {
		System.out.println("To Select desired product and its sepcifications");
		a=new Actions(driver);
		we=driver.findElement(By.xpath("//h2[contains(text(),'Apple iPhone Xs Max (512GB) - Space Grey')]"));
		a.moveToElement(we).build().perform();		
		Thread.sleep(2000);			    
	}

	@Then("^user selects desired product$")
	public void user_selects_desired_product() throws Throwable {
		System.out.println("Apple iPhone Xs Max (512GB) - Space Grey");
		driver.findElement(By.xpath("//a[@title='Apple iPhone Xs Max (512GB) - Space Grey']")).click();
	}

}
