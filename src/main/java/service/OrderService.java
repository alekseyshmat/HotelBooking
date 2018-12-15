package service;

import entity.Order;
import entity.types.OrderStatus;
import entity.types.PaymentStatus;
import entity.types.PaymentType;
import entity.types.RoomType;
import exception.RepositoryException;
import exception.ServiceException;
import repository.OrderRepository;
import repository.UserRepository;
import repository.creator.RepositoryCreator;
import specification.searchSpecification.FindById;
import specification.searchSpecification.order.FindByIdAndStatus;
import specification.searchSpecification.order.FindByIdAndStatusJoinRoom;
import specification.searchSpecification.order.FindByStatusJoinUser;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class OrderService {

    public Optional<Order> findById(Integer id) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            OrderRepository orderRepository = repositoryCreator.getOrderRepository();
            return orderRepository.query(new FindById(id));
        } catch (RepositoryException ex) {
            throw new ServiceException(ex.getMessage(), ex);
        }
    }

    public List<Order> findByStatus(OrderStatus orderStatus) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            OrderRepository orderRepository = repositoryCreator.getOrderRepository();
            return orderRepository.queryAll(new FindByStatusJoinUser(orderStatus));
        } catch (RepositoryException ex) {
            throw new ServiceException(ex.getMessage(), ex);
        }
    }

    public void makeOrder(int idClient, LocalDate checkInDate, LocalDate checkOutDate,
                          RoomType roomType, PaymentType paymentType) {
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

    public void completeOrder(Integer id, LocalDate invoiceDate, OrderStatus orderStatus) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            OrderRepository orderRepository = repositoryCreator.getOrderRepository();
            Order order = new Order(id, invoiceDate, orderStatus);
            orderRepository.save(order);
        } catch (RepositoryException ex) {
            throw new ServiceException(ex.getMessage(), ex);
        }
    }

    public void payOrder(Integer id, PaymentStatus paymentStatus) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            OrderRepository orderRepository = repositoryCreator.getOrderRepository();
            Order order = new Order(id, paymentStatus);
            orderRepository.save(order);
        } catch (RepositoryException ex) {
            throw new ServiceException(ex.getMessage(), ex);
        }
    }
}
