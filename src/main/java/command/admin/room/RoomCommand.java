package command.admin.room;

import command.Command;
import command.CommandResult;
import entity.Room;
import exception.ServiceException;
import service.RoomService;
import util.PagesDelimiter;
import util.Validation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Designed to map rooms.
 */

public class RoomCommand implements Command {

    private static final String ROOMS_PAGE = "/WEB-INF/pages/admin/rooms.jsp";
    private static final String ERROR_PAGE = "/WEB-INF/pages/error/Error404.jsp";
    private static final String ROOM_LIST = "roomList";
    private static final String PAGE_NUMBER = "pageNumber";
    private static final String PAGES = "pages";
    private static final String LIMIT = "limit";
    private static final String MESSAGE = "message";
    private static final String NOTIFY_MESSAGE = "notifyMessage";

    /**
     * Process the request, map rooms and generates a result of processing in the form of
     * {@link command.CommandResult} object.
     *
     * @param request  an {@link HttpServletRequest} object that contains client request
     * @param response an {@link HttpServletResponse} object that contains the response the servlet sends to the client
     * @return A response in the form of {@link command.CommandResult} object.
     * @throws ServiceException when RepositoryException is caught.
     */

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        PagesDelimiter<Room> roomPagesDelimiter = new PagesDelimiter<>();
        RoomService roomService = new RoomService();
        List<Room> fullRoomList = roomService.findAll();

        String stringLimit = request.getParameter(LIMIT);
        String stringPageNumber = request.getParameter(PAGE_NUMBER);

        Validation validation = new Validation();
        Map<String, String> pageData = new HashMap<>();
        pageData.put(LIMIT, stringLimit);
        pageData.put(PAGE_NUMBER, stringPageNumber);
        if (!validation.isValidData(pageData)) {
            return CommandResult.forward(ERROR_PAGE);
        }

        Integer limit = Integer.valueOf(stringLimit);
        Integer pageNumber = Integer.valueOf(stringPageNumber);

        Integer offset = limit * (pageNumber - 1);
        List<Room> roomList = roomService.findAll(limit, offset);

        List<Integer> pages = roomPagesDelimiter.calculatePages(fullRoomList, limit);

        request.setAttribute(LIMIT, limit);
        request.setAttribute(PAGES, pages);
        request.setAttribute(PAGE_NUMBER, pageNumber);
        request.setAttribute(ROOM_LIST, roomList);

        String notifyMessage = request.getParameter(MESSAGE);
        if (notifyMessage != null) {
            request.setAttribute(NOTIFY_MESSAGE, notifyMessage);
        }
        return CommandResult.forward(ROOMS_PAGE);
    }
}
