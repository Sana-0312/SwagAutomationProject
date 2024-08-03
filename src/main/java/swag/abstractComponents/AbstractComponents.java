package swag.abstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import swag.pageObjects.CartPage;
import swag.pageObjects.CheckoutPage;

public class AbstractComponents {
	
	WebDriver driver;
	public CartPage cartPage;
	public 	CheckoutPage checkoutPage;
	public AbstractComponents(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css="product_sort_container")
	WebElement sort;
	
	@FindBy(css=".shopping_cart_link")
	WebElement cart;
	
	@FindBy(css=".checkout_button")
	WebElement checkout;
	
	public String getTitle()
	{
		return driver.getTitle();
	}
	public void waitForElementToAppear(By findBy)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	public void waitForElementToClick(By findBy)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(findBy));
	}
	public void sortItems(String value)
	{
		Select s = new Select(sort);
		s.selectByValue(value);
		
	}
	public CartPage goTocartPage()
	{
		cart.click();
		cartPage = new CartPage(driver);
		return cartPage;
		
	}
	public CheckoutPage cartCheckOut()
	{
		checkout.click();
		checkoutPage = new CheckoutPage(driver);
		return checkoutPage;
	}
	public void scrolling(String scroll)
	{
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript(scroll);
	}
}
