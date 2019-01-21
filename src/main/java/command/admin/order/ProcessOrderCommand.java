package command.admin.order;

import command.Command;
import command.CommandResult;
import entity.Order;
import entity.types.OrderStatus;
import exception.ServiceException;
import service.OrderService;
import service.RoomBusyService;
import util.DateCalculator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Optional;

/**
 * Designed to process orders.
 */

public class ProcessOrderCommand implements Command {

    private static final String ADMIN_ORDERS = "controller?command=showAllOrders";
    private static final String ID_ORDER = "idOrder";
    private static final String ID_ROOM = "idRoom";
    private static final String COST = "cost";

    /**
     * Process the request, process order and generates a result of processing in the form of
     * {@link command.CommandResult} object.
     *
     * @param request  an {@link HttpServletRequest} object that contains client request
     * @param response an {@link HttpServletResponse} object that contains the response the servlet sends to the client
     * @return A response in the form of {@link command.CommandResult} object.
     * @throws ServiceException when RepositoryException is caught.
     */

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        DateCalculator dateCalculator = new DateCalculator();
        HttpSession session = request.getSession();
        Integer idOrder = (Integer) session.getAttribute(ID_ORDER);
        session.removeAttribute(ID_ORDER);
        Integer idRoom = Integer.valueOf(request.getParameter(ID_ROOM));

        String stringCost = request.getParameter(COST);
        BigDecimal cost = new BigDecimal(stringCost);

        OrderService orderService = new OrderService();
        Optional<Order> optionalOrder = orderService.findById(idOrder);

        Date startDate = null;
        Date endDate = null;
        int days = 1;
        if (optionalOrder.isPresent()) {
            Order order = optionalOrder.get();
            startDate = order.getCheckInDate();
            endDate = order.getCheckOutDate();
            days = dateCalculator.calculateDaysBetween(startDate, endDate);
        }

        BigDecimal overallCost = cost.multiply(new BigDecimal(days));
        orderService.processOrder(idOrder, idRoom, overallCost, OrderStatus.SEEN);

        RoomBusyService roomBusyService = new RoomBusyService();
        roomBusyService.addBusyRoom(null, idRoom, startDate, endDate);

        return CommandResult.redirect(ADMIN_ORDERS);
    }
}
