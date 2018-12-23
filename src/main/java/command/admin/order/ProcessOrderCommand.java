package command.admin.order;

import command.Command;
import command.CommandResult;
import entity.Order;
import entity.RoomBusy;
import entity.types.OrderStatus;
import exception.ServiceException;
import service.OrderService;
import service.RoomBusyService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Optional;

public class ProcessOrderCommand implements Command {

    private static final String ADMIN_ORDERS = "controller?command=showAllOrders";
    private static final String ID_ORDER = "idOrder";
    private static final String ID_ROOM = "idRoom";
    private static final String COST = "cost";
    private static final String CHECK_IN_DATE = "checkInDate";
    private static final String CHECK_OUT_DATE = "checkOutDate";

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

        Optional<Order> optionalOrder = orderService.findById(idOrder);

        Date startDate = null;
        Date endDate = null;
        if (optionalOrder.isPresent()) {
            Order order = optionalOrder.get();
            startDate = order.getCheckInDate();
            endDate = order.getCheckOutDate();
        }

        RoomBusyService roomBusyService = new RoomBusyService();
        roomBusyService.addBusyRoom(null, idRoom, startDate, endDate);

        return CommandResult.redirect(ADMIN_ORDERS);
    }
}
