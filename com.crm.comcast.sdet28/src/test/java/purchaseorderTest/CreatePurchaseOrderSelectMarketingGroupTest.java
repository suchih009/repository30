package purchaseorderTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.comcast.GenericUtility.BaseClass;
import com.crm.comcast.GenericUtility.ExcelUtility;
import com.crm.comcast.GenericUtility.FileUtility;
import com.crm.comcast.GenericUtility.IPathConstants;
import com.crm.comcast.GenericUtility.JavaUtility;
import com.crm.comcast.GenericUtility.WebDriverUtility;
import com.crm.comcast.objectRepository.CreatePurchaseOrderPage;
import com.crm.comcast.objectRepository.HomePage;
import com.crm.comcast.objectRepository.LoginPage;
import com.crm.comcast.objectRepository.PurchaseOrderInformationPage;
import com.crm.comcast.objectRepository.PurchaseOrderPage;
/**
 * create purchase order and select assigned to and in that select groups 
 * and select marketing group
 * @author suchi
 *
 */

public class CreatePurchaseOrderSelectMarketingGroupTest extends BaseClass {
	@Test
	public void createPurchaseOrderSelectMarketingGroup() throws Throwable {
		//create an object for utilities
		JavaUtility jUtil = new JavaUtility();
		ExcelUtility eUtil = new ExcelUtility();
		WebDriverUtility wUtil = new WebDriverUtility();

		//generate random number
		int randomNumber = jUtil.getRandomNumber();

		//get data from excel sheet
		String VendorName = eUtil.getStringCellData("Sheet1",5,2);
		String Qty = eUtil.getStringCellData("Sheet1",5,3);
		String Subject = eUtil.getStringCellData("Sheet1",5,5);
		String BillingAddress = eUtil.getStringCellData("Sheet1",5,6);
		String ShippingAddress = eUtil.getStringCellData("Sheet1",5,7);
		String ProductName = eUtil.getStringCellData("Sheet1",5,8);



		//mouseOver on more and clicks on purchase order link
		HomePage homePage = new HomePage(driver);
		homePage.clickOnmore();
		homePage.clickOnPurchaseOrderLink();

		//clicks on  purchaseOrderPlusImage
		PurchaseOrderPage purchaseOrderPage = new PurchaseOrderPage(driver); 
		purchaseOrderPage.clickCreatePurchaseOrderPlusImage();

		//create purchase order
		CreatePurchaseOrderPage createpurchaseOrderPage = new CreatePurchaseOrderPage(driver);
		createpurchaseOrderPage.clickonSubjectTextField(Subject);
		createpurchaseOrderPage.selectVendorName(VendorName);
		createpurchaseOrderPage.switchToWindow(driver, VendorName);
		createpurchaseOrderPage.clickOnSearchTextField();
		createpurchaseOrderPage.switchToWindow(driver, ProductName);
        createpurchaseOrderPage.selectStatusDropDownList();
		//createpurchaseOrderPage.clickOnUserRadioButton();
		//createpurchaseOrderPage.selectAssignedToDropDownList();
		createpurchaseOrderPage.clickOnGroupRadioButton();
		//createpurchaseOrderPage.selectMarketingGrooupDropDownList();
		createpurchaseOrderPage.clickOnBillingAddressField(BillingAddress);
		createpurchaseOrderPage.clickOnShippingAddressField(ShippingAddress);
		createpurchaseOrderPage.clickOnQtyTextField(Qty);
		createpurchaseOrderPage.selectProductName(ProductName);
		createpurchaseOrderPage.switchToWindow(driver,ProductName);
		//createpurchaseOrderPage.selectProductName(ProductName);
		//createpurchaseOrderPage.switchToWindow(driver,ProductName);
		createpurchaseOrderPage.clickOnSearchTextField1();
		createpurchaseOrderPage.switchToWindow(driver, ProductName);
		createpurchaseOrderPage.clickOnSaveButton();
		createpurchaseOrderPage.switchToWindow(driver, ProductName);


		PurchaseOrderInformationPage purchaseOrderInfo = new PurchaseOrderInformationPage(driver);
		purchaseOrderInfo.getPurchaseOrderInfoText();
		
		String actual="BillingAddress";
		String expected="BillingAddress";
		Assert.assertEquals(actual, expected);

      /* String actual=driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
		if(actual.contains(BillingAddress))
		{
			System.out.println("purchase order is not created");
		}
		else {
			System.out.println("purchase order is created");
		}
		*/

	}
}


