package builder;

import entity.Room;
import entity.types.RoomType;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RoomBuilder implements Builder<Room> {

    private static final String ID = "id";
    private static final String ROOM_NUMBER = "room_number";
    private static final String TYPE = "type";
    private static final String BUSY = "is_busy";

    @Override
    public Room build(ResultSet resultSet) throws SQLException {
        Integer id = resultSet.getInt(ID);
        String roomNumber = resultSet.getString(ROOM_NUMBER);
        RoomType roomType = RoomType.valueOf(resultSet.getString(TYPE).toUpperCase());
        boolean busy = resultSet.getBoolean(BUSY);

        return new Room(id, roomNumber, roomType, busy);
    }
}
