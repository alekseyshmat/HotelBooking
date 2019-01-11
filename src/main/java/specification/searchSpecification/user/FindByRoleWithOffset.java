package specification.searchSpecification.user;

import entity.types.Role;
import specification.Specification;

import java.util.Arrays;
import java.util.List;

public class FindByRoleWithOffset implements Specification {

    private Role role;
    private Integer limit;
    private Integer offset;

    public FindByRoleWithOffset(Role role, Integer limit, Integer offset) {
        this.role = role;
        this.limit = limit;
        this.offset = offset;
    }

    @Override
    public String toSql() {
        return "WHERE role = ? LIMIT ? OFFSET ? ";
    }

    @Override
    public List<Object> getParametres() {
        return Arrays.asList(role, limit, offset);
    }
}
