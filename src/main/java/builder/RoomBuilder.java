package builder;

import entity.Room;
import entity.RoomPrice;
import entity.types.RoomType;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RoomBuilder implements Builder<Room> {

    private static final String ID = "room.id";
    private static final String ROOM_NUMBER = "room_number";
    private static final String TYPE = "type";

    @Override
    public Room build(ResultSet resultSet) throws SQLException {
        Integer id = resultSet.getInt(ID);
        String roomNumber = resultSet.getString(ROOM_NUMBER);
        RoomType roomType = RoomType.valueOf(resultSet.getString(TYPE).toUpperCase());

        return new Room(id, roomNumber, roomType);
    }
}
