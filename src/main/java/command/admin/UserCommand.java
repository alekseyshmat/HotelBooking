package command.admin;

import command.Command;
import command.CommandResult;
import entity.User;
import entity.types.Role;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class UserCommand implements Command {

    private static final String USERS_PAGE = "/WEB-INF/pages/admin/users.jsp";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        UserService userService = new UserService();
        List<User> userList = userService.findByRole(Role.USER);
        request.setAttribute("userList", userList);

        return CommandResult.forward(USERS_PAGE);
    }
}
