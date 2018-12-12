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

    public AbstractRepository(Connection connection) {
        this.connection = connection;
    }

    public List<T> executeQuery(String sql, Builder<T> builder, List<Object> params) {
        List<T> objects = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            PrepareStatement.prepare(preparedStatement, params);
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

    //    public void executeUpdate(String sql, List<Object> params){
    public void save(Map<String, Object> values, String sql) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            prepare(preparedStatement, values);


            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalArgumentException();
        }
    }

    protected void prepare(PreparedStatement preparedStatement, List<Object> params) throws SQLException {
        int length = params.size();
        for (int i = 0; i < length; i++) {
            preparedStatement.setString(i + 1, String.valueOf(params.get(i)));
        }
    }

    private void prepare(PreparedStatement preparedStatement, Map<String, Object> params) throws SQLException {
        int length = params.size();
        for (int i = 0; i < length; i++) {
            Object value = params.get("");
            preparedStatement.setString(i + 1, String.valueOf(value));
        }
    }

    protected abstract Map<String, Object> getFields(T item);

    protected abstract String getTableName();


}
