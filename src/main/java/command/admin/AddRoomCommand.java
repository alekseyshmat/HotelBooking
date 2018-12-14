package command.admin;

import command.Command;
import command.CommandResult;
import entity.Room;
import entity.types.RoomType;
import exception.ServiceException;
import service.RoomService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class AddRoomCommand implements Command {

    private static final String MAIN_PAGE = "/WEB-INF/pages/admin/rooms.jsp";
    private static final String ROOM_NUMBER = "roomNumber";
    private static final String ROOM_TYPE = "typeRoom";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        String roomNumber = request.getParameter(ROOM_NUMBER);

        String stringRoomType = request.getParameter(ROOM_TYPE);
        RoomType roomType = RoomType.valueOf(stringRoomType.toUpperCase());

        RoomService roomService = new RoomService();
        roomService.addRoom(null, roomNumber, roomType);

        List<Room> roomList = roomService.findAll();
        request.setAttribute("roomList", roomList);

        return CommandResult.redirect(MAIN_PAGE);
    }
}
