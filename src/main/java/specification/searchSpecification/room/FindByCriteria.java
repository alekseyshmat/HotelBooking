package specification.searchSpecification.room;

import entity.types.RoomType;
import specification.Specification;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class FindByCriteria implements Specification {

    private RoomType roomType;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private boolean roomStatus;

    public FindByCriteria(RoomType roomType, LocalDate checkInDate, LocalDate checkOutDate, boolean roomStatus) {
        this.roomType = roomType;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.roomStatus = roomStatus;
    }

    @Override
    public String toSql() {
        return "WHERE (is_busy= ?  AND room.type =?)";
    }

    @Override
    public List<Object> getParametres() {
        return Arrays.asList(roomType, checkInDate, checkOutDate, roomStatus);
    }
}
