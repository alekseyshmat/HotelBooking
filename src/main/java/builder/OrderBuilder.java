package builder;


import entity.Order;
import entity.types.OrderStatus;
import entity.types.PaymentStatus;
import entity.types.PaymentType;
import entity.types.RoomType;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class OrderBuilder implements Builder<Order> {

    private static final String ID = "id";
    private static final String ID_CLIENT = "id_client";
    private static final String CHECK_IN_DATE = "check_in_date";
    private static final String CHECK_OUT_DATE = "check_out_date";
    private static final String INVOICE_DATE = "invoice_date";
    private static final String TYPE = "type";
    private static final String PAYMENT_TYPE = "payment_type";
    private static final String PAYMENT_STATUS = "payment_status";
    private static final String ORDER_STATUS = "order_status";
    private static final String FIRST_NAME = "first_name";
    private static final String LAST_NAME = "last_name";
    private static final String COST = "cost";

    @Override
    public Order build(ResultSet resultSet) throws SQLException {

        Integer id = resultSet.getInt(ID);
        int idClient = resultSet.getInt(ID_CLIENT);
        Date checkInDate = resultSet.getDate(CHECK_IN_DATE);
        Date checkOutDate = resultSet.getDate(CHECK_OUT_DATE);
        Date invoiceDate = resultSet.getDate(INVOICE_DATE);

        RoomType roomType = RoomType.valueOf(resultSet.getString(TYPE).toUpperCase());
        PaymentType paymentType = PaymentType.valueOf(resultSet.getString(PAYMENT_TYPE).toUpperCase());
        PaymentStatus paymentStatus = PaymentStatus.valueOf(resultSet.getString(PAYMENT_STATUS).toUpperCase());
        OrderStatus orderStatus = OrderStatus.valueOf(resultSet.getString(ORDER_STATUS).toUpperCase());
        BigDecimal cost = resultSet.getBigDecimal(COST);

//        String firstName = resultSet.getString(FIRST_NAME);
//        String lastName = resultSet.getString(LAST_NAME);


        return new Order(id, idClient, checkInDate, checkOutDate, invoiceDate, roomType, paymentType,
                paymentStatus, orderStatus, null, null, cost);
    }
}
