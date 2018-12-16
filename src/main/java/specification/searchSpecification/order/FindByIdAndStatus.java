package specification.searchSpecification.order;

import entity.types.OrderStatus;
import specification.Specification;

import java.util.Arrays;
import java.util.List;

public class FindByIdAndStatus implements Specification {

    private Integer idClient;
    private OrderStatus orderStatus;

    public FindByIdAndStatus(Integer idClient, OrderStatus orderStatus) {
        this.idClient = idClient;
        this.orderStatus = orderStatus;
    }

    @Override
    public String toSql() {
        return "WHERE id_client = ? AND order_status = ?";
    }

    @Override
    public List<Object> getParametres() {
        return Arrays.asList(idClient, orderStatus);
    }
}
