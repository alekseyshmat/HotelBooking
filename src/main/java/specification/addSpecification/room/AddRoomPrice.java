package specification.addSpecification.room;

import specification.Specification;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class AddRoomPrice implements Specification {

    private int roomId;
    private LocalDate startDate;
    private LocalDate endDate;
    private BigDecimal cost;

    public AddRoomPrice(int roomId, LocalDate startDate, LocalDate endDate, BigDecimal cost) {
        this.roomId = roomId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.cost = cost;
    }

    @Override
    public String toSql() {
        return "VALUES (?, ?, ?, ?)";
    }

    @Override
    public List<Object> getParametres() {
        return Arrays.asList(roomId, startDate, endDate, cost);
    }
}
