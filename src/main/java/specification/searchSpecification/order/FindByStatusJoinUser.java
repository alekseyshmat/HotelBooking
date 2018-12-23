package specification.searchSpecification.order;

import entity.types.OrderStatus;
import specification.Specification;

import java.util.Collections;
import java.util.List;

public class FindByStatusJoinUser implements Specification {

    private OrderStatus orderStatus;

    public FindByStatusJoinUser(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public String toSql() {
        return "INNER JOIN user ON user.id = `order`.id_client " +
                "LEFT JOIN room ON room.id = `order`.id_room " +
                "WHERE order_status = ?";
    }

    @Override
    public List<Object> getParametres() {
        return Collections.singletonList(orderStatus);
    }
}
