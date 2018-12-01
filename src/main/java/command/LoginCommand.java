package command;

import entity.User;
import entity.types.Role;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginCommand implements Command {

    private static final String MAIN_PAGE = "/WEB-INF/pages/main.jsp";
    private static final String ADMIN_PAGE = "/WEB-INF/pages/admin/adminProfile.jsp";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(true);
//        session.setAttribute("user", new User("Aleksey", Role.ADMIN));
        session.setAttribute("admin", new User("Aleksey", Role.ADMIN));
//        session.setAttribute("user", new User("Aleksey", Role.USER));

        String role = (String) session.getAttribute("role");
        return Role.ADMIN.getValue().equals(role) ?
                CommandResult.forward(ADMIN_PAGE) :
                CommandResult.forward(MAIN_PAGE);


       /* UserService service = new UserService();
        String login = request.getParameter("login");
        String password = request.getParameter("password");
      *//*  Optional<User> user = service.login(login, password);
        if (user.isPresent()) {
            request.setAttribute("user", user);
        }*//*
        return "/WEB-INF/startpage.jsp";*/
    }
}
