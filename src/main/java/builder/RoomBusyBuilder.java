package builder;

import entity.Room;
import entity.RoomBusy;
import entity.RoomPrice;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class RoomBusyBuilder implements Builder<RoomBusy> {

    private static final String ID = "id";
    private static final String ID_ROOM = "id_room";
    private static final String START_DATE = "date_start";
    private static final String END_DATE = "date_end";

    @Override
    public RoomBusy build(ResultSet resultSet) throws SQLException {
        RoomPrice roomPrice = new RoomPriceBuilder().build(resultSet);
        Room room = new RoomBuilder().build(resultSet);

        Integer id = resultSet.getInt(ID);
        Integer idRoom = resultSet.getInt(ID_ROOM);

        Date stingsStartDate = resultSet.getDate(START_DATE);
        LocalDate startDate = stingsStartDate.toLocalDate();

        Date stingEndDate = resultSet.getDate(END_DATE);
        LocalDate endDate = stingEndDate.toLocalDate();

        return new RoomBusy(id, idRoom, startDate, endDate, room, roomPrice);
    }
}
