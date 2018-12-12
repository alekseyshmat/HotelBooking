package repository;

import builder.Builder;
import builder.RoomBuilder;
import builder.RoomPriceBuilder;
import entity.RoomPrice;
import specification.Specification;

import java.sql.Connection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class RoomPriceRepository extends AbstractRepository<RoomPrice> {

    private static final String SELECT_QUERY = "SELECT * FROM room_price ";
    private static final String INSERT_QUERY = "INSERT INTO `room_price` " +
            "(`id_room`, `start_date`, `end_date`, `cost`)";

    public RoomPriceRepository(Connection connection) {
        super(connection);
    }

    @Override
    protected Map<String, Object> getFields(RoomPrice item) {
        return null;
    }

    @Override
    protected String getTableName() {
        return null;
    }

    @Override
    public Optional<RoomPrice> query(Specification specification) {
        return null;
    }

    @Override
    public List<RoomPrice> queryAll(Specification specification) {
        String query = SELECT_QUERY + specification.toSql();
        List<Object> params = specification.getParametres();
        Builder<RoomPrice> builder = new RoomPriceBuilder();
        return executeQuery(query, builder, params);
    }

    @Override
    public void save(RoomPrice item) {

    }

    //    @Override
    public void queryAdd(Specification specification) {
        String query = INSERT_QUERY + specification.toSql();
        List<Object> params = specification.getParametres();
//        executeUpdate(query, params);
    }
}
