package builder;

import entity.Room;
import entity.RoomPrice;
import exception.RepositoryException;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Designed to build an object of type {@link entity.RoomPrice} with specified characteristics.
 */

public class RoomPriceBuilder implements Builder<RoomPrice> {

    private static final String ID = "id";
    private static final String ID_ROOM = "id_room";
    private static final String START_DATE = "start_date";
    private static final String END_DATE = "end_date";
    private static final String COST = "cost";

    /**
     * Builds an object of type Room price with properties.
     *
     * @param resultSet Instance of {@link java.sql.ResultSet} with property set to build an object type Room price.
     * @return Returns built object type Room price.
     * @throws RepositoryException Throws when SQL Exception is caught.
     */
    @Override
    public RoomPrice build(ResultSet resultSet) throws RepositoryException {
        try {
            Room room = new RoomBuilder().build(resultSet);

            Integer id = resultSet.getInt(ID);
            Integer idRoom = resultSet.getInt(ID_ROOM);

            Date startDate = resultSet.getDate(START_DATE);
            Date endDate = resultSet.getDate(END_DATE);
            BigDecimal cost = resultSet.getBigDecimal(COST);

            return new RoomPrice(id, idRoom, startDate, endDate, cost, room);
        } catch (SQLException e) {
            throw new RepositoryException(e.getMessage(), e);
        }
    }
}
