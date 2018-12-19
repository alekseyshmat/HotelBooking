package builder;

import entity.Order;
import entity.types.*;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;

public class UserOrderBuilder implements Builder<Order> {

    private static final String ID = "id";
    private static final String ID_CLIENT = "id_client";
    private static final String CHECK_IN_DATE = "check_in_date";
    private static final String CHECK_OUT_DATE = "check_out_date";
    private static final String TYPE = "type";

    private static final String PAYMENT_STATUS = "payment_status";
    private static final String ORDER_STATUS = "order_status";
    private static final String COST = "cost";
    private static final String ROOM_NUMBER = "room_number";

    @Override
    public Order build(ResultSet resultSet) throws SQLException {
        Integer id = resultSet.getInt(ID);
        Integer idClient = resultSet.getInt(ID_CLIENT);
        LocalDate checkInDate = (resultSet.getDate(CHECK_IN_DATE)).toLocalDate();
        LocalDate checkOutDate = (resultSet.getDate(CHECK_OUT_DATE)).toLocalDate();
        RoomType roomType = RoomType.valueOf(resultSet.getString(TYPE).toUpperCase());
        PaymentStatus paymentStatus = PaymentStatus.valueOf(resultSet.getString(PAYMENT_STATUS).toUpperCase());
        OrderStatus orderStatus = OrderStatus.valueOf(resultSet.getString(ORDER_STATUS).toUpperCase());
        BigDecimal cost = resultSet.getBigDecimal(COST);

        String roomNumber = resultSet.getString(ROOM_NUMBER);

        return new Order(id, idClient, checkInDate, checkOutDate, roomType,
                paymentStatus, orderStatus, cost, roomNumber);
    }
}
