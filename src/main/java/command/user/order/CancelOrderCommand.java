package command.user.order;

import command.Command;
import command.CommandResult;
import entity.types.OrderStatus;
import exception.ServiceException;
import service.OrderService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Designed to cancel order.
 */

public class CancelOrderCommand implements Command {

    private static final String ID = "cancelOrderId";
    private static final String CANCEL_COMMAND = "controller?command=showOrders";

    /**
     * Process the request, cancel order and generates a result of processing in the form of
     * {@link command.CommandResult} object.
     *
     * @param request  an {@link HttpServletRequest} object that contains client request
     * @param response an {@link HttpServletResponse} object that contains the response the servlet sends to the client
     * @return A response in the form of {@link command.CommandResult} object.
     * @throws ServiceException when RepositoryException is caught.
     */

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        Integer id = Integer.valueOf(request.getParameter(ID));
        OrderService orderService = new OrderService();
        orderService.cancelOrder(id, OrderStatus.CANCELED);

        return CommandResult.redirect(CANCEL_COMMAND);
    }
}
