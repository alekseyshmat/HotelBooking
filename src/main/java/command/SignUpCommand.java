package command;

import exception.ServiceException;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;

public class SignUpCommand implements Command {

    private static final String LAST_NAME = "lastName";
    private static final String FIRST_NAME = "firstName";
    private static final String EMAIL = "email";
    private static final String BIRTHDAY = "birthday";
    private static final String LOGIN = "login";
    private static final String PASSWORD = "userPass";
    private static final String START_PAGE = "controller?command=startPage";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        String lastName = request.getParameter(LAST_NAME);
        String firstName = request.getParameter(FIRST_NAME);
        String email = request.getParameter(EMAIL);
        System.out.println(request.getParameter(BIRTHDAY));
        Date birthday = Date.valueOf(request.getParameter(BIRTHDAY));
        String login = request.getParameter(LOGIN);
        String password = request.getParameter(PASSWORD);

        UserService userService = new UserService();
        userService.signUpUser(null, firstName, lastName, email, login, password, birthday);
        return CommandResult.redirect(START_PAGE);
    }
}
