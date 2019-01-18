package util;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PagesDelimiterTest {

    private PagesDelimiter<Object> pagesDelimiter;


    @BeforeClass
    public void setUp() {
        pagesDelimiter = new PagesDelimiter<>();
    }

    @DataProvider(name = "calculatePagesPositiveTest")
    public Object[][] dataForCalculatePagesPositiveTest() {
        return new Object[][]{
                {
                        Arrays.asList(          //input itemList
                                new Object(),
                                new Object(),
                                new Object(),
                                new Object(),
                                new Object(),
                                new Object()
                        ),
                        5,                      //input limit
                        Arrays.asList(1, 2)                      //expected count of pages
                },
                {
                        Arrays.asList(          //input itemList
                                new Object(),
                                new Object(),
                                new Object(),
                                new Object(),
                                new Object()
                        ),
                        5,                      //input limit
                        Collections.singletonList(1)                      //expected count of pages
                }
        };
    }

    @Test(dataProvider = "calculatePagesPositiveTest")
    public void calculatePagesPositiveTest(List<Object> itemList, int limit, List<Integer> expected) {
        List<Integer> actual = pagesDelimiter.calculatePages(itemList, limit);

        Assert.assertEquals(actual, expected);
    }
}
