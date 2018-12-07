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

    public UserRepository getUserRepository(){
        return new UserRepository(connection);
    }
    @Override
    public void close() throws Exception {
        //слздает конекшн пул
        //получаем соед
    }
}
