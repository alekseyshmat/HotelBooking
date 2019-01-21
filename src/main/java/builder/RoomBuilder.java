package builder;

import entity.Room;
import entity.types.RoomType;
import exception.RepositoryException;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Designed to build an object of type {@link entity.Room} with specified characteristics.
 */

public class RoomBuilder implements Builder<Room> {

    private static final String ID = "room.id";
    private static final String ROOM_NUMBER = "room_number";
    private static final String TYPE = "type";

    /**
     * Builds an object of type Room with properties.
     *
     * @param resultSet Instance of {@link java.sql.ResultSet} with property set to build an object type Room.
     * @return Returns built object type Room.
     * @throws RepositoryException Throws when SQL Exception is caught.
     */

    @Override
    public Room build(ResultSet resultSet) throws RepositoryException {
        try {
            Integer id = resultSet.getInt(ID);
            String roomNumber = resultSet.getString(ROOM_NUMBER);
            RoomType roomType = RoomType.valueOf(resultSet.getString(TYPE).toUpperCase());

            return new Room(id, roomNumber, roomType);
        } catch (SQLException e) {
            throw new RepositoryException(e.getMessage(), e);
        }
    }
}
