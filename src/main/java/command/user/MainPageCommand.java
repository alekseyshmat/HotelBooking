package command.user;

import command.Command;
import command.CommandResult;
import exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainPageCommand implements Command {

    private static final String MAIN_PAGE = "/WEB-INF/pages/makeOrder.jsp";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        return CommandResult.forward(MAIN_PAGE);
    }
}
