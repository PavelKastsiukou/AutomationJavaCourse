import org.testng.Assert;
import org.testng.annotations.*;


public class StringOperationsTest {

    @DataProvider
    public Object[][] dataProviderTestGetLength() {
        return new Object[][]{{"abc", 3}, {"", 0}, {"  hhh", 5}};
    }

    @DataProvider
    public Object[][] dataProviderTestGetSum() {
        return new Object[][]{{"abc", "cab", "abccab"}, {"aaa", "bbb", "aaabbb"}, {"vvv", "nnn", "vvvnnn"}};
    }

    @DataProvider
    public Object[][] dataProviderTestGetReverseSum() {
        return new Object[][]{{"aaa", "bbb","ccc", "cccbbbaaa"}, {"a", "b","c", "cba"}, {"","","",""}};
    }

    @Test(dataProvider = "dataProviderTestGetSum")
    public void testGetSum(String str1, String str2, String expected) {
        StringOperations stringOperations = new StringOperations();
        String actual = stringOperations.getSum(str1, str2);
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "dataProviderTestGetReverseSum")
    public void testGetReverseSum(String s, String s2, String s3, String expected) {
        StringOperations stringOperations = new StringOperations();
        String actual = stringOperations.getReverseSum(s, s2, s3);
        Assert.assertEquals(actual, expected);
    }

    @Test(dataProvider = "dataProviderTestGetLength")
    public void testGetLength(String str, int expected) {
        StringOperations stringOperations = new StringOperations();
        int actual = stringOperations.getLength(str);
        Assert.assertEquals(actual, expected, "Error");
    }
}