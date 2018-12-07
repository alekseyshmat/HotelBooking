package command;

import entity.User;
import entity.types.Role;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Optional;

public class LoginCommand implements Command {

    private static final String MAIN_PAGE = "/WEB-INF/pages/main.jsp";
    private static final String ADMIN_PAGE = "/WEB-INF/pages/admin/orders.jsp";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        UserService service = new UserService();
        String login = request.getParameter("username");
        String password = request.getParameter("password");
        Optional<User> user = service.login(login, password);
        //todo проверка

        User user1 = null;
        if (user.isPresent()) {
            user1 = user.get();
        }
        Role role = user1.getRole();
        String name = user1.getFirstName();
        HttpSession session = request.getSession();

        int id = user1.getId();

        session.setAttribute("id", id);
        session.setAttribute("name", name);
        session.setAttribute("role", role);
        return Role.ADMIN.equals(role) ?
                new CommandResult(ADMIN_PAGE, false) :
                new CommandResult(MAIN_PAGE, false);
    }
}
