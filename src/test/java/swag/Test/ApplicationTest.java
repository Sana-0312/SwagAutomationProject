package swag.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import swag.pageObjects.CartPage;
import swag.pageObjects.CheckoutPage;
import swag.pageObjects.ProductsPage;
import testComponents.BaseTest;

public class ApplicationTest extends BaseTest{
	@Test(dataProvider="getData")
	public void SwagTest(HashMap<String,String> input) throws InterruptedException, IOException 
	{
		ProductsPage productPage = loginpage.userLogin(input.get("userName"), input.get("userPassword"));
		productPage.addProductToCart(input.get("productName"));
		productPage.additemToCart(input.get("itemName"));
		System.out.println(productPage.numOfItems());
		CartPage cartPage = productPage.goTocartPage();
		int cartSize = cartPage.getItemsSize();
		System.out.println(cartSize);
		cartPage.removeCartItem(input.get("itemName"));
		CheckoutPage checkoutPage = cartPage.cartCheckOut();
		checkoutPage.checkOut(input.get("firstName"), input.get("lastName"),input.get("postalCode"));
		getScreenshot("Order_Placed", driver);
		String Msg = checkoutPage.getthankyouMsg();
		System.out.println(Msg);
	}

	@DataProvider
	public Object[][] getData() throws IOException
	{
		List<HashMap<String,String>> data = getJasonData(System.getProperty("user.dir")+"\\src\\test\\java\\swag\\Data\\data.jason");
		return new Object[][] {{data.get(0)}};
	}

}
