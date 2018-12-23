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

    private static final String MAIN_PAGE = "controller?command=showRooms&pageNumber=1";
    private static final String ID = "roomId";
    private static final String EDIT_ROOM_NUMBER = "editRoomNumber";
    private static final String EDIT_ROOM_TYPE = "editTypeRoom";
    private static final String ADD_ROOM_NUMBER = "addRoomNumber";
    private static final String ADD_ROOM_TYPE = "addTypeRoom";
    private static final String ROOM_LIST = "roomList";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        String stringId = request.getParameter(ID);
        Integer id = null;
        if (stringId != null) {
            id = Integer.valueOf(stringId);
        }
        String roomNumber = request.getParameter(EDIT_ROOM_NUMBER);
        if (roomNumber == null) {
            roomNumber = request.getParameter(ADD_ROOM_NUMBER);
        }

        String stringRoomType = request.getParameter(EDIT_ROOM_TYPE);
        if (stringRoomType == null) {
            stringRoomType = request.getParameter(ADD_ROOM_TYPE);
        }
        RoomType roomType = RoomType.valueOf(stringRoomType.toUpperCase());

        RoomService roomService = new RoomService();
        roomService.saveRoom(id, roomNumber, roomType);

        List<Room> roomList = roomService.findAll();
        request.setAttribute(ROOM_LIST, roomList);

        return CommandResult.redirect(MAIN_PAGE);
    }
}
