package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageMailRu {
	private final WebDriver driver;
	By usernameLocator = By.id("mailbox__login");
	By passwordLocator = By.id("mailbox__password");
	By loginButtonLocator = By.id("mailbox__auth__button");

	public LoginPageMailRu(WebDriver driver) {
		this.driver = driver;
	}

	public LoginPageMailRu userNameInputField(String username) {
		driver.findElement(usernameLocator).sendKeys(username);
		return this;
	}

	public LoginPageMailRu passwordInputField(String password) {
		driver.findElement(passwordLocator).sendKeys(password);
		return this;
	}


	public LoginPageMailRu submitLogin() {
		driver.findElement(loginButtonLocator).submit();
		return this;
	}

	public LoginPageMailRu loginAs(String username, String password) {
		userNameInputField(username);
		passwordInputField(password);
		return submitLogin();
	}

}
