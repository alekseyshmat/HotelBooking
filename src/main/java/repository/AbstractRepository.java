package repository;

import builder.Builder;
import util.PrepareStatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public abstract class AbstractRepository<T> implements Repository<T> {

    private Connection connection;
    private String INSERT_QUERY = "INSERT INTO ";
    private String VALUES = " VALUES";

    public AbstractRepository(Connection connection) {
        this.connection = connection;
    }

    public List<T> executeQuery(String sql, Builder<T> builder, List<Object> params) {
        List<T> objects = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            prepare(preparedStatement, params);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                T item = builder.build(resultSet);
                objects.add(item);
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException();
        }
        return objects;
    }


    public Optional<T> executeQueryForSingleResult(String query, Builder<T> builder, List<Object> params) {
        List<T> items = executeQuery(query, builder, params);

        return items.size() == 1 ?
                Optional.of(items.get(0)) :
                Optional.empty();
    }

    public void save(T item) {
        try {
            String sql = prepareSql(item);
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            prepare(preparedStatement, item);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalArgumentException();
        }
    }

    private void prepare(PreparedStatement preparedStatement, List<Object> params) throws SQLException {
        int length = params.size();
        for (int i = 0; i < length; i++) {
            preparedStatement.setString(i + 1, String.valueOf(params.get(i)));
        }
    }

    private String prepareSql(T item) {
        StringBuilder columns = new StringBuilder("(");
        StringBuilder values = new StringBuilder("(");

        for (Map.Entry<String, Object> entry : getFields(item).entrySet()) {
            String column = entry.getKey();
            columns.append(" `").append(column).append("`,");
            values.append(" ?,");
        }
        values.deleteCharAt(values.lastIndexOf(","));
        columns.deleteCharAt(columns.lastIndexOf(","));
        values.append(")");
        columns.append(")");
        return INSERT_QUERY + getTableName() + columns + VALUES + values;
    }

    private void prepare(PreparedStatement preparedStatement, T item) throws SQLException {
        int i = 1;
        for (Map.Entry<String, Object> entry : getFields(item).entrySet()) {
            preparedStatement.setString(i++, String.valueOf(entry.getValue()));
        }
    }
}
