package command.admin.room;

import command.Command;
import command.CommandResult;
import entity.Room;
import entity.RoomBusy;
import entity.types.RoomType;
import exception.ServiceException;
import service.RoomBusyService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class SearchRoomByCriteria implements Command {

//    private static final String SELECT_PAGE = "controller?command=searchRoomByCriteria";
    private static final String SELECT_PAGE = "/WEB-INF/pages/admin/roomSelection.jsp";
    private static final String ROOMS_LIST = "roomsWithCriteria";
    private static final String ID = "id";
    private static final String IN_DATE = "inDate";
    private static final String OUT_DATE = "outDate";
    private static final String TYPE = "type";
    private static final String DATE_PATTERN = "yyyy-MM-dd";
    private static final String ID_ORDER = "idOrder";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        Integer orderId = Integer.valueOf(request.getParameter(ID));
        HttpSession session = request.getSession();
        session.setAttribute(ID_ORDER, orderId);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_PATTERN);

        Date checkInDate = Date.valueOf(request.getParameter(IN_DATE));
//        LocalDate checkInDate = LocalDate.parse(request.getParameter(IN_DATE), formatter);
//        LocalDate checkOutDate = LocalDate.parse(request.getParameter(OUT_DATE), formatter);
        Date checkOutDate = Date.valueOf(request.getParameter(OUT_DATE));
        RoomType roomType = RoomType.valueOf(request.getParameter(TYPE));

        RoomBusyService roomBusyService = new RoomBusyService();
        List<RoomBusy> roomsWithCriteria = roomBusyService.findAllByCriteria(roomType, checkInDate, checkOutDate);
        request.setAttribute(ROOMS_LIST, roomsWithCriteria);
        System.out.println(roomsWithCriteria.get(0).getRoom().getId());
        return CommandResult.forward(SELECT_PAGE);
    }
}
