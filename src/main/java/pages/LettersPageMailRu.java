package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LettersPageMailRu {

    private final WebDriver driver;
    private By senderTextLocator = By.className("b-datalist__item__addr");
    private By logoutButtonLocator = By.id("PH_logoutLink");
    private By letterBodyLocator = By.className("b-letter__body");
    private By letterAuthorLocator = By.className("b-letter__head__addrs__from");
    private By letterSubjectLocator = By.className("b-letter__head__subj__text");

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

    public String convertLetterBodyLocator() {
        String temp = driver.findElement(letterBodyLocator).getText();
        temp = temp.replaceAll("\\r|\\n", " ");
        return temp;
    }

    public String getLetterSubjectLocatorText() {
        return driver.findElement(letterSubjectLocator).getText();
    }

    public String getLetterAuthorLocatorText() {
        return driver.findElement(letterAuthorLocator).getText();
    }

    public String getSenderTextLocator() {
        return driver.findElement(senderTextLocator).getText();
    }
}
