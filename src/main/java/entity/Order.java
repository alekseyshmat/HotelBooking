package entity;

import entity.types.PaymentStatus;
import entity.types.PaymentType;
import entity.types.PlaceType;
import entity.types.OrderStatus;

import java.util.Date;
import java.util.Objects;

public class Order {

    private int id;
    private int idClient;
    private Date checkInDate;
    private Date checkOutDate;
    private PlaceType placeType;
    private PaymentType paymentType;
    private Date invoiceDate;
    private PaymentStatus paymentStatus;
    private OrderStatus orderStatus;

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

    public PlaceType getPlaceType() {
        return placeType;
    }

    public void setPlaceType(PlaceType placeType) {
        this.placeType = placeType;
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
                Objects.equals(placeType, order.placeType) &&
                Objects.equals(paymentType, order.paymentType) &&
                Objects.equals(invoiceDate, order.invoiceDate) &&
                Objects.equals(paymentStatus, order.paymentStatus) &&
                Objects.equals(orderStatus, order.orderStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idClient, checkInDate, checkOutDate, placeType,
                paymentType, invoiceDate, paymentStatus, orderStatus);
    }

    @Override
    public String toString() {
        return "Order : " +
                ", id=" + id +
                ", id client=" + idClient +
                ", check in date=" + checkInDate +
                ", check out date=" + checkOutDate +
                ", place type=" + placeType +
                ", payment type=" + paymentType +
                ", invoice date=" + invoiceDate +
                ", payment status=" + paymentStatus +
                ", order status=" + orderStatus;
    }
}
