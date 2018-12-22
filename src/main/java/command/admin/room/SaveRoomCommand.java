package command.admin.room;

import command.Command;
import command.CommandResult;
import entity.Room;
import entity.types.RoomType;
import exception.ServiceException;
import service.RoomService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class SaveRoomCommand implements Command {

    private static final String MAIN_PAGE = "controller?command=showRooms";
    private static final String ID = "roomId";
    private static final String ROOM_NUMBER = "roomNumber";
    private static final String ROOM_TYPE = "typeRoom";
    private static final String ROOM_LIST = "roomList";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        String stringId = request.getParameter(ID);
        Integer id = null;
        if (stringId != null) {
            id = Integer.valueOf(stringId);
        }
        String roomNumber = request.getParameter(ROOM_NUMBER);

        String stringRoomType = request.getParameter(ROOM_TYPE);
        RoomType roomType = RoomType.valueOf(stringRoomType.toUpperCase());

        RoomService roomService = new RoomService();
        roomService.saveRoom(id, roomNumber, roomType);

        List<Room> roomList = roomService.findAll();
        request.setAttribute(ROOM_LIST, roomList);

        return CommandResult.redirect(MAIN_PAGE);
    }
}
