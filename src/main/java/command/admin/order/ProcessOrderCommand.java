package command.admin.order;

import command.Command;
import command.CommandResult;
import entity.types.OrderStatus;
import exception.ServiceException;
import service.OrderService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;

public class ProcessOrderCommand implements Command {

    private static final String ADMIN_ORDERS = "controller?command=showAllOrders";
    private static final String ID_ORDER = "idOrder";
    private static final String ID_ROOM = "idRoom";
    private static final String COST = "cost";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        HttpSession session = request.getSession();
        Integer idOrder = (Integer) session.getAttribute(ID_ORDER);
        session.removeAttribute(ID_ORDER);
        Integer idRoom = Integer.valueOf(request.getParameter(ID_ROOM));

        String stringCost = request.getParameter(COST);
        BigDecimal cost = new BigDecimal(stringCost);

        OrderService orderService = new OrderService();
        orderService.processOrder(idOrder, idRoom, cost, OrderStatus.SEEN);

        return CommandResult.redirect(ADMIN_ORDERS);
    }
}
