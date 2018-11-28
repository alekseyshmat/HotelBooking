package entity;

import java.math.BigDecimal;
import java.util.Objects;

public class User extends Person {

    private BigDecimal balance;

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        User user = (User) obj;
        return Objects.equals(balance, user.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(balance);
    }

    @Override
    public String toString() {
        return "User : " +
                ", balance=" + balance;
    }
}
