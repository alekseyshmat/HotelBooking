package command;

import exception.ServiceException;
import service.UserService;
import util.Validation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

public class EditProfileCommand implements Command {

    private static final String PROFILE = "controller?command=showProfile";
    private static final String ID = "id";
    private static final String FIRST_NAME = "firstName";
    private static final String LAST_NAME = "lastName";
    private static final String NAME = "name";
    private static final String MESSAGE = "&message=";
    private static final String EDITING_PROFILE = "editingProfile";
    private static final String PROFILE_ERROR = "profileError";

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
