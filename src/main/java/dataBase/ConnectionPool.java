package dataBase;

import java.sql.Connection;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public class ConnectionPool {

    private static final ReentrantLock lock = new ReentrantLock();
    private static AtomicBoolean initialized = new AtomicBoolean(false);
    private static ConnectionPool instance;
    private Deque<Connection> connections;
    private Semaphore semaphore;
    private int connectionSize = 10;

    private ConnectionPool() {
        initConnections();
        createConnections();
    }

    public static ConnectionPool getInstance() {
        if (!initialized.get()) {
            try {
                lock.lock();
                if (!initialized.get()) {
                    instance = new ConnectionPool();
                    initialized.set(true);
                }
            } finally {
                lock.unlock();
            }
        }
        return instance;
    }

    private void initConnections() {
        connections = new ArrayDeque<>();
        semaphore = new Semaphore(connectionSize);
    }

    private void createConnections() {
        for (int i = 0; i < connectionSize; i++) {
            Connection connection = ConnectionCreator.createConnection();
            connections.push(connection);
        }
        if (connections.isEmpty()) {
            throw new IllegalArgumentException("Connections are not created!");
        }
    }
    public Connection getConnection() {
        try {
            lock.lock();
            semaphore.acquire();
            return connections.pop();
        } catch (InterruptedException e) {
            throw new IllegalArgumentException();
        } finally {
            lock.unlock();
        }
    }

    public void returnConnection(Connection connection){
        try {
            lock.lock();
            connections.push(connection);
            semaphore.release();
        } finally {
            lock.unlock();
        }
    }
}
