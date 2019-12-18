package junitcucumber;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class MailFromSpamSteps {
    private static final String MAIN_URL = "http://mail.ru";
    private static final String LOGIN = "blue_wind";
    private static final String PASSWORD = "Norman85!";
    private MailFromSpam mailFromSpam;
    private WebDriver webDriver;

    public MailFromSpamSteps() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
        webDriver = new ChromeDriver();
        mailFromSpam = new MailFromSpam(webDriver);
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Given("^I am on main application page spam$")
    public void loadMainPageGoToSpam() {
        webDriver.get(MAIN_URL);
    }

    @When("^I login$")
    public void loginAsCorrectUserAndGoToSpam() {
        mailFromSpam.selectField();
        mailFromSpam.enterLoginField(LOGIN);
        mailFromSpam.clickGoButton();
        mailFromSpam.enterPasswordField(PASSWORD);
        mailFromSpam.clickGoButton();
    }

    @And("^I click icon spam$")
    public void enterInSpam() throws InterruptedException {
        mailFromSpam.clickToSpam();
        Thread.sleep(5000);
        mailFromSpam.alertWindowFromMailru();
    }

    @And("^I select message$")
    public void clickOnFirstAppearedMessage() {
        mailFromSpam.selectFirstMessage();
    }

    @And("^And I click not spam$")
    public void clickOnNotSpamButton(){
     mailFromSpam.clickButtonOutOfSpam();
    }

    @Then("^I see message mail return from spam$")
    public void spamMEssageRemovedSuccessful() {
        mailFromSpam.outOfSpamMessageAppearedSuccessful();
    }

//    @After
//    public void afterClass() {
//        webDriver.quit();
//    }
}
