package com.crm.comcast.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//element initialization
public class PurchaseOrderPage {
	public PurchaseOrderPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//img[@title='Create Purchase Order...']")
	private WebElement createPurchaseOrderPlusImage;

	//getter methods
	public WebElement getCreatePurchaseOrderPlusImage() {
		return createPurchaseOrderPlusImage;
	}
	
	//business logic
	/**
	 * this method will click on createOrg PlusImage
	 */
	public void clickCreatePurchaseOrderPlusImage() {
		createPurchaseOrderPlusImage.click();
		
	}
	
	
	

}
