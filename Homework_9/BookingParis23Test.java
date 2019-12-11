import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BookingParis23Test {
    private static final String URL = "https://www.booking.com/";
    private static final LocalDate actualDate = LocalDate.now();
    LocalDate actualDatePlusThreeDays = LocalDate.parse(actualDate.plusDays(3).format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
    LocalDate actualDatePlusTenDays = LocalDate.parse(actualDatePlusThreeDays.plusDays(7).format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));

    @Test
    public void bookingParis23Test() throws Exception {
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.get(URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement inputSearchField = driver.findElement(
                By.xpath("//*[@aria-label='Type your destination']"));
        inputSearchField.sendKeys("Paris");
        driver.findElement(By.xpath("(//*[@class='sb-date-field b-datepicker'])[1]")).click();
        driver.findElement(By.xpath("//*[@data-date='" + actualDatePlusThreeDays + "']")).click();

        driver.findElement(By.xpath("//*[@data-date='" + actualDatePlusTenDays + "']")).click();
        driver.findElement(By.xpath("//*[@data-sb-id='main' and @type='submit']")).click();
        WebElement element = driver.findElement(By.xpath("//*[@aria-label='Number of adults']"));
        Select select = new Select(element);
        select.selectByValue("4");
        WebElement element1 = driver.findElement(By.id("no_rooms"));
        Select select1 = new Select(element1);
        select1.selectByValue("2");
        WebElement element2 = driver.findElement(By.xpath("(//label[@class='bui-checkbox']/div[@class='bui-checkbox__label filter_item css-checkbox'])[5]"));
        js.executeScript("arguments[0].scrollIntoView();", element2);
        element2.click();
        driver.findElement(By.xpath("//*[@class=' sort_category   sort_price ']")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@class='sr-cta-button-row'])[1]")));
        element3.click();
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
        driver.findElement(By.xpath("(//*[@id='hp_book_now_button'])[1]")).click();
        driver.findElement(By.xpath("//*[@data-component='hotel/new-rooms-table/reservation-cta']")).click();

        driver.quit();
    }
}