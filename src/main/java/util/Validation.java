package util;

import java.util.Map;

public class Validation {

    private static final String FIRST_NAME = "firstName";
    private static final String LAST_NAME = "lastName";
    private static final String EMAIL = "email";
    private static final String USERNAME = "login";
    private static final String PASSWORD = "userPass";
    private static final String SUM = "sumUp";


    private static final String NAME_PATTERN = "^([a-zA-Z]){3,44}$";
    private static final String EMAIL_PATTERN = "^(\\w+[\\.-]?\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,6})$";
    private static final String USERNAME_PATTERN = "^[a-zA-Z][a-zA-Z0-9-_\\.]{1,20}$";
    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$";
    private static final String SUM_PATTERN = "^([1-9]{1}[0-9]{0,8}\\.?[0-9]{0,2})$";

    private String invalidData;

    private boolean isValid(String pattern, String expression) {
        return expression.matches(pattern);
    }

    private String definePattern(String type) {
        switch (type) {
            case FIRST_NAME:
                return NAME_PATTERN;
            case LAST_NAME:
                return NAME_PATTERN;
            case EMAIL:
                return EMAIL_PATTERN;
            case USERNAME:
                return USERNAME_PATTERN;
            case PASSWORD:
                return PASSWORD_PATTERN;
            case SUM:
                return SUM_PATTERN;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public boolean isValidData(Map<String, String> inputData) {
        for (Map.Entry<String, String> entry : inputData.entrySet()) {
            String value = entry.getValue();
            if (value != null) {
                String key = entry.getKey();
                String pattern = definePattern(key);
                if (!isValid(pattern, value)) {
                    invalidData = key;
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    public String getInvalidData() {
        return invalidData;
    }
}
