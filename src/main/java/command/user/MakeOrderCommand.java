package command.user;

import command.Command;
import command.CommandResult;
import entity.types.PaymentType;
import entity.types.PlaceType;
import entity.types.RoomType;
import service.OrderService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MakeOrderCommand implements Command {

    private static final String MAIN_PAGE = "/WEB-INF/pages/makeOrder.jsp";

    private static final String ID_CLIENT = "id";
    private static final String CHECK_IN_DATE = "checkInDate";
    private static final String CHECK_OUT_DATE = "checkOutDate";
    private static final String TYPE = "typeRoom";
    private static final String PLACE_NUMBER = "placeNumber";
    private static final String PAYMENT_TYPE = "paymentType";
    private static final String DATE_PATTERN = "yyyy-MM-dd";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        int idClient = (int) session.getAttribute(ID_CLIENT);

        String stringCheckInDate = request.getParameter(CHECK_IN_DATE);
        String stringCheckOutDate = request.getParameter(CHECK_OUT_DATE);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_PATTERN);

        LocalDate checkInDate = LocalDate.parse(stringCheckInDate, formatter);
        LocalDate checkOutDate = LocalDate.parse(stringCheckOutDate, formatter);

        String stringRoomType = request.getParameter(TYPE);
        RoomType roomType = RoomType.valueOf(stringRoomType.toUpperCase());

        String stringPlaceType = request.getParameter(PLACE_NUMBER);
        PlaceType placeType = PlaceType.valueOf(stringPlaceType.toUpperCase());

        String stringPaymentType = request.getParameter(PAYMENT_TYPE);
        PaymentType paymentType = PaymentType.valueOf(stringPaymentType.toUpperCase());

        OrderService orderService = new OrderService();
        orderService.makeOrder(idClient, checkInDate, checkOutDate, roomType, placeType, paymentType);

        return CommandResult.redirect(MAIN_PAGE);
    }
}
