package specification.searchSpecification;

import entity.User;
import specification.Specification;

import java.util.Arrays;
import java.util.List;

public class FindByLoginAndPassword implements Specification<User> {

    private String login;
    private String password;

    public FindByLoginAndPassword(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Override
    public String toSql() {
        return "where username = ? AND password = ?";
    }

    @Override
    public List<Object> getParametres() {
        return Arrays.asList(login, password);
    }
}
