package repository;

import builder.RoomBuilder;
import entity.Room;
import specification.Specification;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public class RoomRepository extends AbstractRepository<Room> {
    private static final String TABLE_NAME = "room";
    private static final String SELECT_QUERY = "SELECT * FROM room ";

    public RoomRepository(Connection connection) {
        super(connection);
    }

    @Override
    protected String getTableName() {
        return TABLE_NAME;
    }


    @Override
    public Optional<Room> query(Specification specification) {
        String query = SELECT_QUERY + specification.toSql();
        List<Object> params = specification.getParametres();
        return executeQueryForSingleResult(query, new RoomBuilder(), params);
    }

    @Override
    public List<Room> queryAll(Specification specification) {
        String query = SELECT_QUERY + specification.toSql();
        List<Object> params = specification.getParametres();
        return executeQuery(query, new RoomBuilder(), params);
    }
}
