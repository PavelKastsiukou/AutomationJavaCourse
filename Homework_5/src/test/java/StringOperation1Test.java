import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class StringOperation1Test {
    @DataProvider
    public Object[][] dataProviderTestGetSumWithMinus() {
        return new Object[][]{{1, 3, -4}, {2, 0, -2}, {0, 0, 0}};
    }

    @DataProvider
    public Object[][] dataProviderTestGetLoanProduct() {
        return new Object[][]{{10, 1000, 5, 100}, {5, 5000, 10, 250}, {50, 10000, 2, 5000}};
    }

    @DataProvider
    public Object[][] dataProviderTestGetCookiesAmount() {
        return new Object[][]{{1, 2, 3, 4, 5, 3}, {100, 20, 30, 44, 15, 1}, {11, 23, 13, 54, 15, 6}};
    }

    @Test(dataProvider = "dataProviderTestGetLoanProduct")
    public void testGetLoanProduct(int lP, int lA, int lT, double expected) {
        StringOperation stringOperation = new StringOperation();
        double actual = stringOperation.getLoanRepaymentSum(lP, lA, lT);
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "dataProviderTestGetCookiesAmount")
    public void testGetCookiesAmount(int s, int f, int e, int w, int sa, int expected) {
        StringOperation stringOperation = new StringOperation();
        int actual = stringOperation.getCookiesAmount(s, f, e, w, sa);
        Assert.assertEquals(actual, expected);
    }

    @Test(enabled = false)
    public void testGetHelloPhrase(String n, String p, String g, String expected) {
        StringOperation stringOperation = new StringOperation();
        String actual = stringOperation.getHelloPhrase(n, p, g);
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "dataProviderTestGetSumWithMinus")
    public void testGetSumWithMinus(int a, int b, int expected) {
        StringOperation stringOperation = new StringOperation();
        int actual = stringOperation.getSumWithMinus(a, b);
        Assert.assertEquals(actual, expected);
    }

    @Test(expectedExceptions = RuntimeException.class)
    public void testValidateEmail() {
        StringOperation stringOperation = new StringOperation();
        try {
            stringOperation.validateEmail("12 3@gmail.com");
        } catch (RuntimeException e) {
            Assert.assertThrows(RuntimeException.class, (Assert.ThrowingRunnable) e);
        }
    }
}