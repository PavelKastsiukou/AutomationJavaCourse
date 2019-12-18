package junitcucumber;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class MailToSpamSteps {
    private static final String MAIN_URL = "http://mail.ru";
    private static final String LOGIN = "blue_wind";
    private static final String PASSWORD = "Norman85!";
    private MailToSpam mailToSpam;
    private WebDriver webDriver;

    public MailToSpamSteps() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
        webDriver = new ChromeDriver();
        mailToSpam = new MailToSpam(webDriver);
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Given("^I am on main application page$")
    public void loadMainPage() {
        webDriver.get(MAIN_URL);
    }

    @When("^I login as correct user$")
    public void loginAsCorrectUser() {
        mailToSpam.select();
        mailToSpam.enterLogin(LOGIN);
        mailToSpam.clickEnterButton();
        mailToSpam.enterPassword(PASSWORD);
        mailToSpam.clickEnterButton();
    }

    @And("^I select first message$")
    public void selectFirstMessage() {
        mailToSpam.selectFirstMessageAsCorrectUser();
    }


    @And("^I click spam$")
    public void deleteFirstMEssageAsLoggedUser() {
        mailToSpam.spamFirstMEssage();
    }

    @Then("^I see message message goes to spam$")
    public void spamFirstMEssageAppearedSuccessful() {
        mailToSpam.spamMessageAppeared();
    }

    @After
    public void afterClass() {
        webDriver.quit();
    }
}
