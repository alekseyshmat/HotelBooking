package repository;

import builder.Builder;
import builder.RoomBusyBuilder;
import entity.RoomBusy;
import exception.RepositoryException;
import specification.Specification;

import java.sql.Connection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class RoomBusyRepository extends AbstractRepository<RoomBusy> {

    private static final String DELIMITER = "delimiter // ";
    private static final String SET_QUERY = "DECLARE @checkIn DATE(), @checkOut DATE(); SET @checkIn =?; SET @checkOut=?; ";
    private static final String SELECT_QUERY = "SELECT * FROM `room_busy` ";
    private static final String TABLE_NAME = " `room_busy` ";
    private static final String ID = "id";
    private static final String ID_ROOM = "id_room";
    private static final String START_DATE = "date_start";
    private static final String END_DATE = "date_end";

    public RoomBusyRepository(Connection connection) {
        super(connection);
    }

    @Override
    public Optional<RoomBusy> query(Specification specification) throws RepositoryException {
        String query = DELIMITER + SET_QUERY + SELECT_QUERY + specification.toSql();
        Builder<RoomBusy> builder = new RoomBusyBuilder();
        List<Object> params = specification.getParametres();
        return executeQueryForSingleResult(query, builder, params);
    }

    @Override
    public List<RoomBusy> queryAll(Specification specification) throws RepositoryException {
//        String query = SET_QUERY + SELECT_QUERY + specification.toSql();
        String query = SELECT_QUERY + specification.toSql();
        Builder<RoomBusy> builder = new RoomBusyBuilder();
        List<Object> params = specification.getParametres();
        return executeQuery(query, builder, params);
    }

    @Override
    public String getTableName() {
        return TABLE_NAME;
    }

    @Override
    public Map<String, Object> getFields(RoomBusy item) {
        Map<String, Object> values = new LinkedHashMap<>();
        values.put(ID_ROOM, item.getIdRoom());
        values.put(START_DATE, item.getStartDate());
        values.put(END_DATE, item.getEndDate());
        values.put(ID, item.getId());
        return values;
    }
}
