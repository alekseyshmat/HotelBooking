package command.user;

import command.Command;
import command.CommandResult;
import entity.types.RoomType;
import exception.ServiceException;
import service.OrderService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Date;

public class MakeOrderCommand implements Command {

    private static final String MAIN_PAGE = "controller?command=mainPage";

    private static final String ID_CLIENT = "id";
    private static final String CHECK_IN_DATE = "checkInDate";
    private static final String CHECK_OUT_DATE = "checkOutDate";
    private static final String TYPE = "typeRoom";

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
