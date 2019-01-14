package command.user;

import command.Command;
import command.CommandResult;
import entity.User;
import entity.types.OperationType;
import exception.ServiceException;
import service.TransactionService;
import service.UserService;
import util.Validation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class RefileBalanceCommand implements Command {

    private static final String SUM = "sumUp";
    private static final String ID = "id";
    private static final String BALANCE_COMMAND = "controller?command=showBalance";
    private static final String MESSAGE = "&message=";
    private static final String REFILE_BALANCE = "refileBalance";
    private static final String INVALID_SUM = "invalidSum";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        Date currentDate = new Date(System.currentTimeMillis());

        HttpSession session = request.getSession();
        Integer id = (Integer) session.getAttribute(ID);

        String stringSum = request.getParameter(SUM);

        Validation validation = new Validation();
        if (!validation.isValidData(SUM, stringSum)) {
            return CommandResult.redirect(BALANCE_COMMAND + MESSAGE + INVALID_SUM);
        }
        BigDecimal sumUp = BigDecimal.valueOf(Long.parseLong(stringSum));

        UserService userService = new UserService();
        Optional<User> optionalUser = userService.findById(id);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            BigDecimal balance = user.getBalance();
            BigDecimal newBalance = balance.add(sumUp);
            userService.updateBalance(id, newBalance);
            TransactionService transactionService = new TransactionService();
            transactionService.addOperations(null, id, OperationType.MONEYTRANSFER, currentDate, sumUp);
        }

        return CommandResult.redirect(BALANCE_COMMAND + MESSAGE + REFILE_BALANCE);
    }
}
