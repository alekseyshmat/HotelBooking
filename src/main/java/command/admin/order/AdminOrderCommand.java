package command.admin.order;

import command.Command;
import command.CommandResult;
import entity.Order;
import entity.types.OrderStatus;
import exception.ServiceException;
import service.OrderService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class AdminOrderCommand implements Command {

    private static final String ADMIN_ORDERS = "/WEB-INF/pages/admin/allOrders.jsp";
    private static final String ORDER_LIST = "orderList";
    private static final String ACTIVE_ORDER_LIST = "activeOrderList";
    private static final String COMPLETED_ORDER_LIST = "completedOrderList";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        OrderService orderService = new OrderService();

        List<Order> orderList = orderService.findByStatus(OrderStatus.INPROCESS);
        request.setAttribute(ORDER_LIST, orderList);

        List<Order> activeOrderList = orderService.findByStatus(OrderStatus.SEEN);
        request.setAttribute(ACTIVE_ORDER_LIST, activeOrderList);

        List<Order> completedOrderList = orderService.findByStatus(OrderStatus.COMPLETED);
        request.setAttribute(COMPLETED_ORDER_LIST, completedOrderList);

        return CommandResult.forward(ADMIN_ORDERS);
    }
}
