package builder;

import entity.RoomPrice;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class RoomPriceBuilder implements Builder<RoomPrice> {

    private static final String ID = "id";
    private static final String ID_ROOM = "id_room";
    private static final String ROOM_NUMBER = "room_number";
    private static final String START_DATE = "start_date";
    private static final String END_DATE = "end_date";
    private static final String COST = "cost";

    @Override
    public RoomPrice build(ResultSet resultSet) throws SQLException {
        Integer id = resultSet.getInt(ID);
        int idRoom = resultSet.getInt(ID_ROOM);
        String roomNumber = resultSet.getString(ROOM_NUMBER);

        Date start = resultSet.getDate(START_DATE);
        Date end = resultSet.getDate(END_DATE);
        BigDecimal cost = resultSet.getBigDecimal(COST);

        LocalDate startDate = start.toLocalDate();
        LocalDate endDate = end.toLocalDate();

        return new RoomPrice(id, idRoom, roomNumber, startDate, endDate, cost);
    }
}
