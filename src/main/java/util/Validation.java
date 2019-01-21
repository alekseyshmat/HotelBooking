package util;

import java.util.Map;

public class Validation {

    private static final String FIRST_NAME = "firstName";
    private static final String LAST_NAME = "lastName";
    private static final String EMAIL = "email";
    private static final String USERNAME = "login";
    private static final String PASSWORD = "userPass";
    private static final String SUM = "sumUp";
    private static final String PAGE_NUMBER = "pageNumber";
    private static final String ADD_ROOM_NUMBER = "addRoomNumber";
    private static final String EDIT_ROOM_NUMBER = "editRoomNumber";
    private static final String ROOM_ID = "roomId";
    private static final String COST = "cost";
    private static final String ACTIVE_ID = "activeId";
    private static final String LIMIT = "limit";
    private static final String PAGE = "roomPage";
    private static final String BIRTHDAY = "birthday";

    private static final String NAME_PATTERN = "^([a-zA-Z]){3,44}$";
    private static final String EMAIL_PATTERN = "^(\\w+[\\.-]?\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,6})$";
    private static final String USERNAME_PATTERN = "^[a-zA-Z][a-zA-Z0-9-_\\.]{1,20}$";
    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$";
    private static final String SUM_PATTERN = "^([1-9]{1}[0-9]{0,8}\\.?[0-9]{0,2})$";
    private static final String ROOM_NUMBER_PATTERN = "^([A-Za-z1-9]{1}[A-Za-z0-9]{0,9})$";
    private static final String ID_PATTERN = "^([1-9]{1}[0-9]{0,10})$";
    private static final String PAGE_PATTERN = "^([1-9]{1}[0-9]*)$";
    private static final String DATE_PATTERN = "^([1|2]{1}[0-9]{3}-[0-9]{1,2}-[0-9]{1,2})$";

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
            case COST:
                return SUM_PATTERN;
            case ADD_ROOM_NUMBER:
                return ROOM_NUMBER_PATTERN;
            case EDIT_ROOM_NUMBER:
                return ROOM_NUMBER_PATTERN;
            case ROOM_ID:
                return ID_PATTERN;
            case ACTIVE_ID:
                return ID_PATTERN;
            case LIMIT:
                return PAGE_PATTERN;
            case PAGE:
                return PAGE_PATTERN;
            case PAGE_NUMBER:
                return PAGE_PATTERN;
            case BIRTHDAY:
                return DATE_PATTERN;
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

    public boolean isValidData(String key, String value) {
        if (value != null) {
            String pattern = definePattern(key);
            if (!isValid(pattern, value)) {
                invalidData = key;
                return false;
            }
        } else {
            return false;
        }
        return true;
    }


    public String getInvalidData() {
        return invalidData;
    }
}
