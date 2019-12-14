package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class MailRuTest {
    private WebDriver driver;
    private MailRu mailRu;

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://mail.ru/");
        mailRu = new MailRu(driver);
    }

    @Test
    public void loginTest() {
        mailRu.enterLogin("blue_wind");
        mailRu.select();
        mailRu.clickLoginButton();
        mailRu.enterPass("gomel85pn");
        mailRu.clickLoginButton();
    }

    @Test(dependsOnMethods = "loginTest")
    public void mailToSpam() {
        mailRu.oneMailToSpam();
    }

    @Test(dependsOnMethods = "loginTest")
    public void FromSpamToIncoming() {
        mailRu.oneMailFromSpamToIncoming();
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}