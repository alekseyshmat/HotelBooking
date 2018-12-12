package repository;

import builder.RoomBuilder;
import entity.Room;
import specification.Specification;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class RoomRepository extends AbstractRepository<Room> {
    private static final String TABLE_NAME = " `room` ";

    private static final String ROOM_NUMBER = "room_number";
    private static final String ROOM_TYPE = "type";
    private static final String PLACE_NUMBER = "place_number";
    private static final String BUSY = "is_busy";

    private static final String SELECT_QUERY = "SELECT * FROM room ";
    private static final String INSERT_QUERY = "INSERT INTO";
    private static final String VALUES = "VALUES (?, ?)";

    public RoomRepository(Connection connection) {
        super(connection);
    }

    @Override
    protected Map<String, Object> getFields(Room item) {
        Map<String, Object> values = new HashMap<>();
        values.put(ROOM_NUMBER, item.getRoomNumber());
        values.put(ROOM_TYPE, item.getRoomType());
        values.put(PLACE_NUMBER, item.getPlaceType());
        values.put(BUSY, item.isBusy());

        return values;
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

    //    @Override
    public void queryAdd(Specification specification) {
        String query = INSERT_QUERY + specification.toSql();
        List<Object> params = specification.getParametres();
//        executeUpdate(query, params);
    }

    //    @Override
    public void save(Room item) {
        String query = INSERT_QUERY + getTableName() + VALUES;
        save(getFields(item), query);
    }


}
