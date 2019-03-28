package com.org.amazon.AmazonValidatewithPOM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddtoCart extends DriverClass{
	
	public AddtoCart(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//li[@title='Click to select Silver']//img")
	private WebElement select_colour;
	@FindBy(xpath="//div[@id='availability']")
	private WebElement availability;
	@FindBy(xpath="//span[@id='nav-cart-count']")
	private WebElement cart_count;
	@FindBy(xpath="//input[@id='add-to-cart-button']")
	private WebElement addtocart;
	@FindBy(xpath="//a[@id='hlb-view-cart-announce']")
	private WebElement viewcart;
	@FindBy(xpath="//a[@aria-label='1 item in cart']")
	private WebElement editcart;
	@FindBy(xpath="//div[@data-name='Active Items']/div/div/div//div/div/div/div/div/span/span/input[@value='Delete']")
	private List<WebElement> deletecartitems;
	
	
	public WebElement getSelect_colour() {
		return select_colour;
	}

	public WebElement setSelect_colour(WebElement select_colour) {
		return this.select_colour = select_colour;
	}
	
	public WebElement getAvailability() {
		return availability;
	}

	public void setAvailability(WebElement availability) {
		this.availability = availability;
	}

	public WebElement getCart_count() {
		return cart_count;
	}

	public void setCart_count(WebElement cart_count) {
		this.cart_count = cart_count;
	}

	public WebElement getAddtocart() {
		return addtocart;
	}

	public void setAddtocart(WebElement addtocart) {
		this.addtocart = addtocart;
	}

	public WebElement getViewcart() {
		return viewcart;
	}

	public void setViewcart(WebElement viewcart) {
		this.viewcart = viewcart;
	}

	public WebElement getEditcart() {
		return editcart;
	}

	public void setEditcart(WebElement editcart) {
		this.editcart = editcart;
	}

	public List<WebElement> getDeletecartitems() {
		return deletecartitems;
	}

	public void setDeletecartitems(List<WebElement> deletecartitems) {
		this.deletecartitems = deletecartitems;
	}
	

}
