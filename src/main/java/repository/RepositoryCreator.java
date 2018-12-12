package repository;

import dataBase.ConnectionPool;

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

    public OrderRepository getOrderRepository(){
        return new OrderRepository(connection);
    }
    @Override
    public void close(){
        connectionPool.returnConnection(connection);
    }

    public RoomPriceRepository getRoomPriceRepository() {
        return new RoomPriceRepository(connection);
    }
}
