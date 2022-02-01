package purchaseorderTest;

import org.testng.annotations.Test;

import com.crm.comcast.GenericUtility.BaseClass;
import com.crm.comcast.GenericUtility.ExcelUtility;
import com.crm.comcast.GenericUtility.FileUtility;
import com.crm.comcast.GenericUtility.JavaUtility;
import com.crm.comcast.GenericUtility.WebDriverUtility;
import com.crm.comcast.objectRepository.CreatePurchaseOrderPage;
import com.crm.comcast.objectRepository.HomePage;
import com.crm.comcast.objectRepository.LoginPage;
import com.crm.comcast.objectRepository.PurchaseOrderInformationPage;
import com.crm.comcast.objectRepository.PurchaseOrderPage;

public class CreateNewPurchaseOrder extends BaseClass {
	@Test(groups= {"regressionTest"})
	public void createPurchaseOrderSelectSupportGroup() throws Throwable {
		//create an object for utilities
		FileUtility fUtil = new FileUtility();
		JavaUtility jUtil = new JavaUtility();
		ExcelUtility eUtil = new ExcelUtility();
		WebDriverUtility wUtil = new WebDriverUtility();

		//get the data from property file
		String url = fUtil.getPropertyFileData("url");
		String username = fUtil.getPropertyFileData("username");
		String password = fUtil.getPropertyFileData("password");
		String browser = fUtil.getPropertyFileData("browser");

		//generate random number
		int randomNumber = jUtil.getRandomNumber();

		//get data from excel sheet
		String VendorName = eUtil.getStringCellData("Sheet1",5,2);
		String Qty = eUtil.getStringCellData("Sheet1",5,3);
		String Subject = eUtil.getStringCellData("Sheet1",5,5);
		String BillingAddress = eUtil.getStringCellData("Sheet1",5,6);
		String ShippingAddress = eUtil.getStringCellData("Sheet1",5,7);
		String ProductName = eUtil.getStringCellData("Sheet1",5,8);


		//login to application
		LoginPage login = new LoginPage(driver);
		login.loginToApplication(username, password);

		//mouseOver on more and clicks on purchase order link
		HomePage homePage = new HomePage(driver);
		homePage.clickOnmore();
		homePage.clickOnPurchaseOrderLink();

		//clicks on  purchaseOrderPlusImage
		PurchaseOrderPage purchaseOrderPage = new PurchaseOrderPage(driver); 
		purchaseOrderPage.clickCreatePurchaseOrderPlusImage();

		CreatePurchaseOrderPage createpurchaseOrderPage = new CreatePurchaseOrderPage(driver);
		createpurchaseOrderPage.clickonSubjectTextField(Subject);
		createpurchaseOrderPage.selectVendorName(VendorName);
		createpurchaseOrderPage.switchToWindow(driver, VendorName);
		createpurchaseOrderPage.clickOnSearchTextField();
		createpurchaseOrderPage.switchToWindow(driver, ProductName);
		createpurchaseOrderPage.selectStatusDropDownList();
		createpurchaseOrderPage.clickOnGroupRadioButton();
		createpurchaseOrderPage.clickOnBillingAddressField(BillingAddress);
		createpurchaseOrderPage.clickOnShippingAddressField(ShippingAddress);
		createpurchaseOrderPage.clickOnQtyTextField(Qty);
		createpurchaseOrderPage.selectProductName(ProductName);
		createpurchaseOrderPage.switchToWindow(driver,ProductName);
		createpurchaseOrderPage.clickOnSearchTextField1();
		createpurchaseOrderPage.switchToWindow(driver, ProductName);
		createpurchaseOrderPage.clickOnSaveButton();

	
	
	//createurchaseOrderPage.clickOnAddProductName();
	//createurchaseOrderPage.selectDropDownList();
	
	PurchaseOrderInformationPage purchaseOrderInfo = new PurchaseOrderInformationPage(driver);
	purchaseOrderInfo.getPurchaseOrderInfoText();
	//purchaseOrderInfo.clickOnSaveButton();
	
}
}
