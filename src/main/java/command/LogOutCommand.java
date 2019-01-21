package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Designed to complete sign out process.
 */

public class LogOutCommand implements Command {

    private static final String LOGIN_PAGE = "/WEB-INF/pages/login.jsp";
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String ROLE = "role";

    /**
     * Process the request, sing out from profile and generates a result of processing in the form of
     * {@link command.CommandResult} object.
     *
     * @param request  an {@link HttpServletRequest} object that contains client request
     * @param response an {@link HttpServletResponse} object that contains the response the servlet sends to the client
     * @return A response in the form of {@link command.CommandResult} object.
     */

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        session.removeAttribute(ID);
        session.removeAttribute(NAME);
        session.removeAttribute(ROLE);
        return CommandResult.forward(LOGIN_PAGE);
    }
}
