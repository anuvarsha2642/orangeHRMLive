package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginPageObjects {

	@FindBy(id="txtUsername")
	public static WebElement userName;
	
	@FindBy(id="txtPassword")
	public static WebElement userPassword;
	
	
}
