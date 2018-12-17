package command;

import command.admin.order.AdminOrderCommand;
import entity.User;
import entity.types.Role;
import exception.ServiceException;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Optional;

public class LoginCommand implements Command {

    private static final String MAIN_PAGE = "/controller?command=mainPage";
    private static final String ADMIN_PAGE = "/WEB-INF/pages/admin/roomPrices.jsp";
    private static final String ID = "id";
    private static final String NAME = "name";
    private static final String ROLE = "role";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
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

        session.setAttribute(ID, id);
        session.setAttribute(NAME, name);
        session.setAttribute(ROLE, role);
        return Role.ADMIN.equals(role) ?
                new AdminOrderCommand().execute(request, response) :
//                CommandResult.redirect(ADMIN_PAGE) :
                CommandResult.redirect(MAIN_PAGE);

    }
}
