package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class MailRu {
    private static final int PRESENSE_TIMEOUT = 10;

    private WebDriver driver;

    @FindBy(xpath = "//*[@placeholder='Имя ящика']")
    private WebElement loginField;

    @FindBy(xpath = "//*[@id='mailbox:domain']")
    private WebElement selector;

    @FindBy(xpath = "//input[@type='submit' and @value='Ввести пароль']")
    private WebElement buttonEnterPassword;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement fieldEnterPassword;

    @FindBy(xpath = "//*[@id='PH_user-email']")
    private WebElement loggedUser;

    @FindBy(xpath = "//*[@class='js-item-checkbox b-datalist__item__cbx'])[1]")
    private WebElement firstMessageAppeared;

    @FindBy(xpath = "//*[@data-name='spam']")
    private WebElement buttonMailToSpam;

    @FindBy(xpath = "//*[@class='ico ico_folder ico ico_folder_spam'']")
    private WebElement navigateToSpamIco;

    @FindBy(xpath = "//*[@id='b-letters']/div/div[5]/div/div[2]/div[1]/div/a/div[1]")
    private WebElement mailFromSpamToIncoming;

    @FindBy(xpath = "//*[@id='b-toolbar__right']/div[3]/div/div[2]/div[3]/div/span")
    private WebElement oneMailOutOfSpam;

    public MailRu(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    public void enterLogin(String login) {
        loginField.clear();
        loginField.sendKeys(login);
    }

    public void select() {
        Select select = new Select(selector);
        select.selectByVisibleText("@list.ru");
    }

    public void enterPass(String pass) {
        buttonEnterPassword.click();
        fieldEnterPassword.sendKeys(pass);
    }

    public void clickLoginButton() {
        buttonEnterPassword.click();
    }

    public void oneMailToSpam() {
        firstMessageAppeared.click();
        buttonMailToSpam.click();
    }

    public void oneMailFromSpamToIncoming() {
        navigateToSpamIco.click();
        mailFromSpamToIncoming.click();
        oneMailOutOfSpam.click();
    }
}


