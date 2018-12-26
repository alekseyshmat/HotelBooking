package filter;

import entity.types.Role;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AccessFilter implements Filter {

    private static final String LOGIN = "login";
    private static final String SHOW_PROFILE = "showProfile";
    private static final String SIGN_OUT = "signOut";
    private static final String EDIT_PROFILE = "editProfile";
    private static final String CHANGE_LANGUAGE = "changeLanguage";

    private static final String SHOW_ORDERS = "showOrders";
    private static final String SHOW_ALL_ORDERS = "showAllOrders";
    private static final String SHOW_USERS = "showUsers";
    private static final String SHOW_ROOMS = "showRooms";
    private static final String SHOW_ROOM_PRICES = "showRoomPrices";
    private static final String SHOW_BALANCE = "showBalance";
    private static final String REFILE_BALANCE = "refileBalance";
    private static final String MAIN_PAGE = "mainPage";
    private static final String MAKE_ORDER = "makeOrder";
    private static final String PROCESS_ORDER = "processOrder";
    private static final String COMPLETE_ORDER = "completeOrder";
    private static final String CANCEL_ORDER = "cancelOrder";
    private static final String UPDATE_BALANCE = "updateBalance";
    private static final String SAVE_ROOM = "saveRoom";
    private static final String ADD_ROOM_PRICE = "addRoomPrice";
    private static final String SEARCH_ROOM_BY_CRITERIA = "searchRoomByCriteria";
    private static final String ROLE = "role";
    private static final String COMMAND = "command";
    private static final String ERROR_PAGE = "/WEB-INF/pages/AccessError.jsp";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String parameter = servletRequest.getParameter(COMMAND);
        if (parameter != null) {
            HttpSession session = ((HttpServletRequest) servletRequest).getSession();
            Role role = (Role) session.getAttribute(ROLE);
            if (parameter.equals(SHOW_ALL_ORDERS) ||
                    parameter.equals(SHOW_USERS) ||
                    parameter.equals(SHOW_ROOMS) ||
                    parameter.equals(SHOW_ROOM_PRICES) ||
                    parameter.equals(PROCESS_ORDER) ||
                    parameter.equals(COMPLETE_ORDER) ||
                    parameter.equals(SAVE_ROOM) ||
                    parameter.equals(ADD_ROOM_PRICE) ||
                    parameter.equals(SEARCH_ROOM_BY_CRITERIA)) {

                if (role.equals(Role.USER)) {
                    ((HttpServletResponse) servletResponse).sendError(401); //todo add page
                    return;
                }
            } else if (parameter.equals(SHOW_ORDERS) ||
                    parameter.equals(SHOW_BALANCE) ||
                    parameter.equals(REFILE_BALANCE) ||
                    parameter.equals(MAIN_PAGE) ||
                    parameter.equals(MAKE_ORDER) ||
                    parameter.equals(CANCEL_ORDER) ||
                    parameter.equals(UPDATE_BALANCE)) {
                if (role.equals(Role.ADMIN)) {
                    ((HttpServletResponse) servletResponse).sendError(401); //todo add page
                    return;
                }
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
