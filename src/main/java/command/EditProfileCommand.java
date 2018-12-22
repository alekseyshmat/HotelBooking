package command;

import exception.ServiceException;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EditProfileCommand implements Command {

    private static final String PROFILE = "controller?command=showProfile";
    private static final String ID = "id";
    private static final String FIRST_NAME = "firstName";
    private static final String LAST_NAME = "lastName";
    private static final String NAME = "name";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        HttpSession session = request.getSession();
        Integer id = (Integer) session.getAttribute(ID);

        String firstName = request.getParameter(FIRST_NAME);
        String lastName = request.getParameter(LAST_NAME);
        UserService userService = new UserService();
        userService.updateProfile(id, firstName, lastName);

        session.removeAttribute(NAME);
        session.setAttribute(NAME, firstName);
        return CommandResult.redirect(PROFILE);
    }
}
