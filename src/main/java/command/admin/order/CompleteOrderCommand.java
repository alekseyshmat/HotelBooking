package command.admin.order;

import command.Command;
import command.CommandResult;
import entity.types.OrderStatus;
import exception.ServiceException;
import service.OrderService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CompleteOrderCommand implements Command {

    private static final String ADMIN_ORDERS = "controller?command=showAllOrders";
    private static final String DATE_PATTERN = "yyyy-MM-dd";
    private static final String ID = "activeId";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        Integer id = Integer.valueOf(request.getParameter(ID));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_PATTERN);
        LocalDate currentDate = LocalDate.parse(LocalDate.now().format(formatter), formatter);

        OrderService orderService = new OrderService();
        orderService.completeOrder(id, currentDate, OrderStatus.COMPLETED);

        return CommandResult.redirect(ADMIN_ORDERS);
    }
}
