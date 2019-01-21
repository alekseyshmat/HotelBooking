package command;

import exception.ServiceException;
import service.UserService;
import util.Validation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Designed to edit user's profile information.
 */

public class EditProfileCommand implements Command {

    private static final String PROFILE = "controller?command=showProfile";
    private static final String ID = "id";
    private static final String FIRST_NAME = "firstName";
    private static final String LAST_NAME = "lastName";
    private static final String NAME = "name";
    private static final String MESSAGE = "&message=";
    private static final String EDITING_PROFILE = "editingProfile";
    private static final String PROFILE_ERROR = "profileError";

    /**
     * Process the request, edit user's profile information and generates a result of processing in the form of
     * {@link command.CommandResult} object.
     *
     * @param request  an {@link HttpServletRequest} object that contains client request
     * @param response an {@link HttpServletResponse} object that contains the response the servlet sends to the client
     * @return A response in the form of {@link command.CommandResult} object.
     * @throws ServiceException when RepositoryException is caught.
     */

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        HttpSession session = request.getSession();
        Integer id = (Integer) session.getAttribute(ID);

        String firstName = request.getParameter(FIRST_NAME);
        String lastName = request.getParameter(LAST_NAME);

        Map<String, String> inputData = new HashMap<>();
        inputData.put(FIRST_NAME, firstName);
        inputData.put(LAST_NAME, lastName);
        Validation validation = new Validation();

        if (!validation.isValidData(inputData)) {
            return CommandResult.redirect(PROFILE + MESSAGE + PROFILE_ERROR);
        }

        UserService userService = new UserService();
        userService.updateProfile(id, firstName, lastName);

        session.removeAttribute(NAME);
        session.setAttribute(NAME, firstName);

        return CommandResult.redirect(PROFILE + MESSAGE + EDITING_PROFILE);
    }
}
