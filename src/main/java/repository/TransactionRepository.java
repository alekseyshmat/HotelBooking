package repository;

import builder.TransactionBuilder;
import entity.Transaction;
import exception.RepositoryException;
import specification.Specification;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class TransactionRepository extends AbstractRepository<Transaction> {

    private static final String TABLE_NAME = " `transaction` ";
    private static final String SELECT_QUERY = "SELECT * FROM ";
    private static final String ID_CLIENT = "id_client";
    private static final String OPERATION = "operation";
    private static final String DATE = "date";
    private static final String SUM = "sum";

    public TransactionRepository(Connection connection) {
        super(connection);
    }

    @Override
    public Optional<Transaction> query(Specification specification) throws RepositoryException {
        return Optional.empty();
    }

    @Override
    public List<Transaction> queryAll(Specification specification) throws RepositoryException {
        String query = SELECT_QUERY + getTableName() + specification.toSql();
        List<Object> params = specification.getParametres();
        return executeQuery(query, new TransactionBuilder(), params);
    }

    @Override
    public String getTableName() {
        return TABLE_NAME;
    }

    @Override
    public Map<String, Object> getFields(Transaction item) {
        Map<String, Object> values = new HashMap<>();
        values.put(ID_CLIENT, item.getIdClient());
        values.put(OPERATION, item.getOperationType());
        values.put(DATE, item.getDate());
        values.put(SUM, item.getSum());
        return values;
    }
}
