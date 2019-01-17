package command;

import exception.ServiceException;
import service.UserService;
import util.Validation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

public class SignUpCommand implements Command {

    private static final String LAST_NAME = "lastName";
    private static final String FIRST_NAME = "firstName";
    private static final String EMAIL = "email";
    private static final String BIRTHDAY = "birthday";
    private static final String LOGIN = "login";
    private static final String PASSWORD = "userPass";
    private static final String START_PAGE = "controller?command=startLogin";
    private static final String LOGIN_PAGE = "/WEB-INF/pages/login.jsp";
    private static final String SIGN_UP_ERROR = "signUpError";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        String lastName = request.getParameter(LAST_NAME);
        String firstName = request.getParameter(FIRST_NAME);
        String email = request.getParameter(EMAIL);
        Date birthday = Date.valueOf(request.getParameter(BIRTHDAY));
        String login = request.getParameter(LOGIN);
        String password = request.getParameter(PASSWORD);

        Map<String, String> signUpData = new HashMap<>();
        signUpData.put(LAST_NAME, lastName);
        signUpData.put(FIRST_NAME, firstName);
        signUpData.put(EMAIL, email);
        signUpData.put(LOGIN, login);
        signUpData.put(PASSWORD, password);

        Validation validation = new Validation();
        if (!validation.isValidData(signUpData)) {
            String errorName = validation.getInvalidData();
            request.setAttribute(SIGN_UP_ERROR, errorName);
            return CommandResult.forward(LOGIN_PAGE);
        }

        UserService userService = new UserService();
        userService.signUpUser(null, firstName, lastName, email, login, password, birthday);
        return CommandResult.redirect(START_PAGE);
    }
}
