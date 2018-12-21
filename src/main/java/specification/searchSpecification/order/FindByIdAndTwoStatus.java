package specification.searchSpecification.order;

import entity.types.OrderStatus;
import specification.Specification;

import java.util.Arrays;
import java.util.List;

public class FindByIdAndTwoStatus implements Specification {

    private Integer id;
    private OrderStatus firstOrderStatus;
    private OrderStatus secondOrderStatus;

    public FindByIdAndTwoStatus(Integer id, OrderStatus firstOrderStatus, OrderStatus secondOrderStatus) {
        this.id = id;
        this.firstOrderStatus = firstOrderStatus;
        this.secondOrderStatus = secondOrderStatus;
    }

    @Override
    public String toSql() {
        return "INNER JOIN user u ON u.id = `order`.id_client " +
                "LEFT JOIN room r ON r.id=`order`.id_room  " +
                "WHERE (`order`.id_client = ? AND " +
                "order_status IN(?, ?))";
    }

    @Override
    public List<Object> getParametres() {
        return Arrays.asList(id, firstOrderStatus, secondOrderStatus);
    }
}
