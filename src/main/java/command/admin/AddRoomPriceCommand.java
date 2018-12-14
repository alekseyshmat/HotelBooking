package command.admin;

import command.Command;
import command.CommandResult;
import entity.Room;
import entity.RoomPrice;
import service.RoomPriceService;
import service.RoomService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class AddRoomPriceCommand implements Command {

    private static final String ROOM_PRICES_PAGE = "/WEB-INF/pages/admin/roomPrices.jsp";
    private static final String PRICE_LIST = "roomPriceList";
    private static final String ROOM_ID = "roomId";
    private static final String START_DATE = "startDate";
    private static final String END_DATE = "endDate";
    private static final String COST = "cost";
    private static final String DATE_PATTERN = "yyyy-MM-dd";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        String stringRoomId = request.getParameter(ROOM_ID);
        String stringStartDate = request.getParameter(START_DATE);
        String stringEndDate = request.getParameter(END_DATE);

        int roomId = Integer.parseInt(stringRoomId);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_PATTERN);

        LocalDate startDate = LocalDate.parse(stringStartDate, formatter);
        LocalDate endDate = LocalDate.parse(stringEndDate, formatter);

        String stringCost = request.getParameter(COST);
        BigDecimal cost = BigDecimal.valueOf(Long.parseLong(stringCost));

        RoomPriceService roomPriceService = new RoomPriceService();
        roomPriceService.addPrice(roomId, startDate, endDate, cost);

        List<RoomPrice> roomPriceList = roomPriceService.findAll();
        request.setAttribute(PRICE_LIST, roomPriceList);

        RoomService roomService = new RoomService();
        List<Room> roomList = roomService.findAll();
        request.setAttribute("roomList", roomList);

        return CommandResult.redirect(ROOM_PRICES_PAGE);
    }
}
