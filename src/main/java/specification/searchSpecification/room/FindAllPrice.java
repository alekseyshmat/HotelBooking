package specification.searchSpecification.room;

import specification.Specification;

import java.util.Collections;
import java.util.List;

public class FindAllPrice implements Specification {

    @Override
    public String toSql() {
        return "INNER JOIN room ON room.id = room_price.id_room;";
    }

    @Override
    public List<Object> getParametres() {
        return Collections.emptyList();
    }
}
