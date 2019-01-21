package command.admin.room;

import command.Command;
import command.CommandResult;
import exception.ServiceException;
import service.RoomService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Designed to delete room.
 */

public class DeleteRoomCommand implements Command {

    private static final String MAIN_PAGE = "controller?command=showRooms&pageNumber=1&limit=5";
    private static final String MESSAGE = "&message=roomDelete";
    private static final String ROOM_ID = "deletedRoomId";

    /**
     * Process the request, delete room and generates a result of processing in the form of
     * {@link command.CommandResult} object.
     *
     * @param request  an {@link HttpServletRequest} object that contains client request
     * @param response an {@link HttpServletResponse} object that contains the response the servlet sends to the client
     * @return A response in the form of {@link command.CommandResult} object.
     * @throws ServiceException when RepositoryException is caught.
     */

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
