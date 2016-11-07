package ru.crystals;

import org.apache.xpath.SourceTree;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.LettersPageMailRu;
import pages.LoginPageMailRu;
import utils.BrowserFactory;

import java.util.concurrent.TimeUnit;

public class TestMailRu {
    private String browserModel = "chrome";
    private String username = "testcrystals";
    private String password = "123qazwer";
    private String sender = "Федор Михайлович";
    private String subject = "TestCrystals HELLO!";
    private String body = "HELLO How are you? I'm fine thank you";
    private LoginPageMailRu loginPageMailRu;
    private LettersPageMailRu lettersPageMailRu;

    private WebDriver driver;

    @BeforeSuite
    public void setupTest() {
        driver = new BrowserFactory().getDriver(browserModel);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        loginPageMailRu = new LoginPageMailRu(driver);
        lettersPageMailRu = new LettersPageMailRu(driver);
    }


    @Test

    public void testCheckMail() {
        loginPageMailRu.openLoginPage();
        loginPageMailRu.loginAs(username, password);
        try {
            Assert.assertEquals(lettersPageMailRu.getSenderTextLocator(), sender);
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            System.out.println("Assert failed. Try Again");
            Assert.assertEquals(lettersPageMailRu.getSenderTextLocator(), sender);
        }
        lettersPageMailRu.openLetter();
        Assert.assertTrue(lettersPageMailRu.getLetterAuthorLocatorText().contains(sender));
        Assert.assertEquals(lettersPageMailRu.getLetterSubjectLocatorText(), subject);
        Assert.assertEquals(lettersPageMailRu.convertLetterBodyLocator(), body);
    }

    @AfterTest
    public void logOut() {
        lettersPageMailRu.logout();
    }

    @AfterSuite
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

}


