package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ru.crystals.TestMailRu;


public class LettersPageMailRu {
	public static By senderTextLocator = By.className("b-datalist__item__addr");
	public static By logoutButtonLocator = By.id("PH_logoutLink");
	public static By letterAuthorLocator = By.xpath("//*[@id=\"b-letter\"]/div[2]/div[2]/div[3]/div[2]/div[1]/span");
	public static By letterSubjectLocator = By.className("b-letter__head__subj__text");
	public static By letterBodyLocator = By.xpath(String.format("//div[text()='%s']", TestMailRu.body));
	private final WebDriver driver;

	public LettersPageMailRu(WebDriver driver) {
		this.driver = driver;
	}


	public LettersPageMailRu logout() {
		driver.findElement(logoutButtonLocator).click();
		return this;
	}

	public LettersPageMailRu openLetter() {
		driver.findElement(senderTextLocator).click();
		return this;
	}

//	public LettersPageMailRu verifyAuthor(String sender) {
//		Assert.assertTrue(driver.findElement(letterAuthorLocator).getText().contains(sender));
//		return this;
//	}
//
//	public LettersPageMailRu verifySubject(String subject) {
////        try {
////            Assert.assertTrue(driver.findElement(letterSubjectLocator).getText().equals("Тестовое задание"));
////        } catch (Throwable AssertionError) {
////            System.out.println("The subject line does not correct");
////        }
//		Assert.assertTrue(driver.findElement(letterSubjectLocator).getText().equals(subject));
//		return this;
//	}
//
//	public LettersPageMailRu verifyBody(String body) {
//		Assert.assertTrue(driver.findElement(letterBodyLocator).getText().equals(body));
//		return this;
//	}

}
