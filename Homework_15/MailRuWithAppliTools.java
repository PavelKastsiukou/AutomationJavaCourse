package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class MailRuWithAppliTools {
    @FindBy(xpath = "//*[@placeholder='Имя ящика']")
    private WebElement loginField;

    @FindBy(xpath = "//*[@id='mailbox:domain']")
    private WebElement selector;

    @FindBy(xpath = "//input[@type='submit' and @value='Ввести пароль']")
    private WebElement buttonEnterPassword;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement fieldEnterPassword;

    @FindBy(xpath = "//*[@id='app-canvas']/div/div[1]/div[1]/div/div[2]/div[1]/div/div/div/div[1]/div")
    private WebElement buttonWriteMessage;

    @FindBy(xpath = "/html/body/div[15]/div[2]/div/div[1]/div[2]/div[3]/div[2]/div/div/div[1]/div/div[2]/div/div")
    private WebElement forWhom;

    @FindBy(xpath = "/html/body/div[15]/div[2]/div/div[1]/div[2]/div[3]/div[3]/div[1]/div[2]/div/input")
    private WebElement messageTheme;

    @FindBy(xpath = "/html/body/div[15]/div[2]/div/div[1]/div[2]/div[3]/div[5]/div/div/div[2]/div[1]")
    private WebElement messageIframe;

    @FindBy(xpath = "/html/body/div[15]/div[2]/div/div[2]/div[1]/span[1]/span")
    private WebElement buttonSendMessage;
    
    public MailRuWithAppliTools(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    public void enterLogin(String login) {
        loginField.clear();
        loginField.sendKeys(login);
    }

    public void select() {
        Select select = new Select(selector);
        select.selectByVisibleText("@inbox.ru");
    }

    public void enterPass(String pass) {
        buttonEnterPassword.click();
        fieldEnterPassword.sendKeys(pass);
    }

    public void sendMessage() {
        buttonWriteMessage.click();
        forWhom.sendKeys("2233454@gmail.com");
        messageTheme.sendKeys("тема");
        messageIframe.sendKeys("fdfdfdf");
        buttonSendMessage.click();

    }

    public void clickLoginButton() {
        buttonEnterPassword.click();
    }
}
