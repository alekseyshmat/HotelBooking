package entity;

import entity.types.RoomType;

import java.math.BigDecimal;
import java.util.Objects;

public class Room implements Entity {

    private Integer id;
    private String roomNumber;
    private RoomType roomType;
    private BigDecimal cost;
    private boolean isDeleted;

    public Room(Integer id, String roomNumber, RoomType roomType) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.roomType = roomType;
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

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
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
        return Objects.equals(id, room.id) &&
                Objects.equals(roomNumber, room.roomNumber) &&
                Objects.equals(roomType, room.roomType) &&
                Objects.equals(cost, room.cost) &&
                Objects.equals(isDeleted, room.isDeleted);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 17;
        result = prime * result + id;
        result = prime * result + roomNumber.hashCode();
        result = prime * result + roomType.hashCode();
        result = prime * result + cost.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Room : " +
                ", id=" + id +
                ", room number=" + roomNumber +
                ", room type=" + roomType +
                ", cost=" + cost +
                ", is deleted=" + isDeleted;
    }
}
