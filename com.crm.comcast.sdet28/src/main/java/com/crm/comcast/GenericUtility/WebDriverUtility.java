package com.crm.comcast.GenericUtility;

import java.nio.file.Files;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File;

public class WebDriverUtility {
	/**
	 * it will load 20 seconds till the element load in DOM
	 * @param driver
	 */
	public void waitForPageLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}
	/**this method will wait till element is visible
	 * 
	 * @param driver
	 * @param element
	 */
	public void waitForVisibilityOfElement(WebDriver driver,WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**this method will wait till the element to be clickable
	 * 
	 * @param driver
	 * @param element
	 */

	public void waitForElementToBeClick(WebDriver driver,WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}
	/**this method is used to wait for the element and click operation
	 * 
	 * @param element
	 * @throws Throwable 
	 * @throws  
	 */
	public void waitAndClick(WebElement element) throws Throwable  {
		int count=0;
		while(count<50) {
			try {
				element.click();
			} catch(Throwable e) {
				Thread.sleep(1000);
				count++;
			}
		}
	}
	/**
	 * this method will select the element based on index
	 * @param element
	 * @param index
	 */
	public void selectOption(WebElement element,int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	/**
	 * this method will select the element based on value
	 * @param element
	 * @param value
	 */
	public void selectOption(WebElement element,String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}
	/**
	 * this method will select the element based on text
	 * @param text
	 * @param element
	 */
	public void selectOption(String text,WebElement element) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}
	/**
	 * this method will verify whether the expected option is present in dropdown list or not
	 * @param element
	 * @param expectedOptions
	 * @return
	 */
	public WebElement verifyTheDropDownList(WebElement element,String expectedOptions) {
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		for(WebElement ele:options) {
			if(ele.equals(expectedOptions)) {
				System.out.println("value is present in dropdown");
				return ele;
			} else { 
				System.out.println("value is not present in dropdown");
				return ele;
			}
		}
		return null;
	}
	/**
	 * this method will perform mouse hovering action
	 * @param driver
	 * @param element
	 */
	public void mouseOver(WebDriver driver,WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}
	/**
	 * this method performs right click action
	 * @param driver
	 * @param element
	 */
	public void rightClick(WebDriver driver,WebElement element) {
		Actions action = new Actions(driver);
		action.contextClick(element).perform();
	}
	/**Used to perform javascript click on webelement
	 * 
	 * @param driver
	 * @param element
	 */
	public void jsClick(WebDriver driver,WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click",element);
	}
	
	
	/**
	 * this method is used to send the value using javascript executor
	 * @param driver
	 * @param valueToEnter
	 * @param element
	 */
	public void enterDataUsingJs(WebDriver driver,String valueToEnter,WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].value='"+valueToEnter+"'",element);
	}
	public void switchToWindow(WebDriver driver,String partialWindowTitle) {
		Set<String> winIds = driver.getWindowHandles();
	   Iterator<String> it = winIds.iterator();
	   while(it.hasNext()) {
		   String winId = it.next();
		   String title = driver.switchTo().window(winId).getTitle();
		   if(title.contains(partialWindowTitle)) {
			   break;
		   }
	   }
	}
	/**
	 * this method is used to take screenshotin the case of failures
	 * @param driver
	 * @param testCaseName
	 * @return
	 */
	/*public String screenShot(WebDriver driver,String testCaseName) throws Throwable{
		JavaUtility jUtil = new JavaUtility();
		String filePath = "./errorshots"+testCaseName+jUtil.systemDateAndTime()+".png";
		TakesScreenshot ts = (TakesScreenshot)driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
	    File destination = new File();
	  //  FileUtils.copy(source,destination);
	    source.renameTo(destination);
		return filePath;
	}
	*/
	

	/**
	 * this method will switch the frames based on the index passed
	 * @param driver
	 * @param index
	 */
	
	public void switchFrames(WebDriver driver,int index) {
		driver.switchTo().frame(index);
	}
	/**
	 * this method will switch the frame based on the name or ID passed
	 * @param driver
	 * @param nameOrId
	 */
	public void switchFrames(WebDriver driver,String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}
	/**
	 * this method will switch the frame based on the webelement passed
	 * @param driver
	 * @param nameOrId
	 */
	public void switchFrames(WebDriver driver,WebElement element) {
			driver.switchTo().frame(element);
	}
				
	/**
	 * this method will accept the alert
	 * 
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver) 
	{
		driver.switchTo().alert().accept();
	}
	/**
	 *this method will click on dismiss button in  Alert popup
	 * @param driver
	 */
	public void cancelAlert(WebDriver driver) 
	{
		driver.switchTo().alert().dismiss();
	}


}
