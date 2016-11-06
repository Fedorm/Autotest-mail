import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.LettersPageMailRu;
import pages.LoginPageMailRu;
import utils.BrowserFactory;

import java.util.concurrent.TimeUnit;

public class TestNgTestBase {
    public static String browserModel = "chrome";
    public static String mailClient = "http://mail.ru";


public static WebDriver driver;

    @BeforeClass
    public void setupTest() {
        driver = new BrowserFactory().getDriver(browserModel);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(mailClient);
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

//    @Test
//    public void testValidLoginMailRu() {
//        LoginPageMailRu loginPageMailRu = new LoginPageMailRu(driver);
//        loginPageMailRu.loginAs("testcrystals", "123qazwer");
//        LettersPageMailRu lettersPageMailRu = new LettersPageMailRu(driver);
//        lettersPageMailRu.logout();
//    }


}