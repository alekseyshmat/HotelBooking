package filter;

import entity.types.Role;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Designed to perform a access operation filter.
 */

public class AccessFilter implements Filter {

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
    private static final String DELETE_ROOM = "deleteRoom";
    private static final String ADD_ROOM_PRICE = "addRoomPrice";
    private static final String SEARCH_ROOM_BY_CRITERIA = "searchRoomByCriteria";
    private static final String ROLE = "role";
    private static final String COMMAND = "command";
    private static final Integer ERROR_NUMBER = 403;

    @Override
    public void init(FilterConfig filterConfig) {
    }

    /**
     * Method of the Filter is called by the
     * container each time a request/response pair is passed through the
     * chain due to a client request for a resource at the end of the chain,
     * checks user on access to the requested page.
     * In the case of non authorization or not access user is forward to error page.
     *
     * @param servletRequest  an {@link ServletRequest} object that contains client request
     * @param servletResponse an {@link ServletResponse} object that contains the response the servlet
     * @param filterChain     an {@link FilterChain} object that allows the Filter to pass
     *                        on the request and response to the next entity in the chain.
     * @throws IOException      Signals that an I/O exception of some sort has occurred.
     * @throws ServletException General exception a servlet can throw when it encounters difficulty.
     */

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
                    parameter.equals(DELETE_ROOM) ||
                    parameter.equals(ADD_ROOM_PRICE) ||
                    parameter.equals(SEARCH_ROOM_BY_CRITERIA)) {

                if (role.equals(Role.USER)) {
                    ((HttpServletResponse) servletResponse).sendError(ERROR_NUMBER);
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
                    ((HttpServletResponse) servletResponse).sendError(ERROR_NUMBER);
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
