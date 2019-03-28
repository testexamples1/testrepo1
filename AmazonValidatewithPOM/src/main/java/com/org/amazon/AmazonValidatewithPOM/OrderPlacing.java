package com.org.amazon.AmazonValidatewithPOM;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPlacing extends DriverClass{
	public OrderPlacing(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='proceedToCheckout']")
	private WebElement checkoutbutton;
	@FindBy(xpath="//div[@class='enter-address-form ']//input[@id='enterAddressFullName']")
	private WebElement formname;
	@FindBy(xpath="//div[@class='enter-address-form ']//input[@id='enterAddressPhoneNumber']")
	private WebElement formmobnum;
	@FindBy(xpath="//div[@class='enter-address-form ']//input[@id='enterAddressPostalCode']")
	private WebElement formpincode;
	@FindBy(xpath="//div[@class='enter-address-form ']//input[@id='enterAddressAddressLine1']")
	private WebElement formaddline1;
	@FindBy(xpath="//div[@class='enter-address-form ']//input[@id='enterAddressAddressLine2']")
	private WebElement formaddline2;
	@FindBy(xpath="//div[@class='enter-address-form ']//input[@id='enterAddressLandmark']")
	private WebElement formlandmark;
	@FindBy(xpath="//div[@class='enter-address-form ']//select[@name='AddressType']")
	private WebElement addresstype;
	@FindBy(xpath="//div[@class='enter-address-form ']//input[@type='submit']")
	private WebElement submitbutton;
	@FindBy(xpath="//div[@class='a-row']//input[@value='Continue'][1]")
	private WebElement continuebutton;
	@FindBy(xpath="//input[@value='instrumentId=NetBanking&isExpired=false&paymentMethod=NB&tfxEligible=false']")
	private WebElement netbankingopt;
	@FindBy(xpath="//span[@class='a-button a-button-dropdown']//span[@class='a-dropdown-prompt'][contains(text(),'Choose an Option')]")
	private WebElement opt;
	@FindBy(xpath="//ul[@id='1_dropdown_combobox']/li/a")
	private List<WebElement> banklist;
	@FindBy(xpath="/html[1]/body[1]/div[5]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/form[1]/div[2]/div[1]/div[1]/div[1]/span[1]")
	private WebElement continuebutton2;
	@FindBy(xpath="//span[contains(@class,'a-button a-button-primary continue-button place-order-button-link a-button-span12')]//input[@title='Place Your Order and Pay']")
	private WebElement placeorderbutton;
	
	public WebElement getCheckoutbutton() {
		return checkoutbutton;
	}
	public void setCheckoutbutton(WebElement checkoutbutton) {
		this.checkoutbutton = checkoutbutton;
	}
	public String getFormname() {
		return formname.getAttribute("value");
	}
	public void setFormname(String formname) {
		this.formname.sendKeys(formname);
	}
	public String getFormmobnum() {
		return formmobnum.getAttribute("value");
	}
	public void setFormmobnum(String formmobnum) {
		this.formmobnum.sendKeys(formmobnum);
	}
	public String getFormpincode() {
		return formpincode.getAttribute("value");
	}
	public void setFormpincode(String formpincode) {
		this.formpincode.sendKeys(formpincode);
	}
	public String getFormaddline1() {
		return formaddline1.getAttribute("value");
	}
	public void setFormaddline1(String formaddline1) {
		this.formaddline1.sendKeys(formaddline1);
	}
	public String getFormaddline2() {
		return formaddline2.getAttribute("value");
	}
	public void setFormaddline2(String formaddline2) {
		this.formaddline2.sendKeys(formaddline2);
	}
	public String getFormlandmark() {
		return formlandmark.getAttribute("value");
	}
	public void setFormlandmark(String formlandmark) {
		this.formlandmark.sendKeys(formlandmark);
	}
	public WebElement getAddresstype() {
		return addresstype;
	}
	public void setAddresstype(WebElement addresstype) {
		this.addresstype = addresstype;
	}
	public WebElement getSubmitbutton() {
		return submitbutton;
	}
	public void setSubmitbutton(WebElement submitbutton) {
		this.submitbutton = submitbutton;
	}
	public WebElement getContinuebutton() {
		return continuebutton;
	}
	public void setContinuebutton(WebElement continuebutton) {
		this.continuebutton = continuebutton;
	}
	public WebElement getNetbankingopt() {
		return netbankingopt;
	}
	public void setNetbankingopt(WebElement netbankingopt) {
		this.netbankingopt = netbankingopt;
	}
	public WebElement getOpt() {
		return opt;
	}
	public void setOpt(WebElement opt) {
		this.opt = opt;
	}
	public List<WebElement> getBanklist() {
		return banklist;
	}
	public void setBanklist(List<WebElement> banklist) {
		this.banklist = banklist;
	}
	public WebElement getContinuebutton2() {
		return continuebutton2;
	}
	public void setContinuebutton2(WebElement continuebutton2) {
		this.continuebutton2 = continuebutton2;
	}
	public WebElement getPlaceorderbutton() {
		return placeorderbutton;
	}
	public void setPlaceorderbutton(WebElement placeorderbutton) {
		this.placeorderbutton = placeorderbutton;
	}

}
