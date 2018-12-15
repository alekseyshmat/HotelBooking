package command.admin.order;

import command.Command;
import command.CommandResult;
import entity.types.OrderStatus;
import exception.ServiceException;
import service.OrderService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;

public class ProcessOrderCommand implements Command {

    private static final String ADMIN_ORDERS = "/WEB-INF/pages/admin/allOrders.jsp";
    private static final String ID = "id";
    private static final String ID_ROOM = "idRoom";
    private static final String COST = "cost";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        Integer id = Integer.valueOf(request.getParameter(ID));

        BigDecimal cost = BigDecimal.valueOf(Long.parseLong(request.getParameter(COST)));

        int idRoom = Integer.valueOf(request.getParameter(ID_ROOM));

        OrderService orderService = new OrderService();
        orderService.processOrder(id, idRoom, cost, OrderStatus.SEEN);

        return CommandResult.redirect(ADMIN_ORDERS);
    }
}
