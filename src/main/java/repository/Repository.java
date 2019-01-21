package repository;

import exception.RepositoryException;
import specification.Specification;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Designed to determine the behavior of the implementing class in the form of database access objects
 * of type T.
 *
 * @param <T> - type of object.
 */

public interface Repository<T> {

    /**
     * Performs a parameterized read query to the database,
     * expecting a single result in the form of an object of type T with the specified identifier.
     *
     * @param specification a {@link Specification} a object that contains last part of sql query and parameters
     * @return a {@link Optional} implementation with object.
     * @throws RepositoryException Signals that an database access object exception of some sort has occurred.
     */

    Optional<T> query(Specification specification) throws RepositoryException;

    /**
     * Performs a parameterized read query to a database to find all object type T.
     *
     * @param specification a {@link Specification} a object that contains last part of sql query and parameters
     * @return a {@link List} implementation with all finding objects.
     * @throws RepositoryException Signals that an database access object exception of some sort has occurred.
     */

    List<T> queryAll(Specification specification) throws RepositoryException;

    /**
     * The method designed for the process of saving a objects in database.
     *
     * @param item an object type T that should be saved to the database.
     * @throws RepositoryException Signals that an database access object exception of some sort has occurred.
     */

    void save(T item) throws RepositoryException;

    String getTableName();

    /**
     * The method designed for the process of return fields of objects.
     *
     * @param item an object type T that should be returned from the database.
     */

    Map<String, Object> getFields(T item);
}
