package command.admin.room;

import command.Command;
import command.CommandResult;
import exception.ServiceException;
import service.RoomPriceService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AddRoomPriceCommand implements Command {

    private static final String ROOM_PRICES_PAGE = "controller?command=showRoomPrices&roomId=";
    private static final String ROOM_LIMIT = "&roomLimit=";
    private static final String ROOM_PAGE = "&roomPage=";
    private static final String ROOM_ID = "roomId";
    private static final String START_DATE = "startDate";
    private static final String END_DATE = "endDate";
    private static final String COST = "cost";
    private static final String LIMIT = "limit";
    private static final String PAGE = "roomPage";
    private static final String DATE_PATTERN = "yyyy-MM-dd";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        String stringRoomId = request.getParameter(ROOM_ID);
        String stringStartDate = request.getParameter(START_DATE);
        String stringEndDate = request.getParameter(END_DATE);

        Integer roomId = Integer.parseInt(stringRoomId);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_PATTERN);

        LocalDate startDate = LocalDate.parse(stringStartDate, formatter);
        LocalDate endDate = LocalDate.parse(stringEndDate, formatter);

        String stringCost = request.getParameter(COST);
        BigDecimal cost = new BigDecimal(stringCost);

        RoomPriceService roomPriceService = new RoomPriceService();
        roomPriceService.addPrice(null, roomId, startDate, endDate, cost);

      /*  List<RoomPrice> roomPriceList = roomPriceService.findAll();
        request.setAttribute(PRICE_LIST, roomPriceList);

        RoomService roomService = new RoomService();
        List<Room> roomList = roomService.findAll();
        request.setAttribute("roomList", roomList);*/
        String limit = request.getParameter(LIMIT);
        String page = request.getParameter(PAGE);
        return CommandResult.redirect(ROOM_PRICES_PAGE + stringRoomId + ROOM_LIMIT + limit + ROOM_PAGE + page);
    }
}
