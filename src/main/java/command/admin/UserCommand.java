package command.admin;

import command.Command;
import command.CommandResult;
import entity.User;
import entity.types.Role;
import exception.ServiceException;
import service.UserService;
import util.PagesDelimiter;
import util.Validation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Designed to map users.
 */

public class UserCommand implements Command {

    private static final String USERS_PAGE = "/WEB-INF/pages/admin/users.jsp";
    private static final String ERROR_PAGE = "/WEB-INF/pages/error/Error404.jsp";
    private static final String PAGE_NUMBER = "pageNumber";
    private static final String PAGES = "pages";
    private static final String LIMIT = "limit";
    private static final String USER_LIST = "userList";

    /**
     * Process the request, map users and generates a result of processing in the form of
     * {@link command.CommandResult} object.
     *
     * @param request  an {@link HttpServletRequest} object that contains client request
     * @param response an {@link HttpServletResponse} object that contains the response the servlet sends to the client
     * @return A response in the form of {@link command.CommandResult} object.
     * @throws ServiceException when RepositoryException is caught.
     */

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        PagesDelimiter<User> roomPagesDelimiter = new PagesDelimiter<>();
        UserService userService = new UserService();
        List<User> fullUserList = userService.findByRole(Role.USER);

        String stringLimit = request.getParameter(LIMIT);
        String stringPageNumber = request.getParameter(PAGE_NUMBER);

        Validation validation = new Validation();
        Map<String, String> pageData = new HashMap<>();
        pageData.put(LIMIT, stringLimit);
        pageData.put(PAGE_NUMBER, stringPageNumber);
        if (!validation.isValidData(pageData)) {
            return CommandResult.forward(ERROR_PAGE);
        }

        Integer limit = Integer.valueOf(stringLimit);
        Integer pageNumber = Integer.valueOf(stringPageNumber);

        Integer offset = limit * (pageNumber - 1);
        List<User> userList = userService.findByRole(Role.USER, limit, offset);

        List<Integer> pages = roomPagesDelimiter.calculatePages(fullUserList, limit);

        request.setAttribute(LIMIT, limit);
        request.setAttribute(PAGES, pages);
        request.setAttribute(PAGE_NUMBER, pageNumber);
        request.setAttribute(USER_LIST, userList);
        return CommandResult.forward(USERS_PAGE);
    }
}
