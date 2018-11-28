package entity;

import java.util.Date;
import java.util.Objects;

public abstract class Person {

    private int id;
    private String firstName;
    private String lastName;
    private Date birthday;
    private String login;
    private String password;

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

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Person person = (Person) obj;
        return id == person.id &&
                Objects.equals(firstName, person.firstName) &&
                Objects.equals(lastName, person.lastName) &&
                Objects.equals(birthday, person.birthday) &&
                Objects.equals(login, person.login) &&
                Objects.equals(password, person.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, birthday, login, password);
    }

    @Override
    public String toString() {
        return "Person : " +
                "id=" + id +
                ", first name=" + firstName +
                ", last name=" + lastName +
                ", birthday=" + birthday +
                ", login='" + login + '\'' +
                ", password=" + password;
    }
}
