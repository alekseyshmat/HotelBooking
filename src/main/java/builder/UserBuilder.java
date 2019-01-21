package builder;

import entity.User;
import entity.types.BlockingStatus;
import entity.types.Role;
import exception.RepositoryException;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Designed to build an object of type {@link entity.User} with specified characteristics.
 */

public class UserBuilder implements Builder<User> {

    private static final String ID = "id";
    private static final String FIRST_NAME = "first_name";
    private static final String LAST_NAME = "last_name";
    private static final String BIRTHDAY = "birthday";
    private static final String EMAIL = "email";
    private static final String LOGIN = "username";
    private static final String PASSWORD = "password";
    private static final String BALANCE = "balance";
    private static final String ROLE = "role";
    private static final String BLOCKING_STATUS = "blocking_status";

    /**
     * Builds an object of type User with properties.
     *
     * @param resultSet Instance of {@link java.sql.ResultSet} with property set to build an object type User.
     * @return Returns built object type User.
     * @throws RepositoryException Throws when SQL Exception is caught.
     */

    @Override
    public User build(ResultSet resultSet) throws RepositoryException {
        try {
            Integer id = resultSet.getInt(ID);
            String firstName = resultSet.getString(FIRST_NAME);
            String lastName = resultSet.getString(LAST_NAME);
            Date birthday = resultSet.getDate(BIRTHDAY);
            String email = resultSet.getString(EMAIL);
            String login = resultSet.getString(LOGIN);
            String password = resultSet.getString(PASSWORD);
            BigDecimal balance = resultSet.getBigDecimal(BALANCE);
            Role role = Role.valueOf(resultSet.getString(ROLE).toUpperCase());
            BlockingStatus blockingStatus = BlockingStatus.valueOf(resultSet.getString(BLOCKING_STATUS).toUpperCase());

            return new User(id, firstName, lastName, birthday, email, login, password, balance, role, blockingStatus);
        } catch (SQLException e) {
            throw new RepositoryException(e.getMessage(), e);
        }
    }
}
