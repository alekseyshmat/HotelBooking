package entity;

import java.time.LocalDate;

public class RoomBusy implements Entity {

    private Integer id;
    private Integer idRoom;
    private LocalDate startDate;
    private LocalDate endDate;
    private Room room;
    private RoomPrice roomPrice;


    public RoomBusy(Integer id, Integer idRoom, LocalDate startDate, LocalDate endDate, Room room, RoomPrice roomPrice) {
        this.id = id;
        this.idRoom = idRoom;
        this.startDate = startDate;
        this.endDate = endDate;
        this.room=room;
        this.roomPrice=roomPrice;
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

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
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
