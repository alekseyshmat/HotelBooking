package command.user.balance;

import command.Command;
import command.CommandResult;
import entity.Transaction;
import entity.User;
import exception.ServiceException;
import service.TransactionService;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

/**
 * Designed to map balance and history operations with balance.
 */

public class BalanceCommand implements Command {

    private static final String BALANCE_PAGE = "/WEB-INF/pages/user/balance.jsp";
    private static final String ID = "id";
    private static final String USER = "user";
    private static final String TRANSACTION_LIST = "transactionList";
    private static final String MESSAGE = "message";

    /**
     * Process the request, map balance and history operations with balance and generates a result of processing in the form of
     * {@link command.CommandResult} object.
     *
     * @param request  an {@link HttpServletRequest} object that contains client request
     * @param response an {@link HttpServletResponse} object that contains the response the servlet sends to the client
     * @return A response in the form of {@link command.CommandResult} object.
     * @throws ServiceException when RepositoryException is caught.
     */

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        HttpSession session = request.getSession();
        int id = (int) session.getAttribute(ID);

        TransactionService transactionService = new TransactionService();
        List<Transaction> transactionList = transactionService.findById(id);

        UserService userService = new UserService();
        Optional<User> optionalUser = userService.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            request.setAttribute(TRANSACTION_LIST, transactionList);
            request.setAttribute(USER, user);
        }

        String message = request.getParameter(MESSAGE);
        if (message != null) {
            request.setAttribute(MESSAGE, message);
        }
        return CommandResult.forward(BALANCE_PAGE);
    }
}
