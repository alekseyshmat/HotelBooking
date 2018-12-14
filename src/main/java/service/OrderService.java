package service;

import entity.Order;
import entity.types.OrderStatus;
import entity.types.PaymentType;
import entity.types.PlaceType;
import entity.types.RoomType;
import exception.RepositoryException;
import exception.ServiceException;
import repository.OrderRepository;
import repository.creator.RepositoryCreator;
import specification.searchSpecification.order.FindByIdAndStatus;
import specification.searchSpecification.order.FindByIdAndStatusJoinRoom;
import specification.searchSpecification.order.FindByStatusJoinUser;

import javax.sql.rowset.serial.SerialException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class OrderService {

    public List<Order> findByStatus(OrderStatus orderStatus) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            OrderRepository orderRepository = repositoryCreator.getOrderRepository();
            return orderRepository.queryAll(new FindByStatusJoinUser(orderStatus));
        } catch (RepositoryException ex) {
            throw new ServiceException(ex.getMessage(), ex);
        }
    }

    public void makeOrder(int idClient, LocalDate checkInDate, LocalDate checkOutDate,
                          RoomType roomType, PlaceType placeType, PaymentType paymentType) {
        RepositoryCreator repositoryCreator = new RepositoryCreator();
        OrderRepository orderRepository = repositoryCreator.getOrderRepository();
//        orderRepository.queryAdd(new MakeOrder(idClient, checkInDate,
//                checkOutDate, roomType, placeType, paymentType));
    }

    public List<Order> findByIdAndStatus(int id, OrderStatus orderStatus) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            OrderRepository orderRepository = repositoryCreator.getOrderRepository();
            return orderRepository.queryAllUser(new FindByIdAndStatus(id, orderStatus));
        } catch (RepositoryException ex) {
            throw new ServiceException(ex.getMessage(), ex);
        }
    }

    public List<Order> findByIdAndStatusWithJoin(int id, OrderStatus orderStatus) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            OrderRepository orderRepository = repositoryCreator.getOrderRepository();
            return orderRepository.queryAllUser(new FindByIdAndStatusJoinRoom(id, orderStatus));
        } catch (RepositoryException ex) {
            throw new ServiceException(ex.getMessage(), ex);
        }
    }

    public void processOrder(Integer id, int idRoom, BigDecimal cost, OrderStatus orderStatus) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            OrderRepository orderRepository = repositoryCreator.getOrderRepository();
            Order order = new Order(id, idRoom, cost, orderStatus);
            orderRepository.save(order);
        } catch (RepositoryException ex) {
            throw new ServiceException(ex.getMessage(), ex);
        }
    }
}
