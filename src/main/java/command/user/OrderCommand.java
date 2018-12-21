package command.user;

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

public class OrderCommand implements Command {

    private static final String USER_ORDERS = "/WEB-INF/pages/user/orders.jsp";
    private static final String ID = "id";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        HttpSession session = request.getSession();
        Integer id = (Integer) session.getAttribute(ID);

        OrderService orderService = new OrderService();
        List<Order> orderList = orderService.findByIdAndStatus(id, OrderStatus.INPROCESS);
        List<Order> activeOrderList = orderService.findByIdAndStatus(id, OrderStatus.SEEN);
        List<Order> completedOrderList = orderService.findByIdAndTwoStatus(id, OrderStatus.COMPLETED, OrderStatus.CANCELED);

        request.setAttribute("userOrderList", orderList);
        request.setAttribute("activeOrderList", activeOrderList);
        request.setAttribute("completedOrderList", completedOrderList);

        return CommandResult.forward(USER_ORDERS);
    }
}
