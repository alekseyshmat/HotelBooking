package command.admin.order;

import command.Command;
import command.CommandResult;
import exception.ServiceException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Designed to forward on admin orders page.
 */

public class AdminStartPageCommand implements Command {

    private static final String ADMIN_ORDERS = "/WEB-INF/pages/admin/roomSelection.jsp";

    /**
     * Process the request, forward to page and generates a result of processing in the form of
     * {@link command.CommandResult} object.
     *
     * @param request  an {@link HttpServletRequest} object that contains client request
     * @param response an {@link HttpServletResponse} object that contains the response the servlet sends to the client
     * @return A response in the form of {@link command.CommandResult} object.
     * @throws ServiceException when RepositoryException is caught.
     */

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        return CommandResult.forward(ADMIN_ORDERS);
    }
}
