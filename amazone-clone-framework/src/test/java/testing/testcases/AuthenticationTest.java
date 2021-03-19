package testing.testcases;

import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.Test;

import testing.pages.home.HomePage;

public class AuthenticationTest extends BaseTest{
  @Test
  public void signoutTest() {
    String login = "test@gmail.com";
    String password = "123456";
    HomePage homePage = HomePage.load();

    String userName = homePage
      .signin(login, password)
      .getUserName();
    Assert.assertEquals(userName, login);

    userName = homePage
      .signout()
      .getUserName();
    String guest = "Guest";
    Assert.assertEquals(userName, guest);
  }

  @Test
  public void signup() {
    String login = new Date().toString().toLowerCase().replace(" ", "").replace(":", "_") + "@gmail.com";
    String password = "123456";
    String userName = HomePage.load()
      .signup(login, password)
      .getUserName();
    Assert.assertEquals(userName, login);
  }
}
