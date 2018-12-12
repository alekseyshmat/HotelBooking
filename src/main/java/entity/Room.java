package entity;

import entity.types.PlaceType;
import entity.types.RoomType;

import java.math.BigDecimal;
import java.util.Objects;

public class Room {

    private int id;
    private String roomNumber;
    private RoomType roomType;
    private PlaceType placeType;
    private BigDecimal cost;
    private boolean busy;

    public Room(int id, String roomNumber, RoomType roomType, boolean busy) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.roomType = roomType;
//        this.placeType = placeType;
//        this.cost = cost;
        this.busy = busy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public PlaceType getPlaceType() {
        return placeType;
    }

    public void setPlaceType(PlaceType placeType) {
        this.placeType = placeType;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public boolean isBusy() {
        return busy;
    }

    public void setBusy(boolean busy) {
        this.busy = busy;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Room room = (Room) obj;
        return id == room.id &&
                Objects.equals(roomNumber, room.roomNumber) &&
                Objects.equals(roomType, room.roomType) &&
                Objects.equals(placeType, room.placeType) &&
                Objects.equals(cost, room.cost) &&
                Objects.equals(busy, room.busy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, roomNumber, roomType, placeType, cost, busy);
    }

    @Override
    public String toString() {
        return "Room : " +
                ", id=" + id +
                ", room number=" + roomNumber +
                ", room type=" + roomType +
                ", place type=" + placeType +
                ", cost=" + cost +
                ", busy=" + busy;
    }
}
