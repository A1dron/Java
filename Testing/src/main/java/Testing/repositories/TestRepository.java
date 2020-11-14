package Testing.repositories;

import Testing.entity.Test;
import org.springframework.data.repository.CrudRepository;

public interface TestRepository extends CrudRepository<Test, Long> {
    void delete(Long id);
}
