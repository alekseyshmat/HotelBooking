package command.admin;

import command.Command;
import command.CommandResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RoomPricesCommand implements Command {

    private static final String ROOM_PRICES_PAGE = "/WEB-INF/pages/admin/roomPrices.jsp";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {

        return CommandResult.forward(ROOM_PRICES_PAGE);
    }
}
