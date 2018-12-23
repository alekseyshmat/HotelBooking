package entity;

import entity.types.BlockingStatus;
import entity.types.Role;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class User implements Serializable, Entity {

    private Integer id;
    private String firstName;
    private String lastName;
    private Date birthday;
    private String email;
    private String login;
    private String password;
    private BlockingStatus blockingStatus;
    private BigDecimal balance;
    private Role role;

    //builder
    public User(Integer id, String firstName, String lastName, Date birthday, String email, String login, String password,
                BigDecimal balance, Role role, BlockingStatus blockingStatus) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.email = email;
        this.login = login;
        this.password = password;
        this.balance = balance;
        this.role = role;
        this.blockingStatus = blockingStatus;
    }

    //update profile
    public User(Integer id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    //update balance
    public User(Integer id, BigDecimal balance) {
        this.id = id;
        this.balance = balance;
    }

    public User(Integer id, BlockingStatus active) {
        this.id = id;
        this.blockingStatus = active;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Role getRole() {
        return role;
    }

    public BlockingStatus getBlockingStatus() {
        return blockingStatus;
    }

    public void setBlockingStatus(BlockingStatus blockingStatus) {
        this.blockingStatus = blockingStatus;
    }

    public void setRole(Role role) {
        this.role = role;
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
        return id == user.id &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(birthday, user.birthday) &&
                Objects.equals(email, user.email) &&
                Objects.equals(login, user.login) &&
                Objects.equals(password, user.password) &&
                Objects.equals(balance, user.balance) &&
                Objects.equals(role, user.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, birthday, email, login, password, balance, role);
    }

    @Override
    public String toString() {
        return "User : " +
                "id=" + id +
                ", first name=" + firstName +
                ", last name=" + lastName +
                ", birthday=" + birthday +
                ", email=" + email +
                ", login='" + login +
                ", password=" + password +
                ", balance=" + balance +
                ", role=" + role;
    }
}
