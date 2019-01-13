package command.user;

import command.Command;
import command.CommandResult;
import entity.Order;
import entity.User;
import entity.types.OperationType;
import entity.types.PaymentStatus;
import exception.ServiceException;
import service.OrderService;
import service.TransactionService;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class PayOrderCommand implements Command {

    private static final String ORDER_PAGE = "controller?command=showOrders";
    private static final String MESSAGE = "&message=";
    private static final String PAY_ORDER = "payOrder";
    private static final String NO_MONEY = "noMoney";
    private static final String ORDER_ID = "orderId";
    private static final String ID = "id";
    private static final String DATE_PATTERN = "yyyy-MM-dd";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_PATTERN);
        LocalDate currentDate = LocalDate.parse(LocalDate.now().format(formatter), formatter);

        HttpSession session = request.getSession();
        Integer id = (Integer) session.getAttribute(ID);

        String stringOrderId = request.getParameter(ORDER_ID);
        Integer orderId;
        if (stringOrderId != null) {
            orderId = Integer.valueOf(stringOrderId);
        } else {
            return CommandResult.forward("nullpage"); //todo add
        }
        OrderService orderService = new OrderService();

        Optional<Order> optionalOrder = orderService.findById(orderId);
        if (optionalOrder.isPresent()) {
            Order order = optionalOrder.get();
            BigDecimal cost = order.getCost();

            UserService userService = new UserService();
            Optional<User> optionalUser = userService.findById(id);
            if (optionalUser.isPresent()) {
                User user = optionalUser.get();

                BigDecimal userBalance = user.getBalance();
                if (userBalance.compareTo(cost) < 0) {
                    return CommandResult.redirect(ORDER_PAGE + MESSAGE + NO_MONEY);
                }

                BigDecimal newBalance = userBalance.subtract(cost);
                userService.updateBalance(id, newBalance);
                orderService.payOrder(orderId, PaymentStatus.PAID);
            }
            TransactionService transactionService = new TransactionService();
            transactionService.addOperations(null, id, OperationType.PAYMENTFORSERVICES, currentDate, cost);
        }
        return CommandResult.redirect(ORDER_PAGE + MESSAGE + PAY_ORDER);
    }
}
