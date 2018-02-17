package Hogwarts.Repository;

import Hogwarts.Domain.IllnessType;
import org.springframework.data.repository.CrudRepository;

public interface IllnessTypeRepository extends CrudRepository<IllnessType, Integer> {
}
