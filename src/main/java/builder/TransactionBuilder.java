package builder;

import entity.Transaction;
import entity.types.OperationType;
import exception.RepositoryException;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Designed to build an object of type {@link entity.Transaction} with specified characteristics.
 */

public class TransactionBuilder implements Builder<Transaction> {

    private static final String ID = "id";
    private static final String ID_CLIENT = "id_client";
    private static final String OPERATION = "operation";
    private static final String DATE = "date";
    private static final String SUM = "sum";

    /**
     * Builds an object of type Transaction with properties.
     *
     * @param resultSet Instance of {@link java.sql.ResultSet} with property set to build an object type Transaction.
     * @return Returns built object type Transaction.
     * @throws RepositoryException Throws when SQL Exception is caught.
     */

    @Override
    public Transaction build(ResultSet resultSet) throws RepositoryException {
        try {
            Integer id = resultSet.getInt(ID);
            Integer idClient = resultSet.getInt(ID_CLIENT);
            OperationType operationType = OperationType.valueOf(resultSet.getString(OPERATION).toUpperCase());
            Date oldDate = resultSet.getDate(DATE);
            BigDecimal sum = resultSet.getBigDecimal(SUM);

            return new Transaction(id, idClient, operationType, oldDate, sum);
        } catch (SQLException e) {
            throw new RepositoryException(e.getMessage(), e);
        }
    }
}
