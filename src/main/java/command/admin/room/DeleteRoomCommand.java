package command.admin.room;

import command.Command;
import command.CommandResult;
import exception.ServiceException;
import service.RoomService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteRoomCommand implements Command {

    private static final String MAIN_PAGE = "controller?command=showRooms&pageNumber=1&limit=5";
    private static final String MESSAGE = "&message=roomDelete";
    private static final String ROOM_ID = "deletedRoomId";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        RoomService roomService = new RoomService();
        String stringRoomId = request.getParameter(ROOM_ID);
        if (stringRoomId != null && !stringRoomId.equals("")) {
            Integer id = Integer.valueOf(stringRoomId);
            roomService.deleteRoom(id);
            return CommandResult.redirect(MAIN_PAGE + MESSAGE);
        }
        return CommandResult.redirect(MAIN_PAGE);
    }
}
