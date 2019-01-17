package entity;

import java.sql.Date;
import java.util.Objects;

public class RoomBusy implements Entity {

    private Integer id;
    private Integer idRoom;
    private Date startDate;
    private Date endDate;
    private Room room;
    private RoomPrice roomPrice;

    //builder
    public RoomBusy(Integer id, Integer idRoom, Date startDate, Date endDate, Room room, RoomPrice roomPrice) {
        this.id = id;
        this.idRoom = idRoom;
        this.startDate = startDate;
        this.endDate = endDate;
        this.room = room;
        this.roomPrice = roomPrice;
    }

    //add busy room
    public RoomBusy(Integer id, Integer idRoom, Date startDate, Date endDate) {
        this.id = id;
        this.idRoom = idRoom;
        this.startDate = startDate;
        this.endDate = endDate;
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

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public RoomPrice getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(RoomPrice roomPrice) {
        this.roomPrice = roomPrice;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        RoomBusy roomBusy = (RoomBusy) obj;
        return Objects.equals(id, roomBusy.id) &&
                Objects.equals(idRoom, roomBusy.idRoom) &&
                Objects.equals(startDate, roomBusy.startDate) &&
                Objects.equals(endDate, roomBusy.endDate) &&
                Objects.equals(room, roomBusy.room)&&
                Objects.equals(roomPrice, roomBusy.roomPrice);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 17;
        result = prime * result + id;
        result = prime * result + idRoom;
        result = prime * result + startDate.hashCode();
        result = prime * result + endDate.hashCode();
        result = prime * result + room.hashCode();
        result = prime * result + roomPrice.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Room : " +
                ", id=" + id +
                ", start date=" + startDate +
                ", end date=" + endDate +
                ", room=" + room +
                ", room price=" + roomPrice;
    }
}
