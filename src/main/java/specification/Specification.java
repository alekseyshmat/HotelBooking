package specification;

import java.util.List;

public interface Specification {

    String toSql();

    List<Object> getParametres();
}
