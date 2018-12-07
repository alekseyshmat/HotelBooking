package repository;

import builder.UserBuilder;
import entity.User;
import specification.Specification;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public class UserRepository extends AbstractRepository<User> {
    private static final String TABLE_NAME = "user";
    private static final String USERNAME_AND_PASSWORD_QUERY = "SELECT * FROM user WHERE username = ? AND password = ?";

    public UserRepository(Connection connection) {
        super(connection);
    }

    @Override
    protected String getTableName() {
        return TABLE_NAME;
    }


//    public Optional<User> findUserByLoginAndPassword(String login, String password) {
    public Optional<User> findUserByLoginAndPassword(Specification specification) {
        List<Object> parametres = specification.getParametres();
        Object login = parametres.get(0);
        Object password = parametres.get(1);

//        String encryptedPassword = DigestUtils.sha256Hex (password);
        return executeQueryForSingleResult(USERNAME_AND_PASSWORD_QUERY, new UserBuilder(), login, password);
    }

    @Override
    public List<User> query(Specification specification) {
        return null;
    }
}
