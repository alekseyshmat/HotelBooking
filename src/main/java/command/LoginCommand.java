package command;

import entity.User;
import entity.types.BlockingStatus;
import entity.types.Role;
import exception.ServiceException;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Optional;

/**
 * Designed to login users.
 */

public class LoginCommand implements Command {

    private static final String MAIN_PAGE = "controller?command=mainPage";
    private static final String ADMIN_PAGE = "controller?command=showAllOrders";
    private static final String LOGIN_PAGE = "/WEB-INF/pages/login.jsp";
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String ROLE = "role";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    private static final String ERROR_MESSAGE = "errorMessage";
    private static final String WRONG_PARAMETER = "Wrong login or password";
    private static final String BLOCKING_ACCOUNT = "Your account is blocked";

    /**
     * Process the request, login and generates a result of processing in the form of
     * {@link command.CommandResult} object.
     *
     * @param request  an {@link HttpServletRequest} object that contains client request
     * @param response an {@link HttpServletResponse} object that contains the response the servlet sends to the client
     * @return A response in the form of {@link command.CommandResult} object.
     * @throws ServiceException when RepositoryException is caught.
     */

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        HttpSession session = request.getSession();
        UserService service = new UserService();
        String login = request.getParameter(USERNAME);
        String password = request.getParameter(PASSWORD);
        Optional<User> optionalUser = service.login(login, password);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();

            BlockingStatus blockingStatus = user.getBlockingStatus();
            if (blockingStatus.equals(BlockingStatus.BLOCKED)) {
                request.setAttribute(ERROR_MESSAGE, BLOCKING_ACCOUNT);
                return CommandResult.forward(LOGIN_PAGE);
            }

            Integer id = user.getId();
            Role role = user.getRole();
            String name = user.getFirstName();

            session.setAttribute(ID, id);
            session.setAttribute(NAME, name);
            session.setAttribute(ROLE, role);
            return Role.ADMIN.equals(role) ?
                    CommandResult.redirect(ADMIN_PAGE) :
                    CommandResult.redirect(MAIN_PAGE);
        } else {
            request.setAttribute(ERROR_MESSAGE, WRONG_PARAMETER);
            return CommandResult.forward(LOGIN_PAGE);
        }
    }
}
