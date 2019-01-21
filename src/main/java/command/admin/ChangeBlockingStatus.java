package command.admin;

import command.Command;
import command.CommandResult;
import entity.types.BlockingStatus;
import exception.ServiceException;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Designed to change user blocking status.
 */

public class ChangeBlockingStatus implements Command {

    private static final String ID_CLIENT = "idClient";
    private static final String BLOCKING_STATUS = "blockingStatus";
    private static final String USER_COMMAND = "controller?command=showUsers&pageNumber=1&limit=5";

    /**
     * Process the request, change user blocking status and generates a result of processing in the form of
     * {@link command.CommandResult} object.
     *
     * @param request  an {@link HttpServletRequest} object that contains client request
     * @param response an {@link HttpServletResponse} object that contains the response the servlet sends to the client
     * @return A response in the form of {@link command.CommandResult} object.
     * @throws ServiceException when RepositoryException is caught.
     */

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {

        Integer id_client = Integer.valueOf(request.getParameter(ID_CLIENT));
        BlockingStatus blockingStatus = BlockingStatus.valueOf(request.getParameter(BLOCKING_STATUS).toUpperCase());

        UserService userService = new UserService();
        userService.changeBlockingStatus(id_client, blockingStatus);

        return CommandResult.redirect(USER_COMMAND);
    }
}
