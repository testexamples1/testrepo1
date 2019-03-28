package com.org.amazon.StepDefClasses;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import com.org.amazon.Amazon_Cucu_Pom.Sign_In;
import com.org.amazon.DriverClass.DriverClass;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SignIn extends DriverClass{
	WebDriver driver=getDriver("chrome");
	Sign_In signinobj;
	
	@Given("^User launches browser and enters URL$")
	public void user_launches_browser_and_enters_URL() throws Throwable {
		signinobj=new Sign_In();
		Assert.assertEquals("https://www.amazon.in/", signinobj.validateUrl());
	}

	@When("^User reaches homepage clicks sign in$")
	public void user_reaches_homepage_clicks_sign_in() throws Throwable {
		signinobj.getSignin_button().click();	
	}

	@When("^User enters details mobilenumber \"([^\"]*)\" and password as \"([^\"]*)\"$")
	public void user_enters_details_mobilenumber_and_password_as(String mobile, String pass) throws Throwable {
		signinobj.setEmail(mobile);
		Assert.assertEquals(mobile, signinobj.getEmail());
		signinobj.getCont_button().click();
		signinobj.setPass(pass);
		Assert.assertEquals(pass, signinobj.getPass());
	}

	@Then("^User clicks continue button$")
	public void user_clicks_continue_button() throws Throwable {
		signinobj.getSubmit().click();
	}
}



