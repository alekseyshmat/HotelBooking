package command.user;

import command.Command;
import command.CommandResult;
import entity.Transaction;
import entity.User;
import exception.ServiceException;
import repository.TransactionRepository;
import service.TransactionService;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

public class BalanceCommand implements Command {

    private static final String BALANCE_PAGE = "/WEB-INF/pages/user/balance.jsp";
    private static final String ID = "id";
    private static final String USER = "user";
    private static final String TRANSACTION_LIST = "transactionList";
    private static final String MESSAGE = "message";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        HttpSession session = request.getSession();
        int id = (int) session.getAttribute(ID);

        TransactionService transactionService = new TransactionService();
        List<Transaction> transactionList = transactionService.findById(id);

        UserService userService = new UserService();
        Optional<User> optionalUser = userService.findById(id);
        if (optionalUser.isPresent()){
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
