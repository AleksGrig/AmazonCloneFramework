package testing.pages.login;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import testing.testcases.BaseTest;

public class LoginPage {
  private final Locators loginLocators = new Locators();

  private LoginPage() {
		PageFactory.initElements(new AjaxElementLocatorFactory(BaseTest.getDriver(), 15), loginLocators);
	}

  public static LoginPage load() {
		return new LoginPage();
	}

  public void signin(String login, String password) {
    loginLocators.login.sendKeys(login);
    loginLocators.password.sendKeys(password);
    loginLocators.signin.click();
  }
  
  public void signup(String login, String password) {
    loginLocators.login.sendKeys(login);
    loginLocators.password.sendKeys(password);
    loginLocators.signup.click();
  }
}
