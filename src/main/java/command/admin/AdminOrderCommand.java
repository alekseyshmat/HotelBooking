package command.admin;

import command.Command;
import command.CommandResult;
import entity.Order;
import entity.types.OrderStatus;
import service.OrderService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class AdminOrderCommand implements Command {

    private static final String ADMIN_ORDERS = "/WEB-INF/pages/admin/allOrders.jsp";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        OrderService orderService = new OrderService();
        List<Order> orderList = orderService.findByStatus(OrderStatus.INPROCESS);
        request.setAttribute("orderList", orderList);

        return CommandResult.forward(ADMIN_ORDERS);
    }
}
