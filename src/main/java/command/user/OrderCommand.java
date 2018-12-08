package command.user;

import command.Command;
import command.CommandResult;
import entity.Order;
import entity.User;
import entity.types.OrderStatus;
import entity.types.Role;
import service.OrderService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class OrderCommand implements Command {

    private static final String USER_ORDERS = "/WEB-INF/pages/user/orders.jsp";
    private static final String ID = "id";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        int id = (int) session.getAttribute(ID);

        OrderService orderService = new OrderService();
        List<Order> orderList = orderService.findByIdAndStatus(id, OrderStatus.INPROCESS);
        request.setAttribute("userOrderList", orderList);
        return CommandResult.forward(USER_ORDERS);
    }
}
