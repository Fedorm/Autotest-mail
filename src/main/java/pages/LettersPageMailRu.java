package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LettersPageMailRu {


	public static By senderTextLocator = By.className("b-datalist__item__addr");
	public static By logoutButtonLocator = By.id("PH_logoutLink");
	public static By letterAuthorLocator = By.xpath("//*[@id=\"b-letter\"]/div[2]/div[2]/div[3]/div[2]/div[1]/span");
	public static By letterSubjectLocator = By.className("b-letter__head__subj__text");
	private final WebDriver driver;
	public LettersPageMailRu(WebDriver driver) {
		this.driver = driver;
	}

	public static By locator(String body) {
		return By.xpath(String.format("//div[text()='%s']", body));
	}

	public LettersPageMailRu logout() {
		driver.findElement(logoutButtonLocator).click();
		return this;
	}

	public LettersPageMailRu openLetter() {
		driver.findElement(senderTextLocator).click();
		return this;
	}

}
