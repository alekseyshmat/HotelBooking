package service;

import entity.Order;
import entity.types.OrderStatus;
import entity.types.PaymentStatus;
import entity.types.RoomType;
import exception.RepositoryException;
import exception.ServiceException;
import repository.OrderRepository;
import repository.creator.RepositoryCreator;
import specification.searchSpecification.order.FindByIdAndStatusJoinRoom;
import specification.searchSpecification.order.FindByIdAndTwoStatus;
import specification.searchSpecification.order.FindByStatusJoinUser;
import specification.searchSpecification.order.FindOptionalById;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

/**
 * Class provides methods to work with {@link Order} objects.
 */

public class OrderService {

    /**
     * The method searches for order with given identifier.
     *
     * @param id a {@link Integer} object identifier in database
     * @return a {@link Optional} implementation with {@link Order} object.
     * @throws ServiceException Signals that service exception of some sort has occurred.
     */

    public Optional<Order> findById(Integer id) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            OrderRepository orderRepository = repositoryCreator.getOrderRepository();
            return orderRepository.query(new FindOptionalById(id));
        } catch (RepositoryException ex) {
            throw new ServiceException(ex.getMessage(), ex);
        }
    }

    /**
     * The method searches for admin orders with given parameters.
     *
     * @param orderStatus a {@link OrderStatus} object that maps current status of the order.
     * @return an {@link List} implementation with {@link Order} objects.
     * @throws ServiceException Signals that service exception of some sort has occurred.
     */

    public List<Order> findByStatus(OrderStatus orderStatus) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            OrderRepository orderRepository = repositoryCreator.getOrderRepository();
            return orderRepository.queryAll(new FindByStatusJoinUser(orderStatus));
        } catch (RepositoryException ex) {
            throw new ServiceException(ex.getMessage(), ex);
        }
    }

    /**
     * The method searches for user orders with given parameters.
     *
     * @param id          a {@link Integer} object identifier in database
     * @param orderStatus a {@link OrderStatus} object that maps current status of the order.
     * @return an {@link List} implementation with {@link Order} objects.
     * @throws ServiceException Signals that service exception of some sort has occurred.
     */

    public List<Order> findByIdAndStatus(Integer id, OrderStatus orderStatus) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            OrderRepository orderRepository = repositoryCreator.getOrderRepository();
            return orderRepository.queryAll(new FindByIdAndStatusJoinRoom(id, orderStatus));
        } catch (RepositoryException ex) {
            throw new ServiceException(ex.getMessage(), ex);
        }
    }

    /**
     * The method searches for user orders with given parameters.
     *
     * @param id                a {@link Integer} object identifier in database
     * @param firstOrderStatus  a {@link OrderStatus} object that maps first type status of the order.
     * @param secondOrderStatus a {@link OrderStatus} object that maps second type status of the order.
     * @return an {@link List} implementation with {@link Order} objects.
     * @throws ServiceException Signals that service exception of some sort has occurred.
     */

    public List<Order> findByIdAndTwoStatus(Integer id, OrderStatus firstOrderStatus, OrderStatus secondOrderStatus)
            throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            OrderRepository orderRepository = repositoryCreator.getOrderRepository();
            return orderRepository.queryAll(new FindByIdAndTwoStatus(id, firstOrderStatus, secondOrderStatus));
        } catch (RepositoryException ex) {
            throw new ServiceException(ex.getMessage(), ex);
        }
    }

    /**
     * The method process order.
     *
     * @param id          a {@link Integer} object identifier in database
     * @param idRoom      a {@link Integer} object room identifier in database
     * @param cost        a {@link BigDecimal} object that maps cost of the order.
     * @param orderStatus a {@link OrderStatus} object that maps status of the order.
     * @throws ServiceException Signals that service exception of some sort has occurred.
     */

    public void processOrder(Integer id, Integer idRoom, BigDecimal cost, OrderStatus orderStatus) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            OrderRepository orderRepository = repositoryCreator.getOrderRepository();
            Order order = new Order(id, idRoom, cost, orderStatus);
            orderRepository.save(order);
        } catch (RepositoryException ex) {
            throw new ServiceException(ex.getMessage(), ex);
        }
    }

    /**
     * The method complete order.
     *
     * @param id          a {@link Integer} object identifier in database
     * @param invoiceDate a {@link Date} object that maps current date.
     * @param orderStatus a {@link OrderStatus} object that maps status of the order.
     * @throws ServiceException Signals that service exception of some sort has occurred.
     */

    public void completeOrder(Integer id, Date invoiceDate, OrderStatus orderStatus) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            OrderRepository orderRepository = repositoryCreator.getOrderRepository();
            Order order = new Order(id, invoiceDate, orderStatus);
            orderRepository.save(order);
        } catch (RepositoryException ex) {
            throw new ServiceException(ex.getMessage(), ex);
        }
    }

    /**
     * The method pay order.
     *
     * @param id            a {@link Integer} object identifier in database
     * @param paymentStatus a {@link PaymentStatus} object that maps payment status of the order.
     * @throws ServiceException Signals that service exception of some sort has occurred.
     */

    public void payOrder(Integer id, PaymentStatus paymentStatus) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            OrderRepository orderRepository = repositoryCreator.getOrderRepository();
            Order order = new Order(id, paymentStatus);
            orderRepository.save(order);
        } catch (RepositoryException ex) {
            throw new ServiceException(ex.getMessage(), ex);
        }
    }

    /**
     * The method make order.
     *
     * @param id           a {@link Integer} object identifier in database
     * @param idClient     a {@link Integer} object client identifier in database
     * @param checkInDate  a {@link Date} object that maps check in date of the order.
     * @param checkOutDate a {@link Date} object that maps check out date of the order.
     * @param roomType     a {@link RoomType} object that maps room type of the order.
     * @throws ServiceException Signals that service exception of some sort has occurred.
     */

    public void makeOrder(Integer id, Integer idClient, Date checkInDate, Date checkOutDate,
                          RoomType roomType) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            OrderRepository orderRepository = repositoryCreator.getOrderRepository();
            Order order = new Order(id, idClient, checkInDate, checkOutDate, roomType);
            orderRepository.save(order);
        } catch (RepositoryException ex) {
            throw new ServiceException(ex.getMessage(), ex);
        }
    }

    /**
     * The method searches for user orders with given parameters.
     *
     * @param id          a {@link Integer} object identifier in database
     * @param orderStatus a {@link OrderStatus} object that maps current status of the order.
     * @throws ServiceException Signals that service exception of some sort has occurred.
     */
    public void cancelOrder(Integer id, OrderStatus orderStatus) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            Order order = new Order(id, orderStatus);
            OrderRepository orderRepository = repositoryCreator.getOrderRepository();
            orderRepository.save(order);
        } catch (RepositoryException ex) {
            throw new ServiceException(ex.getMessage(), ex);
        }
    }
}
