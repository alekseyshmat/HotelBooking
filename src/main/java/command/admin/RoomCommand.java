package command.admin;

import command.Command;
import command.CommandResult;
import entity.Room;
import service.RoomService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class RoomCommand implements Command {

    private static final String ROOMS_PAGE = "/WEB-INF/pages/admin/rooms.jsp";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        RoomService roomService = new RoomService();
        List<Room> roomList = roomService.findAll();
        request.setAttribute("roomList", roomList);

        return CommandResult.forward(ROOMS_PAGE);
    }
}
