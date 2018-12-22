package command.admin.order;

import command.Command;
import command.CommandResult;
import exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminStartPageCommand implements Command {

    private static final String ADMIN_ORDERS = "/WEB-INF/pages/admin/allOrders.jsp";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        return CommandResult.forward(ADMIN_ORDERS);
    }
}
