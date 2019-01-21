package command;

import entity.User;
import exception.ServiceException;
import service.UserService;
import util.Validation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Designed to complete sign up process.
 */

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
    private static final String LOGIN_ERROR = "loginError";

    /**
     * Process the request, complete sign up process and generates a result of processing in the form of
     * {@link command.CommandResult} object.
     *
     * @param request  an {@link HttpServletRequest} object that contains client request
     * @param response an {@link HttpServletResponse} object that contains the response the servlet sends to the client
     * @return A response in the form of {@link command.CommandResult} object.
     * @throws ServiceException when RepositoryException is caught.
     */

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        String lastName = request.getParameter(LAST_NAME);
        String firstName = request.getParameter(FIRST_NAME);
        String email = request.getParameter(EMAIL);
        String stringBirthday = request.getParameter(BIRTHDAY);
        Date birthday = Date.valueOf(stringBirthday);
        String login = request.getParameter(LOGIN);
        String password = request.getParameter(PASSWORD);

        Map<String, String> signUpData = new HashMap<>();
        signUpData.put(LAST_NAME, lastName);
        signUpData.put(FIRST_NAME, firstName);
        signUpData.put(EMAIL, email);
        signUpData.put(LOGIN, login);
        signUpData.put(PASSWORD, password);
        signUpData.put(BIRTHDAY, stringBirthday);

        Validation validation = new Validation();
        if (!validation.isValidData(signUpData)) {
            String errorName = validation.getInvalidData();
            request.setAttribute(SIGN_UP_ERROR, errorName);
            return CommandResult.forward(LOGIN_PAGE);
        }


        UserService userService = new UserService();
        Optional<User> optionalUser = userService.findByLogin(login);
        if (optionalUser.isPresent()) {
            request.setAttribute(LOGIN_ERROR, LOGIN);
            return CommandResult.forward(LOGIN_PAGE);
        }
        userService.signUpUser(null, firstName, lastName, email, login, password, birthday);
        return CommandResult.redirect(START_PAGE);
    }
}
