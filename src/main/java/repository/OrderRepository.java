package repository;

import builder.Builder;
import builder.OrderBuilder;
import builder.UserOrderBuilder;
import entity.Order;
import exception.RepositoryException;
import specification.Specification;

import java.sql.Connection;
import java.util.List;
import java.util.Map;
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
    public Map<String, Object> getFields(Order item) {
        return null;
    }

    @Override
    public String getTableName() {
        return null;
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
