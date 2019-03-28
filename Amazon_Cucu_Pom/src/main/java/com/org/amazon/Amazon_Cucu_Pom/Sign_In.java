package com.org.amazon.Amazon_Cucu_Pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.org.amazon.DriverClass.DriverClass;

public class Sign_In extends DriverClass {
	
	public Sign_In() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[@data-nav-ref='nav_ya_signin']/span")
	private WebElement signin_button;
	@FindBy(xpath="//input[@id='ap_email']")
	private WebElement email;
	@FindBy(xpath="//input[@id='continue']")
	private WebElement cont_button;
	@FindBy(xpath="//input[@id='ap_password']")
	private WebElement pass;
	@FindBy(xpath="//input[@id='signInSubmit']")
	private WebElement submit;
	
	
	public String validateUrl(){
		String s=driver.getCurrentUrl();
		return s;
	}
	
	public WebElement getSignin_button() {
		return signin_button;
	}
	public void setSignin_button(WebElement signin_button) {
		this.signin_button = signin_button;
	}
	public String getEmail() {
		return email.getAttribute("value");
	}
	public void setEmail(String email) {
		this.email.sendKeys(email);
	}
	public WebElement getCont_button() {
		return cont_button;
	}
	public void setCont_button(WebElement cont_button) {
		this.cont_button = cont_button;
	}
	public String getPass() {
		return pass.getAttribute("value");
	}
	public void setPass(String pass) {
		this.pass.sendKeys(pass);
	}
	public WebElement getSubmit() {
		return submit;
	}
	public void setSubmit(WebElement submit) {
		this.submit = submit;
	}
	
}
