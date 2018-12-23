package specification.searchSpecification.order;

import specification.Specification;

import java.util.Collections;
import java.util.List;

public class FindOptionalById implements Specification {

   Integer id;

    public FindOptionalById(Integer id) {
        this.id = id;
    }

    @Override
    public String toSql() {
        return "INNER JOIN user ON user.id = `order`.id_client " +
                "LEFT JOIN room ON room.id=`order`.id_room " +
                "WHERE `order`.id =?";
    }

    @Override
    public List<Object> getParametres() {
        return Collections.singletonList(id);
    }
}
