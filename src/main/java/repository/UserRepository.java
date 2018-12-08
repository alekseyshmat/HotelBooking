package repository;

import builder.Builder;
import builder.BuilderFactory;
import builder.UserBuilder;
import entity.User;
import specification.Specification;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public class UserRepository extends AbstractRepository<User> {
    private static final String TABLE_NAME = "user";
    private static final String SELECT_QUERY = "SELECT * FROM user ";

    public UserRepository(Connection connection) {
        super(connection);
    }

    @Override
    protected String getTableName() {
        return TABLE_NAME;
    }

    @Override
    public Optional<User> query(Specification specification) {
        String query = SELECT_QUERY + specification.toSql();
        return executeQueryForSingleResult(query, new UserBuilder(), specification.getParametres());
    }

    public List<User> queryAll(Specification specification) {
        String query = SELECT_QUERY + specification.toSql();
        return executeQuery(query, new UserBuilder(), specification.getParametres());
    }


}
