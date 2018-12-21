package builder;


import entity.Order;
import entity.Room;
import entity.User;
import entity.types.OrderStatus;
import entity.types.PaymentStatus;
import entity.types.RoomType;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class OrderBuilder implements Builder<Order> {

    private static final String ID = "id";
    private static final String ID_CLIENT = "id_client";
    private static final String CHECK_IN_DATE = "check_in_date";
    private static final String CHECK_OUT_DATE = "check_out_date";
    private static final String INVOICE_DATE = "invoice_date";
    private static final String TYPE = "type";
    private static final String PAYMENT_STATUS = "payment_status";
    private static final String ORDER_STATUS = "order_status";
    private static final String COST = "cost";
    private static final String DATE_PATTERN = "yyyy-MM-dd";

    @Override
    public Order build(ResultSet resultSet) throws SQLException {
        User user = new UserBuilder().build(resultSet);
        Room room = new RoomBuilder().build(resultSet);

        Integer id = resultSet.getInt(ID);
        Integer idClient = resultSet.getInt(ID_CLIENT);
        LocalDate checkInDate = (resultSet.getDate(CHECK_IN_DATE)).toLocalDate();
        LocalDate checkOutDate = (resultSet.getDate(CHECK_OUT_DATE)).toLocalDate();
        Date date = resultSet.getDate(INVOICE_DATE);
        LocalDate invoiceDate;

        if (date != null) {
            invoiceDate = date.toLocalDate();
        } else {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_PATTERN);
            invoiceDate = LocalDate.parse(LocalDate.now().format(formatter), formatter);
        }

        RoomType roomType = RoomType.valueOf(resultSet.getString(TYPE).toUpperCase());
        PaymentStatus paymentStatus = PaymentStatus.valueOf(resultSet.getString(PAYMENT_STATUS).toUpperCase());
        OrderStatus orderStatus = OrderStatus.valueOf(resultSet.getString(ORDER_STATUS).toUpperCase());
        BigDecimal cost = resultSet.getBigDecimal(COST);

        return new Order(id, idClient, checkInDate, checkOutDate, invoiceDate, roomType,
                paymentStatus, orderStatus, cost, user, room);
    }
}
