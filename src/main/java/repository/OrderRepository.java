package repository;

import builder.Builder;
import builder.OrderBuilder;
import builder.UserOrderBuilder;
import entity.Order;
import exception.RepositoryException;
import specification.Specification;

import java.sql.Connection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class OrderRepository extends AbstractRepository<Order> {
    private static final String TABLE_NAME = "`order`";
    private static final String SELECT_QUERY = "SELECT * FROM `order` ";
    private static final String ID ="id";
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

    public OrderRepository(Connection connection) {
        super(connection);
    }

    @Override
    public Map<String, Object> getFields(Order item) {
        Map<String, Object> values = new LinkedHashMap<>();
        values.put(ID, item.getId());
        values.put(ID_CLIENT, item.getIdClient());
        values.put(CHECK_IN_DATE,item.getCheckInDate() );
        values.put(CHECK_OUT_DATE,item.getCheckOutDate() );
        values.put(INVOICE_DATE,item.getInvoiceDate() );
        values.put(TYPE,item.getType() );
        values.put(PAYMENT_TYPE,item.getPaymentType() );
        values.put(PAYMENT_STATUS,item.getPaymentStatus() );
        values.put(ORDER_STATUS,item.getOrderStatus() );
        values.put(COST,item.getCost() );
        return values;
    }

    @Override
    public String getTableName() {
        return TABLE_NAME;
    }


    @Override
    public Optional<Order> query(Specification specification) throws RepositoryException {
        String query = SELECT_QUERY + specification.toSql();
        Builder<Order> builder = new OrderBuilder();
        List<Object> params = specification.getParametres();
        return executeQueryForSingleResult(query, builder, params);
    }

    @Override
    public List<Order> queryAll(Specification specification) throws RepositoryException {
        String query = SELECT_QUERY + specification.toSql();
        Builder<Order> builder = new OrderBuilder();
        List<Object> params = specification.getParametres();
        return executeQuery(query, builder, params);
    }

    public List<Order> queryAllUser(Specification specification) throws RepositoryException {
        String query = SELECT_QUERY + specification.toSql();
        Builder<Order> builder = new UserOrderBuilder();
        List<Object> params = specification.getParametres();
        return executeQuery(query, builder, params);
    }
}
