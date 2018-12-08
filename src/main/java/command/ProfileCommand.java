package command;

import entity.User;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Optional;

public class ProfileCommand implements Command {


    private static final String PROFILE = "/WEB-INF/pages/profile.jsp";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        int id = (int) session.getAttribute("id");

        UserService userService = new UserService();
        Optional<User> user = userService.findById(id);
        user.ifPresent(aUser -> request.setAttribute("user", aUser));

        return new CommandResult(PROFILE, false);
    }
}
