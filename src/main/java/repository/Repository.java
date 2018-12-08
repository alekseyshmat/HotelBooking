package repository;

import specification.Specification;

import java.util.List;
import java.util.Optional;

public interface Repository<T> {


    Optional<T> query(Specification specification);
}
