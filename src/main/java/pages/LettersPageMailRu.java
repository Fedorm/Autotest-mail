package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

/**
 * Created by me on 11/6/2016.
 */
public class LettersPageMailRu {
    By logoutButtonLocator = By.id("PH_logoutLink");
    By senderTextLocator = By.className("b-datalist__item__addr");
    By letterAuthorLocator = By.xpath("//*[@id=\"b-letter\"]/div[2]/div[2]/div[3]/div[2]/div[1]/span");
    By letterSubjectLocator = By.className("b-letter__head__subj__text");
    By letterBodyLocator = By.xpath("//div[text()=\"спасибо за встречу\"]");
//    By letterBodyLocator = By.xpath("//*[text()[contains(.,'спасибо')]]");
//    By letterBodyLocator2 = By.xpath("//*[@id=\"b-letter\"]/div[2]/div[5]/div/div[2]/div/div/div/div[text()=\"спасибо за встречу\"]");

    private final WebDriver driver;

    public LettersPageMailRu(WebDriver driver) {
        this.driver = driver;
    }


    public LettersPageMailRu logout() {
        driver.findElement(logoutButtonLocator).click();
        return this;
    }

    public LettersPageMailRu openLetter(String sender) {
        Assert.assertTrue(driver.findElement(senderTextLocator).getText().equals(sender));
        driver.findElement(senderTextLocator).click();
    return this;
}

    public LettersPageMailRu verifyAuthor(String sender) {
        Assert.assertTrue(driver.findElement(letterAuthorLocator).getText().contains(sender));
        return this;
    }
    public LettersPageMailRu verifySubject(String subject) {
//        try {
//            Assert.assertTrue(driver.findElement(letterSubjectLocator).getText().equals("Тестовое задание"));
//        } catch (Throwable AssertionError) {
//            System.out.println("The subject line does not correct");
//        }
        Assert.assertTrue(driver.findElement(letterSubjectLocator).getText().equals(subject));
        return this;
    }

    public LettersPageMailRu verifyBody() {


        Assert.assertTrue(driver.findElement(letterBodyLocator).getText().equals("спасибо за встречу"));

        return this;
    }

}
