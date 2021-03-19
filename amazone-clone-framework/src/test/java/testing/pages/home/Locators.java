package testing.pages.home;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Locators {
  @FindBy(css = "div.header__nav > a")
	public WebElement login;
  @FindBy(css = ".header__optionLineOne")
  public WebElement greeting;
  @FindBy(css = ".product button")
  public List<WebElement> addToBasket;
  @FindBy(css = ".header__optionBasket")
  public WebElement basket;
  @FindBy(css = ".product")
  public List<WebElement> products;
}
