package testing.testcases;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import testing.pages.home.HomePage;

public class PurchaseTest extends BaseTest {
  @Test
  public void buy() {
    Map<String, String> card = getCard();
    HomePage home =  HomePage.load();
    String productId = home.getRandomProductId();
    
    String ordersProductId = home.signup(getLogin(), getPassword())
    .addProductToBasket(productId)
    .proceedToBasket()
    .proceedToCheckout()
    .payWithCard(card.get("number"), card.get("expired"), card.get("cvc"), card.get("zip"))
    .getFirstProductId();

    Assert.assertEquals(ordersProductId, productId);
  }

  private String getLogin() {
    return new Date().toString().toLowerCase().replace(" ", "").replace(":", "_") + "@gmail.com";
  }
  
  private Map<String, String> getCard() {
    Map<String, String> card = new HashMap<>();
    card.put("number", "4242424242424242");
    card.put("expired", "0424");
    card.put("cvc", "242");
    card.put("zip", "42424");
    return card;
  }
  
  private String getPassword() {
    return "123456";
  }
}