package command;

import entity.User;
import entity.types.Role;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ProfileCommand implements Command {


    private static final String ADMIN_PROFILE = "/WEB-INF/pages/admin/adminProfile.jsp";
    private static final String USER_PROFILE = "/WEB-INF/pages/user/userProfile.jsp";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        session.setAttribute("user", new User("petr", Role.ADMIN));

        Role role = (Role) session.getAttribute("role");
        return Role.ADMIN.equals(role) ?
                new CommandResult(ADMIN_PROFILE, false) :
                new CommandResult(USER_PROFILE, false);
    }
}
