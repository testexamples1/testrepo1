package com.org.amazon.AmazonValidatewithCucumber;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class OrderPlacing extends DriverClass{
	
	WebDriver driver=getDriver("chrome");
	Actions a;
	
	@Given("^user clicks proceed to buy option$")
	public void user_clicks_proceed_to_buy_option() throws Throwable {
		driver.findElement(By.xpath("//input[@name='proceedToCheckout']")).click(); 
	}

	@When("^user enters new address where name as \"([^\"]*)\" number as \"([^\"]*)\" pincode as \"([^\"]*)\" flatno as \"([^\"]*)\" area as \"([^\"]*)\" Landmark as \"([^\"]*)\"$")
	public void user_enters_new_address_where_name_as_number_as_pincode_as_flatno_as_area_as_Landmark_as(String name, String mobnum, String pincode, String flatno, String area, String landmark) throws Throwable {
		driver.findElement(By.xpath("//div[@class='enter-address-form ']//input[@id='enterAddressFullName']")).sendKeys(name);
		driver.findElement(By.xpath("//div[@class='enter-address-form ']//input[@id='enterAddressPhoneNumber']")).sendKeys(mobnum);
		driver.findElement(By.xpath("//div[@class='enter-address-form ']//input[@id='enterAddressPostalCode']")).sendKeys(pincode);
		driver.findElement(By.xpath("//div[@class='enter-address-form ']//input[@id='enterAddressAddressLine1']")).sendKeys(flatno);
		driver.findElement(By.xpath("//div[@class='enter-address-form ']//input[@id='enterAddressAddressLine2']")).sendKeys(area);
		driver.findElement(By.xpath("//div[@class='enter-address-form ']//input[@id='enterAddressLandmark']")).sendKeys(landmark);
	}

	@Then("^select address type as \"([^\"]*)\" and click button$")
	public void select_address_type_as_and_click_button(String adtype) throws Throwable {
		WebElement we=driver.findElement(By.xpath("//div[@class='enter-address-form ']//select[@name='AddressType']"));
		Select s=new Select(we);
		we.click();
		String home="home";
		if(adtype.equalsIgnoreCase(home)){
			s.selectByValue("RES");
		}
		else{
			s.selectByValue("COM");
		}
		driver.findElement(By.xpath("//div[@class='enter-address-form ']//input[@type='submit']")).click();		
	}
	
	@Then("^select payment options and click payments$")
	public void select_payment_options_and_click_payments() throws Throwable {
		driver.findElement(By.xpath("//div[@class='a-row']//input[@value='Continue'][1]")).click();
		a=new Actions(driver);
		driver.findElement(By.xpath("//input[@value='instrumentId=NetBanking&isExpired=false&paymentMethod=NB&tfxEligible=false']")).click();
		WebElement we=driver.findElement(By.xpath("//span[@class='a-button a-button-dropdown']//span[@class='a-dropdown-prompt'][contains(text(),'Choose an Option')]"));
		a.moveToElement(we).build().perform();
		we.click();
		List<WebElement> lwe=driver.findElements(By.xpath("//ul[@id='1_dropdown_combobox']/li/a"));
		for (WebElement banks : lwe) {
			String bankname=banks.getText();
			String b="State Bank of India";
			if(bankname.equalsIgnoreCase(b)){
				banks.click();
			}
		}
		driver.findElement(By.xpath("/html[1]/body[1]/div[5]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/form[1]/div[2]/div[1]/div[1]/div[1]/span[1]")).click();
		driver.findElement(By.xpath("//span[contains(@class,'a-button a-button-primary continue-button place-order-button-link a-button-span12')]//input[@title='Place Your Order and Pay']")).click();
		Thread.sleep(10000);
		driver.quit();
		
	}

}
