package command.admin;

import command.Command;
import command.CommandResult;
import service.RoomPriceService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AddRoomPriceCommand implements Command {

    private static final String ROOM_PRICES_PAGE = "/WEB-INF/pages/admin/roomPrices.jsp";
    private static final String ROOM_NUMBER = "roomNumber";
    private static final String START_DATE = "startDate";
    private static final String END_DATE = "endDate";
    private static final String COST = "cost";
    private static final String DATE_PATTERN = "yyyy-MM-dd";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        String stringRoomNumber = request.getParameter(ROOM_NUMBER);
        String stringStartDate = request.getParameter(START_DATE);
        String stringEndDate = request.getParameter(END_DATE);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_PATTERN);

        LocalDate startDate = LocalDate.parse(stringStartDate, formatter);
        LocalDate endDate = LocalDate.parse(stringEndDate, formatter);

        String stringCost = request.getParameter(COST);
        BigDecimal cost = BigDecimal.valueOf(Long.parseLong(stringCost));

        RoomPriceService roomPriceService = new RoomPriceService();
        roomPriceService.addPrice(stringRoomNumber, startDate, endDate, cost);

        return CommandResult.redirect(ROOM_PRICES_PAGE);
    }
}
