package repository;

import builder.Builder;
import builder.UserBuilder;
import entity.User;
import exception.RepositoryException;
import specification.Specification;

import java.sql.Connection;
import java.util.*;

public class UserRepository extends AbstractRepository<User> {
    private static final String TABLE_NAME = "user";
    private static final String SELECT_QUERY = "SELECT * FROM user ";

    private static final String ID = "id";
    private static final String LAST_NAME = "last_name";
    private static final String FIRST_NAME = "first_name";
    private static final String BIRTHDAY = "birthday";
    private static final String EMAIL = "email";
    private static final String BALANCE = "balance";
    private static final String ROLE = "role";
    private static final String ACTIVE = "blocking_status";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";

    public UserRepository(Connection connection) {
        super(connection);
    }

    @Override
    public Map<String, Object> getFields(User item) {
        Map<String, Object> values = new LinkedHashMap<>();
        values.put(LAST_NAME, item.getLastName());
        values.put(FIRST_NAME, item.getFirstName());
        values.put(BIRTHDAY, item.getBirthday());
        values.put(BALANCE, item.getBalance());
        values.put(EMAIL, item.getEmail());
        values.put(ROLE, item.getRole());
        values.put(ACTIVE, item.getBlockingStatus());
        values.put(USERNAME, item.getLogin());
        values.put(PASSWORD, item.getPassword());
        values.put(ID, item.getId());
        return values;
    }

    @Override
    public String getTableName() {
        return TABLE_NAME;
    }

    @Override
    public Optional<User> query(Specification specification) throws RepositoryException {
        String query = SELECT_QUERY + specification.toSql();
        Builder<User> builder = new UserBuilder();
        List<Object> params = specification.getParametres();
        return executeQueryForSingleResult(query, builder, params);
    }

    @Override
    public List<User> queryAll(Specification specification) throws RepositoryException {
        String query = SELECT_QUERY + specification.toSql();
        Builder<User> builder = new UserBuilder();
        List<Object> params = specification.getParametres();
        return executeQuery(query, builder, params);
    }

}
