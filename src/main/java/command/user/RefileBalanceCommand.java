package command.user;

import command.Command;
import command.CommandResult;
import entity.User;
import entity.types.OperationType;
import exception.ServiceException;
import service.TransactionService;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class RefileBalanceCommand implements Command {

    private static final String SUM = "sumUp";
    private static final String ID = "id";
    private static final String DATE_PATTERN = "yyyy-MM-dd";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_PATTERN);
        LocalDate currentDate = LocalDate.parse(LocalDate.now().format(formatter), formatter);

        HttpSession session = request.getSession();
        Integer id = (Integer) session.getAttribute(ID);

        BigDecimal sumUp = BigDecimal.valueOf(Long.parseLong(request.getParameter(SUM)));

        UserService userService = new UserService();
        Optional<User> optionalUser = userService.findById(id);
        //todo add validation
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            BigDecimal balance = user.getBalance();
            BigDecimal newBalance = balance.add(sumUp);
            userService.updateBalance(id, newBalance);
            TransactionService transactionService = new TransactionService();
            transactionService.addOperations(null, id, OperationType.MONEYTRANSFER, currentDate, sumUp);
        }

        return new BalanceCommand().execute(request, response);
    }
}
