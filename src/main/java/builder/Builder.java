package builder;

import exception.RepositoryException;

import java.sql.ResultSet;

/**
 * Designed to determine the behavior of the implementing class in the form of construction
 * an object of type T with specified characteristics.
 *
 * @param <T> - type of object.
 */
public interface Builder<T> {

    /**
     * Builds an object of type T with properties.
     *
     * @param resultSet Instance of {@link java.sql.ResultSet} with property set to build an object type T.
     * @return Returns built object type T.
     * @throws RepositoryException Throws when SQL Exception is caught.
     */
    T build(ResultSet resultSet) throws RepositoryException;
}
