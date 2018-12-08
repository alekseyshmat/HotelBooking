package specification.searchSpecification.user;

import entity.types.Role;
import specification.Specification;

import java.util.Collections;
import java.util.List;

public class FindByRole implements Specification {

    private Role role;

    public FindByRole(Role role) {
        this.role = role;
    }

    @Override
    public String toSql() {
        return "where role = ?";
    }

    @Override
    public List<Object> getParametres() {
        return Collections.singletonList(role);
    }
}
