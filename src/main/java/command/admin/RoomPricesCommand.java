package command.admin;

import command.Command;
import command.CommandResult;
import entity.Room;
import entity.RoomPrice;
import service.RoomPriceService;
import service.RoomService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class RoomPricesCommand implements Command {

    private static final String ROOM_PRICES_PAGE = "/WEB-INF/pages/admin/roomPrices.jsp";
    private static final String PRICE_LIST = "roomPriceList";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        RoomPriceService roomPriceService = new RoomPriceService();
        List<RoomPrice> roomPriceList = roomPriceService.findAll();

        RoomService roomService = new RoomService();
        List<Room> roomList = roomService.findAll();

        request.setAttribute("roomList", roomList);
        request.setAttribute(PRICE_LIST, roomPriceList);
        return CommandResult.forward(ROOM_PRICES_PAGE);
    }
}
