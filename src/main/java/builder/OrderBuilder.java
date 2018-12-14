package builder;

import entity.Order;
import entity.types.*;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class OrderBuilder implements Builder<Order> {

    private static final String ID = "id";
    private static final String ID_CLIENT = "id_client";
    private static final String CHECK_IN_DATE = "check_in_date";
    private static final String CHECK_OUT_DATE = "check_out_date";
    private static final String INVOICE_DATE = "invoice_date";
    private static final String TYPE = "type";
    private static final String PLACE_NUMBER = "place_number";
    private static final String PAYMENT_TYPE = "payment_type";
    private static final String PAYMENT_STATUS = "payment_status";
    private static final String ORDER_STATUS = "order_status";
    private static final String FIRST_NAME = "first_name";
    private static final String LAST_NAME = "last_name";
    private static final String COST = "cost";

    @Override
    public Order build(ResultSet resultSet) throws SQLException {

        int id = resultSet.getInt(ID);
        int idClient = resultSet.getInt(ID_CLIENT);
        Date checkInDate = resultSet.getDate(CHECK_IN_DATE);
        Date checkOutDate = resultSet.getDate(CHECK_OUT_DATE);
        Date invoiceDate = resultSet.getDate(INVOICE_DATE);
        RoomType roomType = RoomType.valueOf(resultSet.getString(TYPE).toUpperCase());
        PlaceType placeType = PlaceType.valueOf(resultSet.getString(PLACE_NUMBER).toUpperCase());
        PaymentType paymentType = PaymentType.valueOf(resultSet.getString(PAYMENT_TYPE).toUpperCase());
        PaymentStatus paymentStatus = PaymentStatus.valueOf(resultSet.getString(PAYMENT_STATUS).toUpperCase());
        OrderStatus orderStatus = OrderStatus.valueOf(resultSet.getString(ORDER_STATUS).toUpperCase());

        String firstName = resultSet.getString(FIRST_NAME);
        String lastName = resultSet.getString(LAST_NAME);
        BigDecimal cost = resultSet.getBigDecimal(COST);

        return new Order(id, idClient, checkInDate, checkOutDate,invoiceDate, roomType, placeType, paymentType,
                paymentStatus, orderStatus, firstName, lastName,cost);
    }
}
