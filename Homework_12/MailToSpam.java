package junitcucumber;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class MailToSpam {
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

    @FindBy(xpath = "//*[@id='PH_logoutLink']")
    private WebElement logoutLink;

    @FindBy(xpath = "(//*[@class='js-item-checkbox b-datalist__item__cbx'])[1]")
    private WebElement firstMessageAppeared;

    @FindBy(xpath = "//*[@id='b-toolbar__right']/div[2]/div/div[2]/div[3]/div/span")
    private WebElement buttonMailToSpam;

    @FindBy(xpath = "//*[@id='jsHtml']/body/div[1]")
    private WebElement messageDeletedSuccess;

    public MailToSpam(WebDriver webdriver) {
        PageFactory.initElements(webdriver, this);
        this.driver = webdriver;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public void enterLogin(String login) {
        loginField.sendKeys(login);
        buttonEnter.click();
    }

    public void select() {
        Select select = new Select(selector);
        select.selectByVisibleText("@list.ru");
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
        buttonEnter.click();
    }

    public void clickEnterButton() {
        buttonEnter.click();
    }

    public void selectFirstMessageAsCorrectUser() {
        firstMessageAppeared.click();
    }

    public void spamFirstMEssage() {
        buttonMailToSpam.click();
    }

    public boolean spamMessageAppeared() {
        return (new WebDriverWait(driver, LINK_PRESENSE_TIMEOUT)).until(ExpectedConditions.visibilityOf(messageDeletedSuccess))
                .isDisplayed();
    }
}
