package pages;

import com.applitools.eyes.EyesRunner;
import com.applitools.eyes.MatchLevel;
import com.applitools.eyes.selenium.ClassicRunner;
import com.applitools.eyes.selenium.Eyes;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class MailRuWithAppliToolsTest {
    WebDriver driver;
    private MailRuWithAppliTools mailRuWithAppliTools;
    EyesRunner runner = new ClassicRunner();
    Eyes eyes = new Eyes(runner);
    String AppName = "MailRuSendMessage";

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://mail.ru/");
        driver.manage().window().maximize();
        mailRuWithAppliTools = new MailRuWithAppliTools(driver);
    }

    @Test
    public void testBaseLineSendMessage() {
        eyes.setApiKey("wjUOkXMA5ckBUhLIwindODJ6qaFYpMrOIJyrT4KeQZw110");
        eyes.open(driver, AppName, "baseline");
        eyes.setMatchLevel(MatchLevel.LAYOUT);
        eyes.checkWindow();
        mailRuWithAppliTools.enterLogin("ggg.vvv.92");
        mailRuWithAppliTools.select();
        mailRuWithAppliTools.clickLoginButton();
        mailRuWithAppliTools.enterPass("temperament85");
        mailRuWithAppliTools.clickLoginButton();
        eyes.checkWindow();
        mailRuWithAppliTools.sendMessage();
        eyes.checkWindow();
    }
    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}