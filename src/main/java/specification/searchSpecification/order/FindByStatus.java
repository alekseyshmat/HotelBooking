package specification.searchSpecification.order;

import entity.types.OrderStatus;
import specification.Specification;

import java.util.Collections;
import java.util.List;

public class FindByStatus implements Specification {

    private OrderStatus orderStatus;

    public FindByStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public String toSql() {
        return "where order_status = ?";
    }

    @Override
    public List<Object> getParametres() {
        return Collections.singletonList(orderStatus);
    }
}
