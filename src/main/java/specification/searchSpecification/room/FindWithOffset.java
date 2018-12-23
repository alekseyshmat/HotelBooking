package specification.searchSpecification.room;

import specification.Specification;

import java.util.Arrays;
import java.util.List;

public class FindWithOffset implements Specification {

    private Integer limit;
    private Integer offset;

    public FindWithOffset(Integer limit, Integer offset) {
        this.limit = limit;
        this.offset = offset;
    }

    @Override
    public String toSql() {
        return "LIMIT ? OFFSET ? ";
    }

    @Override
    public List<Object> getParametres() {
        return Arrays.asList(limit, offset);
    }
}
