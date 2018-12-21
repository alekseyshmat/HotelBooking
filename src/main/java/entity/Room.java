package entity;

import entity.types.RoomType;

import java.math.BigDecimal;
import java.util.Objects;

public class Room implements Entity {

    private Integer id;
    private String roomNumber;
    private RoomType roomType;
    private BigDecimal cost;

    //build without join
    public Room(Integer id, String roomNumber, RoomType roomType) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.roomType = roomType;
    }



    //build with join
    public Room(Integer id, String roomNumber, RoomType roomType, BigDecimal cost, boolean busy) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.cost = cost;
    }

    public Integer getId() {
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

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
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
                Objects.equals(cost, room.cost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, roomNumber, roomType, cost);
    }

    @Override
    public String toString() {
        return "Room : " +
                ", id=" + id +
                ", room number=" + roomNumber +
                ", room type=" + roomType +
                ", cost=" + cost;
    }
}
