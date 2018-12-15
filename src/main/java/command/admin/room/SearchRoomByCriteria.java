package command.admin.room;

import command.Command;
import command.CommandResult;
import entity.Room;
import exception.ServiceException;
import service.RoomService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class SearchRoomByCriteria implements Command {

    private static final String ROOMS_LIST = "roomsWithCriteria";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {

        RoomService roomService = new RoomService();
        List<Room> roomsWithCriteria = roomService.findAllByCriteria(null, null,null,false);
        request.setAttribute(ROOMS_LIST, roomsWithCriteria);
        return null;
    }
}
