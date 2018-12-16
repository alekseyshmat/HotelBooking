package specification.searchSpecification.order;

import entity.types.OrderStatus;
import specification.Specification;

import java.util.Arrays;
import java.util.List;

public class FindByIdAndStatusJoinRoom implements Specification {

    private Integer idClient;
    private OrderStatus orderStatus;

    public FindByIdAndStatusJoinRoom(Integer idClient, OrderStatus orderStatus) {
        this.idClient = idClient;
        this.orderStatus = orderStatus;
    }

    @Override
    public String toSql() {
        return "left JOIN room r ON r.id = `order`.id_room where (`order`.id_client = ? AND order_status = ?)";
    }

    @Override
    public List<Object> getParametres() {
        return Arrays.asList(idClient, orderStatus);
    }
}
