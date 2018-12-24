package specification.searchSpecification.room;

import specification.Specification;

import java.util.Collections;
import java.util.List;

public class FindAllPrice implements Specification {

    private Integer id;

    public FindAllPrice(Integer id) {
        this.id = id;
    }

    @Override
    public String toSql() {
        return "INNER JOIN room " +
                "ON room.id = room_price.id_room " +
                "WHERE room_price.id_room = ? " +
                "ORDER BY room_price.start_date ASC ";
    }

    @Override
    public List<Object> getParametres() {
        return Collections.singletonList(id);
    }
}
