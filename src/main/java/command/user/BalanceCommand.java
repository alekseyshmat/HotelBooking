package command.user;

import command.Command;
import command.CommandResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BalanceCommand implements Command {

    private static final String BALANCE_PAGE = "/WEB-INF/pages/user/balance.jsp";
    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {


        return CommandResult.forward(BALANCE_PAGE);
    }
}
