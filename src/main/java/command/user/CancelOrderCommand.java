package command.user;

import command.Command;
import command.CommandResult;
import exception.ServiceException;
import service.OrderService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CancelOrderCommand implements Command {

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        OrderService orderService = new OrderService();
//        orderService.ca

        return new OrderCommand().execute(request, response);
    }
}
