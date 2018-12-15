package specification.searchSpecification.transaction;

import specification.Specification;

import java.util.Collections;
import java.util.List;

public class FindByIdClient implements Specification {

    private Integer idClient;

    public FindByIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    @Override
    public String toSql() {
        return "WHERE id_client = ?";
    }

    @Override
    public List<Object> getParametres() {
        return Collections.singletonList(idClient);
    }
}
