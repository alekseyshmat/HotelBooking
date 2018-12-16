package builder;


import entity.Order;
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
    private static final String FIRST_NAME = "first_name";
    private static final String LAST_NAME = "last_name";
    private static final String COST = "cost";
    private static final String DATE_PATTERN = "yyyy-MM-dd";


    @Override
    public Order build(ResultSet resultSet) throws SQLException {

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

        String firstName = resultSet.getString(FIRST_NAME);
        String lastName = resultSet.getString(LAST_NAME);


        return new Order(id, idClient, checkInDate, checkOutDate, invoiceDate, roomType,
                paymentStatus, orderStatus, firstName, lastName, cost);
    }
}
