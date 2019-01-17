package entity;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;

public class RoomPrice implements Entity {

    private Integer id;
    private Integer idRoom;
    private Date startDate;
    private Date endDate;
    private BigDecimal cost;
    private Room room;

    //addprice
    public RoomPrice(Integer id, Integer idRoom, Date startDate, Date endDate, BigDecimal cost) {
        this.id = id;
        this.idRoom = idRoom;
        this.startDate = startDate;
        this.endDate = endDate;
        this.cost = cost;
    }

    //builder
    public RoomPrice(Integer id, Integer idRoom, Date startDate, Date endDate,
                     BigDecimal cost, Room room) {
        this.id = id;
        this.idRoom = idRoom;
        this.startDate = startDate;
        this.endDate = endDate;
        this.cost = cost;
        this.room = room;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(Integer idRoom) {
        this.idRoom = idRoom;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
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

        RoomPrice roomPrice = (RoomPrice) obj;
        return Objects.equals(id, roomPrice.id) &&
                Objects.equals(idRoom, roomPrice.idRoom) &&
                Objects.equals(startDate, roomPrice.startDate) &&
                Objects.equals(endDate, roomPrice.endDate) &&
                Objects.equals(cost, roomPrice.cost) &&
                Objects.equals(room, roomPrice.room);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 17;
        result = prime * result + id;
        result = prime * result + idRoom;
        result = prime * result + startDate.hashCode();
        result = prime * result + endDate.hashCode();
        result = prime * result + cost.hashCode();
        result = prime * result + room.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Room price: " +
                ", id=" + id +
                ", id room=" + idRoom +
                ", start date=" + startDate +
                ", end date=" + endDate +
                ", cost=" + cost +
                ", room=" + room;
    }
}
