package specification;

import java.util.List;

/**
 * Designed to determine the behavior of the implementing class in the form of specification
 * to making query.
 */

public interface Specification {

    /**
     * Add the second part of sql-query for the main part.
     *
     * @return an {@link String} objects with concrete sql-query.
     */
    String toSql();

    /**
     * Add the second part of sql-query for the main part.
     *
     * @return an {@link List} implementation with {@link Object} parameters for sql-query.
     */
    List<Object> getParametres();
}
