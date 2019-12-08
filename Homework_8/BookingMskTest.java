import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BookingMskTest {
    private static final String URL = "https://www.booking.com/";
    private static final int affordableHotelRating = 9;

    @Test
    public void bookingMskTest() throws Exception {
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.get(URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement inputSearchField = driver.findElement(
                By.xpath("//*[@aria-label='Type your destination']"));
        inputSearchField.sendKeys("Москва");
        driver.findElement(By.xpath("//*[@data-sb-id='main' and @type='submit']")).click();
        List<WebElement> elementList = driver.findElements(By.xpath("//*[contains(@class, 'sr_item  sr_item_new sr_item_default sr_property_block  ')]"));
        boolean checkHotelsQuantity = elementList.size() > 0;
        Assert.assertTrue(checkHotelsQuantity);
        if (driver.findElement(By.xpath("//*[@class=' sort_category   sort_bayesian_review_score ']")).isDisplayed()) {
            driver.findElement(By.xpath("//*[@class=' sort_category   sort_bayesian_review_score ']")).click();
        } else {
            if (driver.findElement(By.xpath("//*[@id='sortbar_dropdown_button']")).isDisplayed()) {
                driver.findElement(By.xpath("//*[@id='sortbar_dropdown_button']")).click();
            }
            if (driver.findElement(By.xpath("(//a[@role='menuitem'])[3]")).isDisplayed()) {
                driver.findElement(By.xpath("(//a[@role='menuitem'])[3]")).click();
            }
        }

        if (driver.findElement(By.xpath("//*[@class='c2-calendar-close-button-icon']")).isDisplayed()) {
            driver.findElement(By.xpath("//*[@class='c2-calendar-close-button-icon']")).click();
        } else {
            Thread.sleep(2000);
            WebElement element2 = driver.findElement(By.xpath("(//*[@class='hotel_image'])[1]"));
            js.executeScript("arguments[0].scrollIntoView();", element2);
            Thread.sleep(1000);
            element2.click();
        }
        Thread.sleep(3000);
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }

        String hotelRating = driver.findElement(By.xpath("(//*[@class='bui-review-score c-score bui-review-score--end']/div)[1]")).getText();
        double hotelRatingNumber = Double.parseDouble(hotelRating);
        boolean checkHotelRatingNumber = hotelRatingNumber > affordableHotelRating;
        Assert.assertTrue(checkHotelRatingNumber);
    }
}
