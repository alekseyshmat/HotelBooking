package util;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class ValidationTest {

    private Validation validation;

    @BeforeClass
    public void setUp() {
        validation = new Validation();
    }

    @DataProvider(name = "isValidDataStringParametersPositiveTest")
    public Object[][] dataForValidationStringParametersPositiveTest() {
        return new Object[][]{
                {
                        "firstName", "Aleksey"
                },
                {
                        "lastName", "Shmat"
                },
                {
                        "email", "leha.2409@mail.ru"
                },
                {
                        "userPass", "12345678zA"
                },
                {
                        "cost", "1050.00"
                }
        };
    }

    @DataProvider(name = "isValidDataStringParametersNegativeTest")
    public Object[][] dataForValidationStringParametersNegativeTest() {
        return new Object[][]{
                {
                        "firstName", "a"
                },
                {
                        "lastName", "b"
                },
                {
                        "email", "leha"
                },
                {
                        "userPass", "1234z"
                },
                {
                        "cost", "-1050"
                },
                {
                        "activeId", null
                }
        };
    }

    @DataProvider(name = "isValidDataMapParametersPositiveTest")
    public Object[][] dataForValidationMapParametersPositiveTest() {
        Map<String, String> firstMap = new HashMap<>();
        firstMap.put("firstName", "Aleksey");
        firstMap.put("cost", "1050.00");
        return new Object[][]{
                {
                        firstMap
                }
        };
    }

    @DataProvider(name = "isValidDataMapParametersNegativeTest")
    public Object[][] dataForValidationMapParametersNegativeTest() {
        Map<String, String> testMap = new HashMap<>();
        testMap.put("userPass", "1234z");
        testMap.put("cost", "-1050");
        testMap.put("activeId", null);
        return new Object[][]{
                {
                    testMap
                }
        };
    }


    @Test(dataProvider = "isValidDataStringParametersPositiveTest")
    public void isValidDataStringParametersPositiveTest(String key, String value) {
        boolean actual = validation.isValidData(key, value);

        Assert.assertTrue(actual);
    }

    @Test(dataProvider = "isValidDataStringParametersNegativeTest")
    public void isValidDataStringParametersNegativeTest(String key, String value) {
        boolean actual = validation.isValidData(key, value);

        Assert.assertFalse(actual);
    }

    @Test(dataProvider = "isValidDataMapParametersPositiveTest")
    public void isValidDataMapParametersPositiveTest(Map<String, String> inputData) {
        boolean actual = validation.isValidData(inputData);

        Assert.assertTrue(actual);
    }

    @Test(dataProvider = "isValidDataMapParametersNegativeTest")
    public void isValidDataMapParametersNegativeTest(Map<String, String> inputData) {
        boolean actual = validation.isValidData(inputData);

        Assert.assertFalse(actual);
    }

}

