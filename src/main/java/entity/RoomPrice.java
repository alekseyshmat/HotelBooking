package entity;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;

public class RoomPrice implements Entity {

    private Integer id;
    private Integer idRoom;
    private String roomNumber;
    private Date startDate;
    private Date endDate;
    private BigDecimal cost;
    private Room room;


    public RoomPrice(Integer id, Integer idRoom, Date startDate, Date endDate, BigDecimal cost) {
        this.id = id;
        this.idRoom = idRoom;
        this.startDate = startDate;
        this.endDate = endDate;
        this.cost = cost;
    }

    public RoomPrice(Integer id, Integer idRoom, String roomNumber, Date startDate, Date endDate,
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

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
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
}
