package command.user.order;

import command.Command;
import command.CommandResult;
import entity.Order;
import entity.User;
import entity.types.OrderStatus;
import entity.types.Role;
import exception.ServiceException;
import service.OrderService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Designed to map orders.
 */

public class OrderCommand implements Command {

    private static final String USER_ORDERS = "/WEB-INF/pages/user/orders.jsp";
    private static final String ID = "id";
    private static final String USER_ORDER_LIST = "userOrderList";
    private static final String ACTIVE_ORDER_LIST = "activeOrderList";
    private static final String COMPLETED_ORDER_LIST = "completedOrderList";
    private static final String MESSAGE = "message";

    /**
     * Process the request, map orders and generates a result of processing in the form of
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
        Integer id = (Integer) session.getAttribute(ID);

        OrderService orderService = new OrderService();
        List<Order> orderList = orderService.findByIdAndStatus(id, OrderStatus.INPROCESS);
        List<Order> activeOrderList = orderService.findByIdAndStatus(id, OrderStatus.SEEN);
        List<Order> completedOrderList = orderService.findByIdAndTwoStatus(id, OrderStatus.COMPLETED, OrderStatus.CANCELED);

        request.setAttribute(USER_ORDER_LIST, orderList);
        request.setAttribute(ACTIVE_ORDER_LIST, activeOrderList);
        request.setAttribute(COMPLETED_ORDER_LIST, completedOrderList);

        String message = request.getParameter(MESSAGE);
        if (message != null) {
            request.setAttribute(MESSAGE, message);
        }
        return CommandResult.forward(USER_ORDERS);
    }
}
