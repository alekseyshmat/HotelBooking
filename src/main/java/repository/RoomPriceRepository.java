package repository;

import builder.Builder;
import builder.RoomPriceBuilder;
import entity.RoomPrice;
import exception.RepositoryException;
import specification.Specification;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class RoomPriceRepository extends AbstractRepository<RoomPrice> {

    private static final String SELECT_QUERY = "SELECT * FROM room_price ";
    private static final String TABLE_NAME = "room_price";
    private static final String ID_ROOM = "id_room";
    private static final String START_DATE = "start_date";
    private static final String END_DATE = "end_date";
    private static final String COST = "cost";

    public RoomPriceRepository(Connection connection) {
        super(connection);
    }

    @Override
    public Map<String, Object> getFields(RoomPrice item) {
        Map<String, Object> values = new HashMap<>();
        values.put(ID_ROOM, item.getIdRoom());
        values.put(START_DATE, item.getStartDate());
        values.put(END_DATE, item.getEndDate());
        values.put(COST, item.getCost());
        return values;
    }

    @Override
    public String getTableName() {
        return TABLE_NAME;
    }

    @Override
    public Optional<RoomPrice> query(Specification specification) {
        return null;
    }

    @Override
    public List<RoomPrice> queryAll(Specification specification) throws RepositoryException {
        String query = SELECT_QUERY + specification.toSql();
        List<Object> params = specification.getParametres();
        Builder<RoomPrice> builder = new RoomPriceBuilder();
        return executeQuery(query, builder, params);
    }

}
