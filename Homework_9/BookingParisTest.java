import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BookingParisTest {
    private static final String URL = "https://www.booking.com/";
    private static final LocalDate actualDate = LocalDate.now();
    LocalDate actualDatePlusThreeDays = LocalDate.parse(actualDate.plusDays(3).format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
    LocalDate actualDatePlusTenDays = LocalDate.parse(actualDatePlusThreeDays.plusDays(7).format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));

    @Test
    public void bookingParisTest() throws Exception {
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
        driver.findElement(By.xpath("//*[@class=' sort_category   sort_price ']")).click();

        List<WebElement> elementList = driver.findElements(By.xpath("//*[@class='sr_item  sr_item_new sr_item_default sr_property_block  sr_flex_layout                 ']"));
        boolean checkHotelsQuantity = elementList.size() > 0;
        System.out.println(elementList.size());
        Assert.assertTrue(checkHotelsQuantity);
        WebElement element = driver.findElement(By.xpath("(//label[@class='bui-checkbox']/div[@class='bui-checkbox__label filter_item css-checkbox'])[1]"));
        js.executeScript("arguments[0].scrollIntoView();", element);
        element.click();
        List<WebElement> elementList2 = driver.findElements(By.xpath("//*[@class='sr_item  sr_item_new sr_item_default sr_property_block  sr_flex_layout                 ']"));
        boolean checkHotelsQuantity2 = elementList2.size() > 0;
        Assert.assertTrue(checkHotelsQuantity2);

        driver.quit();
    }
}