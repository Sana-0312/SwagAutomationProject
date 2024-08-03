package swag.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import swag.abstractComponents.AbstractComponents;

public class LoginPage extends AbstractComponents{
	WebDriver driver;
	public ProductsPage productPage;
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="user-name")
	WebElement name;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="login-button")
	WebElement login;
	
	public void goTo()
	{
		driver.get("https://www.saucedemo.com/v1/");	
	}
	public ProductsPage userLogin(String userName, String userPassword)
	{
		name.sendKeys(userName);
		password.sendKeys(userPassword);
		login.click();
		productPage = new ProductsPage(driver);
		return productPage;
	}


}
