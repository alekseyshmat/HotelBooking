package command.admin;

import command.Command;
import command.CommandResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RoomCommand implements Command {

    private static final String ROOMS_PAGE = "/WEB-INF/pages/admin/rooms.jsp";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        return CommandResult.forward(ROOMS_PAGE);
    }
}
