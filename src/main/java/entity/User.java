package entity;

import entity.types.Role;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class User implements Serializable {

    private int id;
    private String firstName;
    private String lastName;
    private Date birthday;
    private String email;
    private String login;
    private String password;
    private BigDecimal balance;
    private boolean admin;

    private Role role;

    public User(String firstName, Role role) {
        this.firstName = firstName;
        this.role = role;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public Role getRole() {
        return role;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        User person = (User) obj;
        return id == person.id &&
                Objects.equals(firstName, person.firstName) &&
                Objects.equals(lastName, person.lastName) &&
                Objects.equals(birthday, person.birthday) &&
                Objects.equals(email, person.email) &&
                Objects.equals(login, person.login) &&
                Objects.equals(password, person.password) &&
                Objects.equals(balance, person.balance) &&
                Objects.equals(admin, person.admin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, birthday, email, login, password, balance, admin);
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
                ", isAdmin=" + admin;
    }
}
