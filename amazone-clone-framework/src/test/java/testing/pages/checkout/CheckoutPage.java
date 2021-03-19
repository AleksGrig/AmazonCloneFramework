package testing.pages.checkout;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import testing.pages.orders.OrdersPage;
import testing.testcases.BaseTest;

public class CheckoutPage {
  private final Locators checkoutLocators = new Locators();

  private CheckoutPage() {
		PageFactory.initElements(new AjaxElementLocatorFactory(BaseTest.getDriver(), 15), checkoutLocators);
	}
  
  public static CheckoutPage load() {
		return new CheckoutPage();
	}

  public OrdersPage payWithCard(String cardNumber, String expired, String cvc, String zip) {
    BaseTest.getDriver().switchTo().frame(2);

    BaseTest.getDriver()
      .findElement(By.cssSelector(".CardNumberField-input-wrapper input"))
      .sendKeys(cardNumber);
    BaseTest.getDriver() 
      .findElement(By.cssSelector(".CardField-expiry.CardField-child input"))
      .sendKeys(expired);
    BaseTest.getDriver()
      .findElement(By.cssSelector(".CardField-cvc.CardField-child input"))
      .sendKeys(cvc);
    BaseTest.getDriver()
      .findElement(By.cssSelector(".CardField-postalCode.CardField-child input"))
      .sendKeys(zip);

    BaseTest.getDriver().switchTo().defaultContent();
    
    try{
      Thread.sleep(2000);
    } catch(InterruptedException e) {
      System.out.println(e.toString());
    }
    checkoutLocators.buyNow.click();
    return OrdersPage.load();
  }  
}
