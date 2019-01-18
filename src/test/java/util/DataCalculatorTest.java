package util;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.sql.Date;

public class DataCalculatorTest {

    private DateCalculator dateCalculator;
    private static final Date firstDate = Date.valueOf("2019-01-10");
    private static final Date secondDate = Date.valueOf("2019-01-20");
    private static final Date thirdDate = Date.valueOf("2019-01-25");
    private static final Date fourthDate = Date.valueOf("2019-02-01");

    @BeforeClass
    public void setUp() {
        dateCalculator = new DateCalculator();
    }

    @DataProvider(name = "calculateDaysBetweenPositiveTest")
    public Object[][] dataForCalculateDaysBetweenPositiveTest() {
        return new Object[][]{
                {
                        firstDate, secondDate, 10
                },
                {
                        firstDate, thirdDate, 15
                },
                {
                        secondDate, thirdDate, 5
                },
                {
                        thirdDate, fourthDate, 7
                }
        };
    }

    @Test(dataProvider = "calculateDaysBetweenPositiveTest")
    public void calculateDaysBetweenPositiveTest(Date firstDate, Date secondDate, int expected) {
        int actual = dateCalculator.calculateDaysBetween(firstDate, secondDate);

        Assert.assertEquals(actual, expected);
    }
}
