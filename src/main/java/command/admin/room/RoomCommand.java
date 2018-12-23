package command.admin.room;

import command.Command;
import command.CommandResult;
import entity.Room;
import exception.ServiceException;
import service.RoomService;
import util.PagesDelimeter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class RoomCommand implements Command {

    private static final String ROOMS_PAGE = "/WEB-INF/pages/admin/rooms.jsp";
    private static final String ROOM_LIST = "roomList";
    private static final String PAGE_NUMBER = "pageNumber";
    private static final String PAGES = "pages";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        PagesDelimeter<Room> roomPagesDelimeter = new PagesDelimeter<>();
        RoomService roomService = new RoomService();
        List<Room> fullRoomList = roomService.findAll();

        Integer limit = 10;
        Integer pageNumber = Integer.valueOf(request.getParameter(PAGE_NUMBER));
        Integer offset = limit * (pageNumber - 1);
        List<Room> roomList = roomService.findAll(limit, offset);

        List<Integer> pages = roomPagesDelimeter.calculatePages(fullRoomList, limit);
        request.setAttribute(PAGES, pages);
        request.setAttribute(ROOM_LIST, roomList);
        return CommandResult.forward(ROOMS_PAGE);
    }
}
