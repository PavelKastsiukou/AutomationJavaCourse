package junitcucumber;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class MailFromSpam {
    private static final int LINK_PRESENSE_TIMEOUT = 10;

    private WebDriver driver;

    @FindBy(xpath = "//*[@id='mailbox:domain']")
    private WebElement selector;

    @FindBy(id = "mailbox:login")
    private WebElement loginField;

    @FindBy(id = "mailbox:password")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@id='mailbox:submit']/input")
    private WebElement buttonEnter;

    @FindBy(xpath = "//*[@id='b-nav_folders']/div/div[4]/a/div")
    private WebElement buttonSpam;

    @FindBy(xpath = "//*[@id='b-letters']/div/div[5]/div/div[2]/div[1]/div/a/div[1]/div")
    private WebElement firstMessageAppeared;

    @FindBy(xpath = "//*[@id='b-toolbar__right']/div[3]/div/div[2]/div[3]/div")
    private WebElement butttonOutOfSpam;

    @FindBy(xpath = "//*[@id='jsHtml']/body/div[1]")
    private WebElement messageOutFromSpam;

    public MailFromSpam(WebDriver webdriver) {
        PageFactory.initElements(webdriver, this);
        this.driver = webdriver;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public void enterLoginField(String login) {
        loginField.sendKeys(login);
        buttonEnter.click();
    }

    public void selectField() {
        Select select = new Select(selector);
        select.selectByVisibleText("@list.ru");
    }

    public void enterPasswordField(String password) {
        passwordField.sendKeys(password);
        buttonEnter.click();
    }

    public void clickGoButton() {
        buttonEnter.click();
    }

    public void clickToSpam() {
        buttonSpam.click();
    }

    public void selectFirstMessage() {
        firstMessageAppeared.click();
    }

    public void alertWindowFromMailru(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }

    public void clickButtonOutOfSpam() {
        butttonOutOfSpam.click();
    }

    public boolean outOfSpamMessageAppearedSuccessful() {
        return (new WebDriverWait(driver, LINK_PRESENSE_TIMEOUT)).until(ExpectedConditions.visibilityOf(messageOutFromSpam))
                .isDisplayed();
    }
}
