package PVTcourses;


import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class App4Test {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {

        assertTrue(true);
    }

    @Test
    public void testGetSumNumbers() {
        App app = new App();
        int actual = app.getSumNumbers(1, 2);
        Assert.assertEquals(actual, 3);
    }
}
