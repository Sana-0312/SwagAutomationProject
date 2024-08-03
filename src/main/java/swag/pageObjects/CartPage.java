package swag.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import swag.abstractComponents.AbstractComponents;

public class CartPage extends AbstractComponents{
	WebDriver driver;
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".cart_item_label")
	List<WebElement> items;
	
	@FindBy(css=".cart_button")
	WebElement remove;
	
	
	
	By itemsBy = By.cssSelector(".cart_item_label");
	By removeBtn = By.cssSelector(".cart_button");
	
	public int getItemsSize()
	{
		return items.size();
	}
	public List<WebElement> getItemsList() {
		waitForElementToAppear(itemsBy);
		return items;
	}
	
	public WebElement getName(String itemName)
	{
		WebElement cartItem =	getItemsList().stream().filter(product->
		product.findElement(By.cssSelector(".inventory_item_name")).getText().equals(itemName)).findFirst().orElse(null);
		return cartItem;
	}
	public void removeCartItem(String itemName) throws InterruptedException
	{
		WebElement cartItem = getName(itemName);
		Thread.sleep(3000);
		cartItem.findElement(removeBtn).click();
	}
	
	
}
