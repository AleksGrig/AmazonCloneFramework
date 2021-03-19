package testing.pages.checkout;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Locators {
  @FindBy(css = ".payment__priceContainer button")
  public WebElement buyNow;
}
