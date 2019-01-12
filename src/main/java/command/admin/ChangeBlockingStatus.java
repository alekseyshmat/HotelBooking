package command.admin;

import command.Command;
import command.CommandResult;
import entity.types.BlockingStatus;
import exception.ServiceException;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChangeBlockingStatus implements Command {

    private static final String ID_CLIENT = "idClient";
    private static final String BLOCKING_STATUS = "blockingStatus";
    private static final String USER_COMMAND = "controller?command=showUsers&pageNumber=1&limit=5";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {

        Integer id_client = Integer.valueOf(request.getParameter(ID_CLIENT));
        BlockingStatus blockingStatus = BlockingStatus.valueOf(request.getParameter(BLOCKING_STATUS).toUpperCase());

        UserService userService = new UserService();
        userService.changeBlockingStatus(id_client, blockingStatus);

        return CommandResult.redirect(USER_COMMAND);
    }
}
