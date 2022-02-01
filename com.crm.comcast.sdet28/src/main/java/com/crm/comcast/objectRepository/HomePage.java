package com.crm.comcast.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.GenericUtility.WebDriverUtility;
/**
 * home page POM design
 * 
 * @author suchi
 *
 */

public class HomePage extends WebDriverUtility {
  //initialization of elements
	WebDriver driver;
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}
	
	//declaration and identification of elements
	@FindBy(linkText="More")
	private WebElement moreLink;
	
	@FindBy(linkText="Purchase Order")
	private WebElement purchaseOrderLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement logOutImg;
	
	 @FindBy(linkText="Sign Out")
	 private WebElement signOutLink;
	 
	 //getter methods
	public WebElement getMoreLink() {
		return moreLink;
	}

	public WebElement getPurchaseOrderLink() {
		return purchaseOrderLink;
	}

	public WebElement getLogOutImg() {
		return logOutImg;
	}

	public WebElement getSignOutLink() {
		return signOutLink;
	}
	
	//business logic
	/**
	 * this method will click on more link
	 * 
	 */
	public void clickOnmore() {
		moreLink.click();
	}
	/**
	 * this method will click on purchaseOrderLink
	 */
	public void clickOnPurchaseOrderLink() {
		purchaseOrderLink.click();
	}
	/**
	 * this method will clickon logout image
	 * 
	 */
	public void clickOnLogoutImage() {
		logOutImg.click();
	/**
	 * this method will click on signout link
	 * 	
	 */
	}
	public void clickOnSignoutLink() {
		signOutLink.click();
	}
	}
	
	
	
	

	