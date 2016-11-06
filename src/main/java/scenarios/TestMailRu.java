package scenarios;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.LettersPageMailRu;
import pages.LoginPageMailRu;
import utils.BrowserFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by me on 11/6/2016.
 */
public class TestMailRu {
    public static String browserModel = "chrome";
    public static String username = "testcrystals";
    public static String password = "123qazwer";
    public static String sender = "Федор Михайлович";
    public static String subject = "Тестовое задание";
    LoginPageMailRu loginPageMailRu;
    LettersPageMailRu lettersPageMailRu;

    WebDriver driver;

    @BeforeSuite
    public void setupTest() {
        driver = new BrowserFactory().getDriver(browserModel);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://mail.ru");
        loginPageMailRu = new LoginPageMailRu(driver);
        lettersPageMailRu = new LettersPageMailRu(driver);
    }

    @AfterTest
    public void logOut() {
        LettersPageMailRu lettersPageMailRu = new LettersPageMailRu(driver);
        lettersPageMailRu.logout();
    }

    @AfterSuite
    public void teardown() {
//        if (driver != null) {
//            driver.quit();
//        }
    }


    @Test(priority = 1)
    public void testValidLogin() {
        loginPageMailRu.loginAs(username, password);
    }

    @Test(priority = 2)
    public void openMail() {
        lettersPageMailRu.openLetter(sender);

    }

    @Test(priority = 3)
    public void checkMail() {
        lettersPageMailRu.verifyAuthor(sender);
        lettersPageMailRu.verifySubject(subject);
        lettersPageMailRu.verifyBody();
    }

}

