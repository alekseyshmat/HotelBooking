package entity;

import entity.types.OrderStatus;
import entity.types.PaymentStatus;
import entity.types.RoomType;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

public class Order implements Entity {

    private Integer id;
    private Integer idClient;
    private Integer idRoom;
    private Date checkInDate;
    private Date checkOutDate;
    private RoomType type;
    private Date invoiceDate;
    private PaymentStatus paymentStatus;
    private OrderStatus orderStatus;
    private BigDecimal cost;
    private User user;
    private Room room;

    //process order
    public Order(Integer id, Integer idRoom, BigDecimal cost, OrderStatus orderStatus) {
        this.id = id;
        this.idRoom = idRoom;
        this.cost = cost;
        this.orderStatus = orderStatus;
    }

    //adminOrders order
    public Order(Integer id, Date invoiceDate, OrderStatus orderStatus) {
        this.id = id;
        this.invoiceDate = invoiceDate;
        this.orderStatus = orderStatus;
    }

    //pay order
    public Order(Integer id, PaymentStatus paymentStatus) {
        this.id = id;
        this.paymentStatus = paymentStatus;
    }

    //make order
    public Order(Integer id, Integer idClient, Date checkInDate, Date checkOutDate, RoomType roomType) {
        this.id = id;
        this.idClient = idClient;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.type = roomType;
    }

    //builder
    public Order(Integer id, Integer idClient, Date checkInDate, Date checkOutDate, Date invoiceDate,
                 RoomType roomType, PaymentStatus paymentStatus, OrderStatus orderStatus, BigDecimal cost, User user, Room room) {
        this.id = id;
        this.idClient = idClient;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.invoiceDate = invoiceDate;
        this.type = roomType;
        this.paymentStatus = paymentStatus;
        this.orderStatus = orderStatus;
        this.cost = cost;
        this.user = user;
        this.room = room;
    }

    //cancel
    public Order(Integer id, OrderStatus orderStatus) {
        this.id = id;
        this.orderStatus = orderStatus;
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

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
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
        return Objects.equals(id, order.id) &&
                Objects.equals(idClient, order.idClient) &&
                Objects.equals(idRoom, order.idRoom) &&
                Objects.equals(checkInDate, order.checkInDate) &&
                Objects.equals(checkOutDate, order.checkOutDate) &&
                Objects.equals(invoiceDate, order.invoiceDate) &&
                Objects.equals(type, order.getType()) &&
                Objects.equals(paymentStatus, order.paymentStatus) &&
                Objects.equals(orderStatus, order.orderStatus) &&
                Objects.equals(cost, order.getCost()) &&
                Objects.equals(user, order.getUser()) &&
                Objects.equals(room, order.getRoom());
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 17;
        result = prime * result + id;
        result = prime * result + idClient;
        result = prime * result + idRoom;
        result = prime * result + checkInDate.hashCode();
        result = prime * result + checkOutDate.hashCode();
        result = prime * result + invoiceDate.hashCode();
        result = prime * result + type.hashCode();
        result = prime * result + paymentStatus.hashCode();
        result = prime * result + orderStatus.hashCode();
        result = prime * result + cost.hashCode();
        result = prime * result + user.hashCode();
        result = prime * result + room.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Order : " +
                ", id=" + id +
                ", id client=" + idClient +
                ", id room=" + idRoom +
                ", check in date=" + checkInDate +
                ", check out date=" + checkOutDate +
                ", invoice date=" + invoiceDate +
                ", type=" + type +
                ", payment status=" + paymentStatus +
                ", order status=" + orderStatus +
                ", cost=" + cost +
                ", user=" + user +
                ", room=" + room;
    }
}
