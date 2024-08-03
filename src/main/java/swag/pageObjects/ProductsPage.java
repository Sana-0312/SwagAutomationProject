package swag.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import swag.abstractComponents.AbstractComponents;

public class ProductsPage extends AbstractComponents{
	WebDriver driver;
	public ProductsPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//div[@class='inventory_item']")
	List<WebElement> productList;
	
	@FindBy(css=".shopping_cart_badge")
	WebElement countItems;
	

	By productsBy = By.xpath("//div[@class='inventory_item']");
	By addToCart = By.cssSelector(".btn_primary");
	
	public List<WebElement> getProductList() {
		waitForElementToAppear(productsBy);
		return productList;
	}
	
	public WebElement getProductByName(String productName)
	{
		WebElement prod =	getProductList().stream().filter(product->
		product.findElement(By.cssSelector(".inventory_item_name")).getText().equals(productName)).findFirst().orElse(null);
		return prod;
	}
	
	
	public void addProductToCart(String productName) throws InterruptedException
	{
		WebElement prod = getProductByName(productName);
		prod.findElement(addToCart).click();
	}
	public String numOfItems()
	{
		return countItems.getText();
	}
	public WebElement getItemByName(String itemName)
	{
		WebElement item =	getProductList().stream().filter(product->
		product.findElement(By.cssSelector(".inventory_item_name")).getText().equals(itemName)).findFirst().orElse(null);
		return item;
	}
	
	
	public void additemToCart(String itemName) throws InterruptedException
	{
		WebElement item = getProductByName(itemName);
		waitForElementToClick(addToCart);
		item.findElement(addToCart).click();
	}
	
	
	
	
	

}
