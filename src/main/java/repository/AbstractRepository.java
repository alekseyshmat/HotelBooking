package repository;

import builder.Builder;
import entity.Entity;
import exception.RepositoryException;
import repository.helper.QueryHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * This class provides a skeletal implementation of the {@link Repository} interface,
 * to minimize the effort required to implement this interface.
 */

public abstract class AbstractRepository<T extends Entity> implements Repository<T> {

    private Connection connection;

    AbstractRepository(Connection connection) {
        this.connection = connection;
    }

    /**
     * Performs a parameterized read query to a database with parameters, waiting for a set of objects,
     * and builds them with the help of a concrete builder implementation.
     *
     * @param sql     a {@link String} object that contains database query.
     * @param builder a implementation of {@link Builder} with a concrete class whose objects are to be built.
     * @param params  a {@link List} List of objects that contains parameters that should be substituted in query.
     * @return a {@link List} implementation with objects.
     * @throws RepositoryException Signals that an database access object exception of some sort has occurred.
     */

    List<T> executeQuery(String sql, Builder<T> builder, List<Object> params) throws RepositoryException {
        List<T> objects = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            QueryHelper.prepare(preparedStatement, params);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                T item = builder.build(resultSet);
                objects.add(item);
            }
        } catch (SQLException ex) {
            throw new RepositoryException(ex.getMessage(), ex);
        }
        return objects;
    }

    /**
     * Performs a parameterized read query to a database with parameters, waiting for an object,
     * and builds them with the help of a concrete builder implementation.
     *
     * @param query   a {@link String} object that contains database query.
     * @param builder a implementation of {@link Builder} with a concrete class whose object is to be built.
     * @param params  a {@link List} List of objects that contains parameters that should be substituted in query.
     * @return a {@link Optional} implementation with object.
     * @throws RepositoryException Signals that an database access object exception of some sort has occurred.
     */

    Optional<T> executeQueryForSingleResult(String query, Builder<T> builder, List<Object> params) throws RepositoryException {
        List<T> items = executeQuery(query, builder, params);

        return items.size() == 1 ?
                Optional.of(items.get(0)) :
                Optional.empty();
    }

    /**
     * Performs update query to a database with parameters or insert new item to a database .
     *
     * @param item a {@link T} object that updates or inserts in database.
     * @throws RepositoryException Signals that an database access object exception of some sort has occurred.
     */

    public void save(T item) throws RepositoryException {
        try {
            String sql;
            if (item.getId() != null) {
                sql = QueryHelper.makeUpdateQuery(getFields(item), getTableName());
            } else {
                sql = QueryHelper.makeInsertQuery(getFields(item), getTableName());
            }
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            QueryHelper.prepare(preparedStatement, getFields(item));

            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            throw new RepositoryException(ex.getMessage(), ex);
        }
    }
}
