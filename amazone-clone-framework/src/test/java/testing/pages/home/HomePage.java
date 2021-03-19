package testing.pages.home;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import testing.pages.basket.BasketPage;
import testing.pages.login.LoginPage;
import testing.testcases.BaseTest;

public class HomePage {
  private final Locators homeLocators = new Locators();

  private HomePage() {
		PageFactory.initElements(new AjaxElementLocatorFactory(BaseTest.getDriver(), 15), homeLocators);
	}
  
  public static HomePage load() {
    BaseTest.getDriver().get("http://localhost:3000/");
		return new HomePage();
	}
  
  public HomePage signin(String login, String password) {
    homeLocators.login.click();
    LoginPage.load().signin(login, password);
    return this;
  }
  
  public HomePage signup(String login, String password) {
    homeLocators.login.click();
    LoginPage.load().signup(login, password);
    return this;
  }

  public HomePage signout() {
    if(!getUserName().equals("Guest")) {
      homeLocators.login.click();
    } 
    return this;
  }

  public HomePage addRandomProductToBasket() {
    homeLocators.addToBasket.get((int)(Math.random() * homeLocators.addToBasket.size())).click();
    return this;
  }

  public BasketPage proceedToBasket() {
    homeLocators.basket.click();
    return BasketPage.load(this);
  }

  public String getUserName() {
    return homeLocators.greeting.getText().split(",")[1].strip();
  }

  public String getRandomProductId() {
    return homeLocators.products
      .get((int)(Math.random() * homeLocators.products.size()))
      .findElement(By.cssSelector(".product__id"))
      .getAttribute("id");
  }

  public HomePage addProductToBasket(String productId) {
    homeLocators.products.stream()
      .filter(product -> product.findElement(By.cssSelector(".product__id")).getAttribute("id").equals(productId))
      .findFirst()
      .ifPresent(product -> product.findElement(By.tagName("button")).click());
    return this;
  }
}
