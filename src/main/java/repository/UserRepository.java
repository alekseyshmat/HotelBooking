package repository;

import builder.Builder;
import builder.UserBuilder;
import entity.User;
import exception.RepositoryException;
import specification.Specification;

import java.sql.Connection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class UserRepository extends AbstractRepository<User> {
    private static final String TABLE_NAME = "user";
    private static final String SELECT_QUERY = "SELECT * FROM user ";


    public UserRepository(Connection connection) {
        super(connection);
    }

    @Override
    public Map<String, Object> getFields(User item) {
        return null;
    }

    @Override
    public String getTableName() {
        return null;
    }

    @Override
    public Optional<User> query(Specification specification) throws RepositoryException {
        String query = SELECT_QUERY + specification.toSql();
        Builder<User> builder = new UserBuilder();
        List<Object> params = specification.getParametres();
        return executeQueryForSingleResult(query, builder, params);
    }

    @Override
    public List<User> queryAll(Specification specification) {
        String query = SELECT_QUERY + specification.toSql();
        Builder<User> builder = new UserBuilder();
        List<Object> params = specification.getParametres();
        return executeQuery(query, builder, params);
    }

    @Override
    public void save(User item) {

    }

    //    @Override
    public void queryAdd(Specification specification) {

    }


}
