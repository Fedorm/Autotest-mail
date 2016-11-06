package scenarios;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.LettersPageMailRu;
import pages.LoginPageMailRu;
import utils.BrowserFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by me on 11/6/2016.
 */
public class TestMailRu {
    public static String browserModel = "chrome";
    public static String mailClient = "http://mail.ru";
    public static String username = "testcrystals";
    public static String password = "123qazwer";
    LoginPageMailRu loginPageMailRu;
    LettersPageMailRu lettersPageMailRu;

    WebDriver driver;
    @BeforeSuite
    public void setupTest() {
        driver = new BrowserFactory().getDriver(browserModel);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(mailClient);
        loginPageMailRu = new LoginPageMailRu(driver);
        lettersPageMailRu = new LettersPageMailRu(driver);
    }

    @AfterTest
    public void logOut(){
        LettersPageMailRu lettersPageMailRu = new LettersPageMailRu(driver);
        lettersPageMailRu.logout();
    }
    @AfterSuite
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }


    @Test(priority = 1)
    public void testValidLogin() {
        loginPageMailRu.loginAs(username, password);
          }

    @Test(priority = 2)
    public void openMail() {
        lettersPageMailRu.openMail();

    }

    @Test(priority = 3)
    public void checkMail() {
        lettersPageMailRu.verifyAuthor();
        lettersPageMailRu.verifySubject();
        lettersPageMailRu.verifyBody();
    }

}

