package testing.pages.orders;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import testing.testcases.BaseTest;

public class OrdersPage {
  private final Locators ordersLocators = new Locators();

  private OrdersPage() {
		PageFactory.initElements(new AjaxElementLocatorFactory(BaseTest.getDriver(), 15), ordersLocators);
	}
  
  public static OrdersPage load() {
		return new OrdersPage();
	}

	public String getFirstProductId() {
		return ordersLocators.id.getAttribute("id");
	}
}
