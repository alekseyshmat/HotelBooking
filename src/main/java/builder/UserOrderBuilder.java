package builder;

import entity.Order;
import entity.types.*;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class UserOrderBuilder implements Builder<Order> {

    private static final String ID = "id";
    private static final String ID_CLIENT = "id_client";
    private static final String CHECK_IN_DATE = "check_in_date";
    private static final String CHECK_OUT_DATE = "check_out_date";
    private static final String TYPE = "type";
    private static final String PLACE_NUMBER = "place_number";
    private static final String PAYMENT_TYPE = "payment_type";
    private static final String PAYMENT_STATUS = "payment_status";
    private static final String ORDER_STATUS = "order_status";
    private static final String COST = "cost";
    private static final String ROOM_NUMBER = "room_number";

    @Override
    public Order build(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt(ID);
        int idClient = resultSet.getInt(ID_CLIENT);
        Date checkInDate = resultSet.getDate(CHECK_IN_DATE);
        Date checkOutDate = resultSet.getDate(CHECK_OUT_DATE);
        RoomType roomType = RoomType.valueOf(resultSet.getString(TYPE).toUpperCase());
        PlaceType placeType = PlaceType.valueOf(resultSet.getString(PLACE_NUMBER).toUpperCase());
        PaymentType paymentType = PaymentType.valueOf(resultSet.getString(PAYMENT_TYPE).toUpperCase());
        PaymentStatus paymentStatus = PaymentStatus.valueOf(resultSet.getString(PAYMENT_STATUS).toUpperCase());
        OrderStatus orderStatus = OrderStatus.valueOf(resultSet.getString(ORDER_STATUS).toUpperCase());
        BigDecimal cost = resultSet.getBigDecimal(COST);
        String roomNumber = resultSet.getString(ROOM_NUMBER);

        return new Order(id, idClient, checkInDate, checkOutDate, roomType, placeType, paymentType,
                paymentStatus, orderStatus, cost, roomNumber);
    }
}
