package command.user.order;

import command.Command;
import command.CommandResult;
import entity.types.RoomType;
import exception.ServiceException;
import service.OrderService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Date;

/**
 * Designed to make order.
 */

public class MakeOrderCommand implements Command {

    private static final String MAIN_PAGE = "controller?command=mainPage";

    private static final String ID_CLIENT = "id";
    private static final String CHECK_IN_DATE = "checkInDate";
    private static final String CHECK_OUT_DATE = "checkOutDate";
    private static final String TYPE = "typeRoom";

    /**
     * Process the request, make order and generates a result of processing in the form of
     * {@link command.CommandResult} object.
     *
     * @param request  an {@link HttpServletRequest} object that contains client request
     * @param response an {@link HttpServletResponse} object that contains the response the servlet sends to the client
     * @return A response in the form of {@link command.CommandResult} object.
     * @throws ServiceException when RepositoryException is caught.
     */

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        HttpSession session = request.getSession();
        Integer idClient = (Integer) session.getAttribute(ID_CLIENT);
        String stringCheckInDate = request.getParameter(CHECK_IN_DATE);
        String stringCheckOutDate = request.getParameter(CHECK_OUT_DATE);

        Date checkInDate = Date.valueOf(stringCheckInDate);
        Date checkOutDate = Date.valueOf(stringCheckOutDate);

        String stringRoomType = request.getParameter(TYPE);
        RoomType roomType = RoomType.valueOf(stringRoomType.toUpperCase());

        OrderService orderService = new OrderService();
        orderService.makeOrder(null, idClient, checkInDate, checkOutDate, roomType);

        return CommandResult.redirect(MAIN_PAGE);
    }
}
