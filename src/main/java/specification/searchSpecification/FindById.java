package specification.searchSpecification;

import specification.Specification;

import java.util.Collections;
import java.util.List;

public class FindById implements Specification {

    private int id;

    public FindById(int id) {
        this.id = id;
    }

    @Override
    public String toSql() {
        return "where id = ?";
    }

    @Override
    public List<Object> getParametres() {
        return Collections.singletonList(id);
    }
}
