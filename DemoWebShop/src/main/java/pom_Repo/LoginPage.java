package pom_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import viaUsingPom.ReadData;

public class LoginPage {
	public WebDriver driver;
	public LoginPage logp;
	public LoginPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
	this.driver=driver;
	}

	@FindBy(id = "Email")
	private WebElement emailTextField;

	@FindBy(id = "Password")
	private WebElement passwordTextField;

	@FindBy(xpath = "//input[@value='Log in']")
	private WebElement loginButton;

	public WebElement getEmailTextField() {
	return emailTextField;
	}

	public WebElement getPasswordTextField() {
	return passwordTextField;
	}

	public WebElement getLoginButton() {
	return loginButton;
	}
	public void login(String email,String password) {
	String expectedLoginPageTime=ReadData.fromProperty("LoginPageTitle");
	logp=new LoginPage(driver);
	CommonPage comp=new CommonPage(driver);
	comp.getLoginLink().click();
	Assert.assertEquals(driver.getTitle(), expectedLoginPageTime,"Login page is not displayed");

	//enter the email
	logp.getEmailTextField().sendKeys(email);
	Assert.assertEquals(logp.getEmailTextField().getAttribute("value"), email,"Email address is not entered properly");

	//enter the password
	logp.getPasswordTextField().sendKeys(password);
	Assert.assertEquals(logp.getPasswordTextField().getAttribute("value"), password,"Password is not entered properly");

	//click on login button
	logp.getLoginButton().click();
	}

}
