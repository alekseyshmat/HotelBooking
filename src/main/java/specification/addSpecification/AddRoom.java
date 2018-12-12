package specification.addSpecification;

import entity.types.RoomType;
import specification.Specification;

import java.util.Arrays;
import java.util.List;

public class AddRoom implements Specification {

    private String roomNumber;
    private RoomType roomType;

    public AddRoom(String roomNumber, RoomType roomType) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
    }

    @Override
    public String toSql() {
        return "VALUES (?, ?)";
    }

    @Override
    public List<Object> getParametres() {
        return Arrays.asList(roomNumber, roomType);
    }
}
