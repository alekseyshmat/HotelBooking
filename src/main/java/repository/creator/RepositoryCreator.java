package repository.creator;

import database.ConnectionPool;
import repository.*;

import java.sql.Connection;

/**
 * Provides {@link AutoCloseable} creator of dao implementation class with connection to database for each.
 */

public class RepositoryCreator implements AutoCloseable {

    private ConnectionPool connectionPool;
    private Connection connection;

    public RepositoryCreator() {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.getConnection();
    }

    /**
     * @return an {@link UserRepository} object with connection to database.
     */

    public UserRepository getUserRepository() {
        return new UserRepository(connection);
    }

    /**
     * @return an {@link RoomRepository} object with connection to database.
     */

    public RoomRepository getRoomRepository() {
        return new RoomRepository(connection);
    }

    /**
     * @return an {@link OrderRepository} object with connection to database.
     */
    public OrderRepository getOrderRepository() {
        return new OrderRepository(connection);
    }

    /**
     * @return an {@link RoomPriceRepository} object with connection to database.
     */
    public RoomPriceRepository getRoomPriceRepository() {
        return new RoomPriceRepository(connection);
    }

    /**
     * @return an {@link TransactionRepository} object with connection to database.
     */

    public TransactionRepository getTransactionRepository() {
        return new TransactionRepository(connection);
    }

    /**
     * @return an {@link RoomBusyRepository} object with connection to database.
     */
    public RoomBusyRepository getRoomBusyRepository() {
        return new RoomBusyRepository(connection);
    }

    /**
     *  Returns database connection to {@link ConnectionPool}
     */
    @Override
    public void close() {
        connectionPool.returnConnection(connection);
    }


}
