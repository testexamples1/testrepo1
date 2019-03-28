package com.org.amazon.AmazonValidatewithCucumber;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SignIn extends DriverClass{
	WebDriver driver=getDriver("chrome");
	Actions a;
	
	@Given("^User launches browser and enters URL$")
	public void user_launches_browser_and_enters_URL() throws Throwable {
		driver.get("https://www.amazon.in/");	    
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);    
	}

	@When("^User reaches homepage clicks sign in$")
	public void user_reaches_homepage_clicks_sign_in() throws Throwable {
		WebElement d=driver.findElement(By.xpath("//a[@data-nav-ref='nav_ya_signin']/span"));
		d.click();	    
	}

	@When("^User enters details mobilenumber \"([^\"]*)\" and password as \"([^\"]*)\"$")
	public void user_enters_details_mobilenumber_and_password_as(String mobile, String pass) throws Throwable {
		driver.findElement(By.xpath("//input[@id='ap_email']")).sendKeys(mobile);
		driver.findElement(By.xpath("//input[@id='continue']")).click();
		driver.findElement(By.xpath("//input[@id='ap_password']")).sendKeys(pass);
	}

	@Then("^User clicks continue button$")
	public void user_clicks_continue_button() throws Throwable {
		driver.findElement(By.xpath("//input[@name='rememberMe']")).click();
		driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();
	    System.out.println("Sign In Complete");
	}
}



