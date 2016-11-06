package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by me on 11/5/2016.
 */
public class LoginPageMailRu {
    By usernameLocator = By.id("mailbox__login");
    By passwordLocator = By.id("mailbox__password");
    By loginButtonLocator = By.id("mailbox__auth__button");

    private final WebDriver driver;

    public LoginPageMailRu(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPageMailRu typeUsername(String username) {
        driver.findElement(usernameLocator).sendKeys(username);
        return this;
    }

    public LoginPageMailRu typePassword(String password) {
        driver.findElement(passwordLocator).sendKeys(password);
        return this;
    }


    public LoginPageMailRu submitLogin() {
        driver.findElement(loginButtonLocator).submit();
        return this;
    }

    public LoginPageMailRu loginAs(String username, String password) {
        typeUsername(username);
        typePassword(password);
        return submitLogin();
    }

}
