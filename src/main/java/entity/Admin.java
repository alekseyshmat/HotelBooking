package entity;

import java.util.Objects;

public class Admin extends Person {

    private String position;


    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Admin admin = (Admin) obj;
        return Objects.equals(position, admin.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

    @Override
    public String toString() {
        return "Admin : " +
                ", position=" + position;
    }
}
