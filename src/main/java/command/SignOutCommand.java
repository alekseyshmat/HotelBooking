package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignOutCommand implements Command {

    private static final String LOGIN_PAGE = "/WEB-INF/pages/login.jsp";
    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        return CommandResult.redirect(LOGIN_PAGE);
    }
}
