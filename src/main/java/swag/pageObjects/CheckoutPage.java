package swag.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import swag.abstractComponents.AbstractComponents;

public class CheckoutPage extends AbstractComponents{
	WebDriver driver;
	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="first-name")
	WebElement fname;
	
	@FindBy(id="last-name")
	WebElement lname;
	
	@FindBy(id="postal-code")
	WebElement code;
	
	@FindBy(xpath="//input[@value='CONTINUE']")
	WebElement continueBtn;
	
	@FindBy(css=".btn_action")
	WebElement finish;
	
	@FindBy(css=".complete-header")
	WebElement success;
	
	public void checkOut(String firstName, String lastName, String postalCode)
	{
		fname.sendKeys(firstName);
		lname.sendKeys(lastName);
		code.sendKeys(postalCode);
		continueBtn.click();
		scrolling("window.scrollBy(0,700)");
		finish.click();
		
	}
	public String getthankyouMsg()
	{
		return success.getText();
	}
	

}
