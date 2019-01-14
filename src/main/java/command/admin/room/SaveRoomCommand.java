package command.admin.room;

import command.Command;
import command.CommandResult;
import entity.Room;
import entity.types.RoomType;
import exception.ServiceException;
import service.RoomService;
import util.Validation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SaveRoomCommand implements Command {

    private static final String MAIN_PAGE = "controller?command=showRooms&pageNumber=1&limit=5&message=";
    private static final String ID = "roomId";
    private static final String EDIT_ROOM_NUMBER = "editRoomNumber";
    private static final String EDIT_ROOM_TYPE = "editTypeRoom";
    private static final String ADD_ROOM_NUMBER = "addRoomNumber";
    private static final String ADD_ROOM_TYPE = "addTypeRoom";
    private static final String ROOM_LIST = "roomList";
    private static final String ADDING_ROOM = "added";
    private static final String EDITING_ROOM = "edited";
    private static final String ERROR_MESSAGE = "invalidRoom";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        String stringId = request.getParameter(ID);
        Integer id = null;
        String roomNumber;
        String stringRoomType;
        String message;
        Validation validation = new Validation();

        if (stringId != null) {
            roomNumber = request.getParameter(EDIT_ROOM_NUMBER);
            stringRoomType = request.getParameter(EDIT_ROOM_TYPE);

            Map<String, String> inputData = new HashMap<>();
            inputData.put(ADD_ROOM_NUMBER, roomNumber);
            inputData.put(ID, stringId);
            if (!validation.isValidData(inputData)) {
                message = ERROR_MESSAGE;
                return CommandResult.redirect(MAIN_PAGE + message);
            }
            id = Integer.valueOf(stringId);
            message = EDITING_ROOM;
        } else {
            roomNumber = request.getParameter(ADD_ROOM_NUMBER);
            stringRoomType = request.getParameter(ADD_ROOM_TYPE);
            if (!validation.isValidData(EDIT_ROOM_NUMBER, roomNumber)) {
                message = ERROR_MESSAGE;
                return CommandResult.redirect(MAIN_PAGE + message);
            }
            message = ADDING_ROOM;
        }

        RoomType roomType = RoomType.valueOf(stringRoomType.toUpperCase());

        RoomService roomService = new RoomService();
        roomService.saveRoom(id, roomNumber, roomType);

        List<Room> roomList = roomService.findAll();
        request.setAttribute(ROOM_LIST, roomList);

        return CommandResult.redirect(MAIN_PAGE + message);
    }
}
