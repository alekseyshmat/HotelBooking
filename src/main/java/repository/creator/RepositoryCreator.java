package repository.creator;

import dataBase.ConnectionPool;
import repository.*;

import java.sql.Connection;

public class RepositoryCreator implements AutoCloseable {

    private ConnectionPool connectionPool;
    private Connection connection;

    public RepositoryCreator() {
        connectionPool = ConnectionPool.getInstance();
        connection = connectionPool.getConnection();
    }

    public UserRepository getUserRepository() {
        return new UserRepository(connection);
    }

    public RoomRepository getRoomRepository() {
        return new RoomRepository(connection);
    }

    public OrderRepository getOrderRepository() {
        return new OrderRepository(connection);
    }

    public RoomPriceRepository getRoomPriceRepository() {
        return new RoomPriceRepository(connection);
    }

    public TransactionRepository getTransactionRepository() {
        return new TransactionRepository(connection);
    }

    public RoomBusyRepository getRoomBusyRepository() {
        return new RoomBusyRepository(connection);
    }

    @Override
    public void close() {
        connectionPool.returnConnection(connection);
    }


}
