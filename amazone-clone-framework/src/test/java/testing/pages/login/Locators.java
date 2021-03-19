package testing.pages.login;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Locators {
  @FindBy(css = "input[type='text']")
	public WebElement login;
  @FindBy(css = "input[type='password']")
	public WebElement password;
  @FindBy(css = ".login__signInButton")
	public WebElement signin;
  @FindBy(css = ".login__registerButton")
	public WebElement signup;
}
