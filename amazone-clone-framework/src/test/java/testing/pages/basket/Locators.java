package testing.pages.basket;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Locators {
  @FindBy(css = ".header__logo")
	public WebElement home;
  @FindBy(css = ".subtotal > button")
	public WebElement proceed;
}
