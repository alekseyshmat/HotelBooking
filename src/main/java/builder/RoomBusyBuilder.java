package builder;

import entity.Room;
import entity.RoomBusy;
import entity.RoomPrice;
import exception.RepositoryException;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Designed to build an object of type {@link entity.RoomBusy} with specified characteristics.
 */

public class RoomBusyBuilder implements Builder<RoomBusy> {

    private static final String ID = "id";
    private static final String ID_ROOM = "id_room";
    private static final String START_DATE = "date_start";
    private static final String END_DATE = "date_end";

    /**
     * Builds an object of type RoomBusy with properties.
     *
     * @param resultSet Instance of {@link java.sql.ResultSet} with property set to build an object type RoomBusy.
     * @return Returns built object type RoomBusy.
     * @throws RepositoryException Throws when SQL Exception is caught.
     */


    @Override
    public RoomBusy build(ResultSet resultSet) throws RepositoryException {
        try {
            RoomPrice roomPrice = new RoomPriceBuilder().build(resultSet);
            Room room = new RoomBuilder().build(resultSet);

            Integer id = resultSet.getInt(ID);
            Integer idRoom = resultSet.getInt(ID_ROOM);

            Date stingsStartDate = resultSet.getDate(START_DATE);
            Date stingEndDate = resultSet.getDate(END_DATE);

            return new RoomBusy(id, idRoom, stingsStartDate, stingEndDate, room, roomPrice);
        } catch (SQLException e) {
            throw new RepositoryException(e.getMessage(), e);
        }
    }
}
