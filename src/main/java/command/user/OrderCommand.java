package command.user;

import command.Command;
import command.CommandResult;
import entity.User;
import entity.types.Role;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class OrderCommand implements Command {

    private static final String ADMIN_ORDERS = "/WEB-INF/pages/admin/orders.jsp";
    private static final String USER_ORDERS = "/WEB-INF/pages/user/orders.jsp";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        Role role = (Role) session.getAttribute("role");
        return Role.ADMIN.equals(role) ?
                new CommandResult(ADMIN_ORDERS, false) :
                new CommandResult(USER_ORDERS, false);
    }
}
