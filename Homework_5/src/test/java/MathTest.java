import org.testng.Assert;
import org.testng.annotations.Test;

public class MathTest {
    @Test
    public void sumTest() {
        Math math = new Math();
        int actual = math.sum(2,3);
        int expectedResult = 5;
        Assert.assertEquals(actual,expectedResult, "Error");
    }
}
