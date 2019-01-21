package command.admin.room;

import command.Command;
import command.CommandResult;
import entity.Room;
import entity.RoomPrice;
import exception.ServiceException;
import service.RoomPriceService;
import service.RoomService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Designed to map prices for room.
 */

public class RoomPricesCommand implements Command {

    private static final String ROOM_PRICES_PAGE = "/WEB-INF/pages/admin/roomPrices.jsp";
    private static final String PRICE_LIST = "roomPriceList";
    private static final String ROOM_LIST = "roomList";
    private static final String ROOM_ID = "roomId";
    private static final String ROOM_LIMIT = "roomLimit";
    private static final String ROOM_PAGE = "roomPage";
    private static final String ROOM_NUMBER = "roomNumber";
    private static final String MESSAGE = "message";
    private static final Integer ROOM_INDEX = 0;

    /**
     * Process the request, map prices for room and generates a result of processing in the form of
     * {@link command.CommandResult} object.
     *
     * @param request  an {@link HttpServletRequest} object that contains client request
     * @param response an {@link HttpServletResponse} object that contains the response the servlet sends to the client
     * @return A response in the form of {@link command.CommandResult} object.
     * @throws ServiceException when RepositoryException is caught.
     */

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        Integer roomPageLimit = Integer.valueOf(request.getParameter(ROOM_LIMIT));
        request.setAttribute(ROOM_LIMIT, roomPageLimit);

        Integer roomPage = Integer.valueOf(request.getParameter(ROOM_PAGE));
        request.setAttribute(ROOM_PAGE, roomPage);

        RoomPriceService roomPriceService = new RoomPriceService();
        Integer roomId = Integer.valueOf(request.getParameter(ROOM_ID));
        List<RoomPrice> roomPriceList = roomPriceService.findAll(roomId);

        if (roomPriceList.size() != 0) {
            Room room = roomPriceList.get(ROOM_INDEX).getRoom();
            String roomNumber = room.getRoomNumber();
            request.setAttribute(ROOM_NUMBER, roomNumber);
        }
        request.setAttribute(ROOM_ID, roomId);

        RoomService roomService = new RoomService();
        List<Room> roomList = roomService.findAll();
        request.setAttribute(ROOM_LIST, roomList);
        request.setAttribute(PRICE_LIST, roomPriceList);

        String message = request.getParameter(MESSAGE);
        if (message != null) {
            request.setAttribute(MESSAGE, message);
        }
        return CommandResult.forward(ROOM_PRICES_PAGE);
    }
}
