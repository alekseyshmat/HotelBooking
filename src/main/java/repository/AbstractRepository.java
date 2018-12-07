package repository;

import builder.Builder;
import builder.BuilderFactory;
import util.PrepareStatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class AbstractRepository<T> implements Repository{

    private static final String GET_ALL_QUERY = "SELECT * FROM ";
    private String WHERE_ID_CONDITION = " WHERE id = ?";

    private Connection connection;

    public AbstractRepository(Connection connection) {
        this.connection = connection;
    }

    public List<T> executeQuery(String sql, Builder<T> builder,  String... params)  {
        List<T> objects = new ArrayList<>();
        try  {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            PrepareStatement.prepare(preparedStatement, params);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                T item = builder.build(resultSet);
                objects.add(item);
            }

        } catch (SQLException e) {
//            throw new RepositoryException(e);
            throw new IllegalArgumentException();
        }
        return objects;
    }


    public Optional<T> executeQueryForSingleResult(String query, Builder<T> builder, String... params)  {

        List<T> items = executeQuery(query, builder, params);

        return items.size() == 1 ?
                Optional.of(items.get(0)) :
                Optional.empty();
    }

    protected abstract String getTableName();

    public Optional<T> findById(int id) {
        Builder builder = BuilderFactory.create(getTableName());
        String query = GET_ALL_QUERY + getTableName() + WHERE_ID_CONDITION;
        String stringId = String.valueOf(id);
        return executeQueryForSingleResult(query, builder, stringId);
    }
}
