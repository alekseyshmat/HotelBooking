package specification.searchSpecification.room;

import specification.Specification;

import java.util.Collections;
import java.util.List;

public class FindAll implements Specification {

    @Override
    public String toSql() {
        return "";
    }

    @Override
    public List<Object> getParametres() {
        return Collections.emptyList();
    }
}
