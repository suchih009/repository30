package com.crm.comcast.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.GenericUtility.WebDriverUtility;

public class PurchaseOrderInformationPage extends WebDriverUtility {
	

	//element initialization
	public PurchaseOrderInformationPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	//declaration and identification of elements
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement purchaseOrderInfoText;

	//getter methods
	public WebElement getPurchaseOrderInfoText() {
		return purchaseOrderInfoText;
	}
	
    //business logic
	/**
	 * this method is used to get purchase order information
	 * @return
	 */
	public String getPurchaseOrderInformationText() {
		return purchaseOrderInfoText.getText();
	}
	

}