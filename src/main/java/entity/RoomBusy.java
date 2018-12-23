package entity;

import java.sql.Date;

public class RoomBusy implements Entity {

    private Integer id;
    private Integer idRoom;
    private Date startDate;
    private Date endDate;
    private Room room;
    private RoomPrice roomPrice;


    public RoomBusy(Integer id, Integer idRoom, Date startDate, Date endDate, Room room, RoomPrice roomPrice) {
        this.id = id;
        this.idRoom = idRoom;
        this.startDate = startDate;
        this.endDate = endDate;
        this.room = room;
        this.roomPrice = roomPrice;
    }

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
}
