package command;

import entity.User;
import exception.ServiceException;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Optional;

public class ProfileCommand implements Command {

    private static final String PROFILE = "/WEB-INF/pages/profile.jsp";
    private static final String ID = "id";
    private static final String USER = "user";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        HttpSession session = request.getSession();
        Integer id = (Integer) session.getAttribute(ID);

        UserService userService = new UserService();
        Optional<User> user = userService.findById(id);
        user.ifPresent(aUser -> request.setAttribute(USER, aUser));

        return CommandResult.forward(PROFILE);
    }
}
