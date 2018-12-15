package command.admin.order;

import command.Command;
import command.CommandResult;
import entity.types.OrderStatus;
import exception.ServiceException;
import service.OrderService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class CompleteOrderCommand implements Command {

    private static final String DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";
    private static final String ID = "";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        Integer id = Integer.valueOf(request.getParameter(ID));

        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat(DATE_PATTERN);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_PATTERN);

        String invoiceDate = formatForDateNow.format(dateNow);
        LocalDate d = LocalDate.parse(invoiceDate, formatter);
        OrderService orderService = new OrderService();
        orderService.completeOrder(id, dateNow, OrderStatus.COMPLETED);

        return null;
    }
}
