package service;

import entity.Order;
import entity.types.OrderStatus;
import entity.types.PaymentType;
import entity.types.PlaceType;
import entity.types.RoomType;
import repository.OrderRepository;
import repository.RepositoryCreator;
import specification.searchSpecification.order.FindByIdAndStatus;
import specification.searchSpecification.order.FindByStatus;
import specification.searchSpecification.order.MakeOrder;

import java.util.Date;
import java.util.List;

public class OrderService {

    public List<Order> findByStatus(OrderStatus orderStatus) {
        RepositoryCreator repositoryCreator = new RepositoryCreator();
        OrderRepository orderRepository = repositoryCreator.getOrderRepository();
        return orderRepository.queryAll(new FindByStatus(orderStatus));
    }

    public void makeOrder(int idClient, Date checkInDate, Date checkOutDate,
                          RoomType roomType, PlaceType placeType, PaymentType paymentType) {
        RepositoryCreator repositoryCreator = new RepositoryCreator();
        OrderRepository orderRepository = repositoryCreator.getOrderRepository();
        orderRepository.queryAdd(new MakeOrder(idClient, checkInDate,
                checkOutDate, roomType, placeType, paymentType));
    }

    public List<Order> findByIdAndStatus(int id, OrderStatus orderStatus) {
        RepositoryCreator repositoryCreator = new RepositoryCreator();
        OrderRepository orderRepository = repositoryCreator.getOrderRepository();
        return orderRepository.queryAll(new FindByIdAndStatus(id, orderStatus));
    }
}
