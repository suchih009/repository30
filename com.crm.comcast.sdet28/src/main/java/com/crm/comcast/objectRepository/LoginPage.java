package com.crm.comcast.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Login page POM design
 * @author suchi
 *
 */

public class LoginPage {
	//element initialization
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	
	
	//element identification and declaration
	@FindBy(name="user_name")
	private WebElement usernameTextField;

	@FindBy(name="user_password")
	private WebElement passwordTextField;

	@FindBy(id="submitButton")
	private WebElement loginButton;


	//getter methods
	public WebElement getUsernameTextField() {
		return usernameTextField;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	//business logic for login action
	/**
	 * this method will perform application login action
	 * @param username
	 * @param password
	 */
	public void loginToApplication(String username ,String password) {
		usernameTextField.sendKeys(username);
		passwordTextField.sendKeys(password);
		loginButton.click();
	}


}










