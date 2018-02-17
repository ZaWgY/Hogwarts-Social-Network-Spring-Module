package Hogwarts.Repository;

import Hogwarts.Domain.Status;
import org.springframework.data.repository.CrudRepository;

public interface StatusRepository extends CrudRepository<Status, Integer> {
}
