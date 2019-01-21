package builder;


import entity.Order;
import entity.Room;
import entity.User;
import entity.types.OrderStatus;
import entity.types.PaymentStatus;
import entity.types.RoomType;
import exception.RepositoryException;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Designed to build an object of type {@link entity.Order} with specified characteristics.
 */

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

    /**
     * Builds an object of type Order with properties.
     *
     * @param resultSet Instance of {@link java.sql.ResultSet} with property set to build an object type Order.
     * @return Returns built object type Order.
     * @throws RepositoryException Throws when SQL Exception is caught.
     */

    @Override
    public Order build(ResultSet resultSet) throws RepositoryException {
        try {
            User user = new UserBuilder().build(resultSet);
            Room room = new RoomBuilder().build(resultSet);

            Integer id = resultSet.getInt(ID);
            Integer idClient = resultSet.getInt(ID_CLIENT);
            Date checkInDate = resultSet.getDate(CHECK_IN_DATE);
            Date checkOutDate = resultSet.getDate(CHECK_OUT_DATE);

            Date invoiceDate = resultSet.getDate(INVOICE_DATE);

            RoomType roomType = RoomType.valueOf(resultSet.getString(TYPE).toUpperCase());
            PaymentStatus paymentStatus = PaymentStatus.valueOf(resultSet.getString(PAYMENT_STATUS).toUpperCase());
            OrderStatus orderStatus = OrderStatus.valueOf(resultSet.getString(ORDER_STATUS).toUpperCase());
            BigDecimal cost = resultSet.getBigDecimal(COST);

            return new Order(id, idClient, checkInDate, checkOutDate, invoiceDate, roomType,
                    paymentStatus, orderStatus, cost, user, room);
        } catch (SQLException e) {
            throw new RepositoryException(e.getMessage(), e);
        }
    }
}
