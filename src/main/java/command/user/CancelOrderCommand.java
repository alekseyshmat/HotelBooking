package command.user;

import command.Command;
import command.CommandResult;
import entity.types.OrderStatus;
import exception.ServiceException;
import service.OrderService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CancelOrderCommand implements Command {

    private static final String ID = "cancelOrderId";
    private static final String CANCEL_COMMAND = "controller?command=showOrders";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        Integer id = Integer.valueOf(request.getParameter(ID));
        OrderService orderService = new OrderService();
        orderService.cancelOrder(id, OrderStatus.CANCELED);

        return CommandResult.redirect(CANCEL_COMMAND);
    }
}
