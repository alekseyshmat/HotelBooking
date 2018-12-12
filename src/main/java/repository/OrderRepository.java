package repository;

import builder.Builder;
import builder.OrderBuilder;
import entity.Order;
import specification.Specification;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public class OrderRepository extends AbstractRepository<Order> {
    private static final String TABLE_NAME = "order";
    private static final String SELECT_QUERY = "SELECT * FROM `order` ";
    private static final String INSERT_QUERY = "INSERT INTO `order` (`id_client`, `check_in_date`, " +
            "`check_out_date`, `type`, `place_number`, `payment_type`) ";

    public OrderRepository(Connection connection) {
        super(connection);
    }

    @Override
    protected String getTableName() {
        return TABLE_NAME;
    }

    @Override
    public Optional<Order> query(Specification specification) {
        String query = SELECT_QUERY + specification.toSql();
        Builder<Order> builder = new OrderBuilder();
        List<Object> params = specification.getParametres();
        return executeQueryForSingleResult(query, builder, params);
    }

    @Override
    public List<Order> queryAll(Specification specification) {
        String query = SELECT_QUERY + specification.toSql();
        Builder<Order> builder = new OrderBuilder();
        List<Object> params = specification.getParametres();
        return executeQuery(query, builder, params);
    }

    @Override
    public void queryAdd(Specification specification) {
        String query = INSERT_QUERY + specification.toSql();
        List<Object> params = specification.getParametres();
        executeUpdate(query, params);
    }
}
