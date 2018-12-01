package command.admin;

import command.Command;
import command.CommandResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserCommand implements Command {

    private static final String USERS_PAGE = "/WEB-INF/pages/admin/users.jsp";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        return CommandResult.forward(USERS_PAGE);
    }
}
