package specification.searchSpecification.user;

import specification.Specification;

import java.util.Collections;
import java.util.List;

public class FindByLogin implements Specification {

    private String login;

    public FindByLogin(String login) {
        this.login = login;
    }

    @Override
    public String toSql() {
        return "WHERE username=?";
    }

    @Override
    public List<Object> getParametres() {
        return Collections.singletonList(login);
    }
}
