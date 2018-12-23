package specification.searchSpecification.room;

import entity.types.RoomType;
import specification.Specification;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class FindByCriteria implements Specification {

    private RoomType roomType;
    private Date checkInDate;
    private Date checkOutDate;

    public FindByCriteria(RoomType roomType, Date checkInDate, Date checkOutDate) {
        this.roomType = roomType;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    @Override
    public String toSql() {
//        return "INNER JOIN room_price rp ON rp.id_room = room.id WHERE (is_busy= ?  AND room.type =?)"
      /* return "RIGHT JOIN room " +
                "ON room.id = room_busy.id_room " +
                "LEFT JOIN room_price rp " +
                "ON room_busy.id_room = rp.id_room WHERE(type = ?  " +
                "AND(( ? NOT BETWEEN date_start and date_end AND ? NOT BETWEEN date_start and date_end ) " +
                "OR ( date_start IS NOT NULL OR date_end IS NOT NULL )) " +
                "AND(( ? BETWEEN start_date and end_date AND ? BETWEEN start_date and end_date ) " +
                "OR  ( cost IS NULL)))";*/

        return "RIGHT JOIN room " +
                "ON room.id = room_busy.id_room " +
                "LEFT JOIN room_price " +
                "ON room.id = room_price.id_room WHERE(type =? " +
                "AND ((? NOT BETWEEN date_start and date_end " +
                " AND ? NOT BETWEEN date_start and date_end) " +
                "OR (date_start IS NULL AND date_end IS NULL)) " +
                " AND ? BETWEEN start_date and end_date " +
                " AND ? BETWEEN start_date and end_date " +
                ")";
    }

    @Override
    public List<Object> getParametres() {
//        return Arrays.asList(roomType, checkInDate, checkOutDate, roomStatus);
        return Arrays.asList(roomType, checkInDate, checkOutDate, checkInDate, checkOutDate);
    }
}
