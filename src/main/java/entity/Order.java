package entity;

import entity.types.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class Order {

    private int id;
    private int idClient;
    private Date checkInDate;
    private Date checkOutDate;
    private RoomType type;
    private PlaceType placeNumber;
    private PaymentType paymentType;
    private Date invoiceDate;
    private PaymentStatus paymentStatus;
    private OrderStatus orderStatus;
    private String firstName;
    private String lastName;
    private BigDecimal cost;
    private String roomNumber;

    public Order(int id, int idClient, Date checkInDate, Date checkOutDate, PlaceType placeNumber,
                 PaymentType paymentType, Date invoiceDate, PaymentStatus paymentStatus, OrderStatus orderStatus) {
        this.id = id;
        this.idClient = idClient;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.placeNumber = placeNumber;
        this.paymentType = paymentType;
        this.invoiceDate = invoiceDate;
        this.paymentStatus = paymentStatus;
        this.orderStatus = orderStatus;
    }

    public Order(int id, int idClient, Date checkInDate, Date checkOutDate, RoomType type, PlaceType placeNumber,
                 PaymentType paymentType, PaymentStatus paymentStatus, OrderStatus orderStatus, String firstName, String lastName) {
        this.id = id;
        this.idClient = idClient;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.type = type;
        this.placeNumber = placeNumber;
        this.paymentType = paymentType;
        this.paymentStatus = paymentStatus;
        this.orderStatus = orderStatus;
        this.firstName = firstName;
        this.lastName = lastName;

    }

    public Order(int id, int idClient, Date checkInDate, Date checkOutDate, RoomType type, PlaceType placeNumber,
                 PaymentType paymentType, PaymentStatus paymentStatus, OrderStatus orderStatus,
                 BigDecimal cost, String roomNumber) {
        this.id = id;
        this.idClient = idClient;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.type = type;
        this.placeNumber = placeNumber;
        this.paymentType = paymentType;
        this.paymentStatus = paymentStatus;
        this.orderStatus = orderStatus;
        this.cost = cost;
        this.roomNumber = roomNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
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

    public PlaceType getPlaceNumber() {
        return placeNumber;
    }

    public void setPlaceNumber(PlaceType placeNumber) {
        this.placeNumber = placeNumber;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public Date getImvoiceDate() {
        return invoiceDate;
    }

    public void setImvoiceDate(Date imvoiceDate) {
        this.invoiceDate = imvoiceDate;
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
                Objects.equals(placeNumber, order.placeNumber) &&
                Objects.equals(paymentType, order.paymentType) &&
                Objects.equals(invoiceDate, order.invoiceDate) &&
                Objects.equals(paymentStatus, order.paymentStatus) &&
                Objects.equals(orderStatus, order.orderStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idClient, checkInDate, checkOutDate, placeNumber,
                paymentType, invoiceDate, paymentStatus, orderStatus);
    }

    @Override
    public String toString() {
        return "Order : " +
                ", id=" + id +
                ", id client=" + idClient +
                ", check in date=" + checkInDate +
                ", check out date=" + checkOutDate +
                ", place type=" + placeNumber +
                ", payment type=" + paymentType +
                ", invoice date=" + invoiceDate +
                ", payment status=" + paymentStatus +
                ", order status=" + orderStatus;
    }
}
