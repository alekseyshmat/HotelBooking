package entity;

import entity.types.OrderStatus;
import entity.types.PaymentStatus;
import entity.types.PaymentType;
import entity.types.RoomType;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

public class Order implements Entity {

    private Integer id;
    private Integer idClient;
    private Integer idRoom;
    private Date checkInDate;
    private Date checkOutDate;
    private RoomType type;
    private PaymentType paymentType;
    private LocalDate invoiceDate;
    private Date invoiceDateNew;
    private PaymentStatus paymentStatus;
    private OrderStatus orderStatus;
    private String firstName;
    private String lastName;
    private BigDecimal cost;
    private String roomNumber;

    public Order(Integer id, Integer idClient, Date checkInDate, Date checkOutDate,
                 PaymentType paymentType, LocalDate invoiceDate, PaymentStatus paymentStatus, OrderStatus orderStatus) {
        this.id = id;
        this.idClient = idClient;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.paymentType = paymentType;
        this.invoiceDate = invoiceDate;
        this.paymentStatus = paymentStatus;
        this.orderStatus = orderStatus;
    }

    public Order(Integer id, Integer idClient, Date checkInDate, Date checkOutDate, LocalDate invoiceDate, RoomType type,
                 PaymentType paymentType, PaymentStatus paymentStatus,
                 OrderStatus orderStatus, String firstName, String lastName, BigDecimal cost) {
        this.id = id;
        this.idClient = idClient;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.invoiceDate = invoiceDate;
        this.type = type;
        this.paymentType = paymentType;
        this.paymentStatus = paymentStatus;
        this.orderStatus = orderStatus;
        this.firstName = firstName;
        this.lastName = lastName;
        this.cost = cost;

    }

    public Order(Integer id, Integer idClient, Date checkInDate, Date checkOutDate, RoomType type,
                 PaymentType paymentType, PaymentStatus paymentStatus, OrderStatus orderStatus,
                 BigDecimal cost, String roomNumber) {
        this.id = id;
        this.idClient = idClient;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.type = type;
        this.paymentType = paymentType;
        this.paymentStatus = paymentStatus;
        this.orderStatus = orderStatus;
        this.cost = cost;
        this.roomNumber = roomNumber;
    }

    public Order(Integer id, Integer idRoom, BigDecimal cost, OrderStatus orderStatus) {
        this.id = id;
        this.idRoom = idRoom;
        this.cost = cost;
        this.orderStatus = orderStatus;
    }


    public Order(Integer id, LocalDate invoiceDate, OrderStatus orderStatus) {
        this.id = id;
        this.invoiceDate = invoiceDate;
        this.orderStatus = orderStatus;
    }

    public Order(Integer id, Integer idClient, Date checkInDate, Date checkOutDate, Date invoiceDate,
                 RoomType roomType, PaymentType paymentType, PaymentStatus paymentStatus,
                 OrderStatus orderStatus, String firstName, String lastName, BigDecimal cost) {
        this.id = id;
        this.idClient = idClient;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.paymentType = paymentType;
        this.type = roomType;
        this.invoiceDateNew = invoiceDate;
        this.paymentStatus = paymentStatus;
        this.orderStatus = orderStatus;
        this.firstName = firstName;
        this.lastName = lastName;
        this.cost = cost;
    }

    public Order(Integer id, PaymentStatus paymentStatus) {
        this.id = id;
        this.paymentStatus = paymentStatus;
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

    public Date getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
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
                Objects.equals(paymentType, order.paymentType) &&
                Objects.equals(invoiceDate, order.invoiceDate) &&
                Objects.equals(paymentStatus, order.paymentStatus) &&
                Objects.equals(orderStatus, order.orderStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idClient, checkInDate, checkOutDate,
                paymentType, invoiceDate, paymentStatus, orderStatus);
    }

    @Override
    public String toString() {
        return "Order : " +
                ", id=" + id +
                ", id client=" + idClient +
                ", check in date=" + checkInDate +
                ", check out date=" + checkOutDate +
                ", payment type=" + paymentType +
                ", invoice date=" + invoiceDate +
                ", payment status=" + paymentStatus +
                ", order status=" + orderStatus;
    }
}
