package specification.searchSpecification.transaction;

import specification.Specification;

import java.util.Collections;
import java.util.List;

public class FindById implements Specification {

    private int idCLient;

    public FindById(int idCLient) {
        this.idCLient = idCLient;
    }

    @Override
    public String toSql() {
        return "WHERE id_client = ?";
    }

    @Override
    public List<Object> getParametres() {
        return Collections.singletonList(idCLient);
    }
}
