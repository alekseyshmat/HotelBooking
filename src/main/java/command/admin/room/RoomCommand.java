package command.admin.room;

import command.Command;
import command.CommandResult;
import entity.Room;
import exception.ServiceException;
import service.RoomService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class RoomCommand implements Command {

    private static final String ROOMS_PAGE = "/WEB-INF/pages/admin/rooms.jsp";
    private static final String ROOM_LIST = "roomList";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        RoomService roomService = new RoomService();


        List<Room> roomList = roomService.findAll();

        int count = roomList.size();

        request.setAttribute(ROOM_LIST, roomList);

        return CommandResult.forward(ROOMS_PAGE);
    }
}
