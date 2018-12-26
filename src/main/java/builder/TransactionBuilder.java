package builder;

import entity.Transaction;
import entity.types.OperationType;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class TransactionBuilder implements Builder<Transaction> {

    private static final String ID = "id";
    private static final String ID_CLIENT = "id_client";
    private static final String OPERATION = "operation";
    private static final String DATE = "date";
    private static final String SUM = "sum";

    @Override
    public Transaction build(ResultSet resultSet) throws SQLException {
        Integer id = resultSet.getInt(ID);
        Integer idClient = resultSet.getInt(ID_CLIENT);
        OperationType operationType = OperationType.valueOf(resultSet.getString(OPERATION).toUpperCase());
        Date oldDate = resultSet.getDate(DATE);
        LocalDate date = oldDate.toLocalDate();
        BigDecimal sum = resultSet.getBigDecimal(SUM);

        return new Transaction(id, idClient, operationType, date, sum);

    }
}
