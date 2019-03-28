package com.org.amazon.Amazon_Cucu_Pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.org.amazon.DriverClass.DriverClass;

public class Product_Shopping extends DriverClass{
	
	public Product_Shopping(){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='twotabsearchtextbox']")
	private WebElement search_bar;
	@FindBy(xpath="//input[@value='Go']")
	private WebElement search_button;
	@FindBy(xpath="//h2[contains(text(),'Apple iPhone Xs Max (512GB) - Space Grey')]")
	private WebElement prod_browse;
	@FindBy(xpath="//a[@title='Apple iPhone Xs Max (512GB) - Space Grey']")
	private WebElement prod_select;
	
	public String validateTitle(){
		String title=driver.getTitle();
		return title;
	}
	
	public String getSearch_bar() {
		return search_bar.getAttribute("value");
	}
	public void setSearch_bar(String search_bar) {
		this.search_bar.sendKeys(search_bar);
	}
	public WebElement getSearch_button() {
		return search_button;
	}
	public void setSearch_button(WebElement search_button) {
		this.search_button = search_button;
	}
	public WebElement getProd_browse() {
		return prod_browse;
	}
	public void setProd_browse(WebElement prodbrowse) {
		this.prod_browse = prodbrowse;
	}
	public WebElement getProd_select() {
		return prod_select;
	}
	public void setProd_select(WebElement prodselect) {
		this.prod_select = prodselect;
	}

}
