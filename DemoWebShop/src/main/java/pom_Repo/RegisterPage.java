package pom_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
public RegisterPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
	
}
@FindBy(id = "gender-male")
private WebElement malegenderRadioButton;

@FindBy(id = "gender-female")
private WebElement femalegenderRadioButton;

@FindBy(id = "FirstName")
private WebElement firstNameTextBox;

@FindBy(id = "LastName")
private WebElement lastNametextBox;

@FindBy(id = "Email")
private WebElement email;

@FindBy(id = "Password")
private WebElement passwordTextbox;

@FindBy(id = "ConfirmPassword")
private WebElement ConfirmPasswordTextBox;

@FindBy(id = "register-button")
private WebElement RegisterButton;

@FindBy(xpath = "//span[contains(text(),\"First name is required.\")]")
private WebElement FirstNameErrorMsg;

@FindBy(xpath = "//span[contains(text(),'Last name is required.')]")
private WebElement LastNameErrorMsg;

@FindBy(xpath = "//span[contains(text(),'Wrong email')]")
private WebElement EmailErrorMsg;

@FindBy(linkText = "Register")
private WebElement Registerlink;

public WebElement getEmailErrorMsg() {
	return EmailErrorMsg;
}

public WebElement getFirstNameErrorMsg() {
	return FirstNameErrorMsg;
}

public WebElement getLastNameErrorMsg() {
	return LastNameErrorMsg;
}

public WebElement getFirstNameErroMsg() {
	return FirstNameErrorMsg;
}

public WebElement getMalegenderRadioButton() {
	return malegenderRadioButton;
}

public WebElement getFemalegenderRadioButton() {
	return femalegenderRadioButton;
}

public WebElement getFirstNameTextBox() {
	return firstNameTextBox;
}

public WebElement getLastNametextBox() {
	return lastNametextBox;
}

public WebElement getEmail() {
	return email;
}

public WebElement getPasswordTextbox() {
	return passwordTextbox;
}

public WebElement getConfirmPasswordTextBox() {
	return ConfirmPasswordTextBox;
}

public WebElement getRegisterButton() {
	return RegisterButton;


}
}

