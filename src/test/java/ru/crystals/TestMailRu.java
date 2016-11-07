package ru.crystals;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import pages.LettersPageMailRu;
import pages.LoginPageMailRu;
import utils.BrowserFactory;

import static pages.LettersPageMailRu.letterAuthorLocator;
import static pages.LettersPageMailRu.letterBodyLocator;
import static pages.LettersPageMailRu.letterSubjectLocator;

/**
 * Created by me on 11/6/2016.
 */
public class TestMailRu {
	public static String browserModel = "chrome";
	public static String username = "testcrystals";
	public static String password = "123qazwer";
	public static String sender = "Федор Михайлович";
	public static String subject = "Тестовое задание";
	public static String body = "спасибо за встречу";
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
	public void testOpenMail() {
		Assert.assertTrue(driver.findElement(LettersPageMailRu.senderTextLocator).getText().equals(sender));
		lettersPageMailRu.openLetter();
	}

	@Test(priority = 3)
	public void testCheckMail() {
		Assert.assertTrue(driver.findElement(letterAuthorLocator).getText().contains(sender));
		Assert.assertTrue(driver.findElement(letterSubjectLocator).getText().equals(subject));
		Assert.assertTrue(driver.findElement(letterBodyLocator).getText().equals(body));

//		lettersPageMailRu.verifyAuthor(sender);
//		lettersPageMailRu.verifySubject(subject);
//		lettersPageMailRu.verifyBody(body);
	}

}


