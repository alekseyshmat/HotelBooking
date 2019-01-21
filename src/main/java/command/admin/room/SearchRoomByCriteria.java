package command.admin.room;

import command.Command;
import command.CommandResult;
import entity.RoomBusy;
import entity.types.RoomType;
import exception.ServiceException;
import service.RoomBusyService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.util.List;

/**
 * Designed to search rooms by criteria.
 */

public class SearchRoomByCriteria implements Command {

    private static final String SELECT_PAGE = "/WEB-INF/pages/admin/roomSelection.jsp";
    private static final String ROOMS_LIST = "roomsWithCriteria";
    private static final String ID = "id";
    private static final String IN_DATE = "inDate";
    private static final String OUT_DATE = "outDate";
    private static final String TYPE = "type";
    private static final String ID_ORDER = "idOrder";

    /**
     * Process the request, search rooms by criteria and generates a result of processing in the form of
     * {@link command.CommandResult} object.
     *
     * @param request  an {@link HttpServletRequest} object that contains client request
     * @param response an {@link HttpServletResponse} object that contains the response the servlet sends to the client
     * @return A response in the form of {@link command.CommandResult} object.
     * @throws ServiceException when RepositoryException is caught.
     */

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        Integer orderId = Integer.valueOf(request.getParameter(ID));
        HttpSession session = request.getSession();
        session.setAttribute(ID_ORDER, orderId);


        Date checkInDate = Date.valueOf(request.getParameter(IN_DATE));
        Date checkOutDate = Date.valueOf(request.getParameter(OUT_DATE));
        RoomType roomType = RoomType.valueOf(request.getParameter(TYPE));

        RoomBusyService roomBusyService = new RoomBusyService();
        List<RoomBusy> roomsWithCriteria = roomBusyService.findAllByCriteria(roomType, checkInDate, checkOutDate);
        request.setAttribute(ROOMS_LIST, roomsWithCriteria);
        return CommandResult.forward(SELECT_PAGE);
    }
}
