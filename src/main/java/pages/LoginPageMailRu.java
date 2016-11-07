package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageMailRu {
    private final WebDriver driver;
    private By usernameLocator = By.id("mailbox__login");
    private By passwordLocator = By.id("mailbox__password");
    private By loginButtonLocator = By.id("mailbox__auth__button");

    public LoginPageMailRu(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPageMailRu openLoginPage() {
        driver.get("http://mail.ru");
        return this;
    }


    private LoginPageMailRu userNameInputField(String username) {
        driver.findElement(usernameLocator).sendKeys(username);
        return this;
    }

    private LoginPageMailRu passwordInputField(String password) {
        driver.findElement(passwordLocator).sendKeys(password);
        return this;
    }


    private LoginPageMailRu submitLogin() {
        driver.findElement(loginButtonLocator).submit();
        return this;
    }

    public LoginPageMailRu loginAs(String username, String password) {
        userNameInputField(username);
        passwordInputField(password);
        return submitLogin();
    }

}
