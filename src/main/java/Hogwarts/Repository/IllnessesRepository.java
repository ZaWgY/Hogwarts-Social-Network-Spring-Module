package Hogwarts.Repository;

import Hogwarts.Domain.Illness;
import org.springframework.data.repository.CrudRepository;

public interface IllnessesRepository extends CrudRepository<Illness, Integer> {
}
