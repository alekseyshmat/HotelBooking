package entity;

import entity.types.OrderStatus;
import entity.types.PaymentStatus;
import entity.types.RoomType;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class Order implements Entity {

    private Integer id;
    private Integer idClient;
    private Integer idRoom;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private RoomType type;
    private LocalDate invoiceDate;
    private PaymentStatus paymentStatus;
    private OrderStatus orderStatus;
    private String firstName;
    private String lastName;
    private BigDecimal cost;
    private String roomNumber;

    //builder user
    public Order(Integer id, Integer idClient, LocalDate checkInDate, LocalDate checkOutDate, RoomType type,
                   PaymentStatus paymentStatus, OrderStatus orderStatus,
                 BigDecimal cost, String roomNumber) {
        this.id = id;
        this.idClient = idClient;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.type = type;
        this.paymentStatus = paymentStatus;
        this.orderStatus = orderStatus;
        this.cost = cost;
        this.roomNumber = roomNumber;
    }

    //process order
    public Order(Integer id, Integer idRoom, BigDecimal cost, OrderStatus orderStatus) {
        this.id = id;
        this.idRoom = idRoom;
        this.cost = cost;
        this.orderStatus = orderStatus;
    }

    //complete order
    public Order(Integer id, LocalDate invoiceDate, OrderStatus orderStatus) {
        this.id = id;
        this.invoiceDate = invoiceDate;
        this.orderStatus = orderStatus;
    }

    //show order admin
    public Order(Integer id, Integer idClient, LocalDate checkInDate, LocalDate checkOutDate, LocalDate invoiceDate,
                 RoomType roomType, PaymentStatus paymentStatus,
                 OrderStatus orderStatus, String firstName, String lastName, BigDecimal cost) {
        this.id = id;
        this.idClient = idClient;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.type = roomType;
        this.invoiceDate = invoiceDate;
        this.paymentStatus = paymentStatus;
        this.orderStatus = orderStatus;
        this.firstName = firstName;
        this.lastName = lastName;
        this.cost = cost;
    }

    //pay order
    public Order(Integer id, PaymentStatus paymentStatus) {
        this.id = id;
        this.paymentStatus = paymentStatus;
    }

    //make order
    public Order(Integer id, Integer idClient, LocalDate checkInDate, LocalDate checkOutDate, RoomType roomType) {
        this.id = id;
        this.idClient = idClient;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.type = roomType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    public Integer getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(Integer idRoom) {
        this.idRoom = idRoom;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public RoomType getType() {
        return type;
    }

    public void setType(RoomType type) {
        this.type = type;
    }

    public LocalDate getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(LocalDate invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Order order = (Order) obj;
        return id == order.id &&
                idClient == order.idClient &&
                Objects.equals(checkInDate, order.checkInDate) &&
                Objects.equals(checkOutDate, order.checkOutDate) &&
                Objects.equals(invoiceDate, order.invoiceDate) &&
                Objects.equals(paymentStatus, order.paymentStatus) &&
                Objects.equals(orderStatus, order.orderStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idClient, checkInDate, checkOutDate,
                 invoiceDate, paymentStatus, orderStatus);
    }

    @Override
    public String toString() {
        return "Order : " +
                ", id=" + id +
                ", id client=" + idClient +
                ", check in date=" + checkInDate +
                ", check out date=" + checkOutDate +
                ", invoice date=" + invoiceDate +
                ", payment status=" + paymentStatus +
                ", order status=" + orderStatus;
    }
}
