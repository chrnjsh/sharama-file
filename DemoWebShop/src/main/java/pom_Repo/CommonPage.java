package pom_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CommonPage {
	
public CommonPage(WebDriver driver) {
PageFactory.initElements(driver, this);
}

public WebElement getRegisterLink() {
return registerLink;
}

public WebElement getLoginLink() {
return loginLink;
}

public WebElement getShoppingCartLink() {
return shoppingCartLink;
}

public WebElement getWishListLink() {
return wishListLink;
}

public WebElement getSearchBar() {
return searchBar;
}

public WebElement getSearchButton() {
return searchButton;
}

@FindBy(linkText = "Register")
private WebElement registerLink;
@FindBy(linkText = "Log in")
private WebElement loginLink;
@FindBy(linkText = "Shopping cart")
private WebElement shoppingCartLink;
@FindBy(linkText = "Wishlist")
private WebElement wishListLink;
@FindBy(name = "q")
private WebElement searchBar;
@FindBy(xpath = "//input[@value='Search']")
private WebElement searchButton;
@FindBy(linkText = "Log out")
private WebElement logoutLink;

public WebElement getLogoutLink() {
return logoutLink;
}


}
