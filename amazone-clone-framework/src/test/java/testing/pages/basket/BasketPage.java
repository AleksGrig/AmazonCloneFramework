package testing.pages.basket;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import testing.pages.checkout.CheckoutPage;
import testing.pages.home.HomePage;
import testing.testcases.BaseTest;

public class BasketPage {
  private final Locators basketLocators = new Locators();
  private final HomePage homePage;

  private BasketPage(HomePage home) {
    homePage = home;
		PageFactory.initElements(new AjaxElementLocatorFactory(BaseTest.getDriver(), 15), basketLocators);
	}

  public static BasketPage load(HomePage home) {
		return new BasketPage(home);
	}

  public HomePage returnHome() {
    basketLocators.home.click();
    return homePage;
  }

  public CheckoutPage proceedToCheckout() {
    basketLocators.proceed.click();
    return CheckoutPage.load();
  }
}
