package com.crm.comcast.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.GenericUtility.WebDriverUtility;
/**
 * createOrganization POM design
 * @author suchi
 *
 */

public class CreatePurchaseOrderPage extends WebDriverUtility {
	WebDriverUtility wUtil = new WebDriverUtility();
	WebDriver driver;
	//element initialization
	public CreatePurchaseOrderPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	//element identification or declaration
	@FindBy(name="subject")
	private WebElement purchaseSubjectTextField;

	@FindBy(xpath="//img[@title='Select']")
	private WebElement selectVendorName;

	@FindBy(name="search_text")
	private WebElement searchTextField;

	@FindBy(name="search")
	private WebElement searchNowVendorButton;

	@FindBy(linkText="HP")
	private WebElement clickOnHPLink; 

	@FindBy(name="postatus")
	private WebElement selectStatusDropDownList;

	@FindBy(name="assigned_group_id")
	private WebElement selectAssignedToDropDownList;

	@FindBy(xpath="//input[@value='U']")
	private WebElement userRadioButton;

	@FindBy(xpath="//input[@value='T']")
	private WebElement groupRadioButton;

	@FindBy(name="assigned_group_id")
	private WebElement assignedToMarketingGroup;

	@FindBy(name="bill_street")
	private WebElement billingAddressTextField;

	@FindBy(name="ship_street")
	private WebElement shippingAddressTextFeild;

	@FindBy(xpath="//img[@title='Products']")
	private WebElement addProductName;

	@FindBy(id="search_txt")
	private WebElement searchProductTextField ;

	@FindBy(name="search")
	private WebElement searchNowProductButton;

	@FindBy(linkText="Laptops")
	private WebElement clickOnLaptopsLink;

	@FindBy(id="qty1")
	private WebElement qtyTextField;

	//@FindBy(xpath="(//input[@title='Save [Alt+S]'])[2]")
	//@FindBy(xpath="//input[@type='submit']")
	@FindBy(name="button")
	private WebElement saveButton;

	//getter methods
	public WebElement getPurchaseSubjectTextField() {
		return purchaseSubjectTextField;
	}

	public WebElement getSelectVendorName() {
		return selectVendorName;
	}

	public WebElement getSearchTextField() {
		return searchTextField;
	}

	public WebElement getSearchNowVendorButton() {
		return searchNowVendorButton;
	}

	public WebElement getClickOnHPLink() {
		return clickOnHPLink;
	}

	public WebElement getSelectStatusDropDownList() {
		return selectStatusDropDownList;
	}

	public WebElement getSelectAssignedToDropDownList() {
		return selectAssignedToDropDownList;
	}

	public WebElement getUserRadioButton() {
		return userRadioButton;
	}

	public WebElement getGroupRadioButton() {
		return groupRadioButton;
	}
	

	/**public WebElement getSupportGroupDropDown() {
		return supportGroupDropDown;
	}
	*/

	public WebElement getBillingAddressTextField() {
		return billingAddressTextField;
	}

	public WebElement getShippingAddressTextFeild() {
		return shippingAddressTextFeild;
	}

	public WebElement getAddProductName() {
		return addProductName;
	}

	public WebElement getSearchProductTextField() {
		return searchProductTextField;
	}

	public WebElement getSearchNowProductButton() {
		return searchNowProductButton;
	}

	public WebElement getClickOnLaptopsLink() {
		return clickOnLaptopsLink;
	}

	public WebElement getQtyTextField() {
		return qtyTextField;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	//business logic
	/**
	 * this method will click on subject textfield
	 * 
	 * @param Subject
	 */
	public void clickonSubjectTextField(String Subject) {
		purchaseSubjectTextField.click();
		purchaseSubjectTextField.sendKeys(Subject);
	}
	/**
	 * this method is used to select vendor name
	 * 
	 * @param VendorName
	 */
	public void selectVendorName(String VendorName) {
		selectVendorName.click();
	}
	/**
	 * this method is used to click on search textfield and click on 
	 * vendor name link
	 * 
	 */
	public void clickOnSearchTextField() {
		searchTextField.click();
		searchTextField.sendKeys("HP");
		searchNowVendorButton.click();
		clickOnHPLink.click();
	}
	/**
	 * This method is used to select "Status" drop down list 
	 * 
	 */
	public void selectStatusDropDownList() {
		selectOption(selectStatusDropDownList,"Approved");
	}
	/**
	 * This method will click on group radio button
	 * 
	 */
	public void clickOnUserRadioButton() {
		userRadioButton.click();
	}
	/**
	 * this method is used to select "Adminstrator" in dropdown list
	 */
	public void selectAssignedToDropDownList() {
		selectOption(selectAssignedToDropDownList,"Adminstrator");
	}
	/**
	 * this method is used to click on group radio button
	 * 
	 */
	public void clickOnGroupRadioButton() {
		groupRadioButton.click();
	}
	/**
	 * this method is used to select "marketing group" in dropdown list
	 * 
	 */
	public void clickOnAssignedToDropDown() {
		selectAssignedToDropDownList.click();
	}
	public void selectMarketingGrooupDropDownList() {
		verifyTheDropDownList(selectAssignedToDropDownList,"Marketing Group");
	}
	public void selectSupportGroupDropDownList() {
	//WebElement ele = driver.findElement(By.name("assigned_group_id"));
	wUtil.selectOption(selectAssignedToDropDownList,"4");
	}

/**	public void selectSupportGrooupDropDownList() {
		verifyTheDropDownList(selectAssignedToDropDownList,"Support Group");
	}
	*/
	/**
	 * this method is used to select "Support Group" in dropdown list
	 * 
	 */
	/**public void selectSupportGroupDropDownList() {
		selectAssignedToDropDownList.click();
		selectOption(selectAssignedToDropDownList,"Support Group");
		supportGroupDropDown.click();
		}
		**/
	/**
	 * this method is used to add product name
	 * @param ProductName
	 */
	public void selectProductName(String ProductName) {
		addProductName.click();
	}
	/**
	 * this method is used to click on "search" textfield and click on 
	 * product name link
	 * 
	 */
	public void clickOnSearchTextField1() {
		searchProductTextField.click();
		searchProductTextField.sendKeys("Laptops");
		searchNowProductButton.click();
		clickOnLaptopsLink.click();
	}              
	
	/**
	 * this method is used to click on "Billing address" textfield
	 * 
	 * @param BillingAddress
	 */
	public void clickOnBillingAddressField(String BillingAddress) {
		billingAddressTextField.sendKeys(BillingAddress);
	}
	/**
	 * this method is used click on "Shipping address" textfield
	 * @param ShippingAddress
	 */
	public void clickOnShippingAddressField(String ShippingAddress) {
		shippingAddressTextFeild.sendKeys(ShippingAddress);
	}
	/**
	 * this method is used to click on Qty textfield
	 * 
	 * @param Qty
	 */
	public void clickOnQtyTextField(String Qty) {
		qtyTextField.sendKeys(Qty);
	}
	/**
	 * this method is used to click on save button
	 * 
	 */
	public void clickOnSaveButton() {
		saveButton.click();
	}
	/**
	 * 
	 * 
	 */
}





