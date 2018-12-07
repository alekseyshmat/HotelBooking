package builder;

import entity.User;
import entity.types.Role;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class UserBuilder implements Builder<User> {

    private static final String FIRST_NAME = "first_name";
    private static final String LAST_NAME = "last_name";
    private static final String BIRTHDAY = "birthday";
    private static final String EMAIL = "email";
    private static final String LOGIN = "username";
    private static final String PASSWORD = "password";
    private static final String BALANCE = "balance";
    private static final String ROLE = "role";


    @Override
    public User build(ResultSet resultSet) throws SQLException {
        String firstName = resultSet.getString(FIRST_NAME);
        String lastName = resultSet.getString(LAST_NAME);
        Date birthday = resultSet.getDate(BIRTHDAY);
        String email = resultSet.getString(EMAIL);
        String login = resultSet.getString(LOGIN);
        String password = resultSet.getString(PASSWORD);
        BigDecimal balance = resultSet.getBigDecimal(BALANCE);
        Role role = Role.valueOf(resultSet.getString(ROLE).toUpperCase());

        return new User(firstName, lastName, birthday, email, login, password, balance, role);
    }
}
