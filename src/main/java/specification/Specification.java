package specification;

import java.util.List;

public interface Specification<T> {

    String toSql();

    List<Object> getParametres();
}
